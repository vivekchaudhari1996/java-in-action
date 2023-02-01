package com.koko.dataStructures.trees;

import java.util.ArrayList;

public class RootToNodePath {

    // Q: We are given a binary tree T and a node V. We need to print a path from the root of the tree to the node.

    // Idea:
    // Use Inorder traversal and maintain an array as you visit.
    // Use flags to remove element from array if not found in that subtree.

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // TC: O(N)
    // SC: O(N)

    static boolean getPath(Node root, ArrayList < Integer > arr, int x) {
        // if root is NULL
        // there is no path
        if (root == null)
            return false;

        // push the node's value in 'arr'
        arr.add(root.data);

        // if it is the required node
        // return true
        if (root.data == x)
            return true;

        // else check whether the required node lies
        // in the left subtree or right subtree of
        // the current node
        if (getPath(root.left, arr, x) ||
                getPath(root.right, arr, x))
            return true;

        // required node does not lie either in the
        // left or right subtree of the current node
        // Thus, remove current node's value from
        // 'arr'and then return false
        arr.remove(arr.size() - 1);
        return false;
    }

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right = new Node(3);

        ArrayList< Integer > arr = new ArrayList < > ();

        boolean res;
        res = getPath(root, arr, 7);

        System.out.print("The path is ");
        for (int it: arr) {
            System.out.print(it + " ");
        }

    }
}
