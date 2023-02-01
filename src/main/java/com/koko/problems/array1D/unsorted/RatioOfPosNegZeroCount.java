package com.koko.problems.array1D.unsorted;

import java.text.DecimalFormat;

public class RatioOfPosNegZeroCount {

    // Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
    // Print the decimal value of each fraction on a new line with 6 places after the decimal.

    // example
    // arr= [1,1,0,-1,-1]
    // there are 5 elemenst. 2 pos, 2 neg, 1 zero.
    // Ratios are: 2/5, 2/5, 1/5
    // 0.4, 0.4, 0.2

    public static void main(String args[])
    {
        int arr[]= new int[]{1,1,0,-1,-1};
        int N = 5;
        double pos=0;
        double neg=0;
        double zero=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>0)
            {
                pos=pos+1;
            }
            else if(arr[i]<0)
            {
                neg=neg+1;
            }
            else
            {
                zero=zero+1;
            }
        }
        DecimalFormat df= new DecimalFormat("#.000000");
        System.out.println(df.format(pos/N));
        System.out.println(df.format(neg/N));
        System.out.println(df.format(zero/N));
    }
}
