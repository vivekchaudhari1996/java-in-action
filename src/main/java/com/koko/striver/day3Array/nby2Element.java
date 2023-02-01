package com.koko.striver.day3Array;

import java.util.HashMap;

public class nby2Element {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 5, 1, 1};
        System.out.println("Majority element using HAshmap " + majorityElementUsingHashMap(arr));
        System.out.println("Majority element using Moore voting algo " + majorityElement(arr));


    }

    /**
     * Time Complexity: O(N)-> Frequency array or O(N log N) -> HashMap
     * Space Complexity: O(N)
     * @param arr
     * @return
     */
    private static int majorityElementUsingHashMap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : arr) {
            if(map.containsKey(a)) { // if already availabel than find the freq and increase it by 1
                map.put(a, map.get(a)+1);
            }
            else { // if already not available then add it as 1 freq
                map.put(a, 1);
            }
        }
        return -1;
    }

    /**
     * Intuition: The question clearly states that the nums array has a majority element.
     * Since it has a majority element we can say definitely the count is more than N/2.
     *
     * Majority element count = N/2 + x;
     *
     * Minority/Other elements = N/2 – x;
     *
     * Where x is the number of times it occurs after reaching the minimum value N/2.
     *
     * Now, we can say that count of minority elements and majority elements are equal up to a
     * certain point of time in the array. So when we traverse through the array we try to keep track
     *of the count of elements and which element we are tracking. Since the majority element appears
     * more than N/2 times, we can say that at some point in array traversal we find the majority element.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param arr
     * @return
     *
     *
     *
     * for n/3 required extended Moore voting which is complex so use the hasmmap
     */
    private static int majorityElement(int[] arr) {
        int count = 0;
        int element = 0;

        for (int a : arr) {
            if (count == 0) {  // yaad kar lo
                element = a;
            }
            if(a== element) { // yaad kar lo
                count++;
            } else {
                count--;
            }
        }
        return element;
    }
}
