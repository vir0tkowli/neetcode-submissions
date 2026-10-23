class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for(int j =0; j < col; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    dfs(grid, visited, i, j);
                } else {
                    continue;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col]) {
            return;
        }

        if (grid[row][col] == '0') {
            return;
        }

        visited[row][col] = true;
        dfs(grid, visited, row + 1, col);
        dfs(grid, visited, row, col + 1);
        dfs(grid, visited, row - 1, col);
        dfs(grid, visited, row, col - 1);
    }
}
