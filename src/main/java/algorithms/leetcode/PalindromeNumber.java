package algorithms.leetcode;

/**
 * Created by 王康 on 2017/6/18.
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int tmp = x;
        int reverseNum = 0;
        while (x != 0) {
            int digit = x % 10;
            int result = reverseNum * 10 + digit;
            if ((result - digit) / 10 != reverseNum) {
                return false;
            }
            reverseNum = result;
            x = x / 10;
        }
        return reverseNum == tmp;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(11001));
    }
}
