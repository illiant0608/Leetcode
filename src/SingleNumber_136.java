import java.util.Arrays;

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        for (int i = 0;i < nums.length;i++) {
            if (i == 0) {
                if (nums[1] != nums[0])
                    return nums[0];
            } else if (i == nums.length - 1) {
                if (nums[nums.length - 2] != nums[nums.length - 1])
                    return nums[nums.length - 1];
            } else {
                if (nums[i - 1] != nums[i] && nums[i+1] != nums[i])
                    return nums[i];
            }
        }

        return 0;
    }
}
