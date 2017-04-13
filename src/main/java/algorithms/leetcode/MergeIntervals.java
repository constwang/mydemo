package algorithms.leetcode;

import java.util.*;

/**
 * Created by wa on 2017/4/10.
 */
public class MergeIntervals {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);
        List<Interval> result = new LinkedList<>();
        if (intervals.size() == 0) return result;
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= pre.end)
                pre.end = Math.max(intervals.get(i).end, pre.end);
            else {
                result.add(pre);
                pre = intervals.get(i);
            }
        }
        result.add(pre);
        return result;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);
        List<Interval> intervals = new LinkedList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        System.out.println(merge(intervals));
    }
}
