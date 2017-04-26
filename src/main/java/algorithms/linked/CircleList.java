package algorithms.linked;

/**
 * Created by wa on 2017/4/18.
 * http://wuchong.me/blog/2014/03/25/interview-link-questions/
 */
public class CircleList {
    public static boolean hasCircle(ReverseList.Node head) {
        ReverseList.Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static ReverseList.Node findLoopPort(ReverseList.Node head) {
        //如果head为空，或者为单结点，则不存在环
        if (head == null || head.next == null) return null;
        ReverseList.Node slow = head, fast = head;
        //先判断是否存在环
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.val == slow.val) break;
        }
        //不存在环
        if (fast.val != slow.val) return null;

        //快指针从头开始走，步长变为1
        fast = head;
        while (fast.val != slow.val) {     //两者相遇即为入口点
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
