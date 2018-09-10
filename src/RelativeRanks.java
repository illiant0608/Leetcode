import java.util.Arrays;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int[] sortedNum = new int[nums.length];
        for (int i = 0;i < nums.length;i++) {
            sortedNum[i] = nums[i];
        }

        Arrays.sort(sortedNum);
        String[] rank = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int k = getRank(sortedNum, nums[i]);
            System.out.println(k);
            if (k == 1)
                rank[i] = "Gold Medal";
            else if (k == 2)
                rank[i] = "Silver Medal";
            else if (k == 3)
                rank[i] = "Bronze Medal";
            else
                rank[i] = k + "";
        }

        return rank;
    }

    public static int getRank(int[] nums, int number) {
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] < number)
                continue;
            else if (nums[i] == number)
                return nums.length - i;

        }

        return 1;
    }


    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        RelativeRanks test = new RelativeRanks();
        test.findRelativeRanks(nums);
    }
}
