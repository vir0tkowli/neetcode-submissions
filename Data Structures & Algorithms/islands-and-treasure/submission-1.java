class Solution {
    Queue<int[]> queue;
    int maxVal = Integer.MAX_VALUE ;
    public void islandsAndTreasure(int[][] grid) {
        queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        bfs(grid);
    }

    private void bfs(int[][] grid) {
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int[] dir : directions) {
                int row = current[0] + dir[0];
                int col = current[1] + dir[1];

                if(row >= grid.length || row <0 || col >= grid[0].length || col < 0 || grid[row][col] == -1) {
                    continue;
                }

                if (grid[row][col] != maxVal) {
                    continue;
                }
                queue.offer(new int[]{row, col});
                grid[row][col] = grid[current[0]][current[1]] + 1;
            }
        }
    }
}
