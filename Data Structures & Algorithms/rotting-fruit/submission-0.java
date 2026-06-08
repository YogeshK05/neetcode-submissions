class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, time = -1, ones = 0, reached = 0, size;
        int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++){
            if (grid[i][j] == 2) q.add(new int[]{i, j});
            if (grid[i][j] == 1) ones++;
        }
        if (ones == 0) return 0;
        while (q.size() > 0) {
            size = q.size();
            for (int o = 0; o < size; o++) {
                int[] org = q.remove();
                int x = org[0], y = org[1];
                grid[x][y] = 2;
                for (int[] d: dirs) {
                    int dx = x + d[0], dy = y + d[1];
                    if (dx > -1 && dx < m && dy > -1 && dy < n && grid[dx][dy] == 1) {
                        q.add(new int[]{dx, dy});
                        grid[dx][dy] = 2;
                        reached++;
                    }
                }
            }
            time++;
        }
        return reached == ones ? time : -1;
    }
}