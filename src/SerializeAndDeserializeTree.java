import java.util.*;

public class SerializeAndDeserializeTree {
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    /**
     * 最简单的先序遍历 根的值 + 左子树产生的String + 右子树产生的String
     */
    public String simpleSerialize(TreeNode root) {
        if (root == null) return "X,";
        String left = simpleSerialize(root.left);
        String right = simpleSerialize(root.right);
        return root.val + "," + left + right;
    }

    /**
     * 先序遍历构建String，用X代表null
     */
    public void buildString(TreeNode node, StringBuilder sb) {
        if (node == null)
            sb.append(NN).append(spliter);
        else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.poll();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes); // 需要两个null来返回上一层递归
            return node;
        }
    }

    public static void main(String[] args) {
        SerializeAndDeserializeTree test = new SerializeAndDeserializeTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(test.simpleSerialize(root));
    }
}
