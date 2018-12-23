import java.util.Arrays;

public class LongestHarmoniousSubS_594 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0;i < nums.length;i++) {
            int currentVal = nums[i];
            int j = i + 1;
            while (j < nums.length && nums[j] - currentVal <= 1)
                j++;

            if (j - i > max) {
                if (nums[j-1] - currentVal != 0)
                    max = j - i;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        LongestHarmoniousSubS_594 test =new LongestHarmoniousSubS_594();
        System.out.println(test.findLHS(nums));
    }
}

