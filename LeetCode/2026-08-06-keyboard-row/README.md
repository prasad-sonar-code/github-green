# Keyboard Row

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/keyboard-row/)
- **Date**: 2026-08-06
- **Language**: java


**The Problem**

Given an array of strings `words`, find all the words in `words` that can be typed using letters on the top row of a keyboard (`row1`). If the word can also be typed using the middle row (`row2`), add it to the list of results. If it can also be typed using the bottom row (`row3`), add it to the list of results. Return all the words in the list as a single array.

**Initial Thoughts**

Initially, I tried to check if each word contains only the letters in `row1`, `row2`, or `row3`. However, this approach has a time complexity of O(n^2) because it checks each letter for every word.

**The Core Trick**

Instead of checking for each letter, I decided to iterate through each row and check if a word contains only the letters in that row. This way, we can avoid redundant checks and improve the time complexity to O(n*m) where n is the number of words and m is the maximum length of a word.

**Complexity**

The space complexity remains O(n) as we store the result in a list.

**Key Takeaway**

This problem teaches us the importance of avoiding redundant checks and finding the most efficient solution, especially when dealing with large datasets.