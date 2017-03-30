package algorithms.leetcode;

/**
 * Created by wa on 2017/3/29.
 */
public class MergeTwoSortedLists {

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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //考虑链表为空的情况
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                result.next = l2;
                break;
            }
            if (l2 == null) {
                result.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                result.next = new ListNode(l1.val);
                result = result.next;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                result.next = new ListNode(l2.val);
                result = result.next;
                l2 = l2.next;
            } else {
                result.next = new ListNode(l2.val);
                result = result.next;
                result.next = new ListNode(l2.val);
                result = result.next;
                l2 = l2.next;
                l1 = l1.next;
            }
        }
        return temp.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        node4.next = node5;

        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;

        ListNode result = mergeTwoLists(node1, node2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
