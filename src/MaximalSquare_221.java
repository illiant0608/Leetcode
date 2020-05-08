public class MaximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int res = 0;
        for (int i = 0;i <= matrix.length;i++) {
            for (int j = 0;j <= matrix[0].length;j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;

                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res * res;
    }
}
