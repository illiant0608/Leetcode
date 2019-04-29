import java.util.Scanner;

public class BlackAndWhiteMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int width = scanner.nextInt();
        int[][] matrix = new int[len][width];

        for (int i = 0;i < len;i++)
            for (int j = 0;j < width;j++)
                matrix[i][j] = scanner.nextInt();

        System.out.println(Math.min(count(matrix, true), count(matrix, false)));
    }

    public static int count(int[][] matrix, boolean flag) {
        int minChange = 0;
        int len = matrix.length;
        int width = matrix[0].length;
        for (int i = 0;i < width;i++) {
            if (flag && matrix[0][i] == 0) {
                matrix[0][i] = 1;
                minChange++;
            }
            else if (!flag && matrix[0][i] == 1) {
                matrix[0][i] = 0;
                minChange++;
            }
            flag = !flag;
        }

        for (int i = 1;i < len;i++) {
            for (int j = 0;j < width;j++) {
                if (matrix[i][j] == matrix[i-1][j]) {
                    matrix[i][j] = matrix[i][j] == 1 ? 0 : 1;
                    minChange++;
                }
            }
        }

        return minChange;
    }
}
