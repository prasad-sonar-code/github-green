class Solution {
    // Time complexity: O(n^2 * 26) where n is the length of the string
    // Space complexity: O(n * 26)
    public int beautySum(String s) {
        int n = s.length();
        int[][] prefixSum = new int[n + 1][26];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                prefixSum[i + 1][j] = prefixSum[i][j];
            }
            prefixSum[i + 1][s.charAt(i) - 'a']++;
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int max = 0, min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                int[] count = new int[26];
                for (int k = 0; k < 26; k++) {
                    count[k] = prefixSum[j + 1][k] - prefixSum[i][k];
                }
                for (int k = 0; k < 26; k++) {
                    if (count[k] > 0) {
                        max = Math.max(max, count[k]);
                        min = Math.min(min, count[k]);
                    }
                }
                sum += max - min;
            }
        }
        return sum;
    }
}