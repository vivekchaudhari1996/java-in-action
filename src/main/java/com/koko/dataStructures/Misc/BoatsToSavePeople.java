package com.koko.dataStructures.Misc;

import java.util.Arrays;

public class BoatsToSavePeople {

    //Q:
    // You are given an array people where people[i] is the weight of the ith person,
    // and an infinite number of boats where each boat can carry a maximum weight of limit.
    // Each boat carries at most two people at the same time,
    // provided the sum of the weight of those people is at most limit.
    //
    //Return the minimum number of boats to carry every given person.



    // Example:
    /*
    Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)


Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
     */



    //Solution:
    // If the heaviest person can share a boat with the lightest person,
    // then do so. Otherwise, the heaviest person can't pair with anyone, so they get their own boat.
    //
    //The reason this works is because if the lightest person can pair with anyone,
    // they might as well pair with the heaviest person.


    // TC: O(NlogN)
    // SC: O(logN)

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return ans;
    }

}
