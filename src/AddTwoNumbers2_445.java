import java.util.Stack;

public class AddTwoNumbers2_445 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode node = new ListNode(0);
        while (!stack1.empty() || !stack2.empty()) {
            if (!stack1.empty()) sum += stack1.pop();
            if (!stack2.empty()) sum += stack2.pop();

            node.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            //倒着加新节点
            head.next = node;
            node = head;
            sum /= 10;
        }

        return node.val == 0 ? node.next : node;
    }
}
