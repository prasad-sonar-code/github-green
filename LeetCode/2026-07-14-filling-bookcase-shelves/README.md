# Filling Bookcase Shelves

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/filling-bookcase-shelves/)
- **Date**: 2026-07-14
- **Language**: java


**The Problem**

Given an array of books, each represented as an array of two integers `books[i] = [widthi, heighti]`, find the minimum number of shelves required to accommodate all books without any shelves overlapping. The shelves have infinite vertical space but limited shelf width.

**Initial Thoughts**

Initially, I tried a brute-force approach, checking all possible combinations of shelves and books. However, this approach had a time complexity of O(n^2), where n is the number of books. I needed a more efficient solution.

**The Core Trick**

The key insight was to use dynamic programming to keep track of the minimum height required to place the books on shelves up to that point. By iterating backward from the end of the array, we can update the minimum height for each book based on the height of the previous book(s) and the available shelf width.

**Complexity**

The time complexity of this solution is O(n), which is much more efficient than the brute-force approach. The space complexity is O(n) for storing the dynamic programming array.

**Key Takeaway**

When faced with a problem involving dynamic programming, always start by trying basic solutions such as brute-force or bottom-up approaches. Once you identify the key insight, use it to design a more efficient solution.