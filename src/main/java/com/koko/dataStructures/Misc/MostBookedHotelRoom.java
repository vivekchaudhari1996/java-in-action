package com.koko.dataStructures.Misc;

import java.util.HashMap;
import java.util.Map;

public class MostBookedHotelRoom {

    // Q:
    // Given a hotel which has 10 floors [0-9] and each floor has 26 rooms [A-Z].
    // You are given a sequence of rooms, where + suggests room is booked, - room is freed.
    // You have to find which room is booked maximum number of times.
    //
    //You may assume that the list describe a correct sequence of bookings in chronological order;
    // that is, only free rooms can be booked and only booked rooms can be freeed.
    // All rooms are initially free. Note that this does not mean that all rooms have to be free
    // at the end. In case,
    // 2 rooms have been booked the same number of times, return the lexographically smaller room.



    // Example:
    /*
    Input: ["+1A", "+3E", "-1A", "+4F", "+1A", "-3E"]
Output: "1A"
Explanation: 1A as it has been booked 2 times.
     */



    // Solution1:


    // Using hashmap
    // TC: O(N), SC: O(N)

    static String solution2(String[] rooms) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        for (int i = 0; i < rooms.length; ++i) {
            if (rooms[i].charAt(0) == '+') {
                m.put(rooms[i].substring(1,3), m.getOrDefault(rooms[i].substring(1,3), 0)+1);
            }
        }
        int max = 0;
        String key = "";
        for (String next : m.keySet()) {
            if (max<m.get(next)) {
                key = next;
                max = m.get(next);
            }
        }
        return key;
    }

    public static void main(String[] args) {
        String[] rooms = {"+1A", "+3E", "-1A", "+4F", "+1A", "-3E"};
        System.out.print(solution2(rooms));
    }




    // Sol2:
    // using array
    // SC: O(1)

    public static String solution(String[] floors)
    {
        int[] map = new int[260];
        int max = 0;
        String currentMax = floors[0];

        for (int i = 0; i < floors.length; i++)
        {
            String currentRoom = floors[i];
            if (currentRoom.charAt(0) == '-') continue;
            int idx = (1 + currentRoom.charAt(1) - '0') * (1 + currentRoom.charAt(2) - 'A') - 1;
            map[idx]++;
            if (map[idx] > max)
            {
                max = map[idx];
                currentMax = currentRoom;
            }
            else if (map[idx] == max)
            {
                currentMax = currentMax.compareTo(currentRoom) < 0 ? currentMax : currentRoom;
            }
        }

        return currentMax.substring(1);
    }





}
