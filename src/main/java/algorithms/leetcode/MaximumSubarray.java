package algorithms.leetcode;

/**
 * Created by wa on 2017/4/10.
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int maxUntilNow = nums[0], maxSub = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSub = Math.max(nums[i] + maxSub, nums[i]);
            maxUntilNow = Math.max(maxUntilNow, maxSub);
        }
        return maxUntilNow;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, -4};
        System.out.println(maxSubArray2(nums));
    }
}
