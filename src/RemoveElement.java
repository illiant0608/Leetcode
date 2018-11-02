public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return nums.length;

        int k  = 0;

        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != val)
                nums[k++] = nums[i];
        }

        return k;
    }
}
