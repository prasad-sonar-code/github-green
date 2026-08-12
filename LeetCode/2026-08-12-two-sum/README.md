# Two Sum

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/two-sum/)
- **Date**: 2026-08-12
- **Language**: java


**The Problem**

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`. You may assume that each input would have exactly one solution, and you may not use the same element twice.

**Initial Thoughts**

I started by iterating through the array and checking if the complement of the current number is in the map. If it is, I return the indices of that pair. If not, I add the current number and its index to the map. If I go through the entire array without finding a pair, I throw a runtime exception.

**The Core Trick**

The key to solving this problem is to use a hash map to store the indices of each element in the array. Then, for each element, I check if its complement is already in the map. If it is, I return the indices of that pair. This ensures that I only check each element once and uses space proportional to the size of the array.

**Complexity**

This solution has a time complexity of O(n), where n is the length of the array, because for each element, I check if its complement is in the map. The space complexity is also O(n), because we store all the indices of each element in the array.

**Key Takeaway**

When solving a problem like this, it's important to start with a brute force solution, then optimize it by thinking about how you can use data structures and other techniques to reduce the time or space complexity of your solution.