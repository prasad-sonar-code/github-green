class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1)
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        long p = 1;
        for (int i = 0; i < k - 1; i++) {
            p = (p * power) % modulo;
        }
        long hash = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                hash = (hash - (s.charAt(i - k) - 'a' + 1) * p) % modulo;
            }
            hash = (hash * power + s.charAt(i) - 'a' + 1) % modulo;
            if (i >= k - 1 && hash == hashValue) {
                return s.substring(i - k + 1, i + 1);
            }
        }
        return "";
    }
}