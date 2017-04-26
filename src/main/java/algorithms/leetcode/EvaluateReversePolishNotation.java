package algorithms.leetcode;

import java.util.Stack;

/**
 * Created by wa on 2017/4/25.
 */
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num1 = nums.pop();
                int num2 = nums.pop();
                nums.push(compute(num1, num2, token));
            } else {
                nums.push(Integer.parseInt(token));
            }
        }
        return nums.pop();
    }

    public static int compute(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num2 - num1;
            case "*":
                return num2 * num1;
            case "/":
                return num2 / num1;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String[] tokens = {"1", "2", "-"};
        System.out.println(evalRPN(tokens));
    }
}
