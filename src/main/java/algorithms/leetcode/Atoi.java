package algorithms.leetcode;

/**
 * Created by wangk on 2017/3/20.
 * 1. 前面带正负号的字符串
 * 2. 溢出的处理
 * 3. 空白符
 */
public class Atoi {
    public static int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int index = 0;
        boolean isPositive = true;
        int result = 0;
        while (str.charAt(index) == ' ' && index < str.length()) {
            index++;
        }
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            isPositive = str.charAt(index) == '+';
            index++;
        }
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit > 9 || digit < 0) {
                return result;
            }
            digit = isPositive ? digit : -digit;
            if (isPositive && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit))) {
                return Integer.MAX_VALUE;
            }
            if (!isPositive && (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && Integer.MIN_VALUE % 10 > digit))) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("1"));
        //System.out.println(-2147483648-8);
        String str="";
        System.out.println(str.length());
    }
}
