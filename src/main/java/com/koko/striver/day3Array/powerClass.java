package com.koko.striver.day3Array;

/**
 * Solution 2: Using Binary Exponentiation
 *
 * Approach: Initialize ans as 1.0  and store a duplicate copy of n i.e nn using to avoid overflow
 *
 * Check if nn is a negative number, in that case, make it a positive number.
 *
 * Keep on iterating until nn is greater than zero, now if nn is an odd power then multiply x with
 * ans ans reduce nn by 1. Else multiply x with itself and divide nn by two.
 *
 * Now after the entire binary exponentiation is complete and nn becomes zero, check if n is a
 * negative value we know the answer will be 1 by and.
 *
 * Time Complexity: O(log n)
 *
 * Space Complexity: O(1)
 */
public class powerClass {
    public static void main(String[] args) {
        System.out.println("Power is " + pow(2, 9));
    }

    private static double pow(double x, int n) {
        double ans = 1; // kisi ki bhi power 0 even 1 hota hai
        double nn = n;
        if(nn<0) nn = -1 * nn;

        while(nn>0) {
            if(nn%2 == 0) { // If n is even (x^n) can be written as  (x^2)^n/2
                x= x*x;
                nn= nn/2;
            } else {  // If k is odd (nk) can be written as n.(n)k-1, so now  (k-1) is even.
                ans = ans*x;
                nn= nn-1;
            }
        }
        if(n<0) ans = (double)(1.0) / (double)(ans);
        return ans;

    }
}
