public class ValidateBST_98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root.left, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, long minVal, long maxVal) {
        if (node == null) return true;
        if (node.val >= maxVal || node.val <= minVal) return false;
        return dfs(node.left, minVal, node.val) && dfs(node.right, node.val, maxVal);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBST_98 test = new ValidateBST_98();
        test.isValidBST(root);
    }
}
