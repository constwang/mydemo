package algorithms.sort;

import java.util.Arrays;

/**
 * Created by wa on 2017/4/6.
 */
public class QuickSort1 {
    public static void quickSort(int[] nums) {
        qsort(nums, 0, nums.length - 1);
    }

    private static void qsort(int[] nums, int p, int r) {
        //0或1个元素，返回
        if (p >= r) return;
        //选择左端点为pivot
        int x = nums[p];
        int j = p;
        for (int i = p + 1; i <= r; i++) {
            // 小于pivot的放到左边
            if (nums[i] < x) swap(nums, ++j, i);
        }
        // 交换左端点和pivot位置
        swap(nums, p, j);
        // 递归子序列
        qsort(nums, p, j - 1);
        qsort(nums, j + 1, r);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 8, 7, 1, 3, 5, 6, 4};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
