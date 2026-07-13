class Solution {
    // Time complexity: O(n), Space complexity: O(1)
    public long maxArrayValue(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}