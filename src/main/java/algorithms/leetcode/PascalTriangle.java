package algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wa on 2017/4/19.
 */
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                list.add(1);
            }
            if (i > 0) {
                list.add(1);
                List<Integer> pre = result.get(i - 1);
                for (int j = 1; j < i; j++) {
                    list.add(pre.get(j) + pre.get(j - 1));
                }
                list.add(1);
            }
            result.add(list);
        }
        return result;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }


    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
