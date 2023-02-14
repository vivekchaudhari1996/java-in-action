package com.koko.striver.day18BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * keep in mind - not always left node ka height+ right node height kyuki
 * what if longest path in not passing from root. see the example
 */
public class DiameterOfTree {
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
        root.right.left.left.left = new TreeNode(8);
        root.right.left.left.left.left = new TreeNode(9);

        int diameter;
        diameter = diameterUsingRecursionOrder(root);

        System.out.println("Diameter using recursion= " + diameter);


    }

    /** post order traversal lagega
     *
     * @param root
     * @return
     */
    public static int diameterUsingRecursionOrder(TreeNode root) {
        if (root==null) return 0;

        int withRoot = height(root.left) + height(root.right); // Snenario when diameter cover the root
        int leftSubTreeDiameter = diameterUsingRecursionOrder(root.left);
        int rightSubTreeDiameter = diameterUsingRecursionOrder(root.right);
        return Math.max(withRoot, Math.max(leftSubTreeDiameter, rightSubTreeDiameter));
    }

    public static int height(TreeNode root) {
        if (root==null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
