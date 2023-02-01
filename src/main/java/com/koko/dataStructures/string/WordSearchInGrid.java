package com.koko.dataStructures.string;

public class WordSearchInGrid {

    // ###Backtracking


    // Q:
    // Given an m x n grid of characters board and a string word,
    // return true if word exists in the grid.
    //
    // The word can be constructed from letters of sequentially adjacent cells,
    // where adjacent cells are horizontally or vertically neighboring.
    // The same letter cell may not be used more than once.



    // Example:
    /*
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
     */



    // Solution:
    // Approach 1: Backtracking


    /*
    IDEA: This problem is yet another 2D grid traversal problem
    Backtracking which is a methodology where we mark the current path of exploration,
    if the path does not lead to a solution, we then revert the change
    (i.e. backtracking) and try another path.

    There is a certain code pattern for all the algorithms of backtracking.
     */



    // TC: O(N* 3^L) :
    // N is the number of cells in the board and L is the length of the word to be matched.
    // For the backtracking function, initially we could have at most 4 directions to explore,
    // but further the choices are reduced into 3 (since we won't go back to where we come from).
    // As a result, the execution trace after the first step could be visualized as a 3-ary tree,
    // each of the branches represent a potential exploration in the corresponding direction.
    // Therefore, in the worst case, the total number of invocation would be the number
    // of nodes in a full 3-nary tree, which is 3^L.
    // We iterate through the board for backtracking,
    // i.e. there could be NN times invocation for the backtracking function in the worst case.
    // So. N*3^L

    // Sc: O(L) -> recursion stack.

    class Solution {
        private char[][] board;
        private int ROWS;
        private int COLS;

        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.ROWS = board.length;
            this.COLS = board[0].length;

            for (int row = 0; row < this.ROWS; ++row)
                for (int col = 0; col < this.COLS; ++col)
                    if (this.backtrack(row, col, word, 0))
                        return true;
            return false;
        }

        protected boolean backtrack(int row, int col, String word, int index) {
            /* Step 1). check the bottom case. */
            if (index >= word.length())
                return true;

            /* Step 2). Check the boundaries. */
            if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
                    || this.board[row][col] != word.charAt(index))
                return false;

            /* Step 3). explore the neighbors in DFS */
            boolean ret = false;
            // mark the path before the next exploration
            this.board[row][col] = '#';

            int[] rowOffsets = {0, 1, 0, -1};
            int[] colOffsets = {1, 0, -1, 0};
            for (int d = 0; d < 4; ++d) {
                ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
                if (ret)
                    break;
            }

            /* Step 4). clean up and return the result. */
            this.board[row][col] = word.charAt(index);
            return ret;
        }
    }

}
