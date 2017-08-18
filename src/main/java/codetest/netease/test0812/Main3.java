package codetest.netease.test0812;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 王康 on 2017/8/12.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=input.nextInt();
        }
        Arrays.sort(nums);
        int sum=0;
        for (int i = n/2; i < n; i++) {
            sum+=nums[i];
        }
        sum+=nums[n-1];
        int sum2=0;
        for (int i=0;i<n/2;i++){
            sum2+=nums[i];
        }
        System.out.println(sum-sum2);
    }
}
