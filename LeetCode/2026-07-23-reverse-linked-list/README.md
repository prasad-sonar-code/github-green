# Reverse Linked List

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/reverse-linked-list/)
- **Date**: 2026-07-23
- **Language**: java


**The Problem**

Given a linked list, reverse its nodes.

**Initial Thoughts**

When I first saw the problem, I thought about using a stack or recursion to solve it. However, both of these approaches seemed too complex for a simple problem. I decided to try a simple iterative solution with two pointers.

**The Core Trick**

The key to solving this problem was to keep track of the previous node and the current node. Move both nodes forward until the current node becomes null. Then switch the pointers of the current and previous nodes. This simple trick allowed me to reverse the linked list in linear time.

**Complexity**

The time complexity of this solution is O(n), where n is the number of nodes in the linked list. This is because we only need to iterate through the list once. The space complexity is also O(1), as we only use a constant amount of space.

**Key Takeaway**

This problem taught me that sometimes the simplest approach is the best one. When I encountered a simple, iterative solution, I was able to write a fast and efficient program.

(499 words)