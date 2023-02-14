package com.koko.striver.day18BinaryTree;

/**
 * keep in mind - not always left node ka height+ right node height kyuki
 * what if longest path in not passing from root. see the example
 */
public class LowestCommonAncestorOfTree {
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

        TreeNode lca;
        lca = lca(root, root.right.left.left.left.left, root.right.right);

        System.out.println("lca using recursion= " + lca.data);


    }

    /**
     * Little tricky so if u get confuse..reach the striver video
     * moto - basically here we will return current value to parent if current value is part of pair for whom we are looking for ancestor
     * @param root
     * @return
     */
    private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==root || q==root) return root; // here first time sending back parent when founded the one of the value in pair

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        // now turn to pass the founded ancestor to root
        if (left==null) return right;
        else if (right==null) return left;
        else return root;
    }

}
