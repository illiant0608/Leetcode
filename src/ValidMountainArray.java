public class ValidMountainArray {

    /**
     * 寻找数组中的拐点，如果是MountainArray，那么数组中只能有一个拐点
     */
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        if (A.length == 3)
            return A[1] > A[0] && A[1] > A[2];
        int change = 0;
        for (int i = 1;i < A.length-1;i++) {
            if (A[i-1] == A[i] || A[i] == A[i+1]) return false;
            if ((A[i - 1] < A[i] && A[i] > A[i + 1])
                    || A[i - 1] > A[i] && A[i] < A[i + 1])
                change += 1;
        }


        return change == 1;
    }

    /**
     * 相当于两个人从两边爬山，最后要爬到同一个点
     * @param A
     * @return
     */
    public boolean validMountainArray2(int[] A) {
        int n = A.length, i = 0, j = n - 1;
        while (i + 1 < n && A[i] < A[i+1]) i++;
        while (j > 0 && A[j-1] > A[j]) j--;
        return i > 0 && i == j && j < n - 1;
    }

    public static void main(String[] args) {
        ValidMountainArray test = new ValidMountainArray();
        int[] arr = {14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3};

        System.out.println(test.validMountainArray(arr));
    }
}
