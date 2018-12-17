public class JumpGame_45 {
    //贪心算法
    public int jump(int[] nums) {
        int jump = 0, curEnd = 0, curFarest = 0;

        for (int i = 0;i < nums.length - 1;i++) {
            curFarest = Math.max(curFarest, i + nums[i]); //从i到curEnd的点中，最远能到达的点

            if (curEnd == i) {
                curEnd = curFarest;
                jump++;
            }
        }
        return jump;
    }
}
