package algorithms.leetcode;

import java.util.HashMap;

/**
 * Created by wa on 2017/4/5.
 */
public class LRUCache2 {
    class Node {
        Node pre;
        Node next;

        Integer key;
        Integer val;

        Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;
    private int cap;

    public LRUCache2(int capacity) {
        cache = new HashMap<>(capacity);
        cap = capacity;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node cur = cache.get(key);
        if (cur != null) {
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            appendTail(cur);
            return cur.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node cur = cache.get(key);
        if (cur != null) {
            cur.val = value;
            cache.put(key, cur);
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            appendTail(cur);
        } else {
            if (cache.size() == cap) {
                cache.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
            }
            cur = new Node(key, value);
            appendTail(cur);
            cache.put(key, cur);
        }
    }

    private void appendTail(Node cur) {
        cur.next = tail;
        cur.pre = tail.pre;
        tail.pre.next = cur;
        tail.pre = cur;
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));      // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));      // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
