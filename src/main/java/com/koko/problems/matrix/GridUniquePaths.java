package com.koko.problems.matrix;

public class GridUniquePaths {

    // Q:
    // There is a robot on an m x n grid.
    // The robot is initially located at the top-left corner (i.e., grid[0][0]).
    // The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
    // The robot can only move either down or right at any point in time.
    //
    // Given the two integers m and n, return the number of possible unique paths that the robot can
    // take to reach the bottom-right corner.

    // Example:
    /*
    Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
     */



    // Solution:
    // This is a combinatorial problem and can be solved without DP.
    // For mxn grid, robot has to move exactly m-1 steps down and n-1 steps right and these can be done in any order.
    //
    //For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any order.
    // That is nothing but a permutation problem. Denote down as 'D' and right as 'R', following is one of the path :-
    //
    //D R R R D R R R
    //
    //We have to tell the total number of permutations of the above given word.
    // So, decrease both m & n by 1 and apply following formula:-
    //
    //Total permutations = (m+n)! / (m! * n!)

    // Using combinations
    public int uniquePaths(int m, int n) {
        int N = n + m - 2;
        int r = m - 1;
        double res = 1;

        for (int i = 1; i <= r; i++)
            res = res * (N - r + i) / i;
        return (int)res;
    }

    // Using permutations.
    public int uniquePaths2(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }

        return (int)res;
    }
}
