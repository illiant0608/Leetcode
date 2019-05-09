import java.util.LinkedList;
import java.util.List;

public class KthSmallestInBST {
    List<Integer> list = new LinkedList<>();
    int count = 0;
    int result = Integer.MIN_VALUE;

    /**
     * 利用性质: BST的中序遍历是按从小到大顺序排列的
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        return list.get(k-1);
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }

    /**
     * 在递归中判断是否已经到第k个，不需要保存，降低了空间复杂度
     * 时间复杂度平均为第一种做法的1/2
     */
    public void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        if (++count == k) result = root.val;
        traverse(root.right, k);
    }

    public void printList() {
        System.out.println(list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        KthSmallestInBST test = new KthSmallestInBST();
        test.helper(root);
        test.printList();
    }
}
