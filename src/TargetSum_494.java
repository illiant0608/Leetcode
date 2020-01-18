import java.util.HashMap;
import java.util.Map;

public class TargetSum_494 {
    int ways = 0;
    public int findTargetSumWays(int[] nums, int S) {
        find(nums, 0, S);

        return ways;
    }

    public void find(int[] nums, int index, int target) {
        if (index == nums.length - 1) {
            if (nums[index] == target || -nums[index] == target) {
                if (nums[index] == 0) ways += 2;
                else ways++;
            }
        } else {
            find(nums, index + 1, target - nums[index]);
            find(nums, index + 1, target + nums[index]);
        }
    }

    public int findTargetSumWays_DP(int[] nums, int S) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> dp2 = new HashMap<>();
            for (int tempSum : dp.keySet()) {
                int key1 = tempSum + num;
                dp2.put(key1, dp2.getOrDefault(key1, 0) + dp.get(tempSum));
                int key2 = tempSum - num;
                dp2.put(key2, dp2.getOrDefault(key2, 0) + dp.get(tempSum));
            }
            dp = dp2;
        }

        return dp.getOrDefault(S, 0);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        TargetSum_494 test = new TargetSum_494();

        System.out.println(test.findTargetSumWays(nums, 3));
    }
}
