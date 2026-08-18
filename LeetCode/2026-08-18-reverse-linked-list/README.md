# Reverse Linked List

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/reverse-linked-list/)
- **Date**: 2026-08-18
- **Language**: java


**The Problem**

Given a linked list, reverse its nodes.

**Initial Thoughts**

When I first saw the problem, I thought about using a stack or recursion to solve it. However, both of these approaches seemed too complex for a simple problem like this. Recursion might be overkill and the stack space could be a bottleneck for large lists.

**The Core Trick**

The key to solving this problem is to think like a programmer, breaking down the problem into smaller, manageable parts. Instead of trying to reverse the entire list at once, I decided to start by creating a new list with the reversed nodes. Then, I iterated through the original list, updating the next pointers in the new list.

**Complexity**

The time complexity of this solution is O(n), where n is the number of nodes in the list. This is because we only need to iterate through the list once to reverse the nodes. The space complexity is also O(1), as we only use a constant amount of space to store the new list and update the pointers.

**Key Takeaway**

When solving a problem like this, it's important to start by identifying the core trick or technique that will make the solution more manageable. In this case, breaking down the problem into smaller parts helped me to focus on what was really needed to solve the problem efficiently.