package com.koko.dataStructures.Misc;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    // Q: Given an array of intervals intervals where intervals[i] = [starti, endi],
    // return the minimum number of intervals you need to remove to
    // make the rest of the intervals non-overlapping.


    // Example:
    /*
    Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
     */


    // Solution:
    // Order intervals by start point.
    //Record the end of the last valid interval.
    //For each interval, if is start point is >= the end of the last valid interval,
    // increment the count of valid intervals, and move the end point to the end of the current interval.
    // Otherwise just set the new end point to the minimum between the two overlapping intervals.
    // Return the difference between the number of intervals in the input array and the number of valid intervals
    // you found in the previous way.

    static class Interval{
        int start;
        int end;
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start-i2.start;
            }
        });
        int count=1;
        int lastEnd = intervals[0].end;
        for(int i=1;i<intervals.length;i++) {
            Interval currentInterval = intervals[i];
            if(currentInterval.start>=lastEnd) {
                count++;
                lastEnd=currentInterval.end;
            } else {
                lastEnd=Math.min(currentInterval.end,lastEnd);
            }
        }
        return intervals.length-count;
    }
}
