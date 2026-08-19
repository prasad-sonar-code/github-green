class Solution {
    // Time complexity: O(m * n * log(m * n))
    // Space complexity: O(m * n)
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length, n = grid[0].length;
        int low = pricing[0], high = pricing[1];
        int sx = start[0], sy = start[1];
        boolean[][] visited = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sx, sy, 0});
        visited[sx][sy] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2];
            if (grid[x][y] >= low && grid[x][y] <= high) {
                res.add(Arrays.asList(x, y, d, grid[x][y]));
            }
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != 0 && !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny, d + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        Collections.sort(res, (a, b) -> {
            if (a.get(2).equals(b.get(2))) {
                if (a.get(3).equals(b.get(3))) {
                    if (a.get(0).equals(b.get(0))) {
                        return a.get(1).compareTo(b.get(1));
                    }
                    return a.get(0).compareTo(b.get(0));
                }
                return a.get(3).compareTo(b.get(3));
            }
            return a.get(2).compareTo(b.get(2));
        });
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(k, res.size()); i++) {
            ans.add(res.get(i).subList(0, 2));
        }
        return ans;
    }
}