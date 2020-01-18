public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;

            //如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的
            if (nums[mid] < nums[high]) {
                // 知道哪半段有序之后，就能判断target是不是在这个范围内
                if (nums[mid] < target && nums[high] >= target) low = mid + 1;
                else high = mid - 1;
            } else {
                if (nums[low] <= target && nums[mid] > target) high = mid - 1;
                else low = mid + 1;
            }
        }

        return -1;
    }
}
