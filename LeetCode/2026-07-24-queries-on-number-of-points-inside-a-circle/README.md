# Queries on Number of Points Inside a Circle

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/)
- **Date**: 2026-07-24
- **Language**: java


The problem I solved today was "Queries on the Number of Points Inside a Circle" from LeetCode. I was tasked with finding the number of points inside a given circle for each query. 

My initial thoughts were to use a brute-force approach, iterating through all the points and checking if they're within the circle's radius for each query. However, this would be very inefficient for large datasets. 

The core trick here is to pre-compute the Euclidean distance between each point and the circle's center for all points and queries. This way, we can quickly check if a point is within the circle's radius for each query without having to recalculate the distance for each query. 

The time complexity of this solution is O(n*m), where n is the number of points and m is the number of queries. This is because we iterate through all points and queries once. The space complexity is O(m), as we store the result array for each query.

I'd remember to use a pre-computation technique when faced with a similar problem in the future.