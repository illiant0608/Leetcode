public class ConvertSortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    public TreeNode sort(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sort(nums, left, mid - 1);
        root.right = sort(nums, mid + 1, right);

        return root;
    }
}
