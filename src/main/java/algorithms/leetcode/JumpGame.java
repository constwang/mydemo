package algorithms.leetcode;

/**
 * Created by wa on 2017/4/10.
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = last - 1; i >= 0; i--) {
            if (i + nums[i] >= last) last = i;
        }
        return nums[0] >= last;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(canJump(nums));
    }
}
