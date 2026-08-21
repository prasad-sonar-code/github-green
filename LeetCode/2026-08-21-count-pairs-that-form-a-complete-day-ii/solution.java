class Solution {
    // Time complexity: O(n), where n is the number of hours.
    // Space complexity: O(1), as the space used does not grow with the size of the input array.
    public long countCompleteDayPairs(int[] hours) {
        int[] count = new int[24];
        long pairs = 0;
        
        for (int hour : hours) {
            int complement = (24 - hour % 24) % 24;
            pairs += count[complement];
            count[hour % 24]++;
        }
        
        return pairs;
    }
}