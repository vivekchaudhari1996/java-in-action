package com.koko.striver.day2;

/**
 * Approach: Take a frequency array of size N+1 and initialize it to 0. Now traverse through the array
 * and if the frequency of the element is 0 increase it by 1, else if the frequency is not 0 then that
 * element is the required answer.
 */
public class findDuplicateInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 4};
        System.out.println("duplicate" + findDuplicate(arr));
    }

    private static int findDuplicate(int[] arr) {
        int[] freq = new int[arr.length+1];
        for(int i=0; i<arr.length; i++) {
            if(freq[arr[i]] == 0) {
                freq[arr[i]] +=1;
            } else {
                return arr[i];
            }
        }
        return 0;
    }
}
