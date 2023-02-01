package com.koko.dataStructures.fenwickTrees;

import java.util.Arrays;

public class CountInversionsInArrayWithNegativeNbr {

    // the problem with the previous approach is that it doesn’t work for negative numbers
    // as the index cannot be negative.
    // The idea is to convert the given array to an array with values from 1 to n and
    // the relative order of smaller and greater elements remains the same.

    // arr[] = {7, -90, 100, 1}
    //It gets  converted to,
    //arr[] = {3, 1, 4 ,2 }
    //as -90 < 1 < 7 < 100.
    //
    //Explanation: Make a BIT array of a number of
    //elements instead of a maximum element. Changing
    //element will not have any change in the answer
    //as the greater elements remain greater and at the
    //same position.


    // Time Complexity: The update function and getSum function runs for O(log(n)).
    // The getSum function has to be run for every element in the array.
    // So overall time complexity is O(nlog(n)).
    // Auxiliary Space: O(n).


    static int getSum(int BITree[],
                      int index)
    {
        // Initialize result
        int sum = 0;

        // Traverse ancestors of
        // BITree[index]
        while (index > 0)
        {
            // Add current element of
            // BITree to sum
            sum += BITree[index];

            // Move index to parent node
            // in getSum View
            index -= index & (-index);
        }
        return sum;
    }
    static void updateBIT(int BITree[], int n,
                          int index, int val)
    {
        // Traverse all ancestors
        // and add 'val'
        while (index <= n)
        {
            // Add 'val' to current
            // node of BI Tree
            BITree[index] += val;

            // Update index to that of
            // parent in update View
            index += index & (-index);
        }
    }

    static void convert(int arr[],
                        int n)
    {
        // Create a copy of arrp[] in temp
        // and sort the temp array in
        // increasing order
        int []temp = new int[n];

        for (int i = 0; i < n; i++)
            temp[i] = arr[i];
        Arrays.sort(temp);

        // Traverse all array elements
        for (int i = 0; i < n; i++)
        {
            // lower_bound() Returns pointer
            // to the first element greater
            // than or equal to arr[i]
            arr[i] =lower_bound(temp,0,
                    n, arr[i]) + 1;
        }
    }

    static int lower_bound(int[] a, int low,
                           int high, int element)
    {
        while(low < high)
        {
            int middle = low +
                    (high - low) / 2;
            if(element > a[middle])
                low = middle + 1;
            else
                high = middle;
        }
        return low;
    }

    // Returns inversion count
    // arr[0..n-1]
    static int getInvCount(int arr[],
                           int n)
    {
        // Initialize result
        int invcount = 0;

        // Convert arr[] to an array
        // with values from 1 to n and
        // relative order of smaller
        // and greater elements remains
        // same.  For example, {7, -90,
        // 100, 1} is converted to
        //  {3, 1, 4 ,2 }
        convert(arr, n);

        // Create a BIT with size equal
        // to maxElement+1 (Extra one is
        // used so that elements can be
        // directly be used as index)
        int []BIT = new int[n + 1];

        for (int i = 1; i <= n; i++)
            BIT[i] = 0;

        // Traverse all elements
        // from right.
        for (int i = n - 1; i >= 0; i--)
        {
            // Get count of elements
            // smaller than arr[i]
            invcount += getSum(BIT,
                    arr[i] - 1);

            // Add current element to BIT
            updateBIT(BIT, n, arr[i], 1);
        }

        return invcount;
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = {8, 4, 2, 1};
        int n = arr.length;
        System.out.print("Number of inversions are : " +
                getInvCount(arr, n));
    }
}
