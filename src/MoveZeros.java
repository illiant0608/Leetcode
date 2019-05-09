/**
 * leetcode 283
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int isZero = 0;
        int notZero = 0;

        for (;isZero < nums.length;isZero++) {
            for (notZero = isZero + 1;notZero < nums.length;notZero++) {
                if (nums[isZero] == 0 && nums[notZero] != 0) {
                    nums[isZero] = nums[notZero];
                    nums[notZero] = 0;
                    break;
                }
            }
        }
    }

    /**
     * O(n) solution
     * 因为内容为0的index是不需要被记住的
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int pos = 0; // 用于记录最后一个不为零的位置
        for (int num : nums)
            if (num != 0) nums[pos++] = num;

        while (pos < nums.length)
            nums[pos++] = 0;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeros test = new MoveZeros();
        test.moveZeroes2(nums);
    }
}
