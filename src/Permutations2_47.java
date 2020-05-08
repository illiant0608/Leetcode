import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2_47 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    public void helper(int[] nums, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length)
            result.add(new ArrayList<>(list));
        else {
            for (int i = 0;i < nums.length;i++) {
                // 如果一个数字和它的前一个数字相同
                // 那么只有前一个被用过了才能用这个数字，不然就重复了
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i-1])
                    continue;
                used[i] = true;
                list.add(nums[i]);
                helper(nums, list, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
