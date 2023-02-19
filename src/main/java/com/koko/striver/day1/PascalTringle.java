package com.koko.striver.day1;

import java.util.ArrayList;
import java.util.List;

/**
 *     1
 *    1 1
 *   1 2 1
 *  1 3 3 1
 * 1 4 6 4 1
 */
public class PascalTringle {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> ans = pascalTringle(numRows);

        for (int i=0; i< ans.size(); i++) {
            for (int j=0; j<ans.get(i).size(); j++) {
                System.out.print(" " + ans.get(i).get(j));
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> pascalTringle(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for(int i=0; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<i+1; j++) {
                if (j==0 || j==i) row.add(1);
                else row.add(ans.get(i-1).get(j) + ans.get(i-1).get(j-1));
            }
            ans.add(row);
        }
        return ans;
    }
}
