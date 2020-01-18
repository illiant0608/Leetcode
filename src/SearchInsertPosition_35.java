public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        SearchInsertPosition_35 test = new SearchInsertPosition_35();
        System.out.println(test.searchInsert(arr, 2));
    }
}
