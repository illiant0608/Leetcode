import java.util.Arrays;

public class SmallestRange1_908 {
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int dis = A[A.length - 1] - A[0];
        if (dis >= 2 * K) return dis - 2 * K;
        else return 0;
    }
}
