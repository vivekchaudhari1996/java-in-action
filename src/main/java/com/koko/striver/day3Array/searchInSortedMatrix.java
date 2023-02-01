package com.koko.striver.day3Array;

/**
 * The basic idea is from right corner, if the current number greater than target col - 1 in same row,
 * else if the current number less than target, row + 1 in same column, finally if they are same,
 * we find it, and return return.
 * O(M+N) hai jabki pure binary search lagate to O(log(m*n)) hota.
 */
public class searchInSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("available or not " + searchMatrix(mat, 13));
    }

    private static boolean searchMatrix(int[][] mat, int n) {
        int i = 0;
        int j = mat[0].length-1;
        while(i<mat.length && j>=0) {
            if (mat[i][j] == n) return true;
            else if(n> mat[i][j]) i++; // nyi row me jao
            else j--; // same row me
        }
        return false;
    }
}
