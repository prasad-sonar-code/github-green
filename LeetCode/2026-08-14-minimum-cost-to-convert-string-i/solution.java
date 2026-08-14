class Solution {
    // Time complexity: O(26^3 + n) where n is the length of source string
    // Space complexity: O(26^2)
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] graph = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                graph[i][j] = Integer.MAX_VALUE / 2;
            }
            graph[i][i] = 0;
        }
        
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            graph[from][to] = Math.min(graph[from][to], cost[i]);
        }
        
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        
        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (graph[from][to] >= Integer.MAX_VALUE / 2) {
                return -1;
            }
            res += graph[from][to];
        }
        return res;
    }
}