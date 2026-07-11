# Maximum Length of a Concatenated String with Unique Characters

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/)
- **Date**: 2026-07-11
- **Language**: java


Problem: Given an array of strings, find the length of the longest string that can be formed by concatenating any non-overlapping two strings in the array, where the resulting string must have unique characters.

Initial Thoughts: This problem seems challenging because it requires a recursive approach to try all possible combinations of strings and check if they form a valid, unique string. I thought about using a backtracking algorithm to explore all possible combinations, but I realized that would be too slow with the given time complexity of O(n * 2^n), where n is the number of strings in the array. I needed to find a more efficient solution.

The Core Trick: I noticed that if a string has a unique character, then any other string with that character cannot be part of the combination. This observation led me to create a mask for each string, where each bit represents a unique character in the string. If a bit is set, it means that string has that character. Then, I used the mask to check if a combination could form a valid string.

Complexity: Time complexity is O(n * 2^n), which is still too high. To improve this, I can optimize the mask creation process by only checking the characters that are valid for the current combination. This way, I can avoid checking any characters that are already present in the combination.

Key Takeaway: This problem taught me the importance of optimization and thinking creatively about the problem domain. By recognizing the relationship between the strings and their unique characters, I was able to create an efficient solution that solved the problem in a short amount of time.