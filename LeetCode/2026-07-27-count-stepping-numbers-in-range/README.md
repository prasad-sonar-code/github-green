# Count Stepping Numbers in Range

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/count-stepping-numbers-in-range/)
- **Date**: 2026-07-27
- **Language**: java


Problem: Count Stepping Numbers in Range

Difficulty: Hard

Initial Thoughts:
This problem seems daunting at first, but I quickly realized that it's all about generating and counting all possible stepping numbers with a specific length within a given range. I had some false starts and brute-forced solutions, but they didn't work well with the time constraints.

The Core Trick:
After some thought, I realized that I could use a recursive function to generate each number and then count them within the given range. I also needed to use a helper function to generate all possible numbers of a given length.

Complexity:
Time complexity: O(n \* 10^5), where n is the length of the high number. This is because we have two loops, one for generating numbers and another for counting them. The number of steps in each loop is related to the length of the high number.

Space complexity: O(n \* 10^5), as we need to store intermediate results for each generated number.

Key Takeaway:
Generating and counting all possible numbers with a specific length within a given range can be a complex task, but using a recursive function and a helper function can make it more approachable. Make sure to test your solutions with edge cases and time constraints to avoid getting stuck in false starts.