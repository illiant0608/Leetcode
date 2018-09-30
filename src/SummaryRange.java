import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }

        for (int i = 0;i < nums.length;i++) {
            int a = nums[i];
            while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1)
                i++;

            if (a != nums[i]) {
                res.add(a + "—>" + nums[i]);
            } else {
                res.add(a + "");
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        SummaryRange test = new SummaryRange();
        test.summaryRanges(nums);
    }
}
