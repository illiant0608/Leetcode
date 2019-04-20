import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeZigZag_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(); // 保存一层的节点
        boolean left2right = false;

        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);

        LinkedList<Integer> temp;

        while (!queue.isEmpty()) {
            temp = new LinkedList<>();
            for (int i = queue.size();i > 0;i--) {
                TreeNode curr = queue.poll();
                if (left2right)
                    temp.addFirst(curr.val);
                else
                    temp.add(curr.val);

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            left2right = !left2right;
            result.add(temp);
        }

        return result;
    }
}
