import java.util.HashMap;

public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // cut

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // 递归基的情况只有两种
        // l1, l2长度都为1 或 有一个是null

        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;

        return l.next;
    }
}
