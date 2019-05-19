import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RecoverBSTTest {
    RecoverBST bst = new RecoverBST();

    @Test
    public void recoverTree() {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(2);

        bst.recoverTree(root);
    }
}