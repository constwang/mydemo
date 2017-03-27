package algorithms.leetcode;

import java.util.Stack;

/**
 * Created by wa on 2017/3/27.
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                char pop = stack.pop();
                if (pop == '{' && c != '}') return false;
                if (pop == '(' && c != ')') return false;
                if (pop == '[' && c != ']') return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("[]]"));
    }
}
