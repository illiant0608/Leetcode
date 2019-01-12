import java.util.Arrays;

public class MatchSticksToSquare_473 {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;

        int side = sum / 4;
        Arrays.sort(nums);
        return makesquareSub(nums, nums.length - 1, new int[] {side, side, side, side});
    }

    public boolean makesquareSub(int[] nums, int i , int[] s) {
        if (i < 0) return s[0] == 0 && s[1] == 0 && s[2] == 0 && s[3] == 0;

        for (int j = 0;j < s.length;j++) {
            if (s[j] < nums[i]) continue;
            s[j] -= nums[i];
            if (makesquareSub(nums, i - 1, s)) return true; // T(i, s1, s2, s3, s4) => T(i - 1, s1 - nums[i], s2, s3, s4) ....
            s[j] += nums[i];
        }

        return false;
    }
}
