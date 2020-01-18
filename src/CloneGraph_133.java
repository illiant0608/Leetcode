import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph_133 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
    }

    HashMap<Node, List<Node>> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        Map<Node, Node> lookup = new HashMap<>();
        return dfs(node, lookup);
    }

    public Node dfs(Node node, Map<Node, Node> lookup) {
        if (node == null) return null;
        if (lookup.containsKey(node)) return lookup.get(node);
        Node clone = new Node(node.val);
        lookup.put(node, clone);
        if (node.neighbors != null) {
            clone.neighbors = new ArrayList<>();
            for (Node tmp : node.neighbors) clone.neighbors.add(dfs(tmp, lookup));
        }
        return clone;
    }
}
