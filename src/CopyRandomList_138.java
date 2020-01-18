import java.util.HashMap;

// 简单来说思路就是要把copy的节点保存下来，不能直接去遍历，因为可能会有环的存在
public class CopyRandomList_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    HashMap<Node, Node> visitedHash = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (this.visitedHash.containsKey(head))
            return this.visitedHash.get(head);

        Node node = new Node(head.val);

        this.visitedHash.put(head, node);

        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }

    public Node getClonedNode(Node node) {
        if (node != null) {
            if (this.visitedHash.containsKey(node))
                return this.visitedHash.get(node);
            else {
                this.visitedHash.put(node ,new Node(node.val));
                return this.visitedHash.get(node);
            }
        }

        return null;
    }

    public Node copyRandomList_2(Node head) {
        if (head == null) return null;
        Node oldNode = head;
        Node newNode = new Node(oldNode.val);

        this.visitedHash.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return this.visitedHash.get(head);
    }
}
