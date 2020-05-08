public class ConvertSortedListToBST_109 {
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        for (ListNode ptr = head; ptr != null; ptr = ptr.next)
            length++;

        return sort(head, 0, length - 1);
    }

    // 笨逼做法
    public TreeNode sort(ListNode head, int left, int right) {
        if (left > right) return null;
        if (left == right) {
            ListNode node = getNodeByIndex(head, left);
            return new TreeNode(node.val);
        }
        int mid = (left + right) / 2;
        ListNode mid_node = getNodeByIndex(head, mid);
        TreeNode root = new TreeNode(mid_node.val);
        root.left = sort(head, left, mid - 1);
        root.right = sort(head, mid + 1, right);

        return root;
    }

    // 用快慢指针来找中间元素，而不是每次都去遍历
    public TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;
        if (head == tail) return null;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode thread = new TreeNode(slow.val);
        thread.left = toBST(head, slow);
        thread.right = toBST(slow.next, tail);
        return thread;
    }

    public ListNode getNodeByIndex(ListNode head, int index) {
        ListNode ptr = head;
        for (int i = 0;i < index;i++)
            ptr = ptr.next;
        return ptr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode second = new ListNode(-3);
        ListNode third = new ListNode(0);
        ListNode forth = new ListNode(5);
        ListNode fifth = new ListNode(9);

        head.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;

        ConvertSortedListToBST_109 test = new ConvertSortedListToBST_109();
        test.sortedListToBST(head);
    }
}
