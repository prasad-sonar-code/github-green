class Solution {
    // Time complexity: O(n^2 log n)
    // Space complexity: O(n^2)
    public int[][] diagonalSort(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int k = 0; k < n + m - 1; k++) {
            List<Integer> diagonal = new ArrayList<>();
            int i = Math.max(0, k - m + 1);
            int j = Math.min(k, m - 1);
            while (i < n && j >= 0) {
                diagonal.add(grid[i][j]);
                i++;
                j--;
            }
            Collections.sort(diagonal, (a, b) -> k < m ? a - b : b - a);
            i = Math.max(0, k - m + 1);
            j = Math.min(k, m - 1);
            int index = 0;
            while (i < n && j >= 0) {
                grid[i][j] = diagonal.get(index++);
                i++;
                j--;
            }
        }
        return grid;
    }
}