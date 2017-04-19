package algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by wa on 2017/4/18.
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) return;
        int index = m - 1;
        for (int k = m + n - 1; k >= n; k--) {
            nums1[k] = nums1[index--];
        }

        int start1 = n, start2 = 0;
        index = 0;
        while (start1 < m + n || start2 < n) {
            if (nums1[start1] < nums2[start2]) {
                nums1[index++] = nums1[start1];
                if (start1 < m + n - 1) start1++;
            } else {
                nums1[index++] = nums2[start2];
                if (start2 < n - 1) start2++;
            }
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        while (j >= 0) nums1[k--] = nums2[j--];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 0};
        int[] nums2 = {3};
        merge2(nums1, 2, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
