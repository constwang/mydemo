package algorithms.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wa on 2017/4/9.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] sortCh = str.toCharArray();
            Arrays.sort(sortCh);
            String tmp = String.valueOf(sortCh);
            List<String> value = map.get(tmp);
            if (value == null) {
                value = new LinkedList<>();
            }
            value.add(str);
            map.put(tmp, value);
        }
        return new LinkedList<>(map.values());
    }

    public static void main(String[] args) {
        String[] data = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(data));
    }
}
