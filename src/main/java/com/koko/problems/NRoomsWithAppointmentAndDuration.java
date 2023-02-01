package com.koko.problems;

import java.util.*;


public class NRoomsWithAppointmentAndDuration {

    /*
There are K check up room in sequence (indexed 0 - K-1)in a long corridor and you are given the entry time of different patients and duration of check up in order.
The check up room is assigned on the basis of closest check up room available to incoming patient.
Once check up is finished it can be assigned again.
Find the check up rooms which catered to maximum number of patients.

Inputs:
numRooms: 3 = K
Appointment times: [1, 3, 5, 8, 19] => patients arrival time
Appointment durations: [20, 3, 2, 9, 1] => time spent by a patient in a given room
*/

    public static int maxAllotedRoom = 0;

    public static void main(String[] args) {
        int[] appointmentTimes = {1, 3, 5, 8, 19}; // assuming it is already sorted
        int[] durations = {20, 3, 2, 9, 1};
        int rooms = 3;
        // room no 1 for oth index
        // room no 2 for 1th index
        // room no 3 for 2nd index
        //room no 2 for 3rd index
        // room no 2 for 4th index
        int expectedRoomNo = 2;
        int expectedFrequency = 3;
        int freq = getMaxFrequency(appointmentTimes, durations, rooms);
        System.out.println(freq);
        System.out.println("max no of times alloted room is room no " + maxAllotedRoom + " with frequency " + freq);
    }

    public static int getMaxFrequency(int[] appointmentTimes, int[] durations, int totalRooms) {// two min heap solution order NLOgK
        // two min heap solution order NLOgK
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> roomEndTimePQ = new PriorityQueue<>(Comparator.comparingInt(AbstractMap.SimpleEntry::getValue));
        PriorityQueue<Integer> availableRoomsPQ = new PriorityQueue<>();
        for (int i = 1; i <= totalRooms; i++)
            availableRoomsPQ.add(i);// O(Klogk) to build heap (k is total no of room)
        for (int i = 0; i < appointmentTimes.length; i++) { //O(N)
            while (roomEndTimePQ.size() > 0 && roomEndTimePQ.peek().getValue() < appointmentTimes[i]) {
                availableRoomsPQ.add(roomEndTimePQ.poll().getKey());
            } // this while loop runs Atmost N times during whole iteration so ignore this
            int startTime = appointmentTimes[i];
            if (availableRoomsPQ.size() == 0) { // special case , all room allotted and no one is free
                availableRoomsPQ.add(roomEndTimePQ.peek().getKey()); // deallocation in future
                startTime = roomEndTimePQ.poll().getValue(); // allocation in future
            }
            int roomNo = availableRoomsPQ.poll();
            int freq = frequencyMap.getOrDefault(roomNo, 0);
            frequencyMap.put(roomNo, freq + 1);
            if (frequencyMap.get(roomNo) > max)
                maxAllotedRoom = roomNo;
            max = Math.max(max, frequencyMap.get(roomNo)); // O(1)
            int endTime = startTime + durations[i];
            roomEndTimePQ.add(new AbstractMap.SimpleEntry<>(roomNo, endTime));// O(log k) to heapify (max no of entry in heaps will be k i.e total rooms)
        }
        return max;
    }

}
