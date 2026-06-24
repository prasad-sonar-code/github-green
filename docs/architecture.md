# Architecture

## Overview

GitHubGreenCard is a fully autonomous, serverless pipeline that solves a random LeetCode problem daily using two-stage LLM inference, writes the solution and a humanized dev journal to the repository, and pushes to GitHub.

It runs entirely within **GitHub Actions** (free tier, Ubuntu runner) with no external servers, databases, or infrastructure.

---

## Pipeline Flow

```
┌─────────────────────────────────────────────────────────────────────┐
│  TRIGGER (daily cron or manual workflow_dispatch)                   │
│  └─ midnight UTC + random sleep (0-3h or 6-12h)                    │
└─────────────────────────────────────────────────────────────────────┘
                                │
                                ▼
┌─────────────────────────────────────────────────────────────────────┐
│  STAGE 1: INGESTION                                                │
│                                                                     │
│  1. Fetch random page from alfa-leetcode-api /problems endpoint     │
│  2. Pick one random free problem from the page                      │
│  3. Fetch full detail via /select/raw?titleSlug=...                 │
│  4. Extract: title, difficulty, description, hints, codeSnippets    │
│                                                                     │
│  On failure → fallback to backlog.json (5 curated problems)         │
│                                                                     │
│  Output: ProblemContext (dataclass)                                 │
└─────────────────────────────────────────────────────────────────────┘
                                │
                                ▼
┌─────────────────────────────────────────────────────────────────────┐
│  STAGE 2: EXECUTION (Dual LLM Pipeline)                            │
│                                                                     │
│  ┌─────────────────────┐    ┌──────────────────────────┐           │
│  │  Code Generator     │    │  Doc Writer              │           │
│  │  meta/llama-3.1-    │    │  nvidia/nemotron-mini-   │           │
│  │  70b-instruct       │    │  4b-instruct             │           │
│  │  temperature: 0.2   │    │  temperature: 0.7        │           │
│  │  max_tokens: 4096   │    │  max_tokens: 1500        │           │
│  │                     │    │                          │           │
│  │  Input: Problem     │    │  Input: Problem + Code   │           │
│  │  Output: C++ class  │    │  Output: README.md dev   │           │
│  │  Solution {...}     │    │  journal (anti-AI-tone)  │           │
│  └─────────────────────┘    └──────────────────────────┘           │
└─────────────────────────────────────────────────────────────────────┘
                                │
                                ▼
┌─────────────────────────────────────────────────────────────────────┐
│  STAGE 3: REPOSITORY                                               │
│                                                                     │
│  StructureManager:                                                  │
│  └─ Create LeetCode/YYYY-MM-DD-title/                              │
│      ├─ solution.cpp  (code from Stage 2)                          │
│      └─ README.md     (doc from Stage 2)                           │
└─────────────────────────────────────────────────────────────────────┘
                                │
                                ▼
┌─────────────────────────────────────────────────────────────────────┐
│  STAGE 4: DEPLOYMENT                                               │
│                                                                     │
│  GitManager:                                                        │
│  ├─ git add LeetCode/YYYY-MM-DD-title/                             │
│  ├─ git commit -m "Solve {title}"                                  │
│  ├─ git pull --rebase origin main  (CI only)                       │
│  └─ git push (up to 3 retries, 5s→10s→20s backoff)                │
└─────────────────────────────────────────────────────────────────────┘
                                │
                                ▼
                    GitHub Contribution Graph ✅
```

---

## Module Details

### 1. Ingestion (`src/ingestion/`)

| File | Role |
|---|---|
| `base.py` | Abstract `ProblemFetcher` base class with `fetch()` contract |
| `leetcode.py` | `LeetCodeFetcher` — picks random problem via alfa-leetcode-api REST |
| `backlog.py` | `BacklogFetcher` — fallback from `backlog.json` |

**LeetCodeFetcher flow**:
1. `GET /problems?limit=50&skip=N` where `N` is a random offset within total problem count
2. Filter out paid-only problems
3. Pick one random problem from the result
4. `GET /select/raw?titleSlug={slug}` for full details including `codeSnippets` (exact C++ boilerplate) and `hints`
5. Convert HTML description to plain text
6. Return `ProblemContext`

### 2. Execution (`src/execution/`)

| File | Role |
|---|---|
| `llm_client.py` | `LLMClient` — OpenAI-compatible wrapper with retry (3x) |
| `code_generator.py` | `CodeGenerator` — Stage 1, generates C++ `class Solution` |
| `doc_writer.py` | `DocWriter` — Stage 2, generates humanized dev journal |
| `exceptions.py` | `ExecutionError`, `IngestionError` — pipeline exception types |

**LLM Client**:
- Reads `NVIDIA_API_KEY` or `OPENAI_API_KEY` from environment
- OpenAI-compatible SDK (works with any provider that exposes `/v1/chat/completions`)
- 3 retries with linear backoff (5s → 10s → 15s)
- Supports different models per stage via `base_url` + `model` params

**Code Generator prompt**:
- System: Expert C++ competitive programmer, LeetCode format only
- User: description + constraints + examples + hints + boilerplate
- Constraints: no `#include`, no `main()`, no I/O, only `class Solution { public: ... };`
- Complexity guidance based on constraint size (e.g., `n ≤ 10⁹ → O(log n)`)

**Doc Writer prompt**:
- System: Developer writing a README for a LeetCode solution
- Anti-AI-tone: forbidden phrases include "furthermore", "let's dive in", "in conclusion", etc.
- Sections: Problem Summary, Approach, Complexity, Developer Journal

### 3. Repository (`src/repository/`)

| File | Role |
|---|---|
| `structure.py` | `StructureManager` — writes solution.cpp and README.md |
| `git_ops.py` | `GitManager` — commit and push with pull-before-push + 3 retries |

**StructureManager**:
- Creates `LeetCode/YYYY-MM-DD-kebab-title/`
- Writes solution with correct file extension (.cpp, .py, .java based on config)
- Writes README.md

**GitManager**:
- `commit_and_push()`: git add, commit, pull--rebase (CI only), push
- `_get_authenticated_remote()`: injects `GITHUB_TOKEN` into HTTPS URL for CI auth
- `_pull_rebase()`: safe merge with abort-on-conflict
- Push retry: 3 attempts, exponential backoff (5s → 10s → 20s)

### 4. Model (`src/models/problem.py`)

`ProblemContext` dataclass — the single data contract across all pipeline stages:

```python
@dataclass
class ProblemContext:
    title: str
    difficulty: Difficulty        # Easy | Medium | Hard
    description: str
    constraints: str
    examples: list[dict]          # [{"input": "...", "output": "..."}]
    hints: list[str] = ...        # From LeetCode
    boilerplate: str = ...        # Exact class Solution stub
    source: str = "leetcode"      # "leetcode" | "backlog"
    source_url: str = ...
    solved_date: str = ...        # YYYY-MM-DD
    language: str = "cpp"
```

---

## CI/CD Pipeline

**File**: `.github/workflows/daily-solve.yml`

| Trigger | Description |
|---|---|
| `schedule` | `0 0 * * *` — midnight UTC daily + random sleep |
| `workflow_dispatch` | Manual trigger with optional `dry_run` input |

**Job timeout**: 780 minutes (13 hours) — accommodates up to 12h random delay + 3min pipeline.

**Steps**:
1. **Randomize start time** — Python script sleeps 0-3h (window 0) or 6-12h (window 1)
2. **Checkout** — `actions/checkout@v4` with `secrets.GITHUB_TOKEN`
3. **Python setup** — 3.14
4. **Install deps** — `pip install -r requirements.txt`
5. **Configure Git** — sets user to `${{ github.actor }}`
6. **Run pipeline** — `python -m src.main` with secrets injected as env vars

**Secrets required**:
- `NVIDIA_API_KEY` — NVIDIA NIM LLM access
- `GITHUB_TOKEN` — auto-injected by GitHub Actions for push auth
- `OPENAI_API_KEY` — optional fallback

---

## Failure Modes

| Failure | Behavior | Recovery |
|---|---|---|
| LeetCode API down | Fallback to `backlog.json` | Next cron cycle tries LeetCode again |
| LLM rate limit (40 req/min) | Exponential backoff, 3 retries | Retries on next cycle |
| LLM hard failure | Pipeline crashes, no commit | Retries on next cycle |
| Git push fails (network) | 3 retries with backoff | Commit is lost (ephemeral runner) |
| Rebase conflict | Abort rebase, attempt push anyway | Unlikely (unique dir per day) |
| Missing API key | Pipeline crashes early | Alert via Actions log |

---

## Data Flow

```
External APIs                    Pipeline                    GitHub
─────────────                    ────────                    ──────

alfa-leetcode-api                 src/ingestion/
  /problems?limit=50                ├─ LeetCodeFetcher
  /select/raw?titleSlug=...         └─ BacklogFetcher     ┌──────────┐
                                         │                │          │
NVIDIA NIM API                    src/execution/           │  Your    │
  /v1/chat/completions              ├─ LLMClient           │  Repo    │
    ├─ meta/llama-3.1-70b          ├─ CodeGenerator        │          │
    └─ nemotron-mini-4b            └─ DocWriter            │ LeetCode/│
                                         │                │  .../    │
                                    src/repository/       │ solution │
                                      ├─ StructureManager │ README   │
                                      └─ GitManager ──────→ commit   │
                                                            │ push   │
                                                          └──────────┘
```
