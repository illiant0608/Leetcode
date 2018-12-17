public class ConvertBSTtoGreatTree_538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        TreeNode node = root;
        convert(node);

        return root;
    }

    public void convert(TreeNode node) {
        if (node == null) return;
        convert(node.right);
        node.val += sum;
        sum = node.val;
        convert(node.left);
    }



    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
