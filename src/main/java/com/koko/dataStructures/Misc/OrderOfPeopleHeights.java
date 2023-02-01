package com.koko.dataStructures.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OrderOfPeopleHeights {

    // Queue Reconstruction By Height


    // Q: You are given an array of people,
    // people, which are the attributes of some people in a queue (not necessarily in order).
    // Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front
    // who have a height greater than or equal to hi.

    // Example:
    /*
    Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
Explanation:
Person 0 has height 5 with no other people taller or the same height in front.
Person 1 has height 7 with no other people taller or the same height in front.
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.


Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
     */


    // Solution:
    // We just need to sort our array in descending order by height and in ascending order by k for people
    // that share the same height.
    // Then, we quite literally just insert into an array based on the k value as the index.
    // We'll use a linked list initially for insertion before converting to a 2D array.

    // 1. sort on the basis of height decresing order, if height same then take the onw which is smaller
    //people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    //sort: [7,0],[7,1],[6,1],[5,0],[5,2],[4,4]
    //
    //2. now just add people at the index where they want to as we are picking the max height first.


    // Time Complexity: O(nlogn + n^2) = O(n^2):
    // We sort the array in O(nlogn) time and list insertion will take O(n^2) for n insertions at worst.
    // Space Complexity: O(n)

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> ordered = new LinkedList<>();
        for (int[] p: people) ordered.add(p[1], p);

        return ordered.toArray(new int[people.length][2]);
    }

}
