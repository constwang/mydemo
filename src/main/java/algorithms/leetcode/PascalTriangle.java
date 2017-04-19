package algorithms.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wa on 2017/4/19.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new LinkedList<>();
            if (i == 1) {
                list.add(1);
                result.add(list);
            }
            if (i == 2) {
                list.add(1);
                list.add(1);
                result.add(list);
            }
        }
        return result;
    }
}
