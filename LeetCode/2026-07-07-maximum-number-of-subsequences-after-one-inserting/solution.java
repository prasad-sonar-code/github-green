class Solution {
    public long numOfSubsequences(String s) {
        // Time complexity: O(n)
        // Space complexity: O(n)
        
        int n = s.length();
        long[] preL = new long[n + 1];
        long[] preLC = new long[n + 1];
        long[] sufT = new long[n + 1];
        long[] sufCT = new long[n + 1];

        // Precompute preL, preLC, sufT, and sufCT arrays
        for (int i = 0; i < n; i++) {
            preL[i + 1] = preL[i] + (s.charAt(i) == 'L' ? 1 : 0);
            preLC[i + 1] = preLC[i] + (s.charAt(i) == 'C' ? preL[i] : 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            sufT[i] = sufT[i + 1] + (s.charAt(i) == 'T' ? 1 : 0);
            sufCT[i] = sufCT[i + 1] + (s.charAt(i) == 'T' ? preLC[i] : 0);
        }

        // Compute base as the sum over all i of preLC[i] * sufT[i]
        long base = 0;
        for (int i = 0; i < n; i++) {
            base += preLC[i] * sufT[i];
        }

        // For each insert position i, compute gains and take the maximum of base and base + gain
        long max = base;
        for (int i = 0; i <= n; i++) {
            long gainL = sufCT[i];
            long gainC = preL[i] * sufT[i];
            long gainT = preLC[i];
            max = Math.max(max, base + Math.max(gainL, Math.max(gainC, gainT)));
        }
        return max;
    }
}