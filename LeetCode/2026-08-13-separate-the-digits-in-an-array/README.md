# Separate the Digits in an Array

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/separate-the-digits-in-an-array/)
- **Date**: 2026-08-13
- **Language**: java


The problem today was to separate the digits in an array of integers. The difficulty level was easy but the complexity was moderate due to the presence of large numbers.

At first, I thought of iterating through the array of integers and converting each integer to a string, then splitting it into a string array of digits, and finally converting each digit back to an integer and storing it in a new array. However, this approach would have a time complexity of O(n*m) where n is the length of the input array and m is the maximum number of digits in an integer. This was not efficient enough for large inputs.

The core trick was to iterate through the array of integers, convert each integer to a String, and then convert each character in the string to an integer and store it in a new array. This approach has a time complexity of O(n*m) but a space complexity of O(n*m) which is more efficient since it doesn't require a separate step for splitting the string into an array.

The key takeaway from this problem is that for problems related to arrays of integers, converting to a string and then back to integers can be a time and space-efficient approach, especially when dealing with large inputs.