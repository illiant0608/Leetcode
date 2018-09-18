/**
 * O(N)的解决方法
 * public int pivotIndex(int[] nums) {
 *     int total = 0, sum = 0;
 *     for (int num: nums) total+= num
 *     for (int i = 0; i < nums.length;sum += nums[i++])
 *          if (sum * 2 == total - nums[i]) return i;
 *     return -1;
 * }
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        for (int i = 0;i < nums.length;i++) {
            int sum1 = 0;
            int sum2 = 0;

            for (int j = 0;j < i;j++) {
                sum1 += nums[j];
            }
            for (int j = i+1;j < nums.length;j++){
                sum2 += nums[j];
            }

            if (sum1 == sum2)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex test = new FindPivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        test.pivotIndex(nums);
    }
}
