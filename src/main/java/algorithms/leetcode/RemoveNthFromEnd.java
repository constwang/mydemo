package algorithms.leetcode;

/**
 * Created by wa on 2017/3/27.
 */
public class RemoveNthFromEnd {

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode fast = head, slow = head;
        //slow.next=head;
        int index = 0;
        while (index < n) {
            fast = fast.next;
            index++;
        }
        if (fast == null) return head.next;
        fast = fast.next;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode result = new ListNode(0);
        ListNode fast = result, slow = result;
        result.next = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        //System.out.println(node5);
        ListNode node4 = new ListNode(4);
        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;

        ListNode result = removeNthFromEnd2(node1, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
