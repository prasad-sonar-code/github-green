"""LeetCode ingestion via alfa-leetcode-api REST API — the primary problem source.

API docs: https://github.com/alfaarghya/alfa-leetcode-api
Base URL: https://alfa-leetcode-api.onrender.com
Endpoints:
  GET /daily/raw       — Daily challenge with full data (code snippets, hints, metadata)
  GET /select/raw?titleSlug=<slug>  — Specific problem with full data
"""

from __future__ import annotations

import logging
import re
from typing import Any

import requests

from src.ingestion.base import ProblemFetcher, IngestionError
from src.models.problem import ProblemContext, Difficulty

log = logging.getLogger(__name__)


class LeetCodeFetcher(ProblemFetcher):
    """Fetches LeetCode problems via the alfa-leetcode-api REST API.

    Uses the /raw endpoints which provide full problem data including:
    - codeSnippets (exact LeetCode boilerplate with correct method signature)
    - hints (algorithmic guidance)
    - metaData (function name, params, return type)
    """

    def __init__(
        self,
        api_url: str = "https://alfa-leetcode-api.onrender.com",
        timeout: int = 30,
        language: str = "cpp",
    ):
        self.api_url = api_url.rstrip("/")
        self.timeout = timeout
        self.language = language
        self.session = requests.Session()
        self.session.headers.update({
            "Accept": "application/json",
            "User-Agent": (
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 "
                "(KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
            ),
        })

    def fetch(self) -> ProblemContext:
        """Fetch the daily challenge with full metadata."""
        log.info("Fetching LeetCode daily challenge from %s/daily/raw", self.api_url)
        try:
            resp = self.session.get(
                f"{self.api_url}/daily/raw",
                timeout=self.timeout,
            )
            resp.raise_for_status()
            data = resp.json()
            question = data.get("activeDailyCodingChallengeQuestion", {}).get("question", data)
            return self._parse_problem(question)
        except requests.RequestException as e:
            raise IngestionError(f"Network error fetching daily problem: {e}") from e

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
