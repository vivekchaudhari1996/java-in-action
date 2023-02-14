package com.koko.striver.day20BST;


public class BSTInsertionDeletion {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root = insertBST(root, 5);
        root = insertBST(root, 4);
        root = insertBST(root, 67);
        root = insertBST(root, 55);

//        System.out.println(root.data);
//        System.out.println(root.left.data);
//        System.out.println(root.left.left.data);
        System.out.println(searchBST(root, 4).data);
    }

    private static TreeNode searchBST(TreeNode root, int key) {
        if (root== null || root.data == key) return root;

        if (key < root.data) return searchBST(root.left, key);
        else return searchBST(root.right, key);
    }

    /**
     * O(n) - worst case, in case of skewed tree
     * O(h) - normal
     * @param root
     * @param key
     * @return
     */
    public static TreeNode insertBST(TreeNode root, int key) {
        if (root==null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.data) root.left = insertBST(root.left, key); // yha root.left = something hai
        else root.right = insertBST(root.right, key);
        return root;
    }
}
