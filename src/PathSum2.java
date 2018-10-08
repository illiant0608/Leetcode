import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PathSum2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private List<List<Integer>> resultList = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return resultList;
        Stack<Integer> path = new Stack<>();
        pathSumInner(root, sum, path);
        return resultList;
    }

    public void pathSumInner(TreeNode root, int sum, Stack<Integer> path) {
        path.push(root.val);
        if (root.left == null && root.right == null)
            if (sum == root.val) {
                resultList.add(new ArrayList<>(path));
            }

        if (root.left != null) pathSumInner(root.left, sum-root.val, path);
        if (root.right != null) pathSumInner(root.right, sum-root.val, path);
        path.pop();

    }

    public static void main(String[] args) {

    }
}
