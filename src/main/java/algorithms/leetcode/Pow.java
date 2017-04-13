package algorithms.leetcode;

/**
 * Created by wa on 2017/4/10.
 */
public class Pow {
    public static double myPow(double x, int n) {
        return Pow(x, (long) n);
    }

    public static double Pow(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? Pow(x * x, n / 2) : (x * Pow(x * x, n / 2));
    }

    public static void main(String[] args) {
        System.out.println(myPow(34.00515, -3));
        System.out.println(Double.MAX_EXPONENT);
    }
}
