package algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by wa on 2017/4/13.
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        int redNum = 0, whiteNum = 0, blueNum = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    redNum++;
                    break;
                case 1:
                    whiteNum++;
                    break;
                case 2:
                    blueNum++;
                    break;
            }
        }
        for (int i = 0; i < redNum; i++) nums[i] = 0;
        for (int i = redNum; i < redNum + whiteNum; i++) nums[i] = 1;
        for (int i = redNum + whiteNum; i < redNum + whiteNum + blueNum; i++) nums[i] = 2;
    }

    public static void sortColors2(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for (int i = 0; i <= two; i++) {
            if (nums[i] == 0) swap(nums, i, zero++);
            if (nums[i] == 2) swap(nums, i--, two--);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
