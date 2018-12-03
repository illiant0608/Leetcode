import java.util.Map;

public class BinaryTreeMaximumPathSum_124 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    int helper(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        res = Math.max(res, left + right + node.val);
        return Math.max(left, right) + node.val; //返回以当前节点为终点的path之和
    }
}
