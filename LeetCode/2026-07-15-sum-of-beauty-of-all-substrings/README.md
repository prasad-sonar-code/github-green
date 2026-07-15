# Sum of Beauty of All Substrings

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/sum-of-beauty-of-all-substrings/)
- **Date**: 2026-07-15
- **Language**: java


Problem: Sum of Beauty of All Substrings
Difficulty: Medium
Source: Leetcode

My solution code:

The problem asks to find the sum of beauty of all substrings in a string. The beauty of a substring is defined as the difference between the frequency of the most frequent character and the frequency of the least frequent character. For example, in the string "abacaba", the beauty of the substring "aba" is 2 - 0 = 2, as 'a' has frequency 2 and 'b' has frequency 0.

Initial Thoughts: I first tried a brute-force approach, iterating through all substrings and calculating their beauty. However, this solution has a time complexity of O(n^3), which is not feasible for large inputs.

The Core Trick: To optimize the solution, I realized that for each substring, the beauty is determined by the frequency of the most frequent character and the least frequent character in the entire string. Therefore, I can iterate through the string only once and maintain a prefix sum for each character, which will help me calculate the frequency of each character in a substring efficiently.

Complexity: The time complexity of this solution is O(n^2), with each operation taking constant time. The space complexity is O(n), which is the size of the prefix sum array.

Key Takeaway: When dealing with problems involving substrings and frequencies, it's essential to consider the overall frequency of each character and how it affects the beauty of a substring. This insight helped me optimize the solution and achieve a more efficient time complexity.