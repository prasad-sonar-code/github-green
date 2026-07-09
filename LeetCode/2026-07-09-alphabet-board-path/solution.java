class Solution {
    // Time complexity: O(n), where n is the length of the target string
    // Space complexity: O(1), as the size of the board is fixed
    public String alphabetBoardPath(String target) {
        int[][] board = {
            {0, 1, 2, 3, 4},
            {5, 6, 7, 8, 9},
            {10, 11, 12, 13, 14},
            {15, 16, 17, 18, 19},
            {20, 21, 22, 23, 24},
            {25}
        };
        int[] pos = new int[26];
        for (int i = 0; i < 26; i++) {
            pos[i] = i;
        }
        int x = 0, y = 0;
        StringBuilder res = new StringBuilder();
        for (char c : target.toCharArray()) {
            int idx = c - 'a';
            int newX = idx / 5;
            int newY = idx % 5;
            if (newY < y) {
                for (int i = 0; i < y - newY; i++) {
                    res.append('L');
                }
            }
            if (newX < x) {
                for (int i = 0; i < x - newX; i++) {
                    res.append('U');
                }
            }
            if (newX > x) {
                for (int i = 0; i < newX - x; i++) {
                    res.append('D');
                }
            }
            if (newY > y) {
                for (int i = 0; i < newY - y; i++) {
                    res.append('R');
                }
            }
            res.append('!');
            x = newX;
            y = newY;
        }
        return res.toString();
    }
}