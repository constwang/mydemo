package algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by wa on 2017/4/2.
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        // wrong answer
        int positiveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) positiveIndex++;
            if (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) swap(nums, nums[i] - 1, i);
        }
        for (int i = positiveIndex; i < nums.length; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return nums.length + 1;
    }

    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static int firstMissingPositive2(int[] nums) {
        //int positiveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) swap(nums, nums[i] - 1, i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 0, 3};
        System.out.println(firstMissingPositive2(nums));
    }
}
