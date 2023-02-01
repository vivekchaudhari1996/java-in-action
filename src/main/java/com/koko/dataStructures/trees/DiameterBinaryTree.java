package com.koko.dataStructures.trees;

public class DiameterBinaryTree {

    // Q: Find the Diameter of a Binary Tree.
    // Diameter is the length of the longest path between any 2 nodes in the tree and
    // this path may or may not pass from the root.

    // Idea: Diameter at given Curving Point = Left Height + Right Height

    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // TC: O(N)
    // SC: O(H) Recursion Stack space (Where “H”  is the height of binary tree )

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
