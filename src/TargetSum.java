import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetSum {
    public List<int[]> twoSum(int[] nums, int target) {
        int left=0,right=nums.length-1;
        List<int[]> list = new ArrayList<>();
        while(left<right){
            if (nums[left]+nums[right]==target){
                int[] res = new int[2];
                res[0]=nums[left];
                res[1]=nums[right];
                list.add(res);
                left++;
                right--;
            }
            else if (nums[left]+nums[right]<target)
                left++;
            else
                right--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,7,8,11,15};
        TargetSum test = new TargetSum();
        List<int[]> list = test.twoSum(nums, 15);

        for (int[] res : list) {
            System.out.println(res[0] + ":" + res[1]);
        }
    }
}
