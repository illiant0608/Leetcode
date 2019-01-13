public class LongestIncreasingSequence_674 {

//    public int findLengthOfLCIS(int[] nums) {
//        if (nums.length == 0) return 0;
//        int max = 1;
//        for (int i = 0;i < nums.length;i++) {
//            int tmp = 1;
//            for (int j = i + 1;j < nums.length;j++) {
//                if (nums[j] > nums[j - 1])
//                    tmp++;
//                else
//                    break;
//
//                max = Math.max(max, tmp);
//            }
//
//
//        }
//
//        return max;
//    }

    //上面的写法太慢了,完全没有必要用两层循环
    // faster solution
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int len = 1, temp = 1;
        for (int i = 0; i < nums.length - 1;i++) {
            if (nums[i] < nums[i + 1]) {
                temp++;
                len = Math.max(len, temp);
            } else
                temp = 1;
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        LongestIncreasingSequence_674 test = new LongestIncreasingSequence_674();
        System.out.println(test.findLengthOfLCIS(nums));
    }
}
