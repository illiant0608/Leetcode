import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1;i < intervals.length;i++) {
            if (needMerge(stack.peek(), intervals[i])) {
                // merge
                int[] res = mergeArray(stack.pop(), intervals[i]);

                stack.push(res);
            } else {
                stack.push(intervals[i]);
            }
        }

        int[][] result = new int[stack.size()][];
        for (int i = stack.size() - 1;i >= 0;i--)
            result[i] = stack.pop();

        return result;
    }

    private boolean needMerge(int[] x, int[] y) {
        if (x[1] >= y[0]) return true;
        else return false;
    }

    private int[] mergeArray(int[] x, int[] y) {
        int[] res = new int[2];
        if (x[1] >= y[1]) {
            return x;
        } else {
            res[0] = x[0];
            res[1] = y[1];
        }

        return res;
    }



    public static void main(String[] args) {
        int[][] arr = { {1, 3}, {2, 6}, {8,10}, {15,18}};

        MergeIntervals_56 test = new MergeIntervals_56();
        arr = test.merge(arr);
        for (int[] arry : arr) {
            for (int i : arry)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
