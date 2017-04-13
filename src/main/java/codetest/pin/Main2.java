package codetest.pin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wa on 2017/4/12.
 */
public class Main2 {
    public static class Interval {
        double start;
        double end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static double mergeLine(List<Interval> intervals) {
        Collections.sort(intervals, (obj0, obj1) -> (int) (obj0.start - obj1.start));
        List<Interval> ret = new ArrayList<>();
        Interval prev = null;
        for (Interval inter : intervals) {
            if (prev == null || inter.start > prev.end) {
                ret.add(inter);
                prev = inter;
            } else if (inter.end > prev.end) {
                prev.end = inter.end;
            }
        }
        double result = 0;
        for (Interval interval : ret) {
            result += (interval.end - interval.start);
        }
        return result;
    }
}
