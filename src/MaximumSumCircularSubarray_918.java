public class MaximumSumCircularSubarray_918 {
    public int maxSubarraySumCircular(int[] A) {
//        for (int i = 0;i != (i+len-1) % len;i = (i+len+1) % len) {
//            System.out.println(i);
//        }

        // the max from left side + right side <=> sum - (min in middle side)
        int total = 0, maxSum = -30000, curMax = 0, minSum = 30000, curMin = 0;

        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);

            total += a;
        }

        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray_918 test = new MaximumSumCircularSubarray_918();
        int[] a = {};
        test.maxSubarraySumCircular( a);
    }
}
