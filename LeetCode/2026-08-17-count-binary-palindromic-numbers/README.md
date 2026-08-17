# Count Binary Palindromic Numbers

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/count-binary-palindromic-numbers/)
- **Date**: 2026-08-17
- **Language**: java


Today, I tackled a challenging problem on LeetCode: counting binary palindromic numbers up to a given `long` value. This was a great opportunity to dive into some advanced concepts in dynamic programming and number theory.

At first, I thought about the problem in a simple way, trying to enumerate all palindromes of different lengths and counting them. However, this approach had a time complexity of O(n^2), which was far too slow for larger values of `n`. I needed a more efficient algorithm.

The key trick here was to realize that for each length `len`, we can count all palindromes of that length or less. This allowed me to optimize the brute-force approach by only iterating through lengths up to `64` (the maximum length of a binary number). 

To handle palindromes of length `len`, I used a bitwise approach to mirror the prefix of a number and check if it's within the given range. This was crucial in optimizing the solution.

The final solution had a time complexity of O(log n) and a space complexity of O(1), which made it quite efficient.

This problem taught me the importance of thinking creatively when coming across hard problems. By breaking down the problem into smaller parts, I was able to develop an elegant and efficient solution. I'll remember this experience and apply it to future coding challenges.