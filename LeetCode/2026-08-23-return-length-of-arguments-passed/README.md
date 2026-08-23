# Return Length of Arguments Passed

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/return-length-of-arguments-passed/)
- **Date**: 2026-08-23
- **Language**: java


**The Problem**
Given an array of arguments (represented by `Object... args`), return its length.

**Initial Thoughts**
Hmm, this seems straightforward. I can just return the length of the args array using the built-in `length` method. But what happens if the arguments are not an array? I should check if the `args` variable is null or empty.

**The Core Trick**
The key to this problem is checking if `args` is null or empty. If it is, I need to return 0, as an empty array has length 0. If it's not, I can simply return its length.

**Complexity**
Time complexity: O(1), as I'm just accessing an element from a constant-time array. Space complexity: O(1), as I'm not using any additional data structures.

**Key Takeaway**
Always check for edge cases and null/empty inputs. It might seem like a simple problem, but it's essential to handle all possibilities to avoid unexpected behavior.