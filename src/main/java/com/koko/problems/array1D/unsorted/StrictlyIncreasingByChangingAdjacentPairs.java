package com.koko.problems.array1D.unsorted;

public class StrictlyIncreasingByChangingAdjacentPairs {

    // Question:
    // Given an array arr[] of size N consisting of non-negative integers.
    // In one move ith index element of the array is decreased by 1 and (i+1)th index is increased by 1.
    // The task is to check if there is any possibility to make the given array strictly increasing
    // (containing non-negative integers only) by making any number of moves.

    // Example
    /*
    nput: arr[3] = [1, 2, 3]
Output: Yes
Explanation: The array is already sorted in strictly increasing order.

Input: arr[2] = [2, 0]
Output: Yes
Explanation: Consider i = 0 for the 1st move arr[0] = 2-1 = 1, arr[1] = 0 + 1 = 1.
Now the array becomes, [1, 1].
In 2nd move consider i = 0. So now arr[0] = 1 – 1 = 0, arr[1] = 1 + 1 = 2.
The final array becomes, arr[2] = [0, 2] which is strictly increasing.

Input: arr[3] = [0, 1, 0]
Output: No
Explanation: This array cannot be made strictly increasing containing only non negative integers
by performing any number of moves.
     */



    // Solution

    // Approach: The problem can be solved using the following mathematical observation.
    //
    // 1. Since all the array elements are non-negative, so minimum strictly increasing order of an array
    // 2. of size N can be: 0, 1, 2, 3 . . . (N-1).
    // 3. So the minimum sum(min_sum) of first i elements (till (i-t)th index) of any such array
    // 4. is min_sum = (i*(i+1))/2.
    // 5. Therefore, the sum of first i elements of given array(cur_sum) must satisfy the condition
    // 6. cur_sum ≥ min_sum .
    // 7. If the condition is not satisfied, then it is not possible to make the given array strictly increasing.
    // Consider the following example
    // arr[]           = 2 3 1 0 2
    // min_sum   = 0 1 3 6 10
    // sum(arr)   = 2 5 6 6 8
    //
    // Here at index 4 the sum of array does not satisfy the condition of having minimum sum 10.
    // So it is not possible to change the array into a strictly increasing one.


    // Time Complexity: O(N)
    // Space Complexity: O(1)

    static void CheckStrictlyIncreasing(int arr[],
                                        int N)
    {
        // variable to store sum till current
        // index element
        int cur_sum = 0;
        boolean possible = true;
        for (int index = 0;
             index < N; index++) {
            cur_sum += arr[index];

            // Sum of 0, 1, ...(i)th element
            int req_sum = (index * (index + 1)) / 2;

            // Check if valid or not
            if (req_sum > cur_sum) {
                possible = false;
                break;
            }
        }

        // If can be made strictly increasing
        if (possible)
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3 };
        int N = 3;

        CheckStrictlyIncreasing(arr, N);
    }
}
