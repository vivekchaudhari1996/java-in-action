package com.koko.dataStructures.matrix;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BinaryMatrixToZeroMatrix3 {

    // ###MatrixFlips
    // ###BinaryMatrix



    // Q:
    /*
    Given a m x n binary matrix mat.
    In one step, you can choose one cell and flip it and all the four neighbors
    of it if they exist (Flip is changing 1 to 0 and 0 to 1).
    A pair of cells are called neighbors if they share one edge.

Return the minimum number of steps required to convert mat to a zero matrix or -1 if you cannot.
     */




    // Example:
    /*
    Input: mat = [[0,0],[0,1]]
Output: 3
Explanation: One possible solution is to flip (1, 0) then (0, 1) and finally (1, 1) as shown.



Input: mat = [[1,0,0],[1,0,0]]
Output: -1
Explanation: Given matrix cannot be a zero matrix.

     */






    // Solution:
    // https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/discuss/446342/JavaPython-3-Convert-matrix-to-int%3A-BFS-and-DFS-codes-w-explanation-comments-and-analysis.


    private static final int[] d = {0, 0, 1, 0, -1, 0};

    public int minFlips(int[][] mat) {
        int start = 0, m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                start |= mat[i][j] << i * n + j;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[]{start, 0});
        Map<Integer, Integer> seenSteps = new HashMap<>();
        seenSteps.put(start, 0);
        while (!stk.isEmpty()) {
            int[] a = stk.pop();
            int cur = a[0], step = a[1];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int next = cur;
                    for (int k = 0; k < 5; ++k) {
                        int r = i + d[k], c = j + d[k + 1];
                        if (r >= 0 && r < m && c >= 0 && c < n) {
                            next ^= 1 << r * n + c;
                        }
                    }
                    if (seenSteps.getOrDefault(next, Integer.MAX_VALUE) > step + 1) {
                        seenSteps.put(next, step + 1);
                        stk.push(new int[]{next, step + 1});
                    }
                }
            }
        }
        return seenSteps.getOrDefault(0, -1);
    }
}
