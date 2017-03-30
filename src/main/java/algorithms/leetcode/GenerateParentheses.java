package algorithms.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wa on 2017/3/30.
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        recurse(result, "", 0, 0, n);
        return result;
    }

    public static void recurse(List<String> result, String temp, int open, int close, int max) {
        if (temp.length() == max * 2) {
            result.add(temp);
        } else {
            if (open < max) recurse(result, temp + "(", open + 1, close, max);
            if (close < open) recurse(result, temp + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
