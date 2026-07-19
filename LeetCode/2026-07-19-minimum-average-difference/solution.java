class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        long[] suffixSum = new long[n + 1];
        
        // Calculate prefix sum
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        // Calculate suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }
        
        int minDiffIndex = 0;
        long minDiff = Long.MAX_VALUE;
        
        // Calculate average difference at each index
        for (int i = 0; i < n; i++) {
            long leftAvg = prefixSum[i + 1] / (i + 1);
            long rightAvg = (i == n - 1) ? 0 : suffixSum[i + 1] / (n - i - 1);
            long diff = Math.abs(leftAvg - rightAvg);
            
            // Update minimum difference index
            if (diff < minDiff) {
                minDiff = diff;
                minDiffIndex = i;
            }
        }
        
        return minDiffIndex;
    }
}