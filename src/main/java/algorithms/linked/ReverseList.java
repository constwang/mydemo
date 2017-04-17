package algorithms.linked;

/**
 * Created by wa on 2017/4/14.
 */
public class ReverseList {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) return head;
        Node p = head;
        Node q = p.next;
        head.next = null;
        while (q != null) {
            Node r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head = p;
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node2.next = node3;
        node1.next = node2;
        //System.out.println(node1);
        Node result = reverseList(node1);
        System.out.println(result);
    }
}
