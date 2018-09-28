import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePath {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) searchBT(root, "", result);
        return result;
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path+ root.val + "->" , answer);
        if (root.right != null) searchBT(root.right, path+root.val+"->", answer);
    }
}
