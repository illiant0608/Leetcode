import java.util.ArrayList;
import java.util.List;

public class Subset_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        retList.add(new ArrayList<Integer>());

        //新增加一个元素时，克隆现在所有的子集，然后对每个子集都加上新的元素
        for (int i : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> sub : retList) {
                List<Integer> a = new ArrayList<>(sub); //克隆
                a.add(i); //加上新的元素
                tmp.add(a);
            }

            retList.addAll(tmp);
        }

        return retList;
    }



}
