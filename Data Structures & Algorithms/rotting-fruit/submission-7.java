class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        return bfs(grid, queue, fresh, 0, 0);
    }

    private int bfs(int[][] grid, Deque<int[]> queue, int fresh, int row, int col) {
        int time = 0;
        while(!queue.isEmpty() && fresh > 0) {
            time++;
            int queueLen = queue.size();
            for(int i = 0; i < queueLen; i++) {
                int[] currentFruit = queue.poll();
                int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
                for(int[] dir: dirs) {
                    int newRow = currentFruit[0] + dir[0];
                    int newCol = currentFruit[1] + dir[1];
                    if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length) {
                        continue;
                    }
                    if(grid[newRow][newCol] == 0) {
                        continue;
                    }
                    if(grid[newRow][newCol] == 1) {
                        queue.offer(new int[]{newRow, newCol});
                        grid[newRow][newCol] = 2;
                        fresh--;
                    }
                }
            }
        }

        return (fresh > 0) ? -1 : time;
    }
}
