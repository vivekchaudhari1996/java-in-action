package com.koko.striver.day20BST;

/**
 * floor is nothing but just smaller or same value in BST
 * ceil means barabar or just bada
 * O(h) hoga
 */
public class FloorAndCeilInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(30);
        /**             10
         *             /  \
         *           5     15
         *                /  \
         *              12    30
         */
        System.out.println(floor(root, 14).data); // 12 ans hona chahiye
        System.out.println(ceil(root, 9).data); //
    }

    private static TreeNode floor(TreeNode root, int key) {
        TreeNode floor = new TreeNode(-1);
        while(root != null) {
            if (key == root.data) return root; // when key is same as root
            else if (key < root.data) root = root.left; // to traverse left side
            else {
                floor = root; // ye line important hai.
                root = root.right;
            }
        }
        return floor;
    }

    private static TreeNode ceil(TreeNode root, int key) {
        TreeNode ceil = new TreeNode(-1);
        while(root != null) {
            if (key == root.data) return root;
            else if (key > root.data) root = root.right;
            else {
                ceil = root;
                root = root.left;
            }
        }
        return ceil;
    }
}
