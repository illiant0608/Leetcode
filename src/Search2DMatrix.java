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

    public static void main(String[] args) {
        int[][] matrix = {{1,1}, {2,2}};
        Search2DMatrix test = new Search2DMatrix();
        test.searchMatrix(matrix, 3);
    }
}
