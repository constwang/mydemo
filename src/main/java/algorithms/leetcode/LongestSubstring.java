package algorithms.leetcode;

import java.util.HashMap;

/**
 * Created by wangk on 2017/3/10.
 */
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int repeatedIndex = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.get(s.charAt(i));
            if (index != null) {
                repeatedIndex=Math.max(repeatedIndex,index+1);
            }
            map.put(s.charAt(i), i);
            maxLength=Math.max(maxLength,i-repeatedIndex+1);
        }
        return maxLength;
    }

    public static int correctAnswer(String s){
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
