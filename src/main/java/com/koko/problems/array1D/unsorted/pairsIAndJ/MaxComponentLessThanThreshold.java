package com.koko.problems.array1D.unsorted.pairsIAndJ;

public class MaxComponentLessThanThreshold {

    // Question:
    // Given an array, a window must be chosen such that this component maximized where i and j are indices —
    // sum(a[i]...a[j])(j-i+1), but the component must be equal to or less than the threshold
    // (sum(a[i]...a[j])(j-i+1) <= threshold).

    // Example:
    /*
    Input

N: 8
Arr[]: [2,-3,-4,5,5,6,7,8]
Ind: 4
Threshold = 20

Output

One possible answer
[5,5]

Explanation of output
[5, 5] = 10*2 = 20 <= 20 (threshold)
     */


    // Solution:
    // We have to calculate max(sum(a[i]...a[j])*(j-i+1)) <= threshold
    // I think sliding window is fine for this problem.
    // Keep 2 pointer increase right pointer on each iteration.
    // Whenever window is invalid increase left pointer until window become valid.

    // TC: O(n)
    // SC: O(1)

    public static int[] getOptimal(int[] arr, int threshold) {
        int[] result = new int[2];
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        // j is left pointer, i is right pointer
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            // Current num is bigger than current(prev) sum. Discard current(prev) sum. Reinitialize
            if (num > sum) {
                j = i;
                sum = num;
            }
            else {
                sum += num;
                // if current window is not valid, increase left pointer until make it a valid window.
                while (j < i && sum * (i - j + 1) > threshold) {
                    sum -= arr[j];
                    j++;
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                result[0] = j;
                result[1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result1 = getOptimal(new int[] { 2, -3, -4, 5, 5, 6, 7, 8 }, 20);
        System.out.println("indexes: " + result1[0] + " " + result1[1]);
    }


}
