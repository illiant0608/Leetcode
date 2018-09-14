public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int size = nums.length * nums[0].length;
        if (size != r*c)
            return nums;

        int[] total = new int[size];
        int width = nums[0].length;
        for (int i = 0;i < nums.length; i++) {
            for (int j = 0;j < nums[i].length;j++) {
                total[i*width + j] = nums[i][j];
            }
        }

        int[][] ret = new int[r][c];
        for (int i = 0;i < r;i++) {
            for (int j = 0;j < c;j++) {
                ret[i][j] = total[i*c+j];
            }
        }

        return ret;
    }
}
