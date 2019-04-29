/**
 * leetcode 437
 */
public class PathSum3 {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    public void helper(TreeNode node, int sum) {
        if (node == null) return;
        if (node.val == sum) count++;
        helper(node.left, sum - node.val);
        helper(node.right, sum - node.val);
    }
}
