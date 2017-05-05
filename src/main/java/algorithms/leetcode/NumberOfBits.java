package algorithms.leetcode;

/**
 * Created by wa on 2017/5/3.
 */
public class NumberOfBits {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        String bits = Integer.toBinaryString(n);
        int num = 0;
        for (char c : bits.toCharArray()) {
            if (c == '1') num++;
        }
        return num;
    }

    public static int hammingWeight2(int n) {
        int ones = 0;
        while (n != 0) {
            ones += (n & 1);
            n = n >>> 1;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight2(-1));
    }
}
