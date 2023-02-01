package com.koko.dataStructures.array;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling {

    // ###BucketSort



    // Q:
    /*
    There is a car with capacity empty seats.
    The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi]
indicates that the ith trip has numPassengersi passengers and the locations
to pick them up and drop them off are fromi and toi respectively.
The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and
drop off all passengers for all the given trips, or false otherwise.
     */




    // Example:
    /*
    Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false


Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
     */





    // Solution1:
    // Approach 1: Time Stamp



    // A simple idea is to go through from the start to end,
    // and check if the actual capacity exceeds capacity.
    //
    //To know the actual capacity, we just need the number of passengers changed at each timestamp.
    //
    //We can save the number of passengers changed at each time,
    // sort it by timestamp, and finally iterate it to check the actual capacity.


    // TC: O(NlogN)
    // SC: O(N)

    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> timestamp = new TreeMap<>();
        for (int[] trip : trips) {
            int startPassenger = timestamp.getOrDefault(trip[1], 0) + trip[0];
            timestamp.put(trip[1], startPassenger);

            int endPassenger = timestamp.getOrDefault(trip[2], 0) - trip[0];
            timestamp.put(trip[2], endPassenger);
        }
        int usedCapacity = 0;
        for (int passengerChange : timestamp.values()) {
            usedCapacity += passengerChange;
            if (usedCapacity > capacity) {
                return false;
            }
        }
        return true;
    }




    // Sol2:
    // Bucket Sort


    // Note that in the problem there is a interesting constraint:
    // 0 <= trips[i][1] < trips[i][2] <= 1000
    // What pops into the mind is Bucket Sort, which is a sorting algorithm in O(N) time
    // but requires some prior knowledge for the range of the data.

    // What we do is initial 1001 buckets,
    // and put the number of passengers changed in corresponding buckets,
    // and collect the buckets one by one.


    // TC: O(max(N, 1001))
    // SC: O(1001) ~ O(1)

    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] timestamp = new int[1001];
            for (int[] trip : trips) {
                timestamp[trip[1]] += trip[0];
                timestamp[trip[2]] -= trip[0];
            }
            int usedCapacity = 0;
            for (int number : timestamp) {
                usedCapacity += number;
                if (usedCapacity > capacity) {
                    return false;
                }
            }
            return true;
        }
    }
}
