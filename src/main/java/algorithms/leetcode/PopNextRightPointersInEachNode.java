package algorithms.leetcode;

/**
 * Created by wa on 2017/4/19.
 */
public class PopNextRightPointersInEachNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode pre = root;
        while (pre.left != null) {
            TreeLinkNode cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
    }


    public static void main(String[] args) {

    }
}
