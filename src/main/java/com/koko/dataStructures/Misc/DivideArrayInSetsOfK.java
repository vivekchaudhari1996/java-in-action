package com.koko.dataStructures.Misc;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class DivideArrayInSetsOfK {

    // Q: Given an array of integers nums and a positive integer k,
    // check whether it is possible to divide this array into sets of k consecutive numbers.
    //
    // Return true if it is possible. Otherwise, return false.


    // Example:
    /*
    Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].


Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
     */



    // Solution:
    /*
    We can see that for a array that is divisible into k consecutive numbers,
    we can distribute its elements into k buckets using the formular f(x, k) = x % k. For example:
[1, 2, 3, 3, 4, 5, 1, 2, 3] with k = 3
[1, 2, 0, 0, 1, 2, 1, 2, 0]
when applying the formular.
buckets = [3, 3, 3]

So, the idea of the solution is to divide the elements of the array into k buckets,
then we loop through the bucket to check whether each bucket contains the same element.
However, we will have test case like [16, 21, 26, 31] with k = 4,
applying the formular we will receive [0, 1, 2, 3],
hence, buckets = [1, 1, 1, 1].
So, we have to sort the array first,
then while we distribute the elements into bucket,
we also check whether the different between two consecutive elements is larger than 1.
     */



    // TC: O(NlogN)

    public boolean isPossibleDivide(int[] A, int k) {
        Arrays.sort(A);  // log N
        int[] buckets = new int[k];
        for (int i = 0; i < A.length; i++) {
            if (i % k != 0 && A[i] - A[i - 1] > 1) return false;
            buckets[A[i] % k]++;
        }

        for (int bucket: buckets) {
            if (bucket != buckets[0]) return false;
        }
        return true;
    }



    // Sol2: Using treeMap

    // First, we put all the numbers in TreeMap.
    // We get the first key (Let's say c) of the map.
    // Then we traverse from the first key(c) to c + k - 1 and count minus 1, respectively;
    // if any one of numbers from c to c + k - 1 is not in the map, we return false.
    // Then we traverse from the (first key) to the (first key + k - 1) again and again until the map is empty.

    public boolean isPossibleDivide2(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) return false;

        TreeMap<Integer, Integer> m = new TreeMap<>();
        for(int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }

        while(m.size() > 0) {
            int c = m.firstKey();
            for(int i = c; i < c + k; i++) {
                if(!m.containsKey(i)) return false;
                else{
                    m.put(i, m.get(i) - 1);
                    if(m.get(i) ==0)
                        m.remove(i);
                }
            }
        }
        return true;
    }



    // Sol3: Using PQ

    public boolean isPossibleDivide3(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Integer i : nums){
            pq.add(i);
        }

        while(!pq.isEmpty()){
            int curr = pq.poll();
            for(int j=1; j<k; j++){
                if(!pq.remove(curr + j)) return false;
            }
        }
        return true;
    }
}
