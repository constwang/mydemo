package algorithms.leetcode;

/**
 * Created by wangk on 2017/3/19.
 * 1�������͸��������
 * 2��������10010��ת��
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int result = 0;
        if (x >= 0) {
            while (x != 0) {
                int digit = x % 10;
                x = (x - digit) / 10;
                result = result * 10 + digit;
                if ((x > 0 && result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && x < 10 && x > 7)) {
                    return 0;
                }
            }
        } else {
            result = -0;
            while (x != 0) {
                int digit = x % 10;
                x = (x - digit) / 10;
                result = result * 10 + digit;
                if ((x < 0 && result < Integer.MIN_VALUE / 10) || (result == Integer.MIN_VALUE / 10 && x > -10 && x < -8)) {
                    return 0;
                }
            }
        }
        return result;
    }

    public static int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            int newResult = result * 10 + digit;
            if ((newResult - digit) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
        System.out.println(Integer.MAX_VALUE - 96);
    }
}
