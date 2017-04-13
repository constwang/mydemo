package algorithms.sort;

import java.util.Arrays;

/**
 * Created by wa on 2017/4/6.
 */
public class QuickSort {
    public static void quickSort(int[] nums) {
        qsort(nums, 0, nums.length - 1);
    }

    private static void qsort(int[] nums, int low, int high) {
        if (low < high) {
            int p = partition(nums, low, high);
            qsort(nums, low, p - 1);
            qsort(nums, p + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) high--;
            nums[low] = nums[high];     //交换比枢轴小的记录到左边
            while (low < high && nums[low] <= pivot) low++;
            nums[high] = nums[low];     //交换比枢轴大的记录到右边
        }
        nums[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {2, 8, 7, 1, 3, 5, 6, 4};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

