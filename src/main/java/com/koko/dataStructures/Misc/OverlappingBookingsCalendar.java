package com.koko.dataStructures.Misc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OverlappingBookingsCalendar {

    // Q:
    /*
    A k-booking happens when k events have some non-empty intersection
    (i.e., there is some time that is common to all k events.)

You are given some events [start, end), after each given event, return an integer k
representing the maximum k-booking between all the previous events.

Implement the MyCalendarThree class:

MyCalendarThree() Initializes the object.
int book(int start, int end) Returns an integer k representing the largest integer
such that there exists a k-booking in the calendar.
     */




    // Example:
    /*
    Input
["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
Output
[null, 1, 1, 2, 3, 3, 3]

Explanation
MyCalendarThree myCalendarThree = new MyCalendarThree();
myCalendarThree.book(10, 20); // return 1, The first event can be booked and is disjoint, so the maximum k-booking is a 1-booking.
myCalendarThree.book(50, 60); // return 1, The second event can be booked and is disjoint, so the maximum k-booking is a 1-booking.
myCalendarThree.book(10, 40); // return 2, The third event [10, 40) intersects the first event, and the maximum k-booking is a 2-booking.
myCalendarThree.book(5, 15); // return 3, The remaining events cause the maximum K-booking to be only a 3-booking.
myCalendarThree.book(5, 10); // return 3
myCalendarThree.book(25, 55); // return 3

     */






    // Solution1:
    // Sweep line Algo
    // https://leetcode.com/problems/my-calendar-iii/solution/

    // TC: O(N^2)
    // SC: O(N)

    private Map<Integer, Integer> diff;

    public OverlappingBookingsCalendar() {
        diff = new TreeMap<>();
    }

    public int book(int start, int end) {
        diff.put(start, diff.getOrDefault(start, 0) + 1);
        diff.put(end, diff.getOrDefault(end, 0) - 1);
        int res = 0, cur = 0;
        for (int delta : diff.values()) {
            cur += delta;
            res = Math.max(res, cur);
        }
        return res;
    }





    // Sol2:
    // Segment tree with Lazy update

    // TC: O(NlogC) ; C is the largest time.
    // SC: O(NlogC)

    /*
    private Map<Integer, Integer> vals;
    private Map<Integer, Integer> lazy;

    public OverlappingBookingsCalendar() {
        vals = new HashMap<>();
        lazy = new HashMap<>();
    }

    public void update(int start, int end, int left, int right, int idx) {
        if (start > right || end < left)
            return;
        if (start <= left && right <= end) {
            vals.put(idx, vals.getOrDefault(idx, 0) + 1);
            lazy.put(idx, lazy.getOrDefault(idx, 0) + 1);
        } else {
            int mid = (left + right) / 2;
            update(start, end, left, mid, idx * 2);
            update(start, end, mid + 1, right, idx * 2 + 1);
            vals.put(idx, lazy.getOrDefault(idx, 0)
                    + Math.max(vals.getOrDefault(idx * 2, 0), vals.getOrDefault(idx * 2 + 1, 0)));
        }
    }

    public int book(int start, int end) {
        update(start, end - 1, 0, 1000000000, 1);
        return vals.getOrDefault(1, 0);
    }


     */





    // Sol3:
    // Balanced tree


    /*
    class MyCalendarThree {
    private TreeMap<Integer, Integer> starts;
    private int res;

    public MyCalendarThree() {
        starts = new TreeMap<>();
        starts.put(0, 0);
        res = 0;
    }

    public void split(int x) {
        Integer prev = starts.floorKey(x);
        Integer next = starts.ceilingKey(x);
        if (next != null && next == x)
            return;
        starts.put(x, starts.get(prev));
    }

    public int book(int start, int end) {
        split(start);
        split(end);
        for (var interval : starts.subMap(start, true, end, false).entrySet()) {
            res = Math.max(res, interval.setValue(interval.getValue() + 1) + 1);
        }
        return res;
    }
}
     */
}
