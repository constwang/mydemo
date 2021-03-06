package algorithms.sort;

import java.util.Arrays;

/**
 * Created by wa on 2017/4/25.
 * http://flyingcat2013.blog.51cto.com/7061638/1281026
 */
public class MergeSort {
    //归并排序
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        internalMergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void internalMergeSort(int[] a, int[] b, int left, int right) {
        //当left==right的时，已经不需要再划分了
        if (left < right) {
            int middle = (left + right) / 2;
            internalMergeSort(a, b, left, middle);          //左子数组
            internalMergeSort(a, b, middle + 1, right);       //右子数组
            mergeSortedArray(a, b, left, middle, right);    //合并两个子数组
        }
    }

    // 合并两个有序子序列 arr[left, ..., middle] 和 arr[middle+1, ..., right]。temp是辅助数组。
    private static void mergeSortedArray(int arr[], int temp[], int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        //把数据复制回原数组
        for (i = 0; i < k; ++i) {
            arr[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 7, 5, 2, 9};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
