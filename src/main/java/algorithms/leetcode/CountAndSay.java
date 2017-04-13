package algorithms.leetcode;

import java.util.Stack;

/**
 * Created by wa on 2017/4/10.
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        Stack<String> result = new Stack<>();
        int preDigit = n % 10;
        int num = 1;
        n /= 10;
        while (n != 0) {
            int thisDigit = n % 10;
            n /= 10;
            if (preDigit == thisDigit) num++;
            else {
                result.push(num + "" + preDigit);
                preDigit = thisDigit;
                num = 1;
            }
        }
        String finalResult = num + "" + preDigit;
        while (result.size() != 0) {
            finalResult += result.pop();
        }
        return finalResult;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
    }
}
