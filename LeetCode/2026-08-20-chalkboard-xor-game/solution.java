class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        if (xor == 0) return true;
        if (nums.length % 2 == 0) return true;
        return false;
    }
}