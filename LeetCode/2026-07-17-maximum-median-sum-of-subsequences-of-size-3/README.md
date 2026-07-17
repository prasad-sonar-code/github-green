# Maximum Median Sum of Subsequences of Size 3

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/maximum-median-sum-of-subsequences-of-size-3/)
- **Date**: 2026-07-17
- **Language**: java


**The Problem**

Given an array of integers, the problem asks to find the maximum median sum of subsequences of size 3. A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. The median is defined as the middle value when all values are arranged in ascending order.

**Initial Thoughts**

At first, I thought about brute-forcing all possible subsequences and then sorting them based on their median sum. However, this approach would take exponential time complexity. So, I decided to focus on finding a more efficient solution.

**The Core Trick**

The key idea is to use the fact that for an array of size n, there are exactly n-2 subsequences of length 3. I also noticed that for each of these subsequences, the median sum can be calculated in constant time. This observation allowed me to reduce the problem to finding the maximum sum of a fixed-size subsequence, which is a well-studied problem in algorithms.

**Complexity**

Time complexity: O(n log n) due to sorting. Space complexity: O(n) for sorting in Java.

**Key Takeaway**

This experience taught me that sometimes, focusing on understanding the problem's constraints and potential solutions can lead to finding a more elegant and efficient solution. It's also important to consider the time and space complexities of various solutions to ensure they meet the problem's requirements.