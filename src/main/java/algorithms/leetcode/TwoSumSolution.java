package algorithms.leetcode;

import java.util.HashMap;

/**
 * Created by wa on 2017/3/8.
 */
public class TwoSumSolution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            Integer mapValue = map.get(nums[i]);
            if (mapValue != null) {
                return new int[]{mapValue, i};
            } else {
                map.put(left, i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int[] result = twoSum(nums, 6);
        System.out.println(result[0] + "," + result[1]);
    }
}
