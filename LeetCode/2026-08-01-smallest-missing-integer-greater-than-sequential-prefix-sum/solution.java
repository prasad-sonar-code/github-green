class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int missingInteger(int[] nums) {
        int sum = 0;
        int maxPrefixLen = 0;
        int prefixLen = 1;
        
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (prefixLen > maxPrefixLen) {
                    maxPrefixLen = prefixLen;
                    sum = 0;
                    for (int j = i - maxPrefixLen; j < i; j++) {
                        sum += nums[j];
                    }
                }
                prefixLen = 1;
            } else {
                prefixLen++;
            }
        }
        
        int missing = sum;
        while (true) {
            if (!contains(nums, missing)) {
                return missing;
            }
            missing++;
        }
    }
    
    private boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}