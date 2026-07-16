class Solution {
    // Time complexity: O(log n) due to the conversion of n to a string
    // Space complexity: O(log n) for storing the factorial values and the digits of n
    public boolean isDigitorialPermutation(int n) {
        int[] factorials = new int[10];
        factorials[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        int sum = 0;
        String strN = String.valueOf(n);
        boolean[] seen = new boolean[10];
        for (char c : strN.toCharArray()) {
            int digit = c - '0';
            sum += factorials[digit];
            seen[digit] = true;
        }

        if (sum == n) {
            return true;
        }

        String strSum = String.valueOf(sum);
        if (strSum.charAt(0) == '0') {
            return false;
        }

        for (char c : strSum.toCharArray()) {
            int digit = c - '0';
            if (!seen[digit]) {
                return false;
            }
            seen[digit] = false;
        }

        return true;
    }
}