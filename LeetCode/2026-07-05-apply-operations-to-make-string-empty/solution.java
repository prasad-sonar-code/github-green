class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public String lastNonEmptyString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            maxCount = Math.max(maxCount, count[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == maxCount) {
                sb.append(c);
            } else {
                count[c - 'a']--;
            }
        }
        return sb.reverse().toString();
    }
}