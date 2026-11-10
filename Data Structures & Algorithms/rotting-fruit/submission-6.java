class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            } 
        }
        int time = bfs(grid, queue, fresh);
        return time ;
    }

    private int bfs(int[][] grid, Queue<int[]> queue, int fresh) {
        int time = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty() && fresh > 0) {
            int queueSize = queue.size();
            time++;
            for (int i = 0; i < queueSize; i++) {
                int[] cur = queue.poll();
                for(int[] d: dirs) {
                    int curRow = cur[0] + d[0];
                    int curCol = cur[1] + d[1];
                    if (curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid[0].length) {
                        continue;
                    }
                    if(grid[curRow][curCol] == 1) {
                        grid[curRow][curCol] = 2;
                        fresh--;
                        queue.offer(new int[]{curRow, curCol});
                    }
                }
            }
        }

        return fresh > 0 ? -1 : time;
    }
}
