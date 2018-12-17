import java.util.Arrays;

public class ArrayPartition1_561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0;i < nums.length;i+=2) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        ArrayPartition1_561 test = new ArrayPartition1_561();
        System.out.println(test.arrayPairSum(nums));
    }
}
