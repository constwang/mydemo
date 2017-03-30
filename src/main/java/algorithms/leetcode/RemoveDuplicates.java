package algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by wa on 2017/3/30.
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int result = nums.length;
        int former = nums[0];
        for (int i = 1; i < result; i++) {
            int temp = nums[i];
            if (former == nums[i]) {
                result--;
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = former;
            }
            former = temp;
        }
        int[] temp = new int[result];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i];
        }
        nums = temp;
        return nums.length;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) nums[++j] = nums[i];
        }
        return ++j;
    }

    public static void main(String[] args) {
        int[] params = {1, 1, 1, 2};
        System.out.println(removeDuplicates2(params));
        System.out.println(Arrays.toString(params));
    }
}
