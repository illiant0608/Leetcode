import java.util.List;

public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            // 反转
            pre.next = prepre;
            prepre = pre;
        }
        // fast 走到最后的时候，pre和slow都在中间
        // 而这个时候pre是往前指的，因为做了链表反转

        if (fast != null) {
            slow = slow.next;
        }

        while (pre != null && slow != null) {
            if (pre.val != slow.val)
                return false;
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode next = null;
        while (head.next != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        head.next = prev;
        return head;
    }

    public static void main(String[] args) {
        PalindromeLinkedList_234 test = new PalindromeLinkedList_234();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        test.isPalindrome(head);
    }
}
