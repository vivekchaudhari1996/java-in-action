package com.koko.striver.day14StackAndQueue;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class slidingWindowMaximumClass {
    public static void main(String[] args) {
        int i, j, n, k = 3, x;
        int arr[]={4,0,-1,3,5,3,6,8};
        int ans[] = maxSlidingWindowUsingPriorityQueue(arr, k);
        System.out.println("Maximum element in every " + k + " window ");
        for (i = 0; i < ans.length; i++)
            System.out.print(ans[i] + "  ");
    }

    /**
     * O(nlogk) time, we can better using the dequeue(DLL) and make it O(n)
     * O(K) space for priority
     * yha kuch nhi kar rhe just using the priority queue to get the larget of k window
     * @param arr
     * @param k
     * @return
     */
    private static int[] maxSlidingWindowUsingPriorityQueue(int[] arr, int k) {

        int counter = 0;
        int[] res = new int[arr.length-k+1];

        // create the maxheap, to get the max element always in O(logK)
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // insert the starting k element
        for (int i=0; i<k; i++) {
            queue.add(arr[i]);
        }

        // store largest element from first k element
        res[counter++] = queue.peek();

        // remove the first element from window queue so that later we can store remaining windows's largest
        queue.remove(arr[0]);

        // now keep travesing the remaining element remove from queue one by one to get the largest for that window
        for (int i=k; i<arr.length; i++) {
            queue.add(arr[i]);

            res[counter++] = queue.peek();

            // remove the non required element from queue
            queue.remove(arr[i-k+1]);
        }
        return res;

    }
}
