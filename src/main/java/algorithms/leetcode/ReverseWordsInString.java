package algorithms.leetcode;

/**
 * Created by wa on 2017/4/18.
 */
public class ReverseWordsInString {
    public static String reverseWords(String s) {
        char[] result = s.toCharArray();
        if (result.length == 0) return "";
        reverse(result, 0, result.length - 1);
        int pre = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == ' ') {
                reverse(result, pre, i - 1);
                pre = i + 1;
            }
        }
        reverse(result, pre, result.length - 1);
        return cleanSpaces(result);
    }

    public static void reverse(char[] result, int start, int end) {
        while (start < end) {
            char t = result[start];
            result[start] = result[end];
            result[end] = t;
            start++;
            end--;
        }
    }

    public static String cleanSpaces(char[] result) {
        int i = 0, j = 0;
        while (j < result.length) {
            while (j < result.length && result[j] == ' ') j++;             // skip spaces
            while (j < result.length && result[j] != ' ') result[i++] = result[j++]; // keep non spaces
            while (j < result.length && result[j] == ' ') j++;             // skip spaces
            if (j < result.length) result[i++] = ' ';                      // keep only one space
        }

        return new String(result).substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a "));
    }
}
