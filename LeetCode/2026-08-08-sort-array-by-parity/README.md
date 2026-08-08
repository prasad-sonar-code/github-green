# Sort Array By Parity

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/sort-array-by-parity/)
- **Date**: 2026-08-08
- **Language**: java


**The Problem**

Given an array of integers, sort it in ascending order based on its parity (i.e., if an element is even, place it at the front of the array; if it's odd, place it at the end).

**Initial Thoughts**

At first, I tried to use two pointers to iterate through the array and swap elements based on their parity. However, this solution had a time complexity of O(n^2), as it required multiple passes through the array. I quickly realized that I could use a single pass through the array and maintain two indices - one for even numbers and one for odd numbers - to sort the array in linear time.

**The Core Trick**

In this problem, the core trick is using the modulus operator (%) to check if a number is even or odd, and then placing it in the correct index of the result array based on its parity. This approach allows us to sort the array in linear time, without requiring multiple passes through the array.

**Complexity**

The time complexity of this solution is O(n), where n is the length of the input array, as we iterate through the array only once. The space complexity is also O(n) due to the creation of a new array to store the sorted result.

**Key Takeaway**

This problem serves as a reminder of the importance of using efficient algorithms and data structures, especially when working with large arrays. By using the modulus operator and maintaining two indices, we were able to sort the array in linear time, demonstrating the power of careful thinking and optimization.