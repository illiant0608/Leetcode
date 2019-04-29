public class MaxDepth {
    public int getMaxDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = getMaxDepth(node.left);
        int rightDepth = getMaxDepth(node.right);
        return Math.max(leftDepth, rightDepth);
    }
}
