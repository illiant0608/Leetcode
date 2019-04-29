import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 40
 */
public class CombinationSum2 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new LinkedList<>();
        List<Integer> tmp = new LinkedList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, tmp);

        return result;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> tmp) {
        if (target < 0) return;
        else if (target == 0) {
            result.add(new LinkedList<>(tmp));
            return;
        } else {
            for (int i = index;i < candidates.length;i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                tmp.add(tmp.size(), candidates[i]);
                helper(candidates, target - candidates[i], i+1, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        CombinationSum2 test = new CombinationSum2();
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(test.combinationSum2(candidates, 8));
    }


}
