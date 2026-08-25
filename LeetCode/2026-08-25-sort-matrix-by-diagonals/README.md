# Sort Matrix by Diagonals

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/sort-matrix-by-diagonals/)
- **Date**: 2026-08-25
- **Language**: java


Problem: Sort Matrix by Diagonals

This problem required me to sort a matrix by its diagonals. My initial thoughts were to create two separate arrays for each diagonal, sort them, and then merge them back into the original matrix. However, this approach had a time complexity of O(n^2) for the sorting step and O(n^2) for the merging step, leading to a total time complexity of O(n^4). I needed to find a more efficient solution.

The core trick I stumbled upon was the observation that since the matrix is symmetric (i.e., all elements in the same row have the same index in the corresponding column), I could only need to maintain one sorted array for each diagonal. Then, I could simply iterate through the columns in decreasing order of their indices and swap elements from the original matrix with their corresponding elements in the sorted arrays. This approach significantly reduced the time complexity to O(n^2 log n) due to the sorting step, which is implemented using a binary heap.

Complexity:
Time complexity: O(n^2 log n)
Space complexity: O(n^2)