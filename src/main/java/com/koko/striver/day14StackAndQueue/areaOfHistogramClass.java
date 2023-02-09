package com.koko.striver.day14StackAndQueue;

public class areaOfHistogramClass {
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3, 1};
        int n = 7;
        System.out.println("The largest area in the histogram is " + largestAreaBrute(arr, n));
    }

    /**
     * Brute force is find the left smaller and right smaller in that way we will get the width
     * height will be arr[i] so area = width * height
     * O(n*n)
     * if want to improve the logic then use the next_smaller_element logic using the stack. ll do later
     * @param arr
     * @param n
     * @return
     */
    private static int largestAreaBrute(int[] arr, int n) {
        int maxArea = 0;
        for (int i=0; i<n; i++) {

            // find the left smaller
            int left=i;
            for (int j=i; j>=0; j--) {
                if (arr[j]<arr[i]) {
                    left = j+1;
                    break;
                }
            }

            // find the right smaller
            int right=i;
            for (int j=i; j<n; j++) {
                if (arr[j]<arr[i]) {
                    right = j-1;
                    break;
                }
            }

            // area
            maxArea = Math.max(maxArea, (right-left+1)*arr[i]);
        }
        return maxArea;
    }
}
