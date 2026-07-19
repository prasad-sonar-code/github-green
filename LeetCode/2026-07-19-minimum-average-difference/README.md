# Minimum Average Difference

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-average-difference/)
- **Date**: 2026-07-19
- **Language**: java


**The Problem**

Given an array of integers, `nums`, find the minimum difference between any two non-adjacent numbers. Non-adjacent numbers do not share an index. For example, in the array `[1, 3, 2, 4, 2]`, the minimum difference is `1` between `3` and `2`.

**Initial Thoughts**

I thought about using a brute-force approach by comparing each number with every other number. But that would take exponential time, which is not efficient. I also considered sorting the array and then calculating the difference between every pair of numbers. However, that would still have a time complexity of O(n log n).

**The Core Trick**

To solve this problem efficiently, I needed to calculate the prefix and suffix sums of the array. Then, for each index in the array, I could calculate the average difference between that index and the indices before and after it. The index with the smallest average difference would give me the minimum difference between any two non-adjacent numbers.

**Complexity**

The time complexity of this algorithm is O(n), which is good because the problem asks for the minimum difference between any two indices. Since there are `n` indices in the array, I need to calculate the average difference at each index. The space complexity is also O(n), as we need to store the prefix and suffix sums of the array.

**Key Takeaway**

This problem required me to think about how to efficiently calculate the average difference between non-adjacent numbers in an array. I learned that using prefix and suffix sums can help in this case, as it allows us to calculate the average difference at each index in the array.