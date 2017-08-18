package codetest.netease.test0812;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 王康 on 2017/8/12.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int n = input.nextInt();
            int[] nums = new int[n];
            //String[] numString = input.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i]=input.nextInt();
                //nums[i] = Integer.parseInt(numString[i]);
            }
            if (n % 2 == 0) {
                for (int i = n - 1; i >= 1; i -= 2) {
                    System.out.print(nums[i] + " ");
                }
                for (int i = 0; i < n - 1; i += 2) {
                    System.out.print(nums[i]);
                    if (i != n - 2) {
                        System.out.print(" ");
                    }
                }
            } else {
                for (int i = n - 1; i >= 0; i -= 2) {
                    System.out.print(nums[i]+" ");
                }
                for (int i = 1; i < n - 1; i += 2) {
                    System.out.print(nums[i]);
                    if (i != n - 2) {
                        System.out.print(" ");
                    }
                }
            }
        }

    }

    public static void swap(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
