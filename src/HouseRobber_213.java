public class HouseRobber_213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] rob_nums = new int[nums.length - 1];

        for (int i = 0;i < nums.length - 1;i++) rob_nums[i] = nums[i];
        int rob_first = rob_money(rob_nums);

        for (int i = 0;i < nums.length - 1;i++) rob_nums[i] = nums[i+1];
        int not_rob_first = rob_money(rob_nums);

        return Math.max(rob_first, not_rob_first);
    }

    private int rob_money(int[] nums) {
        int rob = 0;
        int notrob = 0;
        for (int i = 0;i < nums.length;i++) {
            int currob = notrob + nums[i]; // 如果偷这家，那么前一家就不能偷
            notrob = Math.max(notrob, rob); // 如果不偷这家，那么notrob就是偷或不偷上一家中的最大值
            rob = currob;
        }

        return Math.max(rob, notrob);
    }
}
