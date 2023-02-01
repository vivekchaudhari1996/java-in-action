package com.koko.dataStructures.Misc;

import java.util.TreeMap;

public class OverlappingBookingsCalendar3 {

    //Q:
    /*
    You are implementing a program to use as your calendar.
    We can add a new event if adding the event will not cause a triple booking.

A triple booking happens when three events have some non-empty intersection
(i.e., some moment is common to all the three events.).

The event can be represented as a pair of integers start and end that represents a
booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendarTwo class:

MyCalendarTwo() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar
successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
     */






    // Solution:
    // Using boundary count
    // https://leetcode.com/problems/my-calendar-ii/

    // TC: O(N^2)
    // SC: O(N)

    TreeMap<Integer, Integer> delta;

    public OverlappingBookingsCalendar3() {
        delta = new TreeMap();
    }

    public boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d: delta.values()) {
            active += d;
            if (active >= 3) {
                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);
                if (delta.get(start) == 0)
                    delta.remove(start);
                return false;
            }
        }
        return true;
    }
}
