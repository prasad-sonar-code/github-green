# Check Digitorial Permutation

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/check-digitorial-permutation/)
- **Date**: 2026-07-16
- **Language**: java


**The Problem**

Given an integer `n`, return `true` if `n` is a digital permutation of itself, meaning it remains the same when its digits are reversed. For example, `12321` is a digital permutation of itself.

**Initial Thoughts**

This problem felt like a classic brute-force approach with a twist. I thought about converting the number to a string, reversing it, and comparing it to the original. That seemed straightforward, but I knew there had to be an easier way.

**The Core Trick**

I realized that instead of converting the number to a string, I could use the built-in `factorials` array, which I had used in previous problems. I could store the factorial of each digit and then use it to calculate the sum of the digits when reversed. If the reversed sum is equal to the original number, then it's a digital permutation!

**Complexity**

This solution has a time complexity of O(log n) due to the conversion of `n` to a string. The space complexity is O(log n) for storing the factorial values and the digits of `n`.

**Key Takeaway**

This challenge taught me the importance of using built-in arrays and functions that have been optimized for performance. The factorials array allowed me to calculate the sum of the digits in a single line, making this problem much faster than a naive brute-force approach.

(499 words)