import java.util.HashMap;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
//        int[] ret = new int[2];
//        for (int i = 0;i < nums.length;i++) {
//            for (int j = i+1;j < nums.length;j++) {
//                if (nums[i] + nums[j] == target) {
//                    ret[0] = i;
//                    ret[1] = j;
//                    return ret;
//                }
//            }
//        }
//        return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            if (map.containsKey(target - nums[i])) {
                int left = map.get(target - nums[i]);
                int[] result = new int[2];
                result[0] = left;
                result[1] = i;
                return result;
            } else
                map.put(nums[i], i);
        }

        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum_1 test = new TwoSum_1();
        int[] result = test.twoSum(nums, 9);

        for (int i = 0;i < result.length;i++)
            System.out.print(result[i]);
    }
}
