# Two Sum

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/two-sum/)
- **Date**: 2026-08-04
- **Language**: java


**The Problem**

Given an array of integers `nums` and an integer `target`, find two indices `i` and `j` in the array such that `nums[i] + nums[j] = target`. Return these indices as an array. You may assume that each input would have exactly one solution, and you may not use the same element twice.

**Initial Thoughts**

At first, I tried using a nested loop approach to iterate through the array and find the target sum, but this solution had a time complexity of O(n^2), which was too slow for large arrays. I then thought about using a hash map to store the elements and their indices in the array, and then iterate through the array again to find the elements that add up to the target. This solution had a time complexity of O(n), but I was still worried about the space complexity, which was O(n) due to the hash map.

**The Core Trick**

I realized that I could use a hash map to store only one element at a time, and then check if the complement of the current element in the map exists. If it does, I would return the indices of the current element and the index of the complement in the map. This solution had a time complexity of O(n), as we iterate through the array only once, and the space complexity was O(1), as we don't use any additional data structures.

**Complexity**

The time complexity of this solution is O(n), as we iterate through the array only once. The space complexity is O(1), as we don't use any additional data structures.

**Key Takeaway**

This problem is a classic example of how to use a hash map to solve a two-pointer problem. I learned that sometimes, the best solution relies on understanding the problem space and leveraging the available algorithms and data structures that can help solve the problem efficiently.