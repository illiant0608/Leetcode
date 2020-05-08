import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet2_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int pos, List<List<Integer>> res, List<Integer> each) {
        if (pos <= nums.length) res.add(new ArrayList<>(each));

        for (int i = pos;i < nums.length;i++) {
            if (i > pos && nums[i] == nums[i-1]) continue;
            each.add(nums[i]);
            helper(nums, i+1, res, each);
            each.remove(each.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSet2_90 test = new SubSet2_90();
        int[] arr = {1, 2, 2};
        List<List<Integer>> res = test.subsetsWithDup(arr);

        for (List<Integer> l : res) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
