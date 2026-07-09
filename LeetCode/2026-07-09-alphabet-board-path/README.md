# Alphabet Board Path

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/alphabet-board-path/)
- **Date**: 2026-07-09
- **Language**: java


Problem: Alphabet Board Path

Difficulty: Medium

The problem asks to find a path to reach the target string on a 3x5 board, given a starting position and the target string. Each position on the board has a unique integer value from 0 to 24. The path can move 'U' (up), 'D' (down), 'L' (left), and 'R' (right) to adjacent positions, and ends with a '!' character.

Initial Thoughts: I'm thinking of using a brute-force approach, where I try all possible combinations of moves and check if they lead to the target string. But that seems inefficient for a medium difficulty problem.

The Core Trick: The key to solving this problem is the structure of the board and the target string. I notice that the target string is formed by concatenating the unique integer values of the positions in a specific order. This suggests a topological sort approach, where I first sort the positions in the target string by their integer values and then construct the path from the top left corner to the bottom right corner.

Complexity: The time complexity of this solution is O(n), where n is the length of the target string. This is because we perform a single topological sort on the sorted positions. The space complexity is O(1), as we only use a constant amount of additional data structures.

Key Takeaway: Always look for patterns and structure in problems to simplify the solution. In this case, the structure of the board and the target string helped me identify a topological sort approach and optimize the solution.