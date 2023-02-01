package com.koko.problems.array1D.unsorted.pairsIAndJ;

public class BestSightSeeingPair {

    // Question:
    // You are given an integer array values where values[i] represents the value of the ith sightseeing spot.
    // Two sightseeing spots i and j have a distance j - i between them.
    // The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j:
    // the sum of the values of the sightseeing spots, minus the distance between them.

    //Return the maximum score of a pair of sightseeing spots.


    // Example:
    /*
Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11

Input: values = [1,2]
Output: 2
     */




    // Solution:
    // Given: maximum(values[i] + values[j] + i - j)

    // If we rewrite the equation as: maximum((values[i] + i) + (values[j] - j)) ,
    // Aim is to maximize MS = values[i] + values[j] + i - j for i < j,
    // which can be rewritten as S + D where S = values[i] + i, D = values[j] - j,
    // Try solving this equation.

    // TC: O(n)
    // SC: O(1)

    public int maxScoreSightseeingPair(int[] values) {
        int maxI=values[0]+0;
        int res=-1;
        for(int i=1;i<values.length;i++) {
            res=Math.max(res,maxI+values[i]-i);
            maxI=Math.max(maxI,values[i]+i);
        }
        return res;
    }

    public int maxScoreSightseeingPair2(int[] values) {
        int i=0,ans=0,j;
        for(j=1;j<values.length;j++){
            ans=Math.max(ans,values[i]+values[j]+i-j);
            i=(i+values[i])<(j+values[j])?j:i;
        }
        return ans;
    }


}
