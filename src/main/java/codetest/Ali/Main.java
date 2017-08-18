package codetest.Ali;


import java.util.*;

/**
 * Created by 王康 on 2017/8/13.
 */
public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static int maxScore(List<Integer> score) {
        if (score.size() == 0) return 0;
        int[] nums = new int[score.size() + 2];
        int n = 1;
        for (int x : score) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        int[][] memo = new int[n][n];
        return recurse(memo, nums, 0, n - 1);
    }

    static int recurse(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + recurse(memo, nums, left, i) + recurse(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res = 0;

        int _score_size = 0;
        _score_size = Integer.parseInt(in.nextLine().trim());
        List<List<Integer>> scores = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        int _score_item;
        for (int _score_i = 0; _score_i < _score_size; _score_i++) {
            _score_item = Integer.parseInt(in.nextLine().trim());
            if (_score_item == 0) {
                scores.add(new LinkedList<>(tmp));
                tmp = new LinkedList<>();
                continue;
            }
            tmp.add(_score_item);
        }
        scores.add(new LinkedList<>(tmp));
        for (List<Integer> _score : scores) {
            res += maxScore(_score);
        }
        System.out.println(String.valueOf(res));

    }
}
