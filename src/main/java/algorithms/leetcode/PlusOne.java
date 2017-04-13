package algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by wa on 2017/4/11.
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int toAdd = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + toAdd;
            if (digits[i] >= 10) {
                digits[i] = digits[i] - 10;
            } else {
                toAdd = 0;
                break;
            }
        }
        if (toAdd == 0) return digits;
        else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
    }

    public static int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        int[] digits = {8};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
