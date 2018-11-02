public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int pointer = 0;
        for (int i = 0;i < A.length;i++) {
            if (A[i] % 2 == 0) {
                B[pointer] = A[i];
                pointer++;
            }
        }
        for (int i = 0;i < A.length;i++) {
            if (A[i] % 2 == 1) {
                B[pointer] = A[i];
                pointer++;
            }
        }

        return B;
    }
}
