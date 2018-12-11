import java.util.TreeSet;

public class ContainsDuplicate3_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0)
            return false;

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {
            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((ceil != null && (long)ceil - (long)nums[ind] <= t) ||
                    (floor != null && (long)nums[ind] - (long)floor <= t)) {
                return true;
            }

            values.add(nums[ind]);

            //只需要保持一个固定长度的窗口
            if (ind >= k)
                values.remove(nums[ind - k]);
        }

        return false;
    }
}
