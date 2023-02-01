package com.koko.dataStructures.Misc;

import java.util.ArrayList;

public class MaxDistanceBetweenIndexes {

    // Q: You are given two non-increasing 0-indexed integer arrays nums1 and nums2.
    //
    //A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length,
    // is valid if both i <= j and nums1[i] <= nums2[j]. The distance of the pair is j - i
    //
    //Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.


    // Example:
    /*
    Input: nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
Output: 2
Explanation: The valid pairs are (0,0), (2,2), (2,3), (2,4), (3,3), (3,4), and (4,4).
The maximum distance is 2 with pair (2,4).

Input: nums1 = [2,2,2], nums2 = [10,10,1]
Output: 1
Explanation: The valid pairs are (0,0), (0,1), and (1,1).
The maximum distance is 1 with pair (0,1).
     */


    // Solution:
    // Since our arrays are sorted, we can advance i while n1[i] is bigger than n2[j],
    // and increment j otherwise.

    // TC: O(N)
    // SC: O(1)

    public int maxDistance(int[] n1, int[] n2) {
        int i = 0, j = 0, res = 0;
        while (i < n1.length && j < n2.length)
            if (n1[i] > n2[j])
                ++i;
            else
                res = Math.max(res, j++ - i);
        return res;
    }



    // Q: For single array
    // Max value of j-i
    // given a[i] <= a[j]

    // I from 0, j from end
    // When max value found for a particular j, break.


    public static int maxDiff(ArrayList<Integer> a, int n) {
        // Write your code here.
        int i = 0, j = 0, res = 0;
        for(i=0;i<n;i++){
            for(j=n-1;j>=i;j--){
                if(a.get(j)>=a.get(i))
                    break;
            }
            res = Math.max(res, j-i);
        }
        return res;
    }
}
