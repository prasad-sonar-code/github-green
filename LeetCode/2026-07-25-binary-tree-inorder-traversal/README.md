# Binary Tree Inorder Traversal

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- **Date**: 2026-07-25
- **Language**: java


**The Problem**

Given a binary tree, write a function to perform inorder traversal and return a list of integers representing the order in which nodes are visited.

**Initial Thoughts**

Initially, I thought of using recursion to traverse the tree and add each node's value to a list. However, I realized that recursion can be slow for large trees due to the call stack. I decided to use an iterative approach with a stack to visit the nodes in the correct order.

**The Core Trick**

The core trick in this problem is to use a stack to keep track of the nodes to be visited in the left subtree, then the current node, and finally the nodes in the right subtree. By popping elements from the stack in each step, we ensure that the nodes are visited in the correct order.

**Complexity**

The time complexity of this solution is O(n), where n is the number of nodes in the tree, as we traverse the tree in-order. The space complexity is O(h), where h is the height of the tree (worst case: O(n) for unbalanced tree), as we store the stack elements in the worst case.

**Key Takeaway**

This problem demonstrates the importance of using the correct data structures and algorithms to solve problems efficiently. In this case, using a stack to manage the nodes to be visited in each subtree makes the solution faster and more straightforward.