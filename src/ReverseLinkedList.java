import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 206
 */
public class ReverseLinkedList {

    /**
     * 栈实现
     * 几乎是最慢的实现
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            ListNode temp = head.next;
            stack.push(head);
            head.next = null; // 切除掉链表之间的连接，防止出现死循环
            head = temp;
        }

        ListNode newHead = stack.pop();
        ListNode temp = newHead;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }

        return newHead;
    }

    /**
     * 递归实现
     */
    public ListNode reverseListRecursivly(ListNode head) {
        return helper(head, null);
    }

    public ListNode helper(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return helper(next, head);
    }

    public ListNode reverseListIteratably(ListNode head) {
        if (head == null) return null;
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;

        ReverseLinkedList test = new ReverseLinkedList();
        ListNode t = test.reverseListRecursivly(head);
        while (t != null) {
            System.out.print(t.val + " ");
            t = t.next;
        }
    }
}
