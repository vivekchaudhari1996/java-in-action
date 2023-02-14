package com.koko.striver.day19BinaryTree;

public class ConstructUsingInorderAndPreorder {
    public static void main(String[] args) {
        int preorder[] = {10,20,40,50,30,60};
        int inorder[] = {40,20,50,10,60,30};
        TreeNode root = buildTree(preorder, inorder);

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
     * preorder ka first wala root hoga and then find the same in inorder list and now
     * do the same process for left section of inorder list and right section of inorder
     *
     * thoda yaad karna hoga.
     * @param preorder
     * @param inorder
     * @return
     */
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, inorder.length-1, preorder, inorder);
    }

    static int p = 0;
    private static TreeNode helper(int iS, int iE, int[] preorder, int[] inorder) {
        if(iS>iE) return null;
        int rootInorder = findRootInorder(preorder[p], iS, iE, inorder);

        TreeNode root = new TreeNode(inorder[rootInorder]);
        p++;

        root.left = helper(iS,rootInorder-1, preorder, inorder);
        root.right = helper(rootInorder+1, iE, preorder, inorder);
        return root;
    }

    private static int findRootInorder(int root, int iS, int iE, int[] inorder) {
        for(int i = iS; i<=iE; i++) {
            if(root == inorder[i]) {
                return i;
            }
        }
        return -1;
    }
}
