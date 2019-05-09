/**
 * leetcode 86
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(-1);
        ListNode t1 = l1;
        ListNode l2 = new ListNode(-1);
        ListNode t2 = l2;

        while (head != null) {
            if (head.val < x) {
                t1.next = head;
                t1 = head;
            } else {
                t2.next = head;
                t2 = head;
            }

            head = head.next;
        }

        t2.next = null; // 防止产生环
        t1.next = l2.next;
        return l1.next;
    }
}
