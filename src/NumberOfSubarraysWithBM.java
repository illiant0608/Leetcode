import java.util.Arrays;

public class NumberOfSubarraysWithBM {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        Arrays.sort(A);
        int low = 0, high = A.length - 1;
        for (int i = 0;i < A.length;i++) {
            if (A[i] > L) {
                low = i;
                break;
            }

        }

        for (int i = A.length-1;i >= 0;i--) {
            if (A[i] <= R) {
                high = i;
                break;
            }

        }

        return (int) Math.pow(2, high-low+1) - 1;
    }

    public static void main(String[] args) {
        int[] A = {2, 9, 2, 5, 6};
        int L = 2;
        int R = 8;

        NumberOfSubarraysWithBM n = new NumberOfSubarraysWithBM();
        int num = n.numSubarrayBoundedMax(A, L, R);
        System.out.println(num);
    }
}
