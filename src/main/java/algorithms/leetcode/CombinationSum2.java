package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangk on 2017/3/25.
 */
public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        recurse(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public static void recurse(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(temp));
        } else if (remain > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (i>start&&candidates[i]==candidates[i-1]) continue;
                temp.add(candidates[i]);
                recurse(result, temp, candidates, remain - candidates[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
