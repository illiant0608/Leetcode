import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    /**
     * 非递归层次遍历
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;

        while (!queue.isEmpty()) {
            int n = queue.size(); // !!!要提前把queue的大小保存下来
            for (int i = 0;i < n;i++) {
                TreeNode curr = queue.poll();
                if (i == 0) res = curr.val; // 最左

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return res;
    }

    /**
     * 递归先序遍历
     * 维护一个最大深度值
     * 最后一行的最左边肯定最先被遍历到，由于是新一行，最大深度肯定比之前大
     * 所以一定会更新result值，遍历到最后一行其他节点时，由于depth == max_depth
     * 就不会更新result了
     */
    int result;
    int max_depth = 1;
    public int findBottomLeftValueRecursivly(TreeNode root) {
        helper(root, 1);
        return result;
    }

    public void helper(TreeNode node, int depth) {
        if (node == null) return;
        if (depth > max_depth) {
            max_depth = depth;
            result = node.val;
        }
        helper(node.left, depth+1);
        helper(node.right, depth+1);
    }

    public static void main(String[] args) {
        System.out.println(12 & 3);
    }
}
