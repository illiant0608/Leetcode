public class SortColors_75 {
    public void sortColors(int[] nums) {
        //quickSort(nums, 0, nums.length - 1);
        int second = nums.length - 1, zero = 0;
        for (int i = 0;i <= second;i++) {
            while (nums[i] == 2 && i < second) {
                nums[i] = nums[second];
                nums[second--] = 2;
            }
            while (nums[i] == 0 && i > zero) {
                nums[i] = nums[zero];
                nums[zero++] = 0;
            }
        }
    }

    private void quickSort(int[] arr, int low, int high) {
        int p, i, j, temp;
        if (low >= high) return;

        p = arr[low];
        i = low;
        j = high;

        while (i < j) {
            while (arr[j] >= p && i < j) {
                j--;
            }

            while (arr[i] <= p && i < j) {
                i++;
            }

            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        arr[low] = arr[i];
        arr[i] = p;
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }
}
