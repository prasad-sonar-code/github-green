# Minimum Moves to Pick K Ones

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-moves-to-pick-k-ones/)
- **Date**: 2026-08-16
- **Language**: java


Problem: Given an array of integers `nums` and an integer `k`, return the minimum number of moves to pick `k` ones. In each move, you can either flip one 0 to 1 or one 1 to 0.

Initial Thoughts: This is a classic problem with a few brute-force solutions. The first thought was to iterate through all possible combinations of `k` indices and calculate the total moves required to get them all as ones or zeros. However, this would have a time complexity of O(2^n), which is too slow.

The Core Trick: The key insight is that we can use a binary search approach to find the median index and then calculate the moves for each possible combination of `k` indices around the median index. By doing this, we can reduce the time complexity to O(n log k).

Complexity: The time complexity is O(n log k) due to the binary search algorithm. The space complexity is O(n) for the array of indices and the moves counter.

Key Takeaway: Always consider the time complexity and space complexity when solving problems. In this case, a binary search approach is much more efficient than a brute-force solution.