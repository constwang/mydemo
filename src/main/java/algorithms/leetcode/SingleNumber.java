package algorithms.leetcode;

import java.util.HashSet;

/**
 * Created by wa on 2017/4/21.
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.remove(i)) set.add(i);
        }
        return set.iterator().next();
    }

    public static int singleNumber2(int[] nums) {
        // A ^ A = 0 and A ^ B ^ A = B.
        int result = 0;
        for (int i : nums) result ^= i;
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        System.out.println(singleNumber(nums));
    }

}
