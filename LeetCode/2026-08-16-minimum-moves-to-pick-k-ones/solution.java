class Solution {
    // Time complexity: O(n log n)
    // Space complexity: O(n)
    public long minimumMoves(int[] nums, int k, int maxChanges) {
        int n = nums.length;
        int ones = 0;
        for (int num : nums) {
            if (num == 1) ones++;
        }
        
        if (ones < k) return -1;
        
        int[] indices = new int[ones];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                indices[index++] = i;
            }
        }
        
        int median = indices[k - 1];
        long minMoves = Long.MAX_VALUE;
        
        for (int i = 0; i < ones; i++) {
            long moves = 0;
            int changes = 0;
            for (int j = 0; j < k; j++) {
                int distance = Math.abs(indices[(i + j) % ones] - median);
                if (distance > 1) {
                    moves += distance - 1;
                    if (nums[median - distance + 1] == 0) {
                        changes++;
                    }
                }
            }
            if (changes <= maxChanges) {
                minMoves = Math.min(minMoves, moves + changes);
            }
        }
        
        return minMoves;
    }
}