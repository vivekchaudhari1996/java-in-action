package com.koko.problems.array1D.unsorted.removeExactlyOne;

public class MakeArrayStrictlyIncreasing {

    // Question: Given an array arr[] consisting of N integers,
    // the task is to check whether it is possible to make the given array strictly increasing
    // by removing at most one element.

    // Example:
    /*
    Input: arr[] = {1, 1, 2}
    Output: Yes
    Explanation: Removing an occurrence of 1 modifies the array to {1, 2}, which is strictly increasing array.

    Input: arr[] = {2, 2, 3, 4, 5, 5}
    Output: No
     */

    // Solution:
    /*
    The given problem can be solved by traversing the array arr[] and count the indices satisfying
    the condition arr[i-1] ≥ arr[i].
    Follow the steps below to solve the problem:

    1. Initialize two variables, say count as 0 and index as -1,
        to store the count of elements needed to be removed and the index of the removed element respectively.
    2. Traverse the given array over the range [1, N – 1] and if the value of arr[i – 1] is at least arr[i]
        increment the value of count by 1 and update the value of the index as i.
    3. If the value of count is greater than 1, then print “No” and return.
    4. Otherwise, check for the following conditions:
    5. If the value of count is equal to 0, then print “Yes” and return.
    6. If the index is either equal to (N – 1) or equal to 0, then print “Yes” and return.
    7. Check if removing the element at index makes the arr[index – 1] < arr[index + 1],
        then print “Yes” and return.
    8. Check if removing the element at index – 1 makes the arr[index – 2] < arr[index],
        where index – 2 >= 0, then print “Yes” and return.
    9. Check if index < 0, then print “Yes” and return.
    10. After completing the above steps, if none of the above cases are satisfied, then print “No”.
     */

    // Time Complexity: O(N)
    // Auxiliary Space: O(1)


    public static boolean check(int arr[], int n)
    {

        // Stores the count of numbers that
        // are needed to be removed
        int count = 0;

        // Store the index of the element
        // that needs to be removed
        int index = -1;

        // Traverse the range [1, N - 1]
        for(int i = 1; i < n; i++)
        {
            // If arr[i-1] is greater than
            // or equal to arr[i]
            if (arr[i - 1] >= arr[i])
            {
                // Increment the count by 1
                count++;
                // Update index
                index = i;
            }
        }

        // If count is greater than one
        if (count > 1)
            return false;

        // If no element is removed
        if (count == 0)
            return true;

        // If only the last or the
        // first element is removed
        if (index == n - 1 || index == 1)
            return true;

        // If a[index] is removed
        if (arr[index - 1] < arr[index + 1])
            return true;

        // If a[index - 1] is removed
        if (index - 2 >= 0 && arr[index - 2] < arr[index])
            return true;

        // if there is no element to compare
        if(index < 0)
            return true;

        return false;
    }

    // Driver Code
    public static void main(String args[])
    {
        int []arr = { 1, 2, 5, 3, 5 };
        int N = arr.length;

        if (check(arr, N))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
