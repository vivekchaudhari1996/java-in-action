package com.koko.striver.day2;

public class missingNumber {


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 7};
        System.out.println("missing number" + missingNumberUsingXor(arr));
    }

    /**
     * Same idea as the Single Number question, for any integer a, a xor a = 0 and a xor 0 = a.
     * If we xor all numbers in the array and then xor all numbers from 1 to n, effectively all
     * non-missing numbers xor against themselves, generating zero, and this zero is finally xor
     * against the missing number, yielding the result:
     * @param arr
     * @return
     */
    private static int missingNumberUsingXor(int[] arr) {
        int sum =0;
        for(int i =0; i<=arr.length; i++)
            sum^= i;
        for (int i=0; i<arr.length; i++)
            sum^=arr[i];
        return sum;
    }
}
