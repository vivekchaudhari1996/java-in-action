package com.koko.striver.day20BST;

/**
 * inorder lagao and count badhate rho jaise hi k== count then return
 */
public class KthLargestInBST {
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
        System.out.println(kthLargest(root, 3).data); // 12 ans hona chahiye
    }

    static int count=0;
    private static TreeNode kthLargest(TreeNode root, int k) {
        if (root == null ) return null;

        // basically inorder laga hai yha
        // search in Left subtree
        TreeNode left = kthLargest(root.left, k);
        if(left != null) return left; // yha aage jane se pahle if left have something then that is only the ans no.
        count++;
        if (count == k) return root;
        return kthLargest(root.right, k);
    }
}
