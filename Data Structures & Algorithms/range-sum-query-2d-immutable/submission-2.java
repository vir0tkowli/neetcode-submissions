class NumMatrix {

    int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        prefixSum = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            prefixSum[row][0] = matrix[row][0];
            for (int col = 1; col < matrix[0].length; col++) {
                prefixSum[row][col] = prefixSum[row][col -1] + matrix[row][col];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int row = row1;
        int result = 0;
        while (row <= row2) {
            if (col1 != 0) {
                result += prefixSum[row][col2] - prefixSum[row][col1 -1];
            } else {
                result += prefixSum[row][col2];
            }
            row++;
        }
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */