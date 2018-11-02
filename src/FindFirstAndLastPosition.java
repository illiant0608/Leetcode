public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int start = FindFirstAndLastPosition.findGreaterOrEqual(nums, target);
        if (start == nums.length || nums[start] != target)
            return new int[] {-1, -1};
        int end = FindFirstAndLastPosition.findGreaterOrEqual(nums, target + 1);
        return new int[] {start, end - 1};
    }

    private static int findGreaterOrEqual(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindFirstAndLastPosition f = new FindFirstAndLastPosition();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] ret = f.searchRange(nums, 8);
        for (int i = 0;i < ret.length;i++)
            System.out.println(ret[i]);
    }
}
