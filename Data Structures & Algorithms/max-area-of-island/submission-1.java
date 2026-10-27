class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int maxLength = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int currentMax = 0;
                    currentMax = dfs(grid, visited, i, j);
                    maxLength = Math.max(maxLength, currentMax);
                }
            }
        }
        return maxLength;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if(row < 0 || col < 0 || row  >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }

        visited[row][col] = true;
        return 1 + dfs(grid, visited, row + 1, col) + 
        dfs(grid, visited, row - 1, col) + 
        dfs(grid, visited, row, col + 1) +
        dfs(grid, visited, row, col - 1);
    }
}
