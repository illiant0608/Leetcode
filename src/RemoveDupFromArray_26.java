import java.util.ArrayList;
import java.util.List;

public class RemoveDupFromArray_26 {
    public int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (list.contains(i)) continue;
            else list.add(i);
        }
        for (int i = 0;i < list.size();i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }

    // 关键在于这个数组是排序的
    public int removeDuplicates_2(int[] nums) {
        if (nums.length < 2) return nums.length;
        int id = 1; // 第一个肯定算到长度里
        for (int i = 1;i < nums.length;i++) {
            if (nums[i] != nums[i-1]) nums[id++] = nums[i];
        }

        return id;
    }
}
