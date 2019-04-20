import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 146 https://leetcode.com/problems/lru-cache/
 */

public class LRUCache {
    class Node {
        int val;
        int key;
        Node next;
        Node prev;

        public Node() {}

        public Node(int key, int val) { this.key = key; this.val = val; }
    }

    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    int count = 0;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node target_node = map.get(key);
            removeNode(target_node);
            offerFirst(target_node);
            return target_node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node toUpdate = map.get(key);
            toUpdate.val = value;

            removeNode(toUpdate);
            offerFirst(toUpdate);
        } else {
            Node newNode = new Node(key, value);
            offerFirst(newNode);
        }
    }

    private void removeNode(Node toRemove) {
        if (count > 0) {
            Node prev = toRemove.prev;
            Node next = toRemove.next;
            toRemove.next = null;
            toRemove.prev = null;
            prev.next = next;
            next.prev = prev;
            map.remove(toRemove.key);
            count--;
        }
    }

    private void offerFirst(Node toOffer) {
        Node next = head.next;
        head.next = toOffer;
        toOffer.next = next;
        next.prev = toOffer;
        toOffer.prev = head;
        map.put(toOffer.key, toOffer);
        count++;

        if (count > capacity)
            removeNode(tail.prev);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.get(1);
    }

}
