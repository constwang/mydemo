package algorithms.leetcode;

import java.util.*;

/**
 * Created by 王康 on 2017/6/18.
 * 注意题目中已经有List中的interval已经排序，考虑将newInteval插入到List中，然后进行合并操作
 */
public class InsertInterval {
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

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size()==0){
            intervals.add(newInterval);
        }
        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval.start<intervals.get(i).start){
                intervals.add(i,newInterval);
                break;
            }
        }
        if (newInterval.start>=intervals.get(intervals.size()-1).start){
            intervals.add(intervals.size(),newInterval);
        }
        System.out.println(intervals);
        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for (Interval interval:intervals){
            Interval tmp=result.get(result.size()-1);
            if (interval.start<=tmp.end){
                tmp.end=Math.max(tmp.end,interval.end);
            }else {
                result.add(interval);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval interval1=new Interval(1,5);
        //Interval interval2=new Interval(6,9);
        List<Interval> intervals=new ArrayList<>();
        intervals.add(interval1);
        //intervals.add(interval2);
        Interval newInterval=new Interval(2,3);
        System.out.println(insert(intervals,newInterval));
    }
}
