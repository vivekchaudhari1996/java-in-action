package com.koko.dataStructures.Misc;

public class FurthestHousesDiffColors {

    // Q: There are n houses evenly lined up on the street,
    // and each house is beautifully painted. You are given a 0-indexed integer array colors of length n,
    // where colors[i] represents the color of the ith house.
    //
    //Return the maximum distance between two houses with different colors.


    // Example:
    /*
    Input: colors = [1,1,1,6,1,1,1]
Output: 3
Explanation: In the above image, color 1 is blue, and color 6 is red.
The furthest two houses with different colors are house 0 and house 3.
House 0 has color 1, and house 3 has color 6. The distance between them is abs(0 - 3) = 3.
Note that houses 3 and 6 can also produce the optimal answer.


Input: colors = [1,8,3,8,3]
Output: 4
Explanation: In the above image, color 1 is blue, color 8 is yellow, and color 3 is green.
The furthest two houses with different colors are house 0 and house 4.
House 0 has color 1, and house 4 has color 3. The distance between them is abs(0 - 4) = 4.
     */


    // Solution:

    // The maximum distance will always include either first or the last house.
    // This can be proven by a contradiction.
    //
    //Therefore, we need to return the maximum of two cases: max(j, n - i - 1), where
    //
    //i is the leftmost position of the color different from the last color.
    //j is the rightmost position of the color different from the first one.

    // TC: O(N)

    public int maxDistance(int[] cs) {
        int n = cs.length, i = 0, j = n - 1;
        while (cs[0] == cs[j])
            --j;
        while (cs[n - 1] == cs[i])
            ++i;
        return Math.max(j, n - i - 1);
    }
}
