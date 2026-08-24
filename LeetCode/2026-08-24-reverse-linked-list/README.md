# Reverse Linked List

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/reverse-linked-list/)
- **Date**: 2026-08-24
- **Language**: java


**The Problem**

Given a linked list, reverse its nodes.

**Initial Thoughts**

When I first saw the problem, I thought about using a stack or recursion to solve it. However, both of these approaches seemed too complex for a simple problem. I decided to try a simple iterative solution with two pointers.

**The Core Trick**

The key to solving this problem was to keep track of the previous node and the current node. Move both nodes forward until the current node becomes null. Then switch the pointers of the current and previous nodes. This will reverse the linked list.

**Complexity**

The time complexity is O(n), where n is the number of nodes in the list. The space complexity is O(1), as we only use a constant amount of space.

**Key Takeaway**

When dealing with linked lists, it's important to break down the problem into smaller subproblems and think about how to reverse each section of the list. In this case, I used two pointers to reverse the list from head to tail.