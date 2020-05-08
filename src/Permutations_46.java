import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums, new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, List<Integer> list) {
        if (list.size() == nums.length)
            result.add(new ArrayList<>(list));
        else {
            for (int i = 0;i < nums.length;i++) {
                if (list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                helper(nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
