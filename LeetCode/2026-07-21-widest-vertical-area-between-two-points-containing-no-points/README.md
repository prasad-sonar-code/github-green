# Widest Vertical Area Between Two Points Containing No Points

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/)
- **Date**: 2026-07-21
- **Language**: java


**The Problem**
Given an array of points, where each point is represented as an array with two elements: x and y coordinates. The task is to find the width of the vertical area between two points that contain no other points.

**Initial Thoughts**
This problem seems trivial. I thought about using a for loop to iterate through the array, but I realized that this would have a time complexity of O(n^2), which is too slow for large datasets. I then remembered that the points are sorted by x coordinate, so I could use this fact to my advantage.

**The Core Trick**
The key to solving this problem is to use the sorted order of the points. If two points have the same x coordinate, then they must be vertically aligned, which means that the width of the vertical area between them is the difference in y coordinates. By sorting the points by x coordinate, I can easily identify these pairs and calculate the difference in y coordinates to find the maximum width.

**Complexity**
The time complexity of this solution is O(n log n) due to the sorting of the points. The space complexity is O(n) for storing the sorted points array in Java.

**Key Takeaway**
This was a nice problem to practice sorting algorithms. I learned that sorting can be very useful when dealing with vertical areas or other geometric problems that involve points with the same x coordinate.