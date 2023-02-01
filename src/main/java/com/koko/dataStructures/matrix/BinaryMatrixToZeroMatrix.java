package com.koko.dataStructures.matrix;

public class BinaryMatrixToZeroMatrix {

    // ###MatrixFlips
    // ###BinaryMatrix



    // Q:
    /*
    You are given an m x n binary matrix grid.

In one operation, you can choose any row or column and flip each value in that row or column
(i.e., changing all 0's to 1's, and all 1's to 0's).

Return true if it is possible to remove all 1's from grid using
any number of operations or false otherwise.
     */




    // Example:
    /*
    Input: grid = [[0,1,0],[1,0,1],[0,1,0]]
Output: true
Explanation: One possible way to remove all 1's from grid is to:
- Flip the middle row
- Flip the middle column


Input: grid = [[1,1,0],[0,0,0],[0,0,0]]
Output: false
Explanation: It is impossible to remove all 1's from grid.
     */




    // Solution:
    // https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/discuss/?currentPage=1&orderBy=most_votes&query=

    /*
    IDEA:
    Order of flips does not matter, which means that doing flip row1, flip col1 should be exactly
    the same as doing flip col1, flip row1 on a random matrix.
    The reason is that for each of the flip, we do one Not operation on each of the cell in the
    row/column and by doing a sequence of flips ,
    the total number of Not operation on each cell is fixed and
    thus order of the flip does not make a difference.

As a result, if there is a solution that we can remove all ones,
we can first do all row flips, then columns flips,
which means that after row flips all columns should either be all zeros or all ones.
That's why each row should have the same "pattern".
     */



    // 1. Both rows have to follow the same patterns for us to be able to flip them into all 0s.
    //and by the same patterns, I mean for any two rows, they either have to be
    //
    //Exactly the same
    //Exactly opposite
    //If there exists a pair of two rows that do not meet the requirements above,
    // we can't flip the table into all 0s.

    //Reason being that we will want to perform column flip if there are two rows
    // that don't meet the requirement above,
    // but when we do col flip, all rows have 1 element flipped as well,
    // so no matter what we do, it won't be doable.



    public boolean removeOnes(int[][] grid) {
        for (int[] g : grid){
            for (int i = 0; i < g.length; i++){
                if (Math.abs(g[i] - grid[0][i]) != Math.abs(g[0] - grid[0][0]))
                    return false;
            }
        }
        return true;
    }



    // 2. The basic logic is each row should either be equal or 1's compliment of each other.

    public boolean removeOnes2(int[][] grid) {
        for (int i=1; i<grid.length; i++) {
            if (!equalsOrCompliment(grid[0], grid[i])) return false;
        }
        return true;
    }


    private boolean equalsOrCompliment(int[] row1, int[] row2) {
        boolean equals = true, compliment = true;
        for (int i=0; i<row1.length; i++) {
            equals = equals&&(row1[i]==row2[i]);
            compliment = compliment&&(row1[i]!=row2[i]);
        }
        return equals || compliment;
    }
}
