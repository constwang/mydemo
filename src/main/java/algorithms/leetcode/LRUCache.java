package algorithms.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wa on 2017/4/5.
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;


    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer value = cache.get(key);
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {

    }
}
