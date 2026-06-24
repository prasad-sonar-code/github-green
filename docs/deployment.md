# Deployment Guide

GitHubGreenCard is **serverless** — it runs entirely within GitHub Actions. There is no server, database, or hosting to manage.

---

## Architecture

```
┌────────────────────────────────────┐
│  GitHub Actions (ubuntu-latest)    │
│                                    │
│  ┌──────────────────────────────┐  │
│  │  Daily DSA Solve Workflow    │  │
│  │  ├─ Checkout repo            │  │
│  │  ├─ Install Python + deps    │  │
│  │  ├─ Run pipeline (~3 min)    │  │
│  │  └─ Commit + push            │  │
│  └──────────────────────────────┘  │
│                                    │
│  Calls:                            │
│  ├─ alfa-leetcode-api (LeetCode)   │
│  └─ NVIDIA NIM API (LLM)          │
└────────────────────────────────────┘
         │
         ▼
┌────────────────────────────────────┐
│  github.com/yash1648/github-green  │
│  └─ LeetCode/YYYY-MM-DD-title/     │
│      ├─ solution.cpp               │
│      └─ README.md                  │
└────────────────────────────────────┘
```

## Deployment Steps

### 1. Fork or clone the repository

```bash
git clone https://github.com/yash1648/github-green.git
cd github-green
```

### 2. Add the NVIDIA API key to GitHub Secrets

1. Navigate to: **https://github.com/yash1648/github-green/settings/secrets/actions**
2. Click **"New repository secret"**
3. **Name**: `NVIDIA_API_KEY`
4. **Value**: `nvapi-...` (your key from [build.nvidia.com](https://build.nvidia.com))
5. Click **"Add secret"**

### 3. Verify the workflow file

The pipeline is defined in `.github/workflows/daily-solve.yml`. Default settings:

- **Cron**: `0 2 * * *` (02:00 UTC)
- **Timeout**: 10 minutes
- **Python**: 3.14

### 4. Push to main

```bash
git push origin main
```

### 5. Trigger a manual test run

1. Go to **Actions → Daily DSA Solve → "Run workflow"**
2. Leave `dry_run` unchecked (or check it to test without git push)
3. Click **"Run"**

### 6. Monitor

- Watch the workflow run at **https://github.com/yash1648/github-green/actions**
- Each run produces a commit under your username
- Verify by checking the **LeetCode/** directory in the repository

---

## Scheduled Runs

The workflow runs daily at **02:00 UTC** (configurable via the `cron` expression in `daily-solve.yml`).

Each run takes approximately 2–3 minutes — no random delays, minimal Actions minutes used.

---

## Manual Triggers

You can trigger the workflow manually from the Actions tab:

| Input | Default | Description |
|---|---|---|
| `dry_run` | `false` | Set to `true` to fetch + generate without committing |

---

## Required Secrets

| Secret | Source | Purpose |
|---|---|---|
| `NVIDIA_API_KEY` | [build.nvidia.com](https://build.nvidia.com) | LLM inference for code + docs |
| `GITHUB_TOKEN` | Auto-injected by GitHub Actions | Authentication for git push |

---

## Cost

| Service | Cost | Limits |
|---|---|---|
| GitHub Actions | Free for public repos | 2,000 min/month (1 run/day ≈ 30 min → ~900 min/month) |
| NVIDIA NIM | Free tier | 1,000 inference credits, 40 req/min |
| alfa-leetcode-api | Free | No auth required |

---

## Changing the Schedule

Edit the `cron` expression in `.github/workflows/daily-solve.yml`:

```yaml
on:
  schedule:
    - cron: "0 0 * * *"   # midnight UTC
```

Cron format: `minute hour day month weekday`. Use [crontab.guru](https://crontab.guru) to generate expressions.

To disable scheduled runs, change the cron to a never-match value:

```yaml
- cron: "0 5 31 2 *"  # Feb 31 — never runs
```

---

## Troubleshooting CI

### Workflow fails with "No API key found"

The `NVIDIA_API_KEY` secret is missing or misnamed.

1. Verify the secret exists at **Settings → Secrets → Actions → Repository secrets**
2. The name must be exactly `NVIDIA_API_KEY` (all caps)

### Workflow fails with "Process completed with exit code 1"

Check the expandable log output in the Actions run. Common causes:

- **LLM failure** — NVIDIA NIM may be down or rate-limited
- **LeetCode API failure** — alfa-leetcode-api may be unreachable (falls back to backlog)
- **Secret not set** — `NVIDIA_API_KEY` must be added to repository secrets

### Push rejected

- The `contents: write` permission in `daily-solve.yml` allows push
- If using a fork, ensure the fork's `main` branch is not protected

### Testing with dry_run

Trigger a manual run with `dry_run=true` to test ingestion + LLM without pushing:

```
                    ┌─────────────────────┐
No dry_run          │  fetch → LLM → git  │  → pushes to GitHub
                    └─────────────────────┘

                    ┌─────────────────────┐
dry_run=true        │  fetch → LLM → skip │  → writes files locally, no push
                    └─────────────────────┘
```
