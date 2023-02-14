package com.koko.striver.day18BinaryTree;

public class isIdenticalTree {
    static boolean isIdentical(TreeNode node1, TreeNode node2) {


//        if (node1 == null && node2 == null) // reach to bottom both null
//            return true;
//        else if (node1 == null || node2 == null) // if one is not null then controller reach here
//            return false;

        // uppar wala code aaise likhe, yhi wala isSymmetric me bhi hai
        if(node1 == null || node2 == null)
            return node1 == node2;

        return ((node1.data == node2.data) && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right));
    }


    public static void main(String args[]) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);

        if (isIdentical(root1, root2))
            System.out.println("Two Trees are identical");
        else System.out.println("Two trees are non-identical");

    }
}
