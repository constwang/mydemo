package algorithms.leetcode;

/**
 * Created by wa on 2017/4/25.
 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static int helper(int[] nums, int i, int j) {
        if (i == j) return i;
        else if (i + 1 == j) {
            if (nums[i] > nums[j]) return i;
            return j;
        } else {
            int m = (i + j) / 2;
            if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) return m;
            else if (nums[m] > nums[m - 1] && nums[m] < nums[m + 1]) return helper(nums, m + 1, j);
            else return helper(nums, i, m - 1);
        }
    }

    public static void main(String[] args) {

    }
}
