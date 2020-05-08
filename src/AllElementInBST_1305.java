import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllElementInBST_1305 {
    public void dfs (TreeNode node, List<Integer> list) {
        if (node == null) return;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
        return;
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);


        // merge sort
        int i1 = 0, i2 = 0;
        while (i1 < l1.size() || i2 < l2.size()) {
            if (i2 == l2.size() || i1 < l1.size() && l1.get(i1) <= l2.get(i2)) {
                ans.add(l1.get(i1));
                i1++;
            } else {
                ans.add(l2.get(i2));
                i2++;
            }
        }

        return ans;
    }
}
