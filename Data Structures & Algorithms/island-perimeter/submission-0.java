class Solution {
    int perimeter;
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        perimeter = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for(int j = 0 ; j < col; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, visited, i, j);
                }
            }
        }
        return perimeter;
    }
    private void dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0) {
            perimeter++;
            return;
        }
        if(grid[row][col] == 0 && !visited[row][col]) {
            perimeter++;
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        dfs(grid, visited, row + 1, col);
        dfs(grid, visited, row - 1, col);
        dfs(grid, visited, row, col + 1);
        dfs(grid, visited, row, col - 1);
    }
}