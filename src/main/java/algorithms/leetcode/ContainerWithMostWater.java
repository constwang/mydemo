package algorithms.leetcode;

/**
 * Created by wa on 2017/4/17.
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int max = 0;
        int start = 0, end = height.length - 1;
        while (start < end) {
            int h = Math.min(height[start], height[end]);
            max = Math.max(max, (end - start) * h);
            while (start < end && height[start] <= h) start++;
            while (start < end && height[end] <= h) end--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 1};
        System.out.println(maxArea(height));
    }

}
