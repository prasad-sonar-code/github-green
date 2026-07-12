# Shortest Cycle in a Graph

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/shortest-cycle-in-a-graph/)
- **Date**: 2026-07-12
- **Language**: java


**The Problem**

Given a directed graph `edges` where `edges[i] = [a, b]` represents a directed edge from node `a` to node `b`, find the length of the shortest cycle in the graph. If no cycle exists, return `-1`.

**Initial Thoughts**

At first, I thought about using Depth-First Search (DFS) or Breadth-First Search (BFS) to find a cycle. But these algorithms have a time complexity of O(n^2) or O(n*m), respectively, which is not efficient enough for large graphs.

**The Core Trick**

I realized that the problem can be solved by finding the shortest path from any node to itself in the graph. A cycle is formed when the shortest path returns to a previously visited node. To do this, I used a modified version of the Floyd-Warshall algorithm to compute the shortest path distances between all pairs of nodes. This algorithm has a time complexity of O(n^3), which is acceptable for the given constraints.

**Complexity**

The time complexity of my solution is O(n^3) because of the Floyd-Warshall algorithm. The space complexity is also O(n^3) due to the intermediate results stored in a 2D DP array.

**Key Takeaway**

When dealing with a graph problem, it's important to consider the time and space complexity of your solution. In this case, I chose a modified version of the Floyd-Warshall algorithm over DFS or BFS because it has a better time complexity. However, it's always good to have alternative solutions to compare with.