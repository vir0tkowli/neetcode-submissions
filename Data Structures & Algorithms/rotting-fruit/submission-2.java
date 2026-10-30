class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        
        return bfs(grid, queue, fresh);
    }

    private int bfs(int[][] grid, Queue<int[]> queue, int fresh) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int time = 0;
        while(fresh > 0 && !queue.isEmpty()) {
            // queue.size() changes ever minute
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int[] currentRotten = queue.poll();
                for(int[] dir: directions) {
                                    
                    System.out.printf("\nINSIDE %s", fresh);

                    int row = currentRotten[0] + dir[0];
                    int col = currentRotten[1] + dir[1];
                    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                        continue;
                    }
                    if(grid[row][col] == 1) {
                        queue.offer(new int[]{row, col});
                        fresh--;
                        grid[row][col] = 2;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
