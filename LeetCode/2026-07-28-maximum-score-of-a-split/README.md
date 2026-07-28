# Maximum Score of a Split

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/maximum-score-of-a-split/)
- **Date**: 2026-07-28
- **Language**: java


**The Problem**

Given an array of non-negative integers, find the maximum score by splitting the array into two non-empty parts and choosing one part. Specifically, the score of a split is the sum of elements in the first part minus the minimum of the second part. A split is valid if both parts contain at least one element.

**Initial Thoughts**

At first, I thought about using a greedy approach, where I split the array into two equal halves and take the maximum score for each half. But I realized that this approach doesn't consider the constraints of the problem, such as the minimum size of each part.

**The Core Trick**

To solve this problem efficiently, I need to compute prefix sums and suffix minimums. The prefix sum of an array indicates the cumulative sum of elements up to a certain index. Similarly, the suffix minimum of an array indicates the minimum value among all elements to the right of that index.

By computing these two arrays, I can efficiently compute the maximum score for each split. I can do this by iterating through the array and comparing the score of each split with the maximum score so far.

**Complexity**

Time complexity: O(n)

Space complexity: O(n)

**Key Takeaway**

This problem demonstrates the importance of carefully considering the constraints and requirements of a problem when solving it. In this case, I needed to compute prefix sums and suffix minimums to efficiently compute the maximum score for each split.