package codetest.netease;

import java.util.Scanner;

/**
 * Created by wangk on 2017/3/25.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] fistline = in.nextLine().split(" ");
        int n = Integer.parseInt(fistline[0]);
        int k = Integer.parseInt(fistline[1]);
        int[] nums = new int[n];
        String[] line2 = in.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }
        reverse(nums,k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void reverse(int[] nums, int k) {
        if (k > 0) {
            int temp = nums[0];
            for (int i = 0; i < nums.length - 1; i++) {
                nums[i] += nums[i + 1];
                if (nums[i] >= 100) {
                    nums[i] = nums[i] % 100;
                }
            }
            nums[nums.length - 1] += temp;
            if (nums[nums.length - 1] >= 100) {
                nums[nums.length - 1] = nums[nums.length - 1] % 100;
            }
            k-=1;
            reverse(nums, k);
        }
    }
}
