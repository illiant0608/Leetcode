public class LowestCommonAncestor_236 {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);

        return ans;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;

        int left = dfs(node.left, p, q) ? 1 : 0;
        int right = dfs(node.right, p, q) ? 1 : 0;
        int mid = (node == p || node == q) ? 1 : 0;

        if (left + right + mid >= 2) ans = node;

        return left + right + mid > 0;
    }
}
