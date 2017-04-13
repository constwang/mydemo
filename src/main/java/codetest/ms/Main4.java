package codetest.ms;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wa on 2017/3/31.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            Stack<Character> stack = new Stack<>();
            int total = 0;
            int lack = 0;
            for (char ch : line.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                    total++;
                } else {
                    if (stack.size() != 0) stack.pop();
                    else {
                        lack++;
                        total++;
                    }
                }
            }
            lack += stack.size();
            if (lack == 0) {
                System.out.println(lack + " " + 0);
            } else if (total == lack) {
                List<String> result = new LinkedList<>();
                recurse(result, "", 0, 0, total);
                System.out.println(lack + " " + result.size());
            } else {
                System.out.println(lack + " " + total);
            }
        }
    }

    public static void recurse(List<String> result, String temp, int open, int close, int max) {
        if (temp.length() == max * 2) {
            result.add(temp);
        } else {
            if (open < max) recurse(result, temp + "(", open + 1, close, max);
            if (close < open) recurse(result, temp + ")", open, close + 1, max);
        }
    }
}
