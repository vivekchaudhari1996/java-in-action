package com.koko.dataStructures.array;

import java.util.*;

public class MaximumPerformanceOfTeam {

    // ###PriorityQueue
    // ###Greedy



    // Q:
    /*
    You are given two integers n and k and two integer arrays speed and efficiency
    both of length n. There are n engineers numbered from 1 to n.
    speed[i] and efficiency[i] represent the speed and efficiency of the ith engineer respectively.

Choose at most k different engineers out of the n engineers to form a team with the maximum performance.

The performance of a team is the sum of their engineers' speeds multiplied
by the minimum efficiency among their engineers.

Return the maximum performance of this team.
Since the answer can be a huge number, return it modulo 109 + 7.
     */



    // Example:
    /*
    Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
Output: 60
Explanation:
We have the maximum performance of the team by selecting engineer 2
(with speed=10 and efficiency=4) and engineer 5 (with speed=5 and efficiency=7).
That is, performance = (10 + 5) * min(4, 7) = 60.



Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
Output: 68
Explanation:
This is the same example as the first but k = 3.
We can select engineer 1, engineer 2 and engineer 5 to get the maximum performance of the team.
That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
     */




    // Solution:
    // Approach: Greedy with Priority Queue
    // https://leetcode.com/problems/maximum-performance-of-a-team/solution/


    /*
    IDEA:
    For each candidate, we treat him/her as the one who has the minimum efficiency in a team.
    Then, we select the rest of the team members based on this condition.
    Given all the eligible candidates, in order to maximize the total speed,
    we need to find the fastest k-1 eligible candidates.

    The priority queue, also known as heap, is a data structure which dynamically maintains
    the order of elements based on some predefined priority.
     */


    // TC: O(N) + O(NlogN) + O(NlogK)
    // SC: O(N) + O(K) + O(logN)
    // In Java, the Collections.sort() is implemented as a variant of the quicksort algorithm
    // whose space complexity is O(logN)

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int modulo = (int) Math.pow(10, 9) + 7;
        // build tuples of (efficiency, speed)
        List<Pair> candidates = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            candidates.add(new Pair(efficiency[i], speed[i]));
        }
        // sort the members by their efficiencies
        candidates.sort(Comparator.comparing(Pair::getEfficiency).reversed());  // NlogN

        // create a heap to keep the top (k-1) speeds
        PriorityQueue<Integer> speedHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

        long speedSum = 0, perf = 0;
        for (Pair p : candidates) {
            int currEfficiency = p.getEfficiency();
            int currSpeed = p.getSpeed();
            // maintain a heap for the fastest (k-1) speeds
            if (speedHeap.size() > k - 1) {
                speedSum -= speedHeap.remove();  // logK
            }
            speedHeap.add(currSpeed); // logK

            // calculate the maximum performance with
            // the current member as the least efficient one in the team
            speedSum += currSpeed;
            perf = Math.max(perf, speedSum * currEfficiency);
        }
        return (int) (perf % modulo);
    }

    public static class Pair{
        int speed;
        int efficiency;
        Pair(int eff, int speed){
            this.speed = speed;
            this.efficiency = eff;
        }
        public int getEfficiency(){
            return this.efficiency;
        }
        public int getSpeed(){
            return this.speed;
        }
    }

}
