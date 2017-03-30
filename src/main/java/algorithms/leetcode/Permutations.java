package algorithms.leetcode;

import java.util.*;

/**
 * Created by wangk on 2017/3/24.
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        recurse(result,new LinkedList<>(),nums);
        return  result;
    }

    public static void recurse(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
        }else {
            for (int i=0;i<nums.length;i++){
                if (temp.contains(nums[i])){
                    continue;
                }
                temp.add(nums[i]);
                recurse(result,temp,nums);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(permute(new int[]{1,2,3}).toString());;
    }
}
