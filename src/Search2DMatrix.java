public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int x = matrix[0].length;
        int y = matrix.length;

        int mid = 0;
        int start = 0;
        int end = y;

        if (y == 1) {
            for (int i = 0;i < matrix[0].length;i++) {
                if (matrix[0][i] == target)
                    return true;
            }

            return false;
        }

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (mid >= y)
                break;

            if (matrix[mid][0] > target){
                end = mid - 1;
                continue;
            } else if (matrix[mid][x-1] < target) {
                start = mid + 1;
                continue;
            } else  {
                for (int i = 0;i < x;i++){
                    if (matrix[mid][i] == target)
                        return true;
                }

                return false;
            }
        }
        return false;
    }

    /**
     * 因为2D matrix每一行的连续性，对整个矩阵做binary search
     * 中间元素 = matrix[mid / totalColumns][mid % totalColumns]
     * @param matrix
     * @param target
     * @return
     */
    public boolean search(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int low = 0;
        int high = matrix.length * matrix[0].length - 1;

        //int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = matrix[mid / totalColumns][mid % totalColumns];

            if (midElement == target) {
                return true;
            } else if (midElement > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {3}};
        Search2DMatrix test = new Search2DMatrix();
        test.search(matrix, 2);
    }
}
