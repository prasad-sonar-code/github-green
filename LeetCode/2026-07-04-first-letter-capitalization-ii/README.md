# First Letter Capitalization II

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/first-letter-capitalization-ii/)
- **Date**: 2026-07-04
- **Language**: java


**The Problem**

Given a string `s`, find the string that results from converting each word (defined as a sequence of non-space characters) in `s` to title case. In title case, words begin with a capital letter and each subsequent word begins with a lowercase letter.

**Initial Thoughts**

At first, I thought this problem was similar to the First Letter Capitalization I problem, where we only need to capitalize the first letter of each word. However, this problem is more complex because we should also handle cases where words are hyphenated and need to be converted to title case.

**The Core Trick**

To solve this problem, I needed to find a way to identify words and handle hyphenated words. I decided to use a regex pattern to split the string into words and then apply the title case conversion to each word. This allowed me to handle both single and hyphenated words.

**Complexity**

The time complexity of this solution is O(n*m) where n is the number of rows and m is the average length of content\_text. This is because we need to iterate over every character in the string once, and the regex pattern used to split the string into words has a constant time complexity. The space complexity is also O(n*m) as we need to store the result table.

**Key Takeaway**

This problem taught me the importance of being aware of various edge cases and how to handle them effectively. By using a regex pattern to split the string into words and then applying the title case conversion, I was able to solve this problem efficiently and effectively.