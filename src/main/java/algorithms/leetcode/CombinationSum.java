package algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangk on 2017/3/25.
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        recurse(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public static void recurse(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int start) {
        int total = getTotal(temp);
        if (total == target) {
            result.add(new ArrayList<>(temp));
        } else if (total < target) {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                recurse(result, temp, candidates, target, i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static int getTotal(List<Integer> temp) {
        int total = 0;
        for (Integer num : temp) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
