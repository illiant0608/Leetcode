public class RemoveDupFromSortedList2_82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode fakehead = new ListNode(0);
        fakehead.next = head;
        ListNode pre = fakehead;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (pre.next == cur)
                pre = pre.next;
            else
                pre.next = cur.next;

            cur = cur.next;
        }

        return fakehead.next;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }

    }

    public static void main(String[] args) {
        RemoveDupFromSortedList2_82 test = new RemoveDupFromSortedList2_82();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        test.printList(node1);
        test.deleteDuplicates(node1);
    }
}
