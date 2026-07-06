# Valid Parentheses

- **Difficulty**: Easy
- **Source**: [Leetcode](https://leetcode.com/problems/valid-parentheses/)
- **Date**: 2026-07-06
- **Language**: java


**The Problem**

Given a string containing only three types of characters: '(', ')', '[' and ']', determine whether the parentheses are balanced. A pair of parentheses is balanced if the opening parenthesis (e.g., '(' or '[') matches with a closing parenthesis that is of the same type but closes the other pair (e.g., ')' or ']').

**Initial Thoughts**

At first, I tried using a hash map to store the opening and closing parentheses. If the opening parenthesis is found, I added it to the map. Then, for each closing parenthesis, I checked if its corresponding opening parenthesis was in the map. If it was, I removed it from the map. If not, the parentheses were not balanced. However, I faced a time complexity issue as I needed to iterate through the entire string for each closing parenthesis, leading to O(n^2) time complexity.

**The Core Trick**

To improve the time complexity, I decided to use a stack to keep track of the opening parentheses. Whenever an opening parenthesis is encountered, I push it onto the stack. For each closing parenthesis, I pop the top element off the stack. If the popped element is not the corresponding opening parenthesis in type (e.g., ')' or ']'), the parentheses are not balanced. If the stack is empty after processing all closing parentheses, the parentheses are balanced.

**Complexity**

Time complexity: O(n), where n is the length of the string. This is because we iterate through the string only once. Space complexity: O(n), where n is the length of the string. This is because we need to store the opening parentheses on the stack.

**Key Takeaway**

This problem requires a good understanding of the basic data structures used in programming. In this case, we used a stack to remove elements efficiently. The approach I took is a well-known technique and can be applied to other problems involving parentheses or other brackets.