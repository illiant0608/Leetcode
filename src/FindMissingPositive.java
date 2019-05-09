

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindMissingPositive {
    /**
     * 先排序算法, 但是不能满足常数空间复杂度
     */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        Arrays.sort(nums);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!list.contains(i)) return i;
        }

        return -1;
    }

    /**
     * 对数组进行就地排序，不开辟额外空间，让数组中的第i位存放数值i+1
     */
    public int firstMissingPositiveConstantSpace(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] < 1 || nums[i] > nums.length) i++;
            else if (nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);
            else i++;
        }

        i = 0;
        while (i < nums.length && nums[i] == i + 1) i++;
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
