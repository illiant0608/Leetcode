import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequence_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        helper(set, list, nums, 0);

        List result = new ArrayList(set);
        return result;
    }

    private void helper(Set<List<Integer>> set, List<Integer> sub, int[] nums, int index) {
        if (sub.size() >= 2) set.add(new ArrayList(sub));

        for (int i = index;i < nums.length;i++) {
            if (sub.size() == 0 || nums[i] >= sub.get(sub.size() - 1)) {
                sub.add(nums[i]);
                helper(set, sub, nums, i + 1);
                sub.remove(sub.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {4, 6, 7, 7};
//        IncreasingSubsequence_491 test = new IncreasingSubsequence_491();
//        test.findSubsequences(arr);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);list1.add(2);list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);list2.add(2);list2.add(3);

        set.add(list1);
        System.out.println("set size: " + set.size());
        set.add(list2);
        System.out.println("set size: " + set.size());
    }
}
