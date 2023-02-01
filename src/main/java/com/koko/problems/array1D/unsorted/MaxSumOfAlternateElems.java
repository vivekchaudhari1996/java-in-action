package com.koko.problems.array1D.unsorted;

public class MaxSumOfAlternateElems {

    // Question:
    // You are a professional robber planning to rob houses along a street.
    // Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of
    // them is that adjacent houses have security systems connected and it will automatically contact the
    // police if two adjacent houses were broken into on the same night.
    //
    // Given an integer array nums representing the amount of money of each house,
    // return the maximum amount of money you can rob tonight without alerting the police.


    // Example:
    /*
    Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
     */



    // Solution:
    // think of array as [rob1,rob2,i,i+1,i+2,.....n]
    // Add rob1 + i, and move rob1 to rob2
    // and rob2 to sum of rob1+i.
    // i.e move both rob one place ahead.

    // TC: O(n)
    // SC: O(1)

    public int rob(int[] nums) {
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
