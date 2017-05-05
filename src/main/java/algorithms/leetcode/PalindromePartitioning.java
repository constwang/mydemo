package algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wa on 2017/4/21.
 */
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        recurse(result, new ArrayList<>(), s, 0);
        return result;
    }

    public static void recurse(List<List<String>> result, List<String> temp, String s, int start) {
        if (start == s.length()) result.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    temp.add(s.substring(start, i + 1));
                    recurse(result, temp, s, i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
