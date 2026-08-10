class Solution {
    // Time complexity: O(1) since the input size is fixed
    // Space complexity: O(1) since we only use a constant amount of space
    public int fillCups(int[] amount) {
        int max = Math.max(amount[0], Math.max(amount[1], amount[2]));
        int sum = amount[0] + amount[1] + amount[2];
        return Math.max(max, (sum + 1) / 2);
    }
}