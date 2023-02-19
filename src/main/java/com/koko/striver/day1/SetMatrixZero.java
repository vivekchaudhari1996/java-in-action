package com.koko.striver.day1;

/**
 * if any zero index then need to set the entire row and column zero.
 * we will utilize the first row and column instead of using the extra space
 * O(n*n) time - isse kam to kar hi nhi sakte
 * O(1) space - that is imp
 */
public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeros(mat);

        System.out.println("Final matrix");
        for (int i=0; i< mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                System.out.print(" " + mat[i][j]);
            }
            System.out.println();
        }
    }

    public static void setZeros(int[][] mat) {
        boolean isFirstRowHaveZero = false;
        boolean isFirstColHaveZero = false;

        // checking if first row have zero
        for (int j=0; j<mat[0].length; j++) {
            if (mat[0][j] == 0) isFirstRowHaveZero = true;
        }

        // checking if first column have zero
        for (int i=0; i< mat.length; i++) {
            if(mat[i][0] == 0) isFirstColHaveZero = true;
        }

        // now utilize first row and first column as indicator
        for (int i=1; i<mat.length; i++) {
            for (int j=1; j<mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // now update the row and col as per the first row and first col zeros
        for (int i=1; i<mat.length; i++) {
            for (int j=1; j<mat[i].length; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // now finally update the first row and first column as per the flag set in starting
        for (int j=0; j<mat[0].length; j++) {
            if (isFirstRowHaveZero) mat[0][j] = 0;
        }
        for (int i=0; i<mat.length; i++) {
            if (isFirstColHaveZero) mat[i][0] = 0;
        }
    }
}
