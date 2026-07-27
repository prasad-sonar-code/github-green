class Solution {
    private static final int MOD = (int) 1e9 + 7;
    public int countSteppingNumbers(String low, String high) {
        int res = 0;
        for (int len = low.length(); len <= high.length(); len++) {
            for (int i = 1; i < 10; i++) {
                long cur = dfs(i, len - 1, true, true);
                if (len == low.length()) {
                    if (cur < Integer.parseInt(low)) {
                        res = (int) ((res - cur) % MOD);
                    }
                }
                if (len == high.length()) {
                    if (cur <= Integer.parseInt(high)) {
                        res = (int) ((res + cur) % MOD);
                    }
                }
            }
        }
        return res;
    }

    private long dfs(int cur, int len, boolean smaller, boolean larger) {
        if (len == 0) return 1;
        long res = 0;
        if (cur > 0) {
            if (smaller) {
                res += dfs(cur - 1, len - 1, true, larger);
            } else if (larger) {
                res += dfs(cur - 1, len - 1, true, larger);
            }
        }
        if (cur < 9) {
            if (larger) {
                res += dfs(cur + 1, len - 1, smaller, true);
            } else if (smaller) {
                res += dfs(cur + 1, len - 1, smaller, true);
            }
        }
        return res;
    }
}