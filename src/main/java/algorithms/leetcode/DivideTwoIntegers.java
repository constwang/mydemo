package algorithms.leetcode;

/**
 * Created by wa on 2017/3/28.
 */
public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long result = 0;
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        while (lDividend >= lDivisor) {
            long temp = lDivisor, multiple = 1;
            while (lDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            result += multiple;
            lDividend -= temp;
        }
        result *= sign;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(divide(Integer.MIN_VALUE, -1));
    }
}
