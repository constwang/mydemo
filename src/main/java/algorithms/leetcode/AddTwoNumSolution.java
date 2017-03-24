package algorithms.leetcode;

/**
 * Created by wangk on 2017/3/7.
 */
public class AddTwoNumSolution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode headNode = result;
        int nextAddNum = 0;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            int total = val1 + val2 + nextAddNum;
            if (total >= 10) {
                total = total - 10;
                nextAddNum = 1;
            } else {
                nextAddNum = 0;
            }

            result.next = new ListNode(total);
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val1 = l1.val;
            int total = val1 + nextAddNum;
            if (total >= 10) {
                total = total - 10;
                nextAddNum = 1;
            } else {
                nextAddNum = 0;
            }
            result.next = new ListNode(total);
            result = result.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val2 = l2.val;
            int total = val2 + nextAddNum;
            if (total >= 10) {
                total = total - 10;
                nextAddNum = 1;
            } else {
                nextAddNum = 0;
            }
            result.next = new ListNode(total);
            result = result.next;
            l2 = l2.next;
        }
        return headNode.next;
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode headNode = result;
        int nextAddNum = 0;
        while (l1 != null || l2 != null || nextAddNum != 0) {
            //int val1 = l1.val;
            //int val2 = l2.val;
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int total = val1 + val2 + nextAddNum;
            nextAddNum = total / 10;
            total = total - 10 * nextAddNum;

            result.next = new ListNode(total);
            result = result.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        //node1.next = new ListNode(4);
        ListNode node2 = new ListNode(5);
        //node2.next = new ListNode(6);
        ListNode result = addTwoNumbers2(node1, node2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
