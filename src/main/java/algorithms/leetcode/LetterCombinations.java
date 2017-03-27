package algorithms.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wa on 2017/3/27.
 */
public class LetterCombinations {
    static final String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.length() == 0) {
            return result;
        }
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            LinkedList<String> temp = new LinkedList<>();
            for (String s : result) {
                for (int j = 0; j < map[digit].length(); j++) {
                    temp.add(s + map[digit].charAt(j));
                }
            }
            result = temp;
        }
        return result;
    }

    public static List<String> letterCombinations2(String digits) {
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String s = result.remove();
                for (char c : map[digit].toCharArray()) {
                    result.add(s + c);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations2("23"));

    }
}
