class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i =0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dfs(board, visited, word, i ,j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col, int i) {        
        // If all chars match
        if(i == word.length()) {
            return true;
        }
        // Outside the board.
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        if (visited[row][col] || board[row][col] != word.charAt(i)) {
            return false;
        }
        visited[row][col] = true;
        boolean res =  dfs(board, visited, word, row +1, col, i+1) || 
        dfs(board, visited, word, row, col + 1, i+1) || 
        dfs(board, visited, word, row -1, col, i+1) || 
        dfs(board, visited, word, row, col-1, i+1);
    
        // Just like a WOW
        visited[row][col] = false;
        return res;
    }
}
