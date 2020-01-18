import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SmallLestFromLeaf_988 {
    List<String> list = new LinkedList<>();
    char start = 'a';

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) return "";

        dfs(root, new StringBuilder());

        Collections.sort(list);

        return list.get(0);
    }

    private void dfs(TreeNode root, StringBuilder cur) {
        cur.append((char)(start + root.val));

        if (root.left == null && root.right == null) {
            StringBuilder tmp = new StringBuilder(cur);
            list.add(tmp.reverse().toString());
            cur.delete(cur.length()-1, cur.length());
            return;
        }

        StringBuilder tmp = new StringBuilder(cur);
        if (root.left != null) dfs(root.left, cur);
        cur = tmp;
        if (root.right != null) dfs(root.right, cur);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        TreeNode left = new TreeNode(1);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        TreeNode right = new TreeNode(3);
        right.left = new TreeNode(0);
        right.right = new TreeNode(2);
        root.left = left;
        root.right = right;

        SmallLestFromLeaf_988 test = new SmallLestFromLeaf_988();
        test.smallestFromLeaf(root);
    }
}
