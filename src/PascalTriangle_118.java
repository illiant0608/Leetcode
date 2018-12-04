import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();

        for (int i = 0;i < numRows;i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1;j++) {
                row.set(j, row.get(j) + row.get(j+1));
            }
            allrows.add(new ArrayList<>(row));
        }

        return allrows;
    }

    public static void main(String[] args) {
        PascalTriangle_118 test = new PascalTriangle_118();
        test.generate(5);
    }

}
