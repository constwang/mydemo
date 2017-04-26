package algorithms.leetcode;

import algorithms.linked.ListNode;

/**
 * Created by wa on 2017/4/25.
 */
public class IntersectionOfTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headB == null || headA == null) return null;
        ListNode end = headB;
        while (end.next != null) end = end.next;
        end.next = headA;

        ListNode fast = headB, slow = headB;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = headB;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                end.next = null;
                return fast;
            }
        }
        end.next = null;
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = node1;
        System.out.println(getIntersectionNode(node1, node1).val);
    }


}
