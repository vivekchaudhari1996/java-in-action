package com.koko.striver.day17BinaryTree;

import java.util.ArrayList;

/**
 * Time Complexity: O(N)
 *
 * Space Complexity: O(H)       (H -> Height of the Tree)
 *
 * moto is - traverse to each level and add the first element of each level
 */
public class RightSideViewBinaryTree {
    public static void main(String[] args) {

        /**
         *             1
         *           /  \
         *          2     3
         *         / \   / \
         *        4   5 6  7
         *           /    /\
         *          8    9  10
         */
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

        ArrayList<Integer> leftView;
        leftView = rightViewTraversal(root);

        System.out.println("Right view");
        for (int i=0; i< leftView.size(); i++) {
            System.out.print(" " + leftView.get(i));

        }
    }

    /**
     * O(n) -
     * @param root
     * @return
     */
    private static ArrayList<Integer> rightViewTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, ans, 0);
        return ans;
    }

    private static void helper(Node root, ArrayList<Integer> ans, int level) {
        if(root == null) return;

        // first element of each level will be in element
        if(level == ans.size()) { // ye condition hai kyuki ans me each level par 1 element hi hoga.
            ans.add(root.data);
        }

        helper(root.right, ans, level+1);
        helper(root.left, ans, level+1);
    }
}
