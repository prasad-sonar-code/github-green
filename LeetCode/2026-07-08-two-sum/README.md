# Two Sum

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/two-sum/)
- **Date**: 2026-07-08
- **Language**: java


**The Problem**

Given an array of integers `nums` and an integer `target`, find two indices `i` and `j` in the array such that `nums[i] + nums[j] = target`. Return these indices as an array. You may assume that each input would have exactly one solution, and you may not use the same element twice.

**Initial Thoughts**

At first, I tried using a nested loop approach to iterate through the array and find the target sum, but this solution had a time complexity of O(n^2), which was too slow for large arrays. I then thought about using a hash map to store the elements and their indices in the array, and then iterate through the array again to find the elements that add up to the target. This solution had a time complexity of O(n), but I was still worried about the space complexity, which was O(n) due to the hash map.

**The Core Trick**

I realized that I could use a hash map to store only one element at a time, and then check if the complement of the current element in the target exists in the map. This way, I could avoid storing all elements in the map simultaneously, reducing the space complexity to O(1).

**Complexity**

The time complexity of this solution is O(n), as we iterate through the array only once. The space complexity is O(1), as we only use a constant amount of additional memory to store the indices in the hash map.

**Key Takeaway**

This problem taught me the importance of using hash maps when dealing with arrays and their indices, as it allows for efficient lookup and modification of elements in constant time. It also reinforced the idea of using a two-pointer approach when iterating through arrays, as it can be used to optimize solutions for classic problems like finding the smallest or largest element in a sorted array.

(499 words)