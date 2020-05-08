public class ReorderList_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode prev = null, slow = head, fast = head, l1 = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // 断开

        ListNode l2 = reverse(slow);

        merge(l1, l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        ReorderList_143 test = new ReorderList_143();
        test.reorderList(head);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
