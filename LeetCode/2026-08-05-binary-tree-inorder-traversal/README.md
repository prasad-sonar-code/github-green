# Binary Tree Inorder Traversal

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- **Date**: 2026-08-05
- **Language**: java


**The Problem**

Given a binary tree, write a function to perform inorder traversal and return a list of integers representing the order in which nodes are visited.

**Initial Thoughts**

Initially, I thought of using recursion to traverse the tree and collect the result in a list. This would involve two helper functions: one for the recursive call and another to add the node value to the result list.

**The Core Trick**

What makes this problem interesting is the use of recursion. I noticed that each recursive call visits the left subtree first, then the current node, and finally the right subtree. This pattern can be exploited to traverse the tree inorder.

**Complexity**

Time complexity: O(n), where n is the number of nodes in the tree. This is because each node is visited once, and the depth of the tree is at most log n. Space complexity: O(n), for the recursion stack and the result list.

**Key Takeaway**

For problems involving recursion, it's important to understand the pattern of the recursion tree and how it relates to the traversal order. In this case, by exploiting the pattern of left, current, right, we get an easy solution with a clean time and space complexity.