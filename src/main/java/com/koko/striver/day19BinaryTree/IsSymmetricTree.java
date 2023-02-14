package com.koko.striver.day19BinaryTree;

public class IsSymmetricTree {



    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Symmetric" + isSymmetricTree(root));
    }

    /**
     * moto is root.left.right.right ka mirror hoga root.right.left.left
     * so yhi ka recurssion bna lo bas..
     * this code is quite similar as isIdentical tree only diff is yha recurssion of helper change hoga and bottom wali bhi
     * @param root
     * @return
     */
    private static boolean isSymmetricTree(TreeNode root) {
        if(root == null) return true; // root ka koi role nhi so helper function banana pda.
        return helper(root.left, root.right);
    }

    private static boolean helper(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null || rightRoot == null) return leftRoot == rightRoot; // isko yaad karo nhi to long wala logic which is writter in isIdentical wo wala karo
        return ((leftRoot.data == rightRoot.data) && helper(leftRoot.left, rightRoot.right) && helper(leftRoot.right, rightRoot.left));
    }
}
