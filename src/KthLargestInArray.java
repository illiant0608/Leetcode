public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int[] arr = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] - min]++;
        }

        for (int i = 0;i < arr.length;i++)
            System.out.print(arr[i]);

        System.out.println();

        int index = max - min;
        while (k >= 0) {
            if (nums[index] != 0) {
                k--;
                index--;
            }

        }

        return nums[index];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        KthLargestInArray test = new KthLargestInArray();
        System.out.println(test.findKthLargest(nums, 2));
    }
}
