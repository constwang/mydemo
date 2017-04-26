package algorithms.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by wa on 2017/4/21.
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        int max = 1;
        for (int num : nums) {
            if (set.remove(num)) {
                int val = num;
                int sum = 1;
                while (set.remove(val - 1)) val--;
                sum += (num - val);

                val = num;
                while (set.remove(val + 1)) val++;
                sum += (val - num);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
