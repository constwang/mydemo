package algorithms.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by wa on 2017/5/2.
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] numString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numString[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(numString, comparator);
        if (numString[0].charAt(0) == '0') return "0";
        String result = "";
        for (String str : numString) {
            result += str;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }
}
