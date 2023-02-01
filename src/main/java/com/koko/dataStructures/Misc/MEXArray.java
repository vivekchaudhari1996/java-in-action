package com.koko.dataStructures.Misc;

public class MEXArray {

    // Q: Given an array arr[] having N distinct positive elements,
    // the task is to generate another array B[] such that, for every ith index in the array,
    // arr[], B[i] is the minimum positive number missing from arr[] excluding arr[i].

    // Example:
    /*
    Input: arr[] = {2, 1, 5, 3}
Output: B[] = {2, 1, 4, 3}
Explanation: After excluding the arr[0], the array is {1, 5, 3}, and the minimum positive number which is not present in this array is 2. Therefore, B[0] = 2. Similarly, after excluding arr[1], arr[2], arr[3], the minimum positive numbers which are not present in the array are 1, 4 and 3, respectively. Hence, B[1] = 1, B[2] = 4, B[3] = 3.

Input: arr[] = {1, 9, 2, 4}
Output: B[] = {1, 3, 2, 3}
     */


    // Solution:
    // Efficient Approach: To optimize the above approach,
    // the idea is to calculate MEX of the array arr[] and traverse the array arr[].
    // If arr[i] is less than MEX of the array arr[] then MEX excluding this element will be arr[i] itself,
    // and if arr[i] is greater than MEX of array A[] then MEX of the array will not change after excluding this element.


    //Follow the steps below to solve the problem:
    // Initialize an array, say hash[], to store whether the value i is present in the array arr[] or not.
    // If i is present hash[i] = 1 else hash[i] = 0.
    // Initialize a variable MexOfArr to store MEX of array arr[] and traverse array hash[] from 1 to find
    // the minimum index j for which hash[j] = 0, which implies that the value j is not present in the array arr[]
    // and store MexOfArr = j.
    // Now traverse the array, arr[] and if arr[i] is less than MexOfArr, then store B[i] = arr[i] else B[i] = MexOfArr.


    // Time Complexity: O(N)
    //Auxiliary Space: O(N)


    static int MAXN = 100001;

    // Function to construct array
// B[] that stores MEX of array
// A[] excluding A[i]
    static void constructMEX(int arr[],
                             int N)
    {
        // Stores elements present
        // in arr[]
        int hash[] = new int[MAXN];
        for (int i = 0; i < N; i++)
        {
            hash[i] = 0;
        }

        // Mark all values 1, if
        // present
        for (int i = 0; i < N; i++)
        {
            hash[arr[i]] = 1;
        }

        // Initialize variable to
        // store MEX
        int MexOfArr = 0 ;

        // Find MEX of arr[]
        for (int i = 1; i < MAXN; i++)
        {
            if (hash[i] == 0)
            {
                MexOfArr = i;
                break;
            }
        }

        // Stores MEX for all
        // indices
        int B[] = new int[N];

        // Traverse the given array
        for (int i = 0; i < N; i++)
        {
            // Update MEX
            if (arr[i] < MexOfArr)
                B[i] = arr[i];

                // MEX default
            else
                B[i] = MexOfArr;
        }

        // Print the array B
        for (int i = 0; i < N; i++)
            System.out.print(B[i] + " ");
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Given array arr[]
        int arr[] = {2, 1, 5, 3};

        // Size of array
        int N = arr.length;

        // Function call
        constructMEX(arr, N);
    }
}
