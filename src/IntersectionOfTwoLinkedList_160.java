public class IntersectionOfTwoLinkedList_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    /**
     * proof
     * A length: a + c, B length: b + c
     * A + B = B + A
     * 所以两个指针最终一定会相交（如果链表相交的话）
     * **/
}
