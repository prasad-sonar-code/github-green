# Merge Two Sorted Lists

- **Difficulty**: Easy
- **Source**: [Backlog](https://leetcode.com/problems/merge-two-sorted-lists/)
- **Date**: 2026-07-20
- **Language**: java


Today, I tackled the "Merge Two Sorted Lists" problem on LeetCode. This exercise was easy, so I didn't spend too much time on it, but I still found it interesting. The problem required merging two sorted linked lists into one, with a time complexity of O(n + m) and space complexity of O(1).

My initial thoughts were to use a while loop to iterate through both lists simultaneously, comparing their values and appending the smaller one to the result. This would ensure that the resulting list would also be sorted. I also made sure to handle the case where one list is empty, by simply appending the remaining nodes to the result.

The core trick in my solution was to use a dummy node to simplify the code. This approach helped me avoid using additional variables to keep track of the current node, making the code more readable and easier to maintain.

In terms of complexity, I assumed that n and m were the lengths of the two linked lists, which is a reasonable assumption given the problem's requirements. My solution runs in O(n + m) time due to the while loop, and uses a constant amount of space.

For next time, I'd remember to always consider using dummy nodes for similar problems, as it can help simplify the code and make it more readable.