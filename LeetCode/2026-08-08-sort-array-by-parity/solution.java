class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int evenIndex = 0, oddIndex = nums.length - 1;
        
        for (int num : nums) {
            if (num % 2 == 0) {
                result[evenIndex++] = num;
            } else {
                result[oddIndex--] = num;
            }
        }
        
        return result;
    }
}