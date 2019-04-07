import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2_119 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return new ArrayList<>();
        if (rowIndex == 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }

        int[][] result = new int[rowIndex][rowIndex];
        for (int i = 0;i < rowIndex;i++) {
            result[i][0] = 1;
            result[i][i] = 1;
        }

        for (int i = 1;i < rowIndex;i++) {
            for (int j = 1;j < i;j++) {
                result[i][j] = result[i-1][j] + result[i-1][j-1];
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0;j < rowIndex;j++) {
            list.add(result[rowIndex-1][j]);
        }

        System.out.println();

        return list;


    }
}
