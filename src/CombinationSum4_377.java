import java.util.HashMap;
import java.util.Map;

public class CombinationSum4_377 {
    //int num = 0;
    Map<Integer, Integer> result_map = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) return 0;

        return recursive(nums, target);
    }

    private int recursive(int[] nums, int target) {
        int sum = 0;
        if (target == 0) return 1;
        else if (target < 0) return 0;
        else {
            if (result_map.containsKey(target))
                return result_map.get(target);
            else {
                for (int value : nums) {
                    sum += recursive(nums, target - value);
                }
                result_map.put(target, sum);
            }
        }

        return sum;
    }

    // 正宗dp
    public int combinationSum4_dp(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target;i++) {
            for (int j = 0;j < len;j++) {
                if (i - nums[j] >= 0)
                    dp[i] += dp[i - nums[j]];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        CombinationSum4_377 test = new CombinationSum4_377();
        System.out.println(test.combinationSum4(nums, 4));
    }
}
