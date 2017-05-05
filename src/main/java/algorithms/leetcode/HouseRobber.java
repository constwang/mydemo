package algorithms.leetcode;

/**
 * Created by wa on 2017/5/4.
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) a = Math.max(a + nums[i], b);
            else b = Math.max(a, b + nums[i]);
        }
        return Math.max(a, b);
    }
}
