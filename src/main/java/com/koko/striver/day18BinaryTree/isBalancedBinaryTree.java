package com.koko.striver.day18BinaryTree;

/**
 * keep in mind - balance is nothing but diff of left and right should be less than or equal to 1
 * what if longest path in not passing from root. see the example
 */
public class isBalancedBinaryTree {
    public static void main(String[] args) {
        /**       1
         *       /  \
         *      2     3
         *            /\
         *           5  6
         *          /
         *         7
         *        /
         *       8
         *      /
         *     9
         *    here path is not passing from root so diameter should be 7 (not 6 :) )
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
//        root.right.left.left.left = new TreeNode(8);
//        root.right.left.left.left.left = new TreeNode(9);

        System.out.println("Tree is = " + isBalanced(root));


    }

    public static boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        int lH = height(root.left);
        int rH = height(root.right);
        if(Math.abs(lH-rH) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    public static int height(TreeNode root) {
        if (root==null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
