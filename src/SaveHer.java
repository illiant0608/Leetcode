import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveHer {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0, m = 0;
        int[][] matrix = new int[0][];
        n = in.nextInt();
        m = in.nextInt();
        matrix = new int[n][m];
        for (int i = 0;i < n;i++)
            for (int j = 0;j < m;j++)
                matrix[i][j] = in.nextInt();

        int result = leastBlood(matrix, 0, 0, 0, 0);
        if (result >= 0) System.out.println(0);
        else System.out.println(Math.abs(result));
    }

    public static int leastBlood(int[][] matrix, int i, int j, int blood, int least) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (i >= n || j >= m) return Integer.MIN_VALUE;

        if (i == n-1 && j == m-1) {
            blood += matrix[i][j];
            least = Math.min(blood, least);
            min = Math.min(min, least);
            return min;
        }
        else {
            blood += matrix[i][j];
            least = Math.min(blood, least);
            //System.out.println(blood + " : " + min);
            int result1 = leastBlood(matrix, i+1, j, blood, least);
            int result2 = leastBlood(matrix, i, j+1, blood, least);
            System.out.println(result1 + " : " + result2);
            return Math.max(result1, result2);
        }

    }


}
