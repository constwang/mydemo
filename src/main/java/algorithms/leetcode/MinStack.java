package algorithms.leetcode;

import java.util.*;

/**
 * Created by wa on 2017/4/25.
 */
public class MinStack {
    private Stack<Integer> nums;
    private TreeMap<Integer, Integer> minNums;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        nums = new Stack<>();
        minNums = new TreeMap<>();
    }

    public void push(int x) {
        nums.push(x);
        Integer times = minNums.get(x);
        if (times == null) minNums.put(x, 1);
        else minNums.put(x, times + 1);
    }

    public void pop() {
        Integer num = nums.pop();
        Integer times = minNums.get(num);
        times--;
        if (times == 0) minNums.remove(num);
        else minNums.put(num, times);
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return minNums.firstKey();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
