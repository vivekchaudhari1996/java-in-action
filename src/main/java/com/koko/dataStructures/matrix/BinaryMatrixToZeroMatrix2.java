package com.koko.dataStructures.matrix;

public class BinaryMatrixToZeroMatrix2 {

    // ###MatrixFlips
    // ###BinaryMatrix
    // ###DFS
    // ###Backtracking



    //Q:
    /*
    You are given a 0-indexed m x n binary matrix grid.

In one operation, you can choose any i and j that meet the following conditions:

0 <= i < m
0 <= j < n
grid[i][j] == 1
and change the values of all cells in row i and column j to zero.

Return the minimum number of operations needed to remove all 1's from grid.
     */




    // Example:
    /*
    Input: grid = [[1,1,1],[1,1,1],[0,1,0]]
Output: 2
Explanation:
In the first operation, change all cell values of row 1 and column 1 to zero.
In the second operation, change all cell values of row 0 and column 0 to zero.



Input: grid = [[0,1,0],[1,0,1],[0,1,0]]
Output: 2
Explanation:
In the first operation, change all cell values of row 1 and column 0 to zero.
In the second operation, change all cell values of row 2 and column 1 to zero.
Note that we cannot perform an operation using row 1 and column 1 because grid[1][1] != 1.
     */





    // Solution:
    // DFS+Backtracking


    // We can use a combination of DFS(recursion) and Backtrack to find the min steps
// Backtrack because we need to check ALL the ways of changing 1's to 0's
// So basically we pick one row, col and change that and then DFS from that point to
// find the answer then we BACKTRACK to reverse what changed and then change some other location and repeat
    // Let's look at this matrix as an example:

// 0 1 0
// 0 0 0
// 1 1 1

// And let's assume we are at row = 2 and col = 1.
// The backup of the row would be [1, 1, 1]. The backup of the column would be [1, 0, 0].
// Why [1, 0, 0] and not [1, 0, 1]? Because we have flipped the ones while creating the
// backup of row 2. If we restore them in the same order, we will not be able to restore the
// value of the item at index (2, 1) correctly.
// Therefore, the backup of row 2 has to be copied AFTER the backup of col 1 has been copied.



    // TC : O((mn)^max(m,n)) -> Recursion is at most max(m,n) deep
    // SC : O(m + n)

    public int removeOnes(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int minFlips = Integer.MAX_VALUE;

        int[] rowValues = new int[cols];
        int[] colValues = new int[rows];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 0) {
                    continue;
                }
                // Preserve the column values
                for(int r = 0; r < rows; r++) {
                    colValues[r] = grid[r][col];
                    grid[r][col] = 0;
                }
                // Preserve the row values
                for(int c = 0; c < cols; c++) {
                    rowValues[c] = grid[row][c];
                    grid[row][c] = 0;
                }
                // Recurse
                minFlips = Math.min(minFlips, (1 + removeOnes(grid)));

                // Backtrack
                // Since we preserved the row values later, so we but them back first
                for(int c = 0; c < cols; c++) {
                    grid[row][c] = rowValues[c];
                }
                // Since we preserved the col values first, so we put them back later
                for(int r = 0; r < rows; r++) {
                    grid[r][col] = colValues[r];
                }
            }
        }
        return ((minFlips == Integer.MAX_VALUE) ? 0 : minFlips);
    }
}
