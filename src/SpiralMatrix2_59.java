public class SpiralMatrix2_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int rowBegin = 0;
        int rowEnd = res.length-1;
        int colBegin = 0;
        int colEnd = res[0].length-1;

        int count = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin;i <= colEnd;i++) {
                res[rowBegin][i] = count;
                count++;
            }
            rowBegin++;

            for (int i = rowBegin;i <= rowEnd;i++) {
                res[i][colEnd] = count;
                count++;
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd;i >= colBegin;i--) {
                    res[rowEnd][i] = count;
                    count++;
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int i = rowEnd;i >= rowBegin;i--) {
                    res[i][colBegin] = count;
                    count++;
                }
            }
            colBegin++;
        }

        return res;
    }
}
