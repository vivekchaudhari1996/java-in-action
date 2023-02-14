package com.koko.striver.day20BST;

public class BSTUsingPreoder {
    public static void main(String[] args) {
        int[] preorder = {8, 5, 3, 6, 9};
        /**
         *         8
         *        / \
         *       5   9
         *      / \
         *     3   6
         */
        TreeNode root = createBSTUsingPreorder(preorder, 0, preorder.length-1);
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.left.left.data);
        System.out.println(root.left.right.data);
        System.out.println(root.right.data);
    }

    private static TreeNode createBSTUsingPreorder(int[] preorder, int start, int end) {
        if (start>end) return null;

        TreeNode root = new TreeNode(preorder[start]);

        // now turn to find the index in preorder which will decide left and right section
        int i;
        for (i=start; i<=end; i++ ) {
            if (preorder[i] > root.data) break;
        }
        root.left = createBSTUsingPreorder(preorder, start+1, i-1);
        root.right = createBSTUsingPreorder(preorder, i, end);
        return root;
    }

}
