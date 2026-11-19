class Solution {
    List<List<Integer>> result;
    boolean atlantic, pacific;
    boolean[][] visited;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        result = new ArrayList<>();
        int row = heights.length;
        int col = heights[0].length;
        
        for(int i = 0; i < row; i++) {
            for(int j = 0 ; j < col; j++) {
                visited = new boolean[row][col];
                atlantic = false;
                pacific = false;
                dfs(heights, i, j, visited);
                if(pacific && atlantic) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited) {
        if(visited[row][col] || (atlantic && pacific)) {
            return;
        }
        visited[row][col] = true;
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        if (row == 0 || col == 0) {
            pacific = true;
        }
        if (row == heights.length - 1 || col == heights[0].length - 1) {
            atlantic = true;
        }
        for(int[] dir: dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            int parentCell = heights[row][col];
            
            if (newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length) {
                continue;
            }
            if(parentCell < heights[newRow][newCol]) {
                continue;
            }
            
            dfs(heights, newRow, newCol, visited);
        }
    }
}
