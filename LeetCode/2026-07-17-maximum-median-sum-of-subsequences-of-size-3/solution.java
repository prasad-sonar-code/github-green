class Solution {
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(n) for sorting in Java
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i -= 3) {
            sum += nums[i];
        }
        return sum;
    }
}