class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int M = grid.length, N = grid[0].length, level = 1;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visit = new boolean[M][N];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < M; i++) for (int j = 0; j < N; j++) if (grid[i][j] == 0) q.add(new int[]{i, j});
        while (q.size() > 0) {
            int size = q.size();
            for (int c = 0; c < size; c++) {
                int[] cell = q.remove();
                int x = cell[0], y = cell[1];
                visit[x][y] = true;
                for (int[] d: dirs) {
                    int dx = x + d[0], dy = y + d[1];
                    if (dx > -1 && dx < M && dy > -1 && dy < N && visit[dx][dy] == false && grid[dx][dy] != -1) {
                        grid[dx][dy] = level;
                        visit[dx][dy] = true;
                        q.add(new int[]{dx, dy});
                    }
                }
            }
            level++;
        }
    }
}
