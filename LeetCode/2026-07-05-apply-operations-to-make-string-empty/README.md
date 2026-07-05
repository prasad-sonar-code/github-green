# Apply Operations to Make String Empty

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/apply-operations-to-make-string-empty/)
- **Date**: 2026-07-05
- **Language**: java


**The Problem**

Given a string `s`, determine the lexicographically smallest non-empty string you can make by applying the following operations as many times as possible:

1. Remove one character from the current string.
2. Swap two adjacent characters.

**Initial Thoughts**

I approached this problem by first counting the frequency of each character in the string `s`. I then iterated through the string and applied the operations to make the frequency of a specific character equal to the maximum frequency. This ensures that the last non-empty string contains the most frequent character.

**The Core Trick**

The key to solving this problem lies in the fact that the lexicographically smallest non-empty string is the one that contains the most frequent character. By focusing on making the frequency of a specific character equal to the maximum frequency, we can efficiently find the last non-empty string.

**Complexity**

The time complexity of this solution is O(n), where n is the length of the input string `s`, due to the linear traversal of the string. The space complexity is also O(n) because we need to store the frequency counts and the reversed string in a StringBuilder.

**Key Takeaway**

When dealing with problems that involve operations on strings, think about which operations can help you get closer to the desired result. In this case, removing characters and swapping adjacent characters can help decrease the length of the string, making it easier to identify the most frequent character. By focusing on making the frequency of a specific character equal to the maximum frequency, we can efficiently find the last non-empty string.