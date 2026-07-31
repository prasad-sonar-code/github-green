# Two Sum

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/two-sum/)
- **Date**: 2026-07-31
- **Language**: java


**The Problem**

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`. You may assume that each input would have exactly one solution, and you may not use the same element twice.

**Initial Thoughts**

I started by iterating through the array and comparing each element to the target. If the complement is found in the map, I immediately return the indices of both elements. If not, I add the current element and its index to the map.

**The Core Trick**

This problem is a classic example of a hash table, where the key is the complement of the current element and the value is its index. If the complement is found, we have the two numbers that add up to the target.

**Complexity**

Time complexity: O(n), where n is the length of the array. Space complexity: O(n), as we store the indices of all elements in the hash map.

**Key Takeaway**

Be mindful of edge cases and ensure your code can handle them gracefully. In this problem, if there's no solution, the function should throw an exception. Also, make sure that the returned indices are in ascending order, which is not explicitly mentioned in the problem statement but is generally a good practice.