package com.koko.dataStructures.trie;

public class CountOfInversionsInArrayTrie {


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
    // We will iterate backwards in the array and store each element into the Trie. To store a number in Trie we
    // have to break the number into its binary form.
    // At any point, while we are storing the bits, we happen to move to the right pointer
    // (i.e the bit is 1) we will check if the left child exists then this means there are numbers
    // which are smaller than the current number who are already been stored into the Trie,
    // these numbers are only the inversion count so we will add these to the count.

    // Time Complexity: O(Nlog(N))
    // Auxiliary Space: O(Nlog(N))


    static class Node
    {
        int count;
        Node left;
        Node right;
    };
    static int ans;

    // function to initialize
// new node
    static Node makeNewNode()
    {
        Node temp = new Node();
        temp.count = 1;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    // Insert element in trie
    static void insertElement(int num,
                              Node root)
    {
        // Converting the number
        // into binary form
        for (int i = 63; i >= 0; i--)
        {
            // Checking if the i-th
            // bit ios set or not
            int a = (num & (1 << i));

            // If the bit is 1
            if (a != 0)
            {
                // if the bit is 1 that means
                // we have to go to the right
                // but we also checks if left
                // pointer exists i.e there is
                // at least a number smaller than
                // the current number already in
                // the trie we add that count
                // to ans
                if (root.left != null)
                    ans += root.left.count;

                // If right pointer is not null
                // we just iterate to that
                // position and increment the count
                if (root.right != null)
                {
                    root = root.right;
                    root.count += 1;
                }

                // If right is null we add a new
                // node over there and initialize
                // the count with 1
                else
                {
                    Node temp = makeNewNode();
                    root.right = temp;
                    root = root.right;
                }
            }

            // if the bit is 0
            else
            {
                // We have to iterate to left,
                // we first check if left
                // exists? if yes then change
                // the root and the count
                if (root.left != null)
                {
                    root = root.left;
                    root.count++;
                }

                // otherwise we create
                // the left node
                else
                {
                    Node temp = makeNewNode();
                    root.left = temp;
                    root = root.left;
                }
            }
        }
    }

    // function to count
// the inversions
    static int getInvCount(int arr[], int n)
    {
        Node head = makeNewNode();
        ans = 0;
        for (int i = n - 1; i >= 0; i--)
        {
            // inserting each element in Trie
            insertElement(arr[i],
                    head);
        }

        return ans;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 8, 4, 2, 1 };
        int n = arr.length;

        System.out.print("Number of inversions are : "
                + getInvCount(arr, n));
    }
}
