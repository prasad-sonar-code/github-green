# Chalkboard XOR Game

- **Difficulty**: Hard
- **Source**: [Leetcode](https://leetcode.com/problems/chalkboard-xor-game/)
- **Date**: 2026-08-20
- **Language**: java


**The Problem**

The problem asks to solve the Chalkboard XOR Game. Given a list of integers where each number is a potential token, determine if the winner can be determined by XORing all the numbers together. If the XOR result is zero, the game ends as a draw. If the XOR result is non-zero, and the number of tokens is odd, the winner is determined by XORing all the tokens together. Otherwise, if the XOR result is non-zero and the number of tokens is even, the winner is determined by XORing all the tokens except one.

**Initial Thoughts**

At first, I thought of using a brute-force approach by XORing all the numbers together and checking if the result is zero or not. But this would have a time complexity of O(n^2) as it would require two loops to XOR all the numbers. This solution seemed inefficient, so I decided to think of a more optimized approach.

**The Core Trick**

The key idea was to take advantage of the property that XOR is a commutative and associative operation. This means that XORing the numbers in any order and combining the results in any way will give the same XOR value. This allowed me to iterate over the numbers only once and perform a single XOR operation to determine the winner.

**Complexity**

The time complexity of this solution is O(n), which is significantly better than the brute-force approach. The space complexity is O(1) as no additional data structures are required.

**Key Takeaway**

This problem taught me a valuable lesson about the importance of understanding the properties of mathematical operations in problem-solving. By leveraging the commutative and associative properties of XOR, I was able to simplify the problem and come up with an efficient solution.