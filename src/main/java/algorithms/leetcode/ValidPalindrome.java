package algorithms.leetcode;

/**
 * Created by wa on 2017/4/21.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        int start = 0, end = ch.length - 1;
        while (start < end) {
            if (isAlphaNum(ch[start])) {
                start++;
                continue;
            }
            if (isAlphaNum(ch[end])) {
                end--;
                continue;
            }
            if (trim(ch[start++]) != trim(ch[end--])) return false;
        }
        return true;
    }

    public static boolean isAlphaNum(char ch) {
        return ch < '0' || (ch > '9' && ch < 'A') || (ch > 'Z' && ch < 'a') || ch > 'z';
    }

    public static char trim(char ch) {
        return ch >= 'A' && ch <= 'Z' ? (char) (ch + 32) : ch;
    }

    public static void main(String[] args) {
        String s = "1b1";
        System.out.println(isPalindrome(s));
    }
}
