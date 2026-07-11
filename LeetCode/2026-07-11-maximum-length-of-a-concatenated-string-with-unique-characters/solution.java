class Solution {
    // Time complexity: O(n * 2^n) where n is the number of strings in arr
    // Space complexity: O(n * 2^n)
    public int maxLength(List<String> arr) {
        int res = 0;
        backtrack(arr, 0, 0, res);
        return res;
    }

    private void backtrack(List<String> arr, int start, int mask, int[] res) {
        res[0] = Math.max(res[0], Integer.bitCount(mask));
        for (int i = start; i < arr.size(); i++) {
            int wordMask = getMask(arr.get(i));
            if (wordMask == -1 || (mask & wordMask) != 0) continue;
            backtrack(arr, i + 1, mask | wordMask, res);
        }
    }

    private int getMask(String word) {
        int mask = 0;
        for (char c : word.toCharArray()) {
            int bit = 1 << (c - 'a');
            if ((mask & bit) != 0) return -1;
            mask |= bit;
        }
        return mask;
    }
}