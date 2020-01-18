public class NumArray_307 {
    private int[] nums;
    public NumArray_307(int[] nums) {
        this.nums = nums;
    }

    public void update(int i, int val) {
        this.nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int x = i;x <= j;x++) {
            sum += this.nums[x];
        }

        return sum;
    }
}
