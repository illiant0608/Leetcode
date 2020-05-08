import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveZeroSumFromLinkedList_1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> seen = new HashMap<>();
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        int prefix = 0;

        seen.put(0, dummy);
        for (ListNode n = dummy; n != null; n = n.next) {
            prefix += n.val;
            seen.put(prefix, n);
        }

        prefix = 0;
        for (ListNode n = dummy; n != null; n = n.next) {
            prefix += n.val;
            n.next = seen.get(prefix).next;
        }
        return dummy.next;
    }
}
