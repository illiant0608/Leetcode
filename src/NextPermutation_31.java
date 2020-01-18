public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int i = nums.length -  2;
        while (i >= 0 && nums[i] >= nums[i+1]) i--; // 倒着找到第一个递减的元素
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--; // 找到最右边的大于i的元素
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while (i < j) swap(A, i++, j--);
    }
}
