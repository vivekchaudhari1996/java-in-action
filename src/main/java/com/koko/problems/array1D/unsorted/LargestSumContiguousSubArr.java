package com.koko.problems.array1D.unsorted;

public class LargestSumContiguousSubArr {

    // Question:
    // Given an integer array nums,
    // find the contiguous subarray (containing at least one number)
    // which has the largest sum and return its sum.

    // Example:
    /*
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
     */


    // Solution:
    // Algorithms (Kadane Algorithm)
    // 1. Initialize currentSum to 0, & maxSum to 1st element of array
    // 2. Loop through each element of the array & Add 1st element of array to currentSum
    //    & check:
    //    1. Check, if currentSum is greater than maxSum, if true
    //       then Update maxSum to currentSum
    //    2. Check, if currentSum value is less than 0, if true
    //       than update currentSum to 0
    // 3. Finally return maxSum


    // TC: O(n)
    // SC: O(1)

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            sum+= nums[i];
            if(sum >max) max = sum;
            if(sum<0) sum = 0;
        }
        return max;
    }
}
