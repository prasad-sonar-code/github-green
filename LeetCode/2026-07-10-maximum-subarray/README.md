# Maximum Subarray

- **Difficulty**: Medium
- **Source**: [Backlog](https://leetcode.com/problems/maximum-subarray/)
- **Date**: 2026-07-10
- **Language**: java


**The Problem**

Given an array of integers, return the contiguous subarray with the largest sum.

**Initial Thoughts**

At first, I tried using a brute-force approach, where I calculate the sum of all possible subarrays and keep track of the maximum subarray sum. However, this solution has a time complexity of O(n^2), which is not efficient enough for large arrays.

**The Core Trick**

Instead, I decided to use Kadane's algorithm, which finds the maximum subarray sum in linear time. This algorithm maintains a running sum of the current subarray and updates it whenever a new subarray starts or an element is added to an existing subarray.

**Complexity**

Time complexity: O(n) - The algorithm iterates through the array once.
Space complexity: O(1) - The algorithm does not use any additional space beyond the input array itself.

**Key Takeaway**

This problem is a great example of how to use dynamic programming to solve a problem in linear time, which is a common technique used in algorithms and data structures. I also learned how to apply Kadane's algorithm in a specific context, which I can use in similar problems.