# Sum of Digits of String After Convert

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/sum-of-digits-of-string-after-convert/)
- **Date**: 2026-08-15
- **Language**: java


**The Problem**

Given a string `s` and an integer `k`, convert every character `s` to its corresponding position in a new string `s2`. Then, sum up all the digits of each character in `s2`. Finally, convert every character in `s2` back to its corresponding letter and return the resulting string `s3`.

**Initial Thoughts**

Initially, I thought about using a brute-force approach by converting each character to its position, summing up the digits, then converting the sum back to a character. However, this approach would have a time complexity of O(n^2), which is too slow for large inputs.

**The Core Trick**

The key insight here is that we only need to use a loop to iterate through the characters in `s` once, as the conversion to position only depends on the current character and the length of the string. Then, we use a second loop to sum up the digits and convert them back to characters, with a time complexity of O(n * k * log(n * 26)) since we need to convert each digit to a character, which takes log time.

**Complexity**

Time complexity: O(n + k * log(n * 26))
Space complexity: O(n)

**Key Takeaway**

Always think about the time complexity and space complexity of the algorithms you come up with, especially when dealing with problems that require multiple loops or conversions. In this case, the key insight was to realize that we can iterate through the characters in `s` once and use a second loop to sum up the digits, which significantly reduces the time complexity.