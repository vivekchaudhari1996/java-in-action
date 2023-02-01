package com.koko.dataStructures.Misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountGoodPathsInGrid {

    // Q:
    /*
    You are given a matrix A having N rows and M columns.
    The rows are numbered 1 to N from the top to bottom and columns are numbered
    1 to M from left to right.
    You are allowed to move right and down only, that is,
    if you are at cell (i,j) then you can move to (i+1,j) and (i,j+1). You are not allowed to move outside the matrix.

Your task is to find the number of good paths starting from (1,1) and ending at (N,M).

Good Path: If the sum of all the elements that lie in the path is divisible by K, then the path is considered as good.
     */


    // Example:
    // There is only 1 good path 1->2->5->6->9 and sum 23




    // Solution:
    // Idea:
    //
    // Note that there are nCr(n + m, n) unique paths possible between (1, 1) and (n, m).
    // In this case, n = 16 and m = 16, so the number of unique paths can be nCr(32, 16) > 10^8.
    //So we will have to apply a technique called "meet in the middle" to solve it.
    //Compute the answer for every element in the diagonal that divides (1, 1) and (n, m).
    // (i.e., the diagonal connecting top right to bottom left corners).
    // Let f[i][j] store a vector of pairs of the form {sum, num},
    // where there are "num" ways to make "sum" while reaching the point "(i, j)".
    //
    //Calculate the answer for the diagonal elements from the top-left corner and from the bottom right-corner.
    // This can be done easily, as the maximum number of good paths in this case will be just nCr(16, 8) ~ 10^4.
    //
    //Now, it is basically like the two-sum problem!
    // For every element, we have {sum, num} pairs from (1, 1) and from (n, m).
    // These are stored in two vectors A and B.
    // We have to find pairs such that sum1 + sum2 is divisible by K, and then add num1 * num2 to the answer.
    // Do this by storing the values from A in a hashmap,
    // and then doing an O(1) query for every value in B to find if the required sum exists.



    private static long solve(long[][] grid, long k){
        int m = grid.length, n = grid[0].length, mid = (m+n-1)/2;
        Map<Long, Integer>[] mapA = new HashMap[m];
        Map<Long, Integer>[] mapB = new HashMap[m];
        Arrays.setAll(mapA, o -> new HashMap<>());
        Arrays.setAll(mapB, o -> new HashMap<>());
        genA(0, 0, k, 0, mid, grid, mapA);
        genB(m-1, n-1, k, 0, mid-(m+n)%2, grid, mapB);
        long ans = 0;
        for (int i = 0; i < m; i++){
            for (long key : mapA[i].keySet()){
                if (mapB[i].containsKey((k-key)%k)){
                    ans += 1L * mapA[i].get(key) * mapB[i].get((k-key)%k);
                }
            }
        }
        return ans;
    }

    private static void genA(int i, int j, long k, long sum, int mid, long[][] grid, Map<Long, Integer>[] map){
        if (i == grid.length || j == grid[0].length){
            return;
        }
        sum += grid[i][j];
        sum %= k;
        if (i+j==mid){
            map[i].merge(sum, 1, Integer::sum);
            return;
        }
        genA(i+1, j, k, sum, mid, grid, map);
        genA(i, j+1, k, sum, mid, grid, map);
    }

    private static void genB(int i, int j, long k, long sum, int mid, long[][] grid, Map<Long, Integer>[] map){
        if (i < 0 || j < 0){
            return;
        }
        if (grid.length-1-i+grid[0].length-1-j==mid){
            map[i].merge(sum, 1, Integer::sum);
            return;
        }
        sum += grid[i][j];
        sum %= k;
        genB(i-1, j, k, sum, mid, grid, map);
        genB(i, j-1, k, sum, mid, grid, map);
    }
}
