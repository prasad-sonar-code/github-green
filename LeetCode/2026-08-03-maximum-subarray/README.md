# Maximum Subarray

- **Difficulty**: Medium
- **Source**: [Backlog](https://leetcode.com/problems/maximum-subarray/)
- **Date**: 2026-08-03
- **Language**: java


**The Problem**

Given an array of integers, return the contiguous subarray with the largest sum.

**Initial Thoughts**

At first, I tried using a brute-force approach, where I calculate the sum of all possible subarrays and keep track of the maximum subarray sum. However, this solution has a time complexity of O(n^2), which is not efficient enough for large arrays.

**The Core Trick**

Instead, I used Kadane's algorithm, which has a time complexity of O(n). The idea is to keep track of the maximum subarray sum ending at each index and update it whenever a new subarray with a larger sum is found. This approach ensures that we only consider contiguous subarrays and has a linear time complexity.

**Complexity**

The time complexity of this solution is O(n), where n is the length of the input array. The space complexity is also O(1), as we only use a constant amount of additional memory for variables like `currentSum` and `maxSum`.

**Key Takeaway**

Kadane's algorithm is a simple yet powerful technique to find the maximum subarray sum in an array. It can be applied to different data types and dimensions as well. The key takeaway is to focus on contiguous subarrays and maintain the maximum subarray sum ending at each index to ensure efficient time complexity.