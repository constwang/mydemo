package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangk on 2017/3/25.
 */
public class SubsetsWithDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new LinkedList<>();
        recurse(result,new ArrayList<>(),nums,0);
        return result;
    }

    public static void recurse(List<List<Integer>> result,List<Integer> temp,int[] nums,int start){
        result.add(new ArrayList<>(temp));
        for (int i=start;i<nums.length;i++){
            if (i>start&&nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            recurse(result,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args){
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
}
