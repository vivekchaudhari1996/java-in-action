package com.koko.striver.day17BinaryTree;

import java.util.ArrayList;

public class rootToNodePath {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        ArrayList<Integer> ans = new ArrayList<>();

        boolean res;
        res = getPath(root, ans, 8);
        System.out.println("Path is -->");
        for(int it: ans) {
            System.out.println(it + " ");
        }
    }

    /**
     * moto is - use the Inorder traversal easy hai issi liye
     * keep adding the element in arr, if node is not the correct then return the false so that
     * we can delete it from the arr
     *
     * Time Complexity: O(N)
     *
     * Reason: We are doing a simple tree traversal.
     *
     * Space Complexity: O(N)
     *
     * Reason: In the worst case (skewed tree), space complexity can be O(N).
     *
     * @param root
     * @param ans
     * @param x
     * @return
     */
    private static boolean getPath(Node root, ArrayList<Integer> arr, int x) {
        // if root is NULL
        // there is no path
        if (root == null)
            return false;

        // push the node's value in 'arr'
        arr.add(root.data);

        // if it is the required node means we are on 8
        // return true
        if (root.data == x)
            return true;

        // else check whether the required node lies
        // in the left subtree or right subtree of
        // the current node
        if (getPath(root.left, arr, x) || getPath(root.right, arr, x))
            return true;

        // required node does not lie either in the
        // left or right subtree of the current node
        // Thus, remove current node's value from
        // 'arr'and then return false
        arr.remove(arr.size() - 1);
        return false;
    }
}
