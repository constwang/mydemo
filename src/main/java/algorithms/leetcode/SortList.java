package algorithms.leetcode;

import algorithms.linked.ListNode;

/**
 * Created by wa on 2017/4/24.
 */
public class SortList {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);
        return merge(node1, node2);
    }

    public static ListNode merge(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(0);
        ListNode tmp = result;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                result.next = new ListNode(node2.val);
                node2 = node2.next;
            } else {
                result.next = new ListNode(node1.val);
                node1 = node1.next;
            }
            result = result.next;
        }
        if (node1 != null) result.next = node1;
        if (node2 != null) result.next = node2;
        return tmp.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        System.out.println(sortList(node1));
    }
}
