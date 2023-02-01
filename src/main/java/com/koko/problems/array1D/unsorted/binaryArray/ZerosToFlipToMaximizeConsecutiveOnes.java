package com.koko.problems.array1D.unsorted.binaryArray;

public class ZerosToFlipToMaximizeConsecutiveOnes {

    // Question: Given a binary array and an integer m,
    // find the position of zeroes flipping which creates maximum number of consecutive 1’s in array.

     /* Example:
     Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
             m = 2
     Output:  5 7
     We are allowed to flip maximum 2 zeroes. If we flip
     arr[5] and arr[7], we get 8 consecutive 1's which is
     maximum possible under given constraints

     Input:   arr[] = {0, 0, 0, 1}
             m = 4
     Output:  0 1 2
     Since m is more than number of zeroes, we can flip
     all zeroes.

      */


    // Solution:
//    The idea is to use Sliding Window for the given array.
//
//    Let us use a window covering from index wL to index wR.
//    Let the number of zeros inside the window be zeroCount.
//    We maintain the window with at most m zeros inside.
//
//    The main steps are:
//
//    While zeroCount is no more than m: expand the window to the right (wR++) and update the count zeroCount.
//    While zeroCount exceeds m, shrink the window from left (wL++), update zeroCount;
//    Update the widest window along the way. The positions of output zeros are inside the best window.

    // Time Complexity: O(N)
    // Auxiliary Space: O(1)

    static int arr[] = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1};

    // m is maximum of number zeroes allowed to flip
    static void findZeroes(int m)
    {
        // Left and right indexes of current window
        int wL = 0, wR = 0;

        // Left index and size of the widest window
        int bestL = 0, bestWindow = 0;

        // Count of zeroes in current window
        int zeroCount = 0;

        // While right boundary of current window doesn't cross
        // right end
        while (wR < arr.length)
        {
            // If zero count of current window is less than m,
            // widen the window toward right
            if (zeroCount <= m)
            {
                if (arr[wR] == 0)
                    zeroCount++;
                wR++;
            }

            // If zero count of current window is more than m,
            // reduce the window from left
            if (zeroCount > m)
            {
                if (arr[wL] == 0)
                    zeroCount--;
                wL++;
            }

            // Update widest window if this window size is more
            if ((wR-wL > bestWindow) && (zeroCount<=m))
            {
                bestWindow = wR-wL;
                bestL = wL;
            }
        }

        // Print positions of zeroes in the widest window
        for (int i=0; i<bestWindow; i++)
        {
            if (arr[bestL+i] == 0)
                System.out.print(bestL+i + " ");
        }
    }

    // Driver method to test the above function
    public static void main(String[] args)
    {
        int m = 2;
        System.out.println("Indexes of zeroes to be flipped are ");

        findZeroes(m);
    }
}
