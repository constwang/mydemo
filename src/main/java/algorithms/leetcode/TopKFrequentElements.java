package algorithms.leetcode;

import java.util.*;

/**
 * Created by wa on 2017/5/4.
 */
public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i : nums) {
            Integer val = map.get(i);
            if (val == null) map.put(i, 1);
            else map.put(i, val + 1);
        }
        for (Integer i : map.keySet()) {
            int times = map.get(i);
            if (bucket[times] == null) bucket[times] = new ArrayList<>();
            bucket[times].add(i);
        }
        List<Integer> res = new ArrayList<>(k);
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) res.addAll(bucket[i]);
        }
        return res;
    }

    //use max heap
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(1, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        queue.addAll(map.entrySet());
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            res.add(queue.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {4, 3, 6};
        System.out.println(topKFrequent2(num, 1));
    }
}
