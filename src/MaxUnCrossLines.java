import java.util.*;

public class MaxUnCrossLines {
    class Pair implements Comparable<Pair> {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Pair o) {
            int abs1 = Math.abs(this.x - this.y);
            int abs2 = Math.abs(o.x - o.y);
            
            return abs1 - abs2;
        }
    }
    public int maxUncrossedLines (int[] A, int[] B) {
        // write code here
        // HashMap<Integer, Integer> pairs = new HashMap<>();
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0;i < A.length;i++) {
            for (int j = 0;j < B.length;j++) {
                if (A[i] == B[j]) {
                    pairs.add(new Pair(i, j));
                }
            }
        }

        Collections.sort(pairs);

        int a_reach = Integer.MIN_VALUE, b_reach = Integer.MIN_VALUE;
        int nums = 0;
        for (Pair pair : pairs) {
            if (pair.x > a_reach && pair.y > b_reach) {
                nums++;
                a_reach = pair.x;
                b_reach = pair.y;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] A = {2, 5, 1, 2, 5};
        int[] B = {10, 5, 2, 1, 5, 2};
        MaxUnCrossLines test = new MaxUnCrossLines();
        System.out.println(test.maxUncrossedLines(A, B));
    }
}
