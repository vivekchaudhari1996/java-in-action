package com.koko.striver.day20BST;

public class IS_BT_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean isBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;

        // imp line
        if (root.data < minValue || root.data > maxValue) return false;

        return (isBST(root.left, minValue, root.data) && isBST(root.right, root.data, maxValue));

    }
}
