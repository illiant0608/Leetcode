public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max = nums[0], min = nums[0], result = 0; //前一次迭代的最大、最小值
        for (int i = 1;i < nums.length;i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            if (max > result) result = max;
        }

        return result;
    }
}
