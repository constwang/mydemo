package algorithms.leetcode;

/**
 * Created by wa on 2017/3/30.
 */
public class MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    public static ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start < end) {
            int middle = (start + end) / 2;
            ListNode l1 = partition(lists, start, middle);
            ListNode l2 = partition(lists, middle + 1, end);
            return mergerTwoLists(l1, l2);
        }
        return null;
    }

    public static ListNode mergerTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergerTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergerTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        //System.out.println(mergeKLists());
    }
}
