# Setup Guide

## Prerequisites

- **Python 3.14+** — required for the pipeline runtime
- **NVIDIA NIM API key** — free at [build.nvidia.com](https://build.nvidia.com) (sign up → API key starts with `nvapi-`)
- **Git** — for local testing and debugging
- **GitHub repository** — the pipeline pushes solutions here

---

## Local Development Setup

### 1. Clone the repository

```bash
git clone https://github.com/yash1648/github-green.git
cd github-green
```

### 2. Create a virtual environment

```bash
python -m venv .venv
source .venv/bin/activate      # Linux/macOS
# .venv\Scripts\activate       # Windows
```

### 3. Install dependencies

```bash
pip install --upgrade pip
pip install -r requirements.txt
```

**Dependencies** (only 3):

| Package | Version | Purpose |
|---|---|---|
| `openai` | ≥1.0.0 | OpenAI-compatible LLM client (used for NVIDIA NIM) |
| `requests` | ≥2.31.0 | HTTP calls to alfa-leetcode-api |
| `pyyaml` | ≥6.0 | Parse `config.yaml` |

### 4. Set environment variables

```bash
export NVIDIA_API_KEY="nvapi-your-key-here"
# Optional: export OPENAI_API_KEY="sk-..."  (fallback if not using NVIDIA)
```

See [`.env.example`](../.env.example) for the full list.

### 5. Run a dry-run test

```bash
DRY_RUN=true python -m src.main
```

This fetches a random LeetCode problem, generates code + docs via LLM, and writes files to `LeetCode/YYYY-MM-DD-title/`. No git operations are performed.

Expected output:

```
=== DRY RUN MODE ===
Step 1: Fetching problem...
Selected: Restore the Array From Adjacent Pairs (Medium)
Fetched random LeetCode problem: Restore the Array From Adjacent Pairs
Step 2-3: Executing LLM pipeline...
Solution code generated (934 bytes)
Documentation generated (1326 bytes)
Files written:
  Solution: LeetCode/2026-06-25-restore-the-array-from-adjacent-pairs/solution.cpp
  README:   LeetCode/2026-06-25-restore-the-array-from-adjacent-pairs/README.md
=== DRY RUN COMPLETE ===
```

### 6. Run full pipeline (local)

```bash
python -m src.main
```

This does everything the dry run does, **plus** `git add → git commit → git push` to the configured remote.

> **Note**: For local pushes, your local git credentials are used. In CI, the `GITHUB_TOKEN` is used.

### 7. Run tests

```bash
python -m pytest tests/ -v
```

All 26 tests should pass.

---

## GitHub Actions Setup

### 1. Add the API key as a repository secret

1. Go to **https://github.com/yash1648/github-green/settings/secrets/actions**
2. Click **"New repository secret"**
3. **Name**: `NVIDIA_API_KEY`
4. **Value**: Your NVIDIA NIM API key (starts with `nvapi-`)
5. Click **"Add secret"**

### 2. Trigger the workflow

- **Manual**: Go to **Actions → Daily DSA Solve → "Run workflow"** → optionally set `dry_run=true` → **"Run"**
- **Scheduled**: The cron runs daily at 02:00 UTC (adjustable)

### 3. Verify

After a successful run, you'll see a new commit like `764e1ca Solve ...` in your repository and a new directory under `LeetCode/`.

---

## Configuration

All pipeline settings live in [`config.yaml`](../config.yaml) at the project root:

| Section | Key | Default | Description |
|---|---|---|---|
| `pipeline.language` | | `cpp` | Target language for solutions |
| `pipeline.output_root` | | `LeetCode` | Output directory under repo root |
| `ingestion.leetcode.api_url` | | `https://alfa-leetcode-api.onrender.com` | LeetCode API endpoint |
| `ingestion.leetcode.timeout` | | `30` | HTTP request timeout (seconds) |
| `ingestion.leetcode.page_size` | | `50` | Problems per page for random selection |
| `execution.llm.base_url` | | `https://integrate.api.nvidia.com/v1` | LLM API base URL |
| `execution.llm.model_code` | | `meta/llama-3.1-70b-instruct` | Model for code generation |
| `execution.llm.model_doc` | | `nvidia/nemotron-mini-4b-instruct` | Model for documentation |
| `execution.llm.temperature_code` | | `0.2` | Low temp for deterministic code |
| `execution.llm.temperature_doc` | | `0.7` | Higher temp for creative docs |
| `execution.llm.max_tokens_code` | | `4096` | Max tokens for code output |
| `execution.llm.max_tokens_doc` | | `1500` | Max tokens for doc output |
| `execution.llm.retry_count` | | `3` | LLM retry attempts |
| `execution.llm.retry_delay` | | `5` | Base delay between retries (seconds) |
| `repository.git.branch` | | `main` | Branch to push to |

---

## Troubleshooting

### "No API key found"

The `NVIDIA_API_KEY` environment variable is not set.

- **Locally**: `export NVIDIA_API_KEY="nvapi-..."`
- **CI**: Add `NVIDIA_API_KEY` to repository secrets

### "Pipeline failed: ... "

Check the log output for the specific error:

- **LeetCode API error** → The alfa-leetcode-api may be down. The pipeline falls back to `backlog.json`.
- **LLM error** → NVIDIA NIM might be rate-limited (40 req/min free tier). The pipeline retries 3x.
- **Git push error** → The pipeline retries push 3x with backoff. Check credentials.

### Verifying LLM access

```bash
curl -s https://integrate.api.nvidia.com/v1/models \
  -H "Authorization: Bearer $NVIDIA_API_KEY" \
  | python -m json.tool | grep -E '"id"|meta/llama'
```

If this returns 404, your key may not have access to the 70B model tier.
