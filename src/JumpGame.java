/**
 * leetcode 55
 */
public class JumpGame {
    int[] result = new int[1];
    public boolean canJump(int[] nums) {
        return jump(nums, 0);
    }

    public boolean jump(int[] nums, int index) {
        System.out.println(index);
        if (index >= nums.length) return false;
        if (index == nums.length - 1) return true;
        else {
            int maxJump = nums[index];
            for (int i = 0;i < maxJump;i++) {

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        JumpGame test = new JumpGame();
        test.canJump(nums);
    }
}
