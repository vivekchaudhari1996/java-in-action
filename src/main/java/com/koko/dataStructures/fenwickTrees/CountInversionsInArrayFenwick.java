package com.koko.dataStructures.fenwickTrees;

public class CountInversionsInArrayFenwick {

    // Q:
    // Inversion Count for an array indicates – how far (or close) the array is from being sorted.
    // If the array is already sorted then the inversion count is 0.
    // If the array is sorted in the reverse order that inversion count is the maximum.
    // Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
    // For simplicity, we may assume that all elements are unique.


    // Example:
    /*
    Input: arr[] = {8, 4, 2, 1}
Output: 6
Explanation: Given array has six inversions: (8,4), (4,2), (8,2), (8,1), (4,1), (2,1).

Input: arr[] = {3, 1, 2}
Output: 2
Explanation: Given array has two inversions: (3,1), (3,2).
     */


    // Solution:
    // Using Fenwick tree
    // Approach: Traverse through the array and for every index find the number of smaller elements on the right
    // side of the array. This can be done using BIT. Traverse the array from end to start.
    // Sum up the counts for all indexes in the array and print the sum.

    // BIT is implemented using an array and works in form of trees.
    // Note that there are two ways of looking at BIT as a tree.
    // The sum operation where parent of index x is “x – (x & -x)”.
    // The update operation where parent of index x is “x + (x & -x)”.

    // Time Complexity :- The update function and getSum function runs for O(log(maximumelement)).
    // The getSum function has to be run for every element in the array.
    // So overall time complexity is : O(n * log(maximumelement)).
    // Auxiliary space : O(maxElement), space required for the BIT is an array of the size of the largest element.


    static int getSum(int[] BITree, int index)
    {
        int sum = 0; // Initialize result

        // Traverse ancestors of BITree[index]
        while (index > 0)
        {
            // Add current element of BITree to sum
            sum += BITree[index];

            // Move index to parent node in getSum View
            index -= index & (-index);
        }
        return sum;
    }

    static void updateBIT(int[] BITree, int n,
                          int index, int val)
    {
        // Traverse all ancestors and add 'val'
        while (index <= n)
        {
            // Add 'val' to current node of BI Tree
            BITree[index] += val;

            // Update index to that of parent in update View
            index += index & (-index);
        }
    }

    // Returns inversion count arr[0..n-1]
    static int getInvCount(int[] arr, int n)
    {
        int invcount = 0; // Initialize result

        // Find maximum element in arr[]
        int maxElement = 0;
        for (int i = 0; i < n; i++)
            if (maxElement < arr[i])
                maxElement = arr[i];

        // Create a BIT with size equal to
        // maxElement+1 (Extra one is used so
        // that elements can be directly be
        // used as index)
        int[] BIT = new int[maxElement + 1];
        for (int i = 1; i <= maxElement; i++)
            BIT[i] = 0;

        // Traverse all elements from right.
        for (int i = n - 1; i >= 0; i--)
        {
            // Get count of elements smaller than arr[i]
            invcount += getSum(BIT, arr[i] - 1);

            // Add current element to BIT
            updateBIT(BIT, maxElement, arr[i], 1);
        }

        return invcount;
    }

    // Driver code
    public static void main (String[] args)
    {
        int []arr = {8, 4, 2, 1};
        int n = arr.length;
        System.out.println("Number of inversions are : " +
                getInvCount(arr,n));
    }
}
