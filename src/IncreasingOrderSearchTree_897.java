import java.util.Stack;

public class IncreasingOrderSearchTree_897 {
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(0), p = dummy;
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode curr = stack.pop();
                root = curr.right; //遍历右子树
                curr.left = null;
                p.right = curr;
                p = p.right;
            }
        }

        return dummy.right;
    }

//    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
//        if (root == null) return tail;
//        TreeNode res = increasingBST(root.left, root);
//        root.left = null;
//        root.right = increasingBST(root.right, tail);
//        return res;
//    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
}
