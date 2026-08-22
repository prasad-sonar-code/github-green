# Find Substring With Given Hash Value

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/find-substring-with-given-hash-value/)
- **Date**: 2026-08-22
- **Language**: java


**The Problem**

Given a string `s`, two integers `power`, `modulo`, an integer `k`, and a hash value `hashValue`, find the first substring of `s` with a hash value equal to `hashValue`.

**Initial Thoughts**

I thought about using a sliding window approach, but I didn't know how to calculate the hash value efficiently. I also tried using a brute-force method, but it was too slow.

**The Core Trick**

I realized that I could calculate the hash value using a polynomial hash function, which reduces the time complexity to O(n). I also used a modulo operation to ensure that the hash values remain within a certain range.

**Complexity**

The time complexity of this solution is O(n), as we are iterating through the string once. The space complexity is O(1), as we only use a constant amount of space.

**Key Takeaway**

This problem taught me the importance of using efficient algorithms and data structures when solving problems like this. I also learned that sometimes, there are multiple ways to approach a problem, and understanding the core trick behind it can lead to a more elegant solution.