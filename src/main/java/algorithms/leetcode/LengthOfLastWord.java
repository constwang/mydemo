package algorithms.leetcode;

/**
 * Created by 王康 on 2017/6/18.
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int length = 0, index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0) {
            if (s.charAt(index) == ' ') break;
            length++;
            index--;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));
    }
}
