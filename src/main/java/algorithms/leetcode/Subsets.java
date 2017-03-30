package algorithms.leetcode;

import java.util.*;

/**
 * Created by wangk on 2017/3/24.
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        //Arrays.sort(nums);
        List<List<Integer>> result=new LinkedList<>();
        recurse(result,new ArrayList<>(),nums,0);
        return result;
    }
    public static void recurse(List<List<Integer>> result,List<Integer> temp,int[] nums,int start){
        result.add(new ArrayList<>(temp));
        for (int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            recurse(result,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args){
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
