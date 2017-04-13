package algorithms.leetcode;

/**
 * Created by wa on 2017/4/3.
 */
public class TrappingRainWater {
    public static int trap(int[] height) {
        int total = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] > maxLeft) maxLeft = height[left];
                else total += (maxLeft - height[left]);
                left++;
            } else {
                if (height[right] > maxRight) maxRight = height[right];
                else total += (maxRight - height[right]);
                right--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 0};
        System.out.println(trap(nums));
    }
}
