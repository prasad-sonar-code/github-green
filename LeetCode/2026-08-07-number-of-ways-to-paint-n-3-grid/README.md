# Number of Ways to Paint N × 3 Grid

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/)
- **Date**: 2026-08-07
- **Language**: java


Problem: Number of Ways to Paint N × 3 Grid

Initial Thoughts: This problem asks to find the total number of ways to paint an N × 3 grid using three colors. At first, I thought this might be a simple combinatorics problem, but as I started calculating the number of ways for small values of N, I realized that it grows very quickly. I also thought about using dynamic programming, but I couldn't come up with a recurrence relation. 

The Core Trick: The key insight was noticing that the number of ways to paint an N × 3 grid is equal to the number of ways to paint an (N-1) × 3 grid plus the number of ways to paint an N × 2 grid. This is because, for a given grid, if the bottom row is painted with a certain color, then the remaining N-1 rows must be painted with the remaining two colors. 

Complexity: The time complexity of this solution is O(n), where n is the number of rows in the grid. This is because, for each row, we need to calculate the number of ways to paint it. The space complexity is also O(1), since we only need to store the current state of each grid (i.e., the last row's color and the rest of the grid's colors).

Key Takeaway: This problem taught me that sometimes, the most elegant solution involves creative thinking outside the box. In this case, breaking down the problem into smaller subproblems and finding a simple recurrence relation was key to solving it efficiently.