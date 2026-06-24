"""LeetCode ingestion via alfa-leetcode-api REST API — the primary problem source.

API docs: https://github.com/alfaarghya/alfa-leetcode-api
Base URL: https://alfa-leetcode-api.onrender.com
Endpoints:
  GET /problems?limit=N&skip=N  — Problem list (paginated)
  GET /select/raw?titleSlug=<slug>  — Specific problem with full data
"""

from __future__ import annotations

import logging
import random
import re
from typing import Any

import requests

from src.ingestion.base import ProblemFetcher, IngestionError
from src.models.problem import ProblemContext, Difficulty

log = logging.getLogger(__name__)


class LeetCodeFetcher(ProblemFetcher):
    """Fetches a random LeetCode problem via the alfa-leetcode-api REST API.

    Strategy:
    1. Fetch a random page from /problems list (skipping paid-only)
    2. Pick a random problem from that page
    3. Fetch full details via /select/raw with the titleSlug

    Provides full problem data including:
    - codeSnippets (exact LeetCode boilerplate with correct method signature)
    - hints (algorithmic guidance)
    """

    def __init__(
        self,
        api_url: str = "https://alfa-leetcode-api.onrender.com",
        timeout: int = 30,
        language: str = "cpp",
        page_size: int = 50,
    ):
        self.api_url = api_url.rstrip("/")
        self.timeout = timeout
        self.language = language
        self.page_size = page_size
        self.session = requests.Session()
        self.session.headers.update({
            "Accept": "application/json",
            "User-Agent": (
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 "
                "(KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
            ),
        })

    def fetch(self) -> ProblemContext:
        """Fetch a random LeetCode problem with full metadata."""
        # Step 1: get total problem count
        log.info("Finding random LeetCode problem...")
        total = self._get_total_problems()
        log.debug("Total problems available: %d", total)

        # Step 2: pick random offset and fetch a page
        max_skip = max(0, total - self.page_size)
        skip = random.randint(0, max_skip)
        problems = self._list_problems(skip=skip)
        log.debug("Fetched %d problems at offset %d", len(problems), skip)

        if not problems:
            raise IngestionError("No problems found in listing")

        # Filter out paid-only problems
        free_problems = [p for p in problems if not p.get("isPaidOnly")]
        if not free_problems:
            raise IngestionError("All problems in this page are paid-only")

        # Step 3: pick one at random
        chosen = random.choice(free_problems)
        title_slug = chosen["titleSlug"]
        log.info("Selected: %s (%s)", chosen["title"], chosen["difficulty"])

        # Step 4: fetch full details
        return self.fetch_by_slug(title_slug)

    def _get_total_problems(self) -> int:
        """Get the total number of problems available."""
        try:
            resp = self.session.get(
                f"{self.api_url}/problems",
                params={"limit": 1},
                timeout=self.timeout,
            )
            resp.raise_for_status()
            data = resp.json()
            return data.get("totalQuestions", 0)
        except requests.RequestException as e:
            raise IngestionError(f"Failed to get problem count: {e}") from e

    def _list_problems(self, skip: int = 0) -> list[dict]:
        """Fetch a page of problems from the listing endpoint."""
        try:
            resp = self.session.get(
                f"{self.api_url}/problems",
                params={"limit": self.page_size, "skip": skip},
                timeout=self.timeout,
            )
            resp.raise_for_status()
            data = resp.json()
            return data.get("problemsetQuestionList", [])
        except requests.RequestException as e:
            raise IngestionError(f"Failed to list problems: {e}") from e

    def fetch_by_slug(self, title_slug: str) -> ProblemContext:
        """Fetch a specific problem by its slug (e.g., 'two-sum') with full metadata."""
        log.info("Fetching problem by slug: %s", title_slug)
        try:
            resp = self.session.get(
                f"{self.api_url}/select/raw",
                params={"titleSlug": title_slug},
                timeout=self.timeout,
            )
            resp.raise_for_status()
            data = resp.json()
            return self._parse_problem(data.get("question", data))
        except requests.RequestException as e:
            raise IngestionError(
                f"Network error fetching '{title_slug}': {e}"
            ) from e

    def _parse_problem(self, data: dict[str, Any]) -> ProblemContext:
        """Parse the raw API response into a ProblemContext.

        The raw endpoint returns the full LeetCode question object with:
        - codeSnippets: exact boilerplate per language
        - hints: algorithmic hints
        - metaData: function signature metadata
        """
        title = data.get("title", data.get("questionTitle", "Unknown"))
        difficulty_str = data.get("difficulty", "Medium")
        difficulty = Difficulty(difficulty_str)

        # Extract description from HTML content
        raw_html = data.get("content", data.get("question", ""))
        description = self._strip_html(raw_html)
        constraints = self._extract_constraints(raw_html)

        # Parse example test cases
        raw = data.get("exampleTestcases", "")
        examples = []
        if raw:
            parts = raw.strip().split("\n")
            for i in range(0, len(parts), 2):
                if i + 1 < len(parts):
                    examples.append({
                        "input": parts[i],
                        "output": parts[i + 1],
                    })

        # Extract exact LeetCode boilerplate for the target language
        boilerplate = ""
        code_snippets = data.get("codeSnippets", [])
        for snippet in code_snippets:
            if snippet.get("langSlug") == self.language:
                boilerplate = snippet.get("code", "")
                log.debug("Found C++ boilerplate: %s chars", len(boilerplate))
                break
        # Fallback: use first available snippet
        if not boilerplate and code_snippets:
            boilerplate = code_snippets[0].get("code", "")

        # Extract hints
        hints = data.get("hints", [])

        title_slug = data.get("titleSlug", "")
        source_url = f"https://leetcode.com/problems/{title_slug}/"

        return ProblemContext(
            title=title,
            difficulty=difficulty,
            description=description,
            constraints=constraints,
            examples=examples,
            boilerplate=boilerplate,
            source_url=source_url,
            source="leetcode",
            language=self.language,
            hints=hints,
        )

    @staticmethod
    def _strip_html(html: str) -> str:
        """Remove HTML tags from the problem description."""
        text = re.sub(r"<[^>]+>", "", html)
        text = text.replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">")
        text = text.replace("&amp;", "&").replace("&quot;", '"').replace("&#39;", "'")
        return text.strip()

    @staticmethod
    def _extract_constraints(html: str) -> str:
        """Extract the constraints section from HTML problem description."""
        match = re.search(
            r"<p><strong>(?:Constraints|Constraints:)</strong></p>\s*(.*?)(?:</ul>|<p>|$)",
            html,
            re.DOTALL,
        )
        if match:
            return LeetCodeFetcher._strip_html(match.group(1))
        return ""
