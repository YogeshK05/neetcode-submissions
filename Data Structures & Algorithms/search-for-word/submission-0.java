class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        boolean res = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res |= find(board, word, m, n, 0, i, j, vis);
                if (res)
                    return true;
            }
        }
        return res;
    }
    private boolean find(
        char[][] board, String word, int m, int n, int i, int x, int y, boolean[][] vis) {
        if (i == word.length())
            return true;
        if (word.charAt(i) != board[x][y])
            return false;
        boolean res = i == word.length() - 1;
        vis[x][y] = true;
        for (int[] d : dirs) {
            int dx = d[0] + x, dy = d[1] + y;
            if (dx > -1 && dx < m && dy > -1 && dy < n && !vis[dx][dy]) {
                vis[dx][dy] = true;
                res |= find(board, word, m, n, i + 1, dx, dy, vis);
                if (res)
                    return true;
                vis[dx][dy] = false;
            }
        }
        vis[x][y] = false;
        return res;
    }
}