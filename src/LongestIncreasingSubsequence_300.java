import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] result = new int[nums.length];
        int n = nums.length;
        result[n - 1] = 1;

        for (int i = n - 2;i >= 0;i--) {
            int max = 0;
            for (int j = i + 1;j < nums.length;j++) {
                if (nums[i] < nums[j])
                    max = Math.max(max, result[j]);
            }
            result[i] = max + 1;
        }
        Arrays.sort(result);
        return result[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence_300 test = new LongestIncreasingSubsequence_300();
        System.out.println(test.lengthOfLIS(nums));
    }
}
