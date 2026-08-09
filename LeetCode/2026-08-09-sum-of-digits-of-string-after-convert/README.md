# Sum of Digits of String After Convert

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/sum-of-digits-of-string-after-convert/)
- **Date**: 2026-08-09
- **Language**: java


**The Problem**

Given a string `s` and an integer `k`, convert every character of `s` to its corresponding character with the smallest index in `s`, and then sum up the digits of those characters. For example, if `s = "cab"`, after converting each character to its corresponding smallest index, `s = "0b1"`. The sum of digits of `s` is 0 + 1 + 1 = 2. If `k = 2`, the process is repeated twice.

**Initial Thoughts**

This problem seems straightforward, but I struggled with the edge cases and the time complexity. Initially, I tried converting each character to its corresponding index and then summing up the digits, but it didn't work, especially for large values of `k`. I also tried using a map to store the mapping of characters to indices, but it was too slow.

**The Core Trick**

The key to solving this problem is to convert the string into digits and then sum up those digits. I realized that if I repeatedly convert the digits to their smallest index, the process will eventually result in a single digit, which is easy to handle.

**Complexity**

The time complexity is O(n + k * log(n * 26)) because we are converting each character to its corresponding index, which is a logarithmic operation. The space complexity is O(n) as we are storing the converted string in a temporary variable.

**Key Takeaway**

This problem taught me the importance of understanding edge cases and time complexity when solving coding problems. It also reinforced the importance of thinking creatively and using the right approach to solve problems.