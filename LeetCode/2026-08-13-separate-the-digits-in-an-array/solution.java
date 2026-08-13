class Solution {
    // Time complexity: O(n*m) where n is the length of nums and m is the maximum number of digits in an integer
    // Space complexity: O(n*m)
    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        int[] result = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            result[i] = sb.charAt(i) - '0';
        }
        return result;
    }
}