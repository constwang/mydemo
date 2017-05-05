package algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by wa on 2017/5/2.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] num) {
        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
    }

}
