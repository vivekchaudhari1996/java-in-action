package com.koko.striver.day8;

import java.util.Arrays;

/**
 * Intuition: At first we need to sort both the arrays. When the events will be sorted, it will be easy to track the count of trains that have arrived but not departed yet. Total platforms needed at one time can be found by taking the difference of arrivals and departures at that time and the maximum value of all times will be the final answer.
 *
 * Approach:  At first we need to sort both the arrays. When the events will be sorted, it will be easy to track the count of trains that have arrived but not departed yet. Total platforms needed at one time can be found by taking the difference of arrivals and departures at that time and the maximum value of all times will be the final answer. If(arr[i]<=dep[j]) means if arrival time is less than or equal to the departure time then- we need one more platform. So increment count as well as increment i. If(arr[i]>dep[j]) means arrival time is more than the departure time then- we have one extra platform which we can reduce. So decrement count but increment j. Update the ans with max(ans, count) after each iteration of the while loop.
 */

public class minimumPlatform {

    public static void main(String[] args) {
        int start[] = {900,945,955,1100,1500,1800};
        int dep[] = {920,1200,1130,1150,1900,2000};
        int n = start.length;
        int totalPlatorm = findMinimumPlatform(start, dep, n);
        System.out.println("Platform needed " + totalPlatorm);
    }

    private static int findMinimumPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platform_needed = 1;
        int result = 1;
        int i=1; // yha 1 hai 0 nhi
        int j=0;

        while(i<n && j<n) {
            if(arr[i] <= arr[j]) {
                platform_needed++;
                i++;
            } else {
                platform_needed--;
                j++;
            }

            if (platform_needed > result)
                result = platform_needed;
        }
        return result;
    }
}

/**
 *
 * Time Complexity: O(nlogn)   (Sorting takes O(nlogn) and traversal of arrays takes O(n) so overall time complexity is O(nlogn)).
 *
 * Space complexity: O(1)   (No extra space used).
 */
