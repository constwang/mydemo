package algorithms.leetcode;

import java.util.HashMap;

/**
 * Created by wangk on 2017/3/10.
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        String result = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer leftIndex = map.get(s.charAt(i));
            if (leftIndex != null && (i - leftIndex) > result.length()) {
                int middleIndex = (i - leftIndex) / 2 + leftIndex;
                int j;
                for (j = leftIndex; j < middleIndex; j++) {
                    if (s.charAt(j) != s.charAt(i - j)) {
                        break;
                    }
                }
                if (j == middleIndex) {
                    result = s.substring(leftIndex, i + 1);
                }
            } else if (leftIndex == null) {
                map.put(s.charAt(i), i);
            }
        }
        return result;
    }

    public static String longestPalindrome2(String s) {
        String result = "";
        if (s.length()<2){
            return s;
        }
        for (int i=0;i<s.length();i++){

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbcccccd"));
    }
}
