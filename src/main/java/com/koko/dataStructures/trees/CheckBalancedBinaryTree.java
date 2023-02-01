package com.koko.dataStructures.trees;

public class CheckBalancedBinaryTree {

    // Q: Check whether the given Binary Tree is a Balanced Binary Tree or not.
    // A binary tree is balanced if, for all nodes in the tree,
    // the difference between left and right subtree height is not more than 1.

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Time Complexity: O(N)
    // SC: O(H) Recursion Stack space (Where “H”  is the height of binary tree)

    public boolean isBalanced(TreeNode root) {
        return dfsHeight (root) != -1;
    }
    int dfsHeight (TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight (root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
