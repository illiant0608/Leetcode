import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserializeBST_449 {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(root);

        while (! stack.empty()) {
            TreeNode node = stack.pop();
            sb.append(node.val).append(" ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(" "))
            return null;

        String[] strs = data.split(" ");
        Queue<Integer> queue = new LinkedList<>();

        for (String str : strs) {
            queue.offer(Integer.parseInt(str));
        }

        return getNodes(queue);
    }

    public TreeNode getNodes(Queue<Integer> queue) {
        if (queue.isEmpty())
            return null;
        TreeNode root = new TreeNode(queue.poll());

        // 把比当前节点小的值都分到smallQueue中
        Queue<Integer> smallQueue = new LinkedList<>();
        while (! queue.isEmpty() && queue.peek() < root.val) {
            smallQueue.offer(queue.poll());
        }

        root.left = getNodes(smallQueue);
        root.right = getNodes(queue);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        SerializeAndDeserializeBST_449 test = new SerializeAndDeserializeBST_449();
        test.serialize(root);
    }
}
