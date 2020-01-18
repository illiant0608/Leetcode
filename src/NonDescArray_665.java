import java.util.Arrays;

public class NonDescArray_665 {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1;i < nums.length && cnt <= 1;i++) {
            if (nums[i-1] > nums[i]) { // 把nums[i]改大或者nums[i-1]改小
                // 贪心的策略是每次都改nums[i-1]，因为改大nums[i]之后更可能不递减
                // 但如果nums[i-2] > nums[i], 那就得改nums[i]
                cnt++;
                if (i - 2 < 0 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
            }
        }
        System.out.println(Arrays.toString(nums));
        return cnt <= 1;
    }

    public static void main(String[] args) {
        NonDescArray_665 test = new NonDescArray_665();
        int[] array = {2, 5, 4};
        System.out.println(test.checkPossibility(array));
    }
}
