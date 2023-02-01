package com.koko.dataStructures.Misc;

public class CountPossiblePathsInGrid {

    // Q:
    // The problem is to count all the possible paths from top left to bottom right
    // of a mXn matrix with the constraints
    // that from each cell you can either move only to right or down



    // Sol1:
    // TC: O(mn), SC: O(mn)


    static int numberOfPaths(int n, int m, int DP[][])
    {

        if (n == 1 || m == 1)
            return DP[n][m] = 1;

        // Add the element in the DP table
        // If it is was not computed before
        if (DP[n][m] == 0)
            DP[n][m] = numberOfPaths(n - 1, m, DP)
                    + numberOfPaths(n, m - 1, DP);

        return DP[n][m];
    }

    // Driver code
    public static void main(String args[])
    {
        // Create an empty 2D table
        int DP[][] = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                DP[i][j] = 0;
            }
        }

        System.out.println(numberOfPaths(3, 3, DP));
    }




    // Sol2:

    // TC:O(mn), SC: O(n)


    static int numberOfPaths(int m, int n)
    {
        // Create a 1D array to store results of subproblems
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    // Driver program to test above function
    public static void main1(String args[])
    {
        System.out.println(numberOfPaths(3, 3));
    }




    // Sol3:

    // (Using combinatorics)
    // In this approach We have to calculate m+n-2Cn-1 here which will be (m+n-2)! / (n-1)! (m-1)!
}
