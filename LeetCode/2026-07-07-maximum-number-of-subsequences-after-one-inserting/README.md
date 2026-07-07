# Maximum Number of Subsequences After One Inserting

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/maximum-number-of-subsequences-after-one-inserting/)
- **Date**: 2026-07-07
- **Language**: java


I tackled the "Maximum Number of Subsequences After One Inserting" problem on LeetCode today. It's a medium-difficulty question that asks to find the maximum number of subsequences after inserting one character to a given string.

Initially, I thought of using recursion but it was too slow for larger inputs. I then tried using dynamic programming but couldn't come up with an efficient solution. After some time, I realized that I needed to compute prefix sum and suffix sum arrays to efficiently process the problem. I also realized that I needed to consider the character types ('L', 'C', and 'T') while computing the prefix and suffix sums.

The complexity of my solution is O(n) in terms of both time and space, which is quite fast compared to the naive recursive solution. I used Java for this problem.

The key takeaway from this problem is the importance of understanding the constraints and thinking about efficient algorithms in dynamic programming problems.