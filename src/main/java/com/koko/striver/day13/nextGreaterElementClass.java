package com.koko.striver.day13;

import java.util.Stack;

public class nextGreaterElementClass {
    public static void main(String[] args) {
        int arr[] = {5,7,1,2,6,0};

        int arr2[] = nextGreaterElementInNormalArray(arr);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        int arr3[] = nextGreaterElementInCircularArray(arr);
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }

    /**
     * traverse from right array.
     * for the rightmost  -1
     * then store the rightmost element in stack as it could be the next largest for others
     * for next element we keep popping from the stack untill we find the greater element. after that put this in stack
     * dont think we get the wrong answer after popping as we are putting the element in stack for whom we are popping
     *
     * @param arr
     * @return
     */
    private static int[] nextGreaterElementInNormalArray(int[] arr) {
        int n = arr.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i>=0; i--) {

            // chote ko remove karte jao
            while (!st.isEmpty() && st.peek() < arr[i]) {
                st.pop();
            }

            //now assign the greater from stack
            if (st.isEmpty()) {
                nge[i] = -1; // case jab stack empty hai
            } else {
                nge[i] = st.peek();
            }

            // push the new element in stack
            st.push(arr[i]);
        }
        return nge;
    }

    /**
     * just need to write the arr 2 times 5,7,1,2,6,0,5,7,1,2,6,0
     * perform the activity only for i<n
     * yhi original question hai
     * @param arr
     * @return
     */
    private static int[] nextGreaterElementInCircularArray(int[] arr) {
        int n = arr.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2*n-1; i>=0; i--) {

            // chote ko remove karte jao
            while (!st.isEmpty() && st.peek() <= arr[i%n]) {
                st.pop();
            }

            //now assign the greater from stack
            if(i<n) {
                if (st.isEmpty()) {
                    nge[i] = -1; // case jab stack empty hai
                } else {
                    nge[i] = st.peek();
                }
            }

            // push the new element in stack
            st.push(arr[i%n]);
        }
        return nge;
    }
}
