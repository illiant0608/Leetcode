public class RangeSum2D_304 {
    private int row, col;
    private int[][] sum;
    public RangeSum2D_304(int[][] matrix) {
        row = matrix.length;
        col = row > 0 ? matrix[0].length : 0;
        sum = new int[row+1][col+1];
        for (int i = 1;i <= row;i++) {
            for (int j = 1;j <= col;j++) {
                sum[i][j] = matrix[i-1][j-1] + sum[i-1][j] + sum[i][j-1] -sum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1]; //可以考虑特殊情况分析
    }
}
