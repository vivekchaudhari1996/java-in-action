package com.koko.problems.matrix.squareMatrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class AbsDiffBetweenSumOfDiagonals {

    // Question: Given a square matrix,
    // find the absolute difference b/w sum of two diagonals.

    // example : 123
    //           456
    //           789
    // Diff = sum(1,5,9) - sum(3,5,7) = |2|

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int diag = 0;
        int rightDiag = 0;
        for(int i=0;i<arr.size();i++){
            diag += arr.get(i).get(i);
            rightDiag += arr.get(arr.size()-1-i).get(i);
        }
        return Math.abs(diag-rightDiag);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);
        bufferedReader.close();
    }
}
