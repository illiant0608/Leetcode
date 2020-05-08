import java.util.Stack;

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = new ListNode(0), head = pre;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;

            pre.next = cur;
            pre = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }

        return head.next;
    }
}
