package com.koko.dataStructures.trees;

public class SymmetricBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int data) {
            this.val = data;
            left = null;
            right = null;
        }
    }

    // TC: O(N)
    // SC: O(N)

    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
