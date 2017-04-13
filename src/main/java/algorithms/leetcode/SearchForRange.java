package algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by wa on 2017/3/31.
 */
public class SearchForRange {
    public static int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (start != -1 && end != -1) break;
            if (nums[i] != target) i++;
            else start = i;
            if (nums[j] != target) j--;
            else end = j;
        }
        return new int[]{start, end};
    }

    public static int[] searchRange2(int[] nums, int target) {
        int start = -1, end = -1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (start != -1 && end != -1) break;
            int mid = (i + j) / 2;
            if (target < nums[mid]) j = mid;
            if (target > nums[mid]) i = mid;
            if (nums[i] != target) i++;
            else start = i;
            if (nums[j] != target) j--;
            else end = j;
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int[] nums = {};
        int[] result = searchRange2(nums, 8);
        System.out.println(Arrays.toString(result));
    }
}
