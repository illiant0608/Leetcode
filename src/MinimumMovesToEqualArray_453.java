import java.util.Arrays;

public class MinimumMovesToEqualArray_453 {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1;i < nums.length;i++) {
            count += (nums[i] - nums[0]);
        }

        return count;
    }
}
