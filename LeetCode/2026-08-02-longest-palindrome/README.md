# Longest Palindrome

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/longest-palindrome/)
- **Date**: 2026-08-02
- **Language**: java


**The Problem**

Given a string `s`, return the length of the longest palindromic substring.

**Initial Thoughts**

At first glance, this problem seems straightforward. I thought about creating a function that iterates through the string and checks if each substring is a palindrome. However, I quickly realized that this would be very slow for large strings. I also thought about using a hash map to count the frequency of each character in the string. If a character appears an odd number of times, that character will contribute to a palindrome, so I could skip it. But this would still be O(n^2) time complexity, which is too slow.

**The Core Trick**

The key to solving this problem efficiently is the use of odd and even counts of characters. If a character appears an odd number of times, it will contribute to a palindrome. On the other hand, if a character appears an even number of times, we can split it into two halves to form a palindrome. For example, `a` has an even count, so `aa` is a palindrome, and so is `abca`. To account for this, I added an additional check to increment `length` if the count of characters is even and the count of odd characters is one.

**Complexity**

The time complexity of this solution is O(n), where n is the length of the input string. This is because we iterate through the string only once. The space complexity is also O(1), since we don't use any additional data structures other than the character count array, which has a constant size.

**Key Takeaway**

This problem teaches us that sometimes, the key to solving a problem efficiently is recognizing patterns and using them to our advantage. In this case, I was able to reduce time complexity from O(n^2) to O(n) simply by noticing that characters with odd counts contribute to palindromes, while characters with even counts can be split into two halves to form a palindrome.