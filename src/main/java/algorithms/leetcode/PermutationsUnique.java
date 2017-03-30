package algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangk on 2017/3/24.
 */
public class PermutationsUnique {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> result=new LinkedList<>();
        Arrays.sort(nums);
        recurse(result,new ArrayList<>(),nums,new boolean[nums.length]);
        return result;
    }

    public static void recurse(List<List<Integer>> result,List<Integer> temp,int[] nums,boolean[] isUsed){
        if (temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
        }else {
            for (int i=0;i<nums.length;i++){
                if (isUsed[i]) continue;
                if (i>0&&nums[i-1]==nums[i]&&!isUsed[i-1]) continue;
                isUsed[i]=true;
                temp.add(nums[i]);
                recurse(result,temp,nums,isUsed);
                isUsed[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
    public static void main(String[] args){
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
}
