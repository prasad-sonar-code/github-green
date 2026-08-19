# K Highest Ranked Items Within a Price Range

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/k-highest-ranked-items-within-a-price-range/)
- **Date**: 2026-08-19
- **Language**: java


The problem I solved today was "K Highest Ranked Items Within a Price Range" from LeetCode. This problem is a bit tricky since it requires a combination of breadth-first search and sorting. Here's my attempt at solving it.

**The Problem:** Given a grid `grid`, a pricing array `pricing`, a start array `start`, and an integer `k`, find the top `k` items with the highest rank within a specified price range. The rank is calculated as the distance from the starting point (top-left corner) to the item plus the item's value.

**Initial Thoughts:** I thought about using a priority queue to keep track of the highest ranked items, but then I realized that I needed to keep track of the starting point as well, which would be more complex. I also considered using a hash map to keep track of the visited cells, but that would increase the space complexity. I decided to use a breadth-first search approach with a queue, which would help me keep track of the starting point.

**The Core Trick:** The core trick in this problem is to calculate the rank of each item and store it along with the cell's position and value. This way, I can sort the items efficiently and easily extract the top `k` items.

**Complexity:** The time complexity is O(m * n * log(m * n)), where m and n are the dimensions of the grid. This is because we need to visit each cell once and update the priority queue for each item. The space complexity is O(m * n) due to the visited array.

**Key Takeaway:** This problem taught me the importance of considering the starting point in a problem and how to efficiently sort items based on a complex criterion like rank.

This was a good learning experience, and I hope to practice more problems like this in future.