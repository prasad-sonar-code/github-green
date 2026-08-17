class Solution {
    // Time complexity: O(log n)
    // Space complexity: O(1)
    public int countBinaryPalindromes(long n) {
        int count = 0;
        for (int len = 1; len <= 64; len++) {
            // Count all palindromes of length < len
            if (len < 64) {
                count += (1 << (len - 1));
            } else {
                // For length = len, extract the prefix of n, mirror it, and check if it exceeds n
                long prefix = n >> (len / 2);
                long mirrored = mirror(prefix, len);
                if (mirrored <= n) {
                    count++;
                }
            }
        }
        return count;
    }

    // Mirror the prefix to form a palindrome
    private long mirror(long prefix, int len) {
        long mirrored = prefix;
        for (int i = 0; i < len / 2; i++) {
            mirrored = (mirrored << 1) | (prefix >> (len / 2 - 1 - i) & 1);
        }
        return mirrored;
    }
}