package algorithms.leetcode;

/**
 * Created by wa on 2017/5/2.
 */
public class ReverseBits {
    public static int reverseBits(int n) {
        //return Integer.reverseBytes(n);
        char[] num = Integer.toBinaryString(n).toCharArray();
        long result = 0;
        int gap = 32 - num.length;
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] == '1') {
                result += Math.pow(2, i + gap);
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
