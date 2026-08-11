# Merge Two Sorted Lists

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/merge-two-sorted-lists/)
- **Date**: 2026-08-11
- **Language**: java


Merging two sorted lists is a classic problem in Data Structures. I found it easy because I knew how to handle situations where one list ends before the other. The core trick is to compare the values in both lists and swap the nodes if necessary. This ensures that the resulting list is also sorted.

The complexity is O(n + m) because we have two nested loops, one for each list. This makes sense since we need to iterate through each node in both lists exactly once. The space complexity is O(1) since we don't need any extra space other than what's used by the dummy node.

I'll remember this problem for next time because it's a great example of how to handle edge cases when merging two sorted lists.