import java.util.*;

/**
 * leetcode 99
 */
public class RecoverBST {
    List<Integer> list = new LinkedList<>();
    List<TreeNode> nodeList = new LinkedList<>();
    public void recoverTree(TreeNode root) {
        // 第一种空间复杂度O(n)的做法
        // 中序遍历树，把所有的节点值保存到列表中
        // 给列表排序，再重新将值赋给节点
        // 用到的性质 =>> BST的中序遍历是从小到大的
        inOrder(root);
        Collections.sort(list);
        for (int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).val = list.get(i);
        }
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        list.add(node.val);
        nodeList.add(node);
        inOrder(node.right);
    }

    /**
     * Inorder traverse, keep the previous tree node,
     * Find first misplaced node by
     * if ( current.val < prev.val )
     *    Node first = prev;
     *
     * Find second by
     * if ( current.val < prev.val )
     *    Node second = current;
     * Using Threaded Binary Tree for traversal
     * 1. Initialize current as root
     * 2. While current is not NULL
     *    If current does not have left child
     *       a) Print current’s data
     *       b) Go to the right, i.e., current = current->right
     *    Else
     *       a) Make current as right child of the rightmost node in current's left subtree
     *       b) Go to this left child, i.e., current = current->left
     */
    public void recoverTreeByMorris(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null, second = null;
        // Morris Traversal
        TreeNode temp = null;
        while(root!=null){
            if(root.left!=null){
                // connect threading for root
                temp = root.left;
                while(temp.right!=null && temp.right != root)
                    temp = temp.right; //左子树的最右节点
                // the threading already exists
                if(temp.right!=null){
                    if(pre!=null && pre.val > root.val){
                        if(first==null){first = pre;second = root;}
                        else{second = root;}
                    }
                    pre = root;

                    temp.right = null;
                    root = root.right;
                }else{
                    // construct the threading
                    temp.right = root; // 左子树最右节点指向根
                    root = root.left;
                }
            }else{
                if(pre!=null && pre.val > root.val){
                    if(first==null){first = pre;second = root;}
                    else{second = root;}
                }
                pre = root;
                root = root.right;
            }
        }
        // swap two node values;
        if(first!= null && second != null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}
