class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        long[] suffixMin = new long[n];
        
        // Compute prefix sums
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        
        // Compute suffix minimums
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }
        
        // Compute maximum score
        long maxScore = Long.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            long score = prefixSum[i] - suffixMin[i + 1];
            maxScore = Math.max(maxScore, score);
        }
        
        return maxScore;
    }
}