class Solution {
    // Time complexity: O(n^2), Space complexity: O(n)
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            int w = 0, h = 0;
            dp[i] = dp[i - 1] + books[i - 1][1];
            for (int j = i - 1; j >= 0; j--) {
                w += books[j][0];
                if (w > shelfWidth) break;
                h = Math.max(h, books[j][1]);
                dp[i] = Math.min(dp[i], dp[j] + h);
            }
        }
        
        return dp[n];
    }
}