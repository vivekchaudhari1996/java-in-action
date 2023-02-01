package com.koko.striver.day7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * sort and then fixed the first pointer then traverse remaining array and find the -x.
 */

public class threeSumClass {
    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
        ArrayList<ArrayList<Integer>> ans;
        ans = threeSum(arr);
        for(int i=0; i< ans.size(); i++) { //size hai na ki length
            for(int j=0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<arr.length -2; i++) {
            // fixed the first pointer then traverese remaining array and find the -x.
            int j = i+1;
            int k = arr.length-1;
            while(j<k) {
                int sum = arr[j] + arr[k];
                if (sum == -arr[i]) { //
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(arr[i]);
                    temp.add(arr[j++]);
                    temp.add(arr[k--]);
                    ans.add(temp);
                } else if (sum > arr[i]) {
                    k--; // value kam karni hai so sabse bada ko kam
                } else {
                    j++; // value badhani hai
                }
            }
        }
        return ans;
    }
}
