package com.koko.problems.array1D.unsorted.removeExactlyOne;

import java.util.Arrays;

public class MinimizeMaxMinDiff {

    // Question: Consider a sequence of  integers. array
    // We want to delete exactly one element,
    // such that the difference between the smallest and largest elements in the sequence is minimal.
    // Then print the minimal absolute difference between the maximal and minimal elements on a new line.

    // Example:
    // 7 4 3 1 3
    // Remove 7 to get minimum diff = Max(4) - Min(1) =  3

    public static void main(String[] args) {
        int[] arr = new int[]{7,4,3,1,3};
        Arrays.sort(arr);
        // Check if removing last max element, what would be Max-Min diff.
        // Check if removing first min elememt, what would be Max-Min diff.

        if(arr[arr.length-1] - arr[1] > arr[arr.length-2] - arr[0]){
            // Print the min diff after removing element.
            System.out.println(arr[arr.length-2] - arr[0]);
        }else{
            System.out.println(arr[arr.length-1] - arr[1]);
        }
    }
}
