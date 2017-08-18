package algorithms.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by 王康 on 2017/8/18.
 */
public class TopNPriorityQueue {

    private static void putToQueue(PriorityQueue<Integer> queue, int value, int topN) {
        if (queue.size() < topN) {
            queue.add(value);
        } else {
            int peek = queue.peek();
            if (value > peek) {
                queue.poll();
                queue.add(value);
            }
        }
    }

    public static int[] findTopNValues(int[] nums,int topN) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < nums.length; i++) {
            putToQueue(queue,nums[i],topN);
        }
        int[] res=new int[topN];
        for (int i = 0; i < res.length; i++) {
            res[i]=queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        int[] res=findTopNValues(nums,3);
        System.out.println(Arrays.toString(res));
    }
}
