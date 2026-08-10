# Minimum Amount of Time to Fill Cups

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/)
- **Date**: 2026-08-10
- **Language**: java


**The Problem**

Given an array of three integers `amount`, where each integer represents the amount of water a cup can hold in milliliters. Find the minimum amount of time required to fill all three cups completely.

**Initial Thoughts**

My initial reaction was that this problem seems straightforward and should have a simple solution. I tried a brute-force approach by iterating through all possible combinations of filling cups in the minimum amount of time, but it quickly became apparent that this would be too slow.

**The Core Trick**

After some thought, I realized that the problem is actually asking for the maximum amount of water that can be filled in the shortest amount of time. This means that the time required to fill each cup should be proportional to the amount of water that can be filled in that cup.

**Complexity**

The time complexity of this solution is O(1), as it only depends on the fixed input size of three integers. The space complexity is also O(1), since we only use a constant amount of space to store the results.

**Key Takeaway**

When faced with a problem that seems straightforward at first glance, take the time to think critically about the constraints and constraints of the problem statement. Often, there is a clever solution that leverages the specific characteristics of the problem.