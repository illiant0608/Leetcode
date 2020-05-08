public class DistributedCoinsInBinaryTree_979 {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    // dfs 返回的是当前节点为了让自己剩下的硬币数为1，需要交给父节点的硬币数
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
