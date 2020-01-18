import java.util.LinkedList;

public class SumNumberInTree_129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int cur) {
        cur = cur * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum += cur;
            return;
        }

        if (root.left != null) dfs(root.left, cur);
        if (root.right != null) dfs(root.right, cur);
    }
}
