package com.koko.problems.array1D.unsorted;

import java.util.Arrays;

public class MaxSumOfAlternateElemsCircularArray {

    // Question:
    // You are a professional robber planning to rob houses along a street.
    // Each house has a certain amount of money stashed.
    // All houses at this place are arranged in a circle.
    // That means the first house is the neighbor of the last one.
    // Meanwhile, adjacent houses have a security system connected,
    // and it will automatically contact the police if two adjacent houses were broken into on the same night.
    //
    // Given an integer array nums representing the amount of money of each house,
    // return the maximum amount of money you can rob tonight without alerting the police.


    // Example:
    /*
    Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
     */



    // Solution:
    // 1. original HOUSE ROBBERS problem BUT from nums-> i=0 to i=n-2.
    // 2. original problem, using the single row solution from nums-> i=1 to i=n-1.
    // 3. Returning the maximum of the results calculated in both of these sub problems.

    // TC: O(n)
    // SC: O(1)

    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(houseRobber(Arrays.copyOfRange(nums, 0, nums.length-1)),
                houseRobber(Arrays.copyOfRange(nums, 1, nums.length)));

    }

    public int houseRobber(int[] nums) {
        int rob1=0,rob2=0;
        //think of array as [rob1,rob2,i,i+1,i+2,.....n]
        for(int i=0;i<nums.length;i++){
            int temp=Math.max(rob1+nums[i],rob2);
            rob1=rob2;
            rob2=temp;
        }
        return rob2;
    }
}
