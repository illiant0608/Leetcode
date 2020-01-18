import java.util.Stack;

// 其实就是前序遍历
public class FlattenBT_114 {
    public void flatten(TreeNode root) {
        if(root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        // 展平左右子树
        flatten(left);
        flatten(right);

        // 把展开的左子树接到根的右边，然后一直遍历到底部，然后把展开的右子树接在后面
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }

    // non-recursive
    public void flatten_2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            if (cur.right != null)
                stk.push(cur.right);
            if (cur.left != null)
                stk.push(cur.left);
            if (!stk.isEmpty())
                cur.right = stk.peek();
            cur.left = null;
        }
    }
}
