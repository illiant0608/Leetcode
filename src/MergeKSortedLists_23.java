import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        //最简单的实现，但是因为result链表越来越长，所以归并排序的效率越来越差
//        if (lists.length == 0) return null;
//        ListNode result = lists[0];
//        for (int i = 1;i < lists.length;i++) {
//            result = mergeTwoLists(result, lists[i] );
//        }
//
//        return result;

        return partion(lists, 0, lists.length - 1);
    }

    //通过递归实现归并，而不是循环
    public ListNode partion(ListNode[] lists, int s, int e) {
        if (s == e) return lists[s];
        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partion(lists, s, q);
            ListNode l2 = partion(lists, q + 1, e);
            return mergeTwoLists(l1, l2);
        } else
            return null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
