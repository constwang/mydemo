package algorithms.leetcode;

import java.util.HashMap;

/**
 * Created by wangk on 2017/3/24.
 */
public class RomanToInt {

    public static int romanToInt(String s) {
        HashMap<Character, Integer> value = new HashMap<>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);
        int result = value.get(s.charAt(s.length()-1));
        int index = s.length()-2;
        while (index >=0) {
            if (value.get(s.charAt(index)) < value.get(s.charAt(index + 1))) {
                result -= value.get(s.charAt(index));
            } else {
                result += value.get(s.charAt(index));
            }
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCVI"));
    }
}
