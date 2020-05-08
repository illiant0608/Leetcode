class BPGNode {
    public String val;
    public String BPG;
    public BPGNode left;
    public BPGNode right;
    public BPGNode(String val) {
        this.val = val;
        int v = Integer.parseInt(val);
        if (v == 0) this.BPG = "B";
        else if (val.contains("0")) this.BPG = "G";
        else this.BPG = "P";
    }
}

public class BPGTree {
    public String bpg(String s) {
        BPGNode root = createTree(s);
        StringBuilder sb = new StringBuilder();
        traversal(root, sb);
        return sb.toString();
    }

    public void traversal(BPGNode root, StringBuilder sb) {
        if (root == null) return;
        traversal(root.left, sb);
        traversal(root.right, sb);
        sb.append(root.BPG);
    }

    public BPGNode createTree(String s) {
        if (s.length() == 1) return new BPGNode(s);
        BPGNode root = new BPGNode(s);
        root.left = createTree(s.substring(0, s.length() / 2));
        root.right = createTree(s.substring(s.length() / 2));

        return root;
    }
}
