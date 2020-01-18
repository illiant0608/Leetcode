public class PrevPermOpt_1053 {
    public int[] prevPermOpt1(int[] A) {
        for (int i = A.length - 2;i >= 0;i--) {
            if (A[i] <= A[i+1])
                continue;
            // A[i-1] > A[i]保证一定能构造出比当前序列小的序列

            int max = Integer.MIN_VALUE;
            int max_pos = -1;
            for (int j = i+1;j < A.length;j++) {
                if (A[j] > max && A[j] < A[i]) {
                    max = A[j];
                    max_pos = j;
                }
            }
            int tmp = A[max_pos];
            A[max_pos] = A[i];
            A[i] = tmp;
            return A;
        }

        return A;
    }

    public static void main(String[] args) {
        PrevPermOpt_1053 test = new PrevPermOpt_1053();
        int[] A = {3, 1, 1, 3};
        test.prevPermOpt1(A);
    }
}
