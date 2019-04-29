import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 95
 */
public class UniqueBST2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return generateSubTrees(1, n);
    }

    private List<TreeNode> generateSubTrees(int s, int e) { //从s到e 构建BST
        List<TreeNode> res = new LinkedList<>();
        if (s > e) {
            res.add(null);
            return res;
        }

        for (int i = s;i <= e;i++) {
            // 可以用一个全局HashMap保存结果
            List<TreeNode> leftSub = generateSubTrees(s, i - 1);
            List<TreeNode> rightSub = generateSubTrees(i + 1, e);

            for (TreeNode left : leftSub) {
                for (TreeNode right : rightSub) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);

                }
            }
        }

        return res;
    }
}
