public class HouseRobber {
    public int rob(int[] nums) {
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
