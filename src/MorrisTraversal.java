public class MorrisTraversal {

    public static void morrisPre(TreeNode root) {
        if (root == null) return;
        TreeNode cur1 = root;
        TreeNode cur2 = null;

        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1)
                    cur2 = cur2.right;

                if (cur2.right == null) {
                    cur2.right = cur1;
                    System.out.print(cur1.val + " ");
                    cur1 = cur1.left;
                    continue;
                } else cur2.right = null;
            } else
                System.out.print(cur1.val + " ");

            cur1 = cur1.right;
        }

        System.out.println();
    }

    public static void morrisIn(TreeNode root) {
        if (root == null) return;
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1)
                    cur2 = cur2.right;
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else
                    cur2.right = null;
            }
            System.out.print(cur1.val + " ");
            cur1 = cur1.right;
        }

        System.out.println();
    }

    public static void morrisPos(TreeNode root) {
        if (root == null) return;
        TreeNode cur1 = root;
        TreeNode cur2 = null;

        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1)
                    cur2 = cur2.right;
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
        }
    }

    public static void printEdge(TreeNode head) {

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(2);

        morrisPre(root);
        morrisIn(root);
    }
}
