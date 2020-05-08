import java.util.ArrayList;
import java.util.List;

public class Chunk {
    public List<List<Integer>> chunk(List<Integer> arr, int n) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0;i < arr.size() / n;i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0;j < n;j++)
                list.add(arr.get(i * n + j));

            result.add(list);
        }

        int rest = (arr.size() / n) * n;
        List<Integer> rest_ints = new ArrayList<>();
        for (int i = rest;i < arr.size();i++) {
            rest_ints.add(arr.get(i));
        }
        result.add(rest_ints);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();


        Chunk test = new Chunk();
        List<List<Integer>> result = test.chunk(list, 3);

        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
