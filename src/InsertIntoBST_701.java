public class InsertIntoBST_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        traverse(node, val);
        return node;
    }

    private void traverse(TreeNode node, int val) {
        if (node.val > val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
                return;
            }

            traverse(node.left, val);
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
                return;
            }

            traverse(node.right, val);
        }
    }
}
