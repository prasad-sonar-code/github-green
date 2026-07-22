# Binary Tree Inorder Traversal

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- **Date**: 2026-07-22
- **Language**: java


**The Problem**

Given a binary tree, write a function to perform inorder traversal and return a sorted list of its values.

**Initial Thoughts**

At first, I thought about using an iterative approach with a stack, but I knew it would be slower because of the constant overhead of creating a new stack frame for each recursive call. I decided to use recursion instead. I also tried to think about how to handle edge cases like empty trees and trees with only one node.

**The Core Trick**

The key idea is to use two helper functions: one for traversing left subtree and another for traversing right subtree. We call these functions recursively on the left and right subtrees, respectively, and add the current node's value to the result list.

**Complexity**

Time complexity: O(n), where n is the number of nodes in the tree. This is because we traverse each node exactly once.

Space complexity: O(n), for the recursion stack and the result list. This is because we use recursion, which requires a stack to store function calls.

**Key Takeaway**

This problem is a great opportunity to practice recursion and think about edge cases. It also showed me the importance of considering time and space complexity when designing algorithms.