/**
 * leetcode 112
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) {
//            if (sum - root.val == 0 && root.left == null && root.right == null)
//                return true;
//            else return false;
//        } else {
//            boolean left = hasPathSum(root.left, sum - root.val);
//            boolean right = hasPathSum(root.right, sum - root.val);
//
//            return left || right;
//        }

        if (root == null) return false;
        if (root.left == null && root.right == null && sum - root.val == 0)
            return true;
        else
            return hasPathSum(root.left, sum - root.val) ||
                    hasPathSum(root.right, sum - root.val);
    }
}
