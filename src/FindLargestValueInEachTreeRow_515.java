import java.util.*;

public class FindLargestValueInEachTreeRow_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int d) {
        if (root == null) return;

        if (d == res.size())
            res.add(root.val);
        else
            res.set(d, Math.max(res.get(d), root.val));

        helper(root.left, res, d + 1);
        helper(root.right, res, d + 1);
    }

    public List<Integer> bfs_solution(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> values = new ArrayList<>();

        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int n = q.size();
            for (int i = 0;i < n;i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            values.add(max);
        }

        return values;
    }
}
