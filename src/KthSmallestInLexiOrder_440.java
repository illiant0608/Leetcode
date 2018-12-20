import java.util.Arrays;
import java.util.Comparator;

public class KthSmallestInLexiOrder_440 {
    public int findKthNumber(int n, int k) {
        //不考虑空间占用的方法
//        String[] arr = new String[n];
//
//        for (int i = 1;i <= n;i++)
//            arr[i-1] = i + "";
//
//        Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
//
//        return Integer.parseInt(arr[k-1]);
        int cur = 1;
        --k;
        while (k > 0) {
            int step = calStep(n ,cur, cur + 1);
            if (step <= k) {
                cur += 1;
                k -= step;
            } else {
                cur *= 10;
                k -= 1;
            }
        }

        return cur;
    }

    public int calStep(int n, long n1, long n2) {
        int step = 0;
        while (n1 <= n) {
            step += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }

        return step;
    }


    public static void main(String[] args) {
        KthSmallestInLexiOrder_440 test =new KthSmallestInLexiOrder_440();
        System.out.println(test.findKthNumber(13, 2));
    }
}
