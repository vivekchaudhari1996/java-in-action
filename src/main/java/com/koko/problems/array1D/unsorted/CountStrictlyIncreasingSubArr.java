package com.koko.problems.array1D.unsorted;

public class CountStrictlyIncreasingSubArr {

    // Question:
    // Given an array of integers,
    // count number of subarrays (of size more than one) that are strictly increasing.

    /* Example:
    Input: arr[] = {1, 4, 3}
    Output: 1
    There is only one subarray {1, 4}

    Input: arr[] = {1, 2, 3, 4}
    Output: 6
    There are 6 subarrays {1, 2}, {1, 2, 3}, {1, 2, 3, 4}
    {2, 3}, {2, 3, 4} and {3, 4}

    Input: arr[] = {1, 2, 2, 4}
    Output: 2
    There are 2 subarrays {1, 2} and {2, 4}

     */


    // Solution:
    // The idea is based on fact that a sorted subarray of length ‘len’
    // adds len*(len-1)/2 to result.
    // For example, {10, 20, 30, 40} adds 6 to the result.

    // 1. We first find the point where sorted order breaks.
    // 2. At this point, our previous window has all strictly increasing elems.
    // 3. So, number of subarrays that can be formed = len * (len-1)/ 2
    // 4. Add this to the final result variable.

    // Time Complexity: O(n)
    // Auxiliary Space: O(1)

    static int arr[] = new int[]{1, 2, 2, 4};

    static int countIncreasing(int n) {
        int cnt = 0;  // Initialize result

        // Initialize length of current increasing
        // subarray
        int len = 1;

        // Traverse through the array
        for (int i = 0; i < n - 1; ++i) {
            // If arr[i+1] is greater than arr[i],
            // then increment length
            if (arr[i + 1] > arr[i])
                len++;

                // Else Update count and reset length
            else {
                cnt += (((len - 1) * len) / 2);
                len = 1;
            }
        }

        // If last length is more than 1
        if (len > 1)
            cnt += (((len - 1) * len) / 2);

        return cnt;
    }

    // Driver method to test the above function
    public static void main(String[] args) {
        System.out.println("Count of strictly increasing subarrays is " + countIncreasing(4));
    }



    // Another solution but with O(n^2) TC
    // use the fact that if subarray arr[i:j] is not strictly increasing,
    // then subarrays arr[i:j+1], arr[i:j+2], .. arr[i:n-1] cannot be strictly increasing.

    // Time Complexity: O(n2)
    // Auxiliary Space: O(1)


    static int countIncreasing2(int n)
    {
        // Initialize count of subarrays as 0
        int cnt = 0;

        // Pick starting point
        for (int i=0; i<n; i++)
        {
            // Pick ending point
            for (int j=i+1; j<n; j++)
            {
                if (arr[j] > arr[j-1])
                    cnt++;

                    // If subarray arr[i..j] is not strictly
                    // increasing, then subarrays after it , i.e.,
                    // arr[i..j+1], arr[i..j+2], .... cannot
                    // be strictly increasing
                else
                    break;
            }
        }
        return cnt;
    }
}
