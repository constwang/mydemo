package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangk on 2017/3/24.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] + nums[i] == 0) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < -nums[i]) left++;
                    else right--;
                }
            }
        }
        return result;
    }

}
