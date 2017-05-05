package algorithms.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by wa on 2017/5/4.
 */
public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : nums) {
            queue.add(i);
            if (queue.size() > k) queue.poll();
        }
        return queue.peek();
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }


}
