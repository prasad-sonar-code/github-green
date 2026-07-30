# Subtract the Product and Sum of Digits of an Integer

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/)
- **Date**: 2026-07-30
- **Language**: java


**The Problem**

Given an integer `n`, the problem asks to subtract the product and sum of its digits. For example, if `n = 123`, the product of digits is `1*2*3 = 6`, and the sum of digits is `1 + 2 + 3 = 6`. The difference between these two values is `6 - 6 = 0`.

**Initial Thoughts**

At first, I tried to solve this problem using recursion, but I thought it might be too slow for large inputs. Then I remembered that the problem required O(log n) time complexity, so I decided to use a loop instead. I also noticed that I could use a single variable `product` to keep track of both product and sum of digits.

**The Core Trick**

The core trick in this problem is to iterate through the digits of the number and calculate both product and sum simultaneously. This way, I can use the same variable `product` for both purposes.

**Complexity**

This solution has a time complexity of O(log n) because I only iterate through the digits of the number once. The space complexity is O(1) as I only use the same number of variables as the problem statement requires.

**Key Takeaway**

When working on a problem with a specific time complexity limit, it's important to think creatively and explore different solutions, even if they seem unconventional at first. In this case, I initially thought of using recursion but later realized that a loop was a more efficient and straightforward solution.