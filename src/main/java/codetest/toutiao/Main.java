package codetest.toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangk on 2017/3/30.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int total=in.nextInt();
        int[] nums=new int[total];
        for (int i=0;i<total;i++){
            nums[i]=in.nextInt();
        }
        List<Integer> data=new ArrayList<>();
        for (int i=1;i<total-1;i++){
            if (nums[i]<nums[i-1]&&nums[i]<nums[i+1]){
                data.add(i);
            }
            if (nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                data.add(i);
            }
        }
        int start=0;
        int end=data.size()-1;
        while (start<end){
            if (nums[data.get(start+1)]<nums[data.get(start)]){
                start++;
            }if (nums[data.get(end-1)]<nums[data.get(end)]){
                end--;
            }
        }

    }
}


