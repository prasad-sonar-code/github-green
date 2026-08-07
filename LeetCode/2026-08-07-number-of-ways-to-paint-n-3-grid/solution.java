class Solution {
    public int numOfWays(int n) {
        // Time complexity: O(n)
        // Space complexity: O(1)
        int MOD = (int) 1e9 + 7;
        long a = 6, b = 6, c = 8, d = 4, e = 4, f = 4;
        for (int i = 2; i <= n; i++) {
            long na = (a + b + c + d + e + f) % MOD;
            long nb = (a + b + c + d) % MOD;
            long nc = (a + b + c + e + f) % MOD;
            long nd = (a + b + d + e) % MOD;
            long ne = (a + c + d + f) % MOD;
            long nf = (b + c + e + f) % MOD;
            a = na; b = nb; c = nc; d = nd; e = ne; f = nf;
        }
        return (int) ((a + b + c + d + e + f) % MOD);
    }
}