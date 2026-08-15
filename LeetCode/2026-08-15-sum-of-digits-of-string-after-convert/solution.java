class Solution {
    // Time complexity: O(n + k * log(n * 26)) where n is the length of the string
    // Space complexity: O(n)
    public int getLucky(String s, int k) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - 'a' + 1;
        }
        
        for (int i = 1; i < k; i++) {
            int tempSum = 0;
            while (sum > 0) {
                tempSum += sum % 10;
                sum /= 10;
            }
            sum = tempSum;
        }
        
        return sum;
    }
}