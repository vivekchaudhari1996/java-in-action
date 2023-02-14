package com.koko.striver.day19BinaryTree;

public class ConstructUsingInorderAndPostorder {
    public static void main(String[] args) {

        int inorder[] = {40,20,50,10,60,30};
        int postorder[] = {40,50,20,60,30,10};
        TreeNode root = buildTree(postorder, inorder);

        /**
         *         10
         *        /  \
         *      20    30
         *     / \     \
         *   40   50    60
         */
        System.out.println(root.left.right.data);
    }

    /**
     * moto - O(n) and O(n)
     * postorder ka last wala root hoga and then find the same in inorder list and now
     * do the same process for left section of inorder list and right section of inorder
     *
     * thoda yaad karna hoga.
     * @param postorder
     * @param inorder
     * @return
     */
    private static TreeNode buildTree(int[] postorder, int[] inorder) {
        p = inorder.length-1;
        return helper(inorder.length-1,0, postorder, inorder);
    }

    static int p = 0;
    private static TreeNode helper(int iE, int iS, int[] postorder, int[] inorder) {
        if(iE<iS) return null;
        int rootInorder = findRootInorder(postorder[p], iE, iS, inorder);

        TreeNode root = new TreeNode(inorder[rootInorder]);
        p--;

        root.right = helper(iE, rootInorder+1, postorder, inorder); // swap hua hai left and right p ko shi rakne ke liye
        root.left = helper(rootInorder-1, iS, postorder, inorder);

        return root;
    }

    private static int findRootInorder(int root, int iE, int iS, int[] inorder) {
        for(int i = iE; i>=iS; i--) {
            if(root == inorder[i]) {
                return i;
            }
        }
        return -1;
    }
}
