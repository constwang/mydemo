package algorithms.leetcode;

import java.math.BigDecimal;

/**
 * Created by wa on 2017/3/27.
 */
public class StrStr {
    public static int strStr(String haystack, String needle) {
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        if ((chars1.length == 0 && chars2.length == 0) || chars2.length == 0) {
            return 0;
        }
        int index = 0;
        while (index < chars1.length) {
            if (chars1[index] == chars2[0]) {
                int temp = index;
                int index2 = 0;
                while (temp < chars1.length && index2 < chars2.length) {
                    if (chars1[temp] != chars2[index2]) {
                        break;
                    }
                    temp++;
                    index2++;
                }
                if (index2 == chars2.length) {
                    return index;
                }
            }
            index++;
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }
}
