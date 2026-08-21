# Count Pairs That Form a Complete Day II

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii/)
- **Date**: 2026-08-21
- **Language**: java


**The Problem**

Given an array of `hours` representing the number of hours worked per day. The goal is to count all pairs of employees who worked a full day (8 hours) or its complement. 

**Initial Thoughts**

Initially, I thought that brute-forcing all pairs and checking if the difference between their hours is equal to 8 would be the simplest solution. However, this approach has a time complexity of O(n^2) due to the nested loops. This is not an ideal solution for large inputs.

**The Core Trick**

To solve this problem efficiently, I needed to count the number of pairs that have a complement of 8 or 0 hours. This is because, for every pair of employees who worked full days, there's a pair with the complement of 8 hours. This idea allowed me to reduce the problem to a single pass over the input array.

**Complexity**

The time complexity is O(n), where n is the number of hours. This is because we are counting the occurrences of each hour in the input array and updating the count for the complementary hour only once. The space complexity is O(1), as we are using a constant amount of extra space to store the count array.

**Key Takeaway**

This problem serves as a reminder that sometimes, the simplest solution isn't the most efficient one. In this case, identifying pairs that have a complement of 8 hours allowed me to reduce the problem to a single pass over the input array, leading to an efficient and elegant solution.