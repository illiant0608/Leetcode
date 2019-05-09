/**
 * leetcode 19
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        while (head != null) {
            int distance = 0;
            ListNode node = head;
            ListNode temp = head;
            while (node != null) {
                distance++;
                node = node.next;
            }

            // 要考虑到删除的就是第一个节点的情况
            // 第一个节点就是没有前驱节点的
            if (distance == n && temp == dummy)
                return dummy.next;

            if (distance == n + 1) {
                ListNode toRemove = temp.next;
                temp.next = toRemove.next;
            }

            head = head.next;
        }

        return dummy;
    }

    /**
     * 双指针法
     */
    public ListNode remove2(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        for (int i = 1;i <= n+1;i++)
            fast = fast.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 这个时候slow就是要移除的节点的前一个节点

        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
        test.remove2(head, 1);

        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
