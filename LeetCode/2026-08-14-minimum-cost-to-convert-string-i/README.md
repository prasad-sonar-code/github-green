# Minimum Cost to Convert String I

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-cost-to-convert-string-i/)
- **Date**: 2026-08-14
- **Language**: java


Problem: Minimum Cost to Convert String I

Initial Thoughts: This problem seems like a combination of graph traversal, string manipulation, and dynamic programming. I need to build a graph with edges representing the cost of changing from one character to another, and then use that graph to find the shortest path from the source string to the target string.

The Core Trick: I realized that I can use a directed graph with weighted edges to represent the cost of changing from one character to another. By using Dijkstra's algorithm, I can find the shortest path between the source and target strings with the minimum cost.

Complexity: Time complexity: O(26^3 + n) where n is the length of the source string. Space complexity: O(26^2) for the graph.

Key Takeaway: When dealing with graph-based problems, it's important to break down the problem into smaller, manageable pieces. In this case, I used a directed graph to represent the cost of changing from one character to another, and then used Dijkstra's algorithm to find the shortest path between the source and target strings.