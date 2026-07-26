# Maximum Subarray

- **Difficulty**: Medium
- **Source**: [Backlog](https://leetcode.com/problems/maximum-subarray/)
- **Date**: 2026-07-26
- **Language**: java


**The Problem**

Given an array of integers, return the maximum sum of a non-empty contiguous subarray.

**Initial Thoughts**

At first, I thought about using dynamic programming to keep track of the maximum sum ending at each index. But that would have too much space complexity. So, I tried to find a way to iterate through the array only once.

**The Core Trick**

I realized that I could keep track of the current sum and the maximum sum seen so far. Whenever I encounter a new number, I compare it with the current sum and update the current sum accordingly. If the new number makes the current sum negative, I reset it to the new number. Finally, I compare the current sum with the maximum sum seen so far. If the current sum is greater, I update the maximum sum.

**Complexity**

Time complexity: O(n), as I iterate through the array once. Space complexity: O(1), since I only use a constant amount of extra space.

**Key Takeaway**

This problem taught me that sometimes, it's possible to solve a problem in a clever way, without resorting to too much extra space. It's important to think creatively to find efficient solutions.