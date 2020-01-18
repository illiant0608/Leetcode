import java.util.Arrays;

public class SmallestRange2_910 {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int left = A[0] + K, right = A[A.length - 1] - K;
        int ans = A[A.length - 1] - A[0];

        // 从i开始将数组分为两段
        // 前半段+K，所以最大值是A[i]+K, 最小值是left
        // 后半段-K, 所以最大值是right, 最小值是A[i+1]-K
        // 新的可能的最小距离就是high - low
        // 遍历所有的i，找到最小的距离
        for (int i = 0;i < A.length - 1;i++) {
            int high = Math.max(right, A[i] + K);
            int low = Math.min(left, A[i + 1] - K);
            ans = Math.min(ans, high - low);
        }

        return ans;
    }
}
