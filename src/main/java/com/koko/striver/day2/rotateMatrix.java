package com.koko.striver.day2;

public class rotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]+", ");
            }
            System.out.println();
        }
    }

    private static void rotate(int[][] matrix) {

        // Transpose the matrix
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix[0].length; j++) { // j=i hai na ki 0, 0 hone par same matrix milega
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Rotate the matrix
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];// matrix.length-1 nhi hai, 0 hone par same matrix milega
                matrix[i][matrix.length-1-j] = temp;
            }
        }


    }
}
