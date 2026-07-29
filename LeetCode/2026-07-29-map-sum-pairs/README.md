# Map Sum Pairs

- **Difficulty**: Medium
- **Source**: [Leetcode](https://leetcode.com/problems/map-sum-pairs/)
- **Date**: 2026-07-29
- **Language**: java


Problem: Map Sum Pairs

Difficulty: Medium

The problem asks to design and implement a data structure for a map-like functionality where the keys are strings and the values are integers. The map supports the following operations: `insert(key, val)` and `sum(prefix)`.

Initial Thoughts:

At first, I tried to use a hash map to store the values for each key, but it would have a time complexity of O(1) for insert and O(n) for sum when the keys are prefix. I then thought about using a trie data structure for this problem.

The Core Trick:

Using a trie data structure allows for fast insert operations with a time complexity of O(1) since each character in a key is added to the trie as we iterate through it. This is because each node in the trie has at most 26 children, and we only need to traverse the trie from the root to the leaf node.

Complexity:

Time complexity: O(1) for insert, O(n) for sum where n is the number of keys with the given prefix. This is because the trie structure allows for fast lookups and insertions. Insertion starts from the root and traverses the trie to the leaf node where the value is added, while the sum operation traverses the trie to find the total sum of values for the given prefix.

Space complexity: O(n) where n is the number of keys. This is because each node in the trie can have at most 26 children, and we need to store all the keys with their corresponding values.

Key Takeaway:

Tries are an efficient data structure for storing and retrieving data with a given prefix. They are also useful when dealing with string-based data.