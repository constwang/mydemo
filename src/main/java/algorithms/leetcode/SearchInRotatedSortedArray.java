package algorithms.leetcode;

/**
 * Created by wa on 2017/3/30.
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        int rot = lo;
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int realMid = (mid + rot) % nums.length;
            if (nums[realMid] == target) return realMid;
            if (nums[realMid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 6, 7, 0, 1};
        System.out.println(search(nums, 1));
    }
}
