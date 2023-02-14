package com.koko.striver.day20BST;

class TreeNode{
    TreeNode left;
    int data;
    TreeNode right;
    TreeNode next;

    TreeNode(int d) {
        this.left = null;
        this.data = d;
        this.right = null;
        this.next = null;
    }
}
/**
 * Perfect binary tree(jiske dono ya ek bhi child nhi, last node ek hi level par honge) me right se connect
 * yha contrain tha ki no need to use the extra memory so used the
 * recursion otherwise level order(height wala formula laga dete)
 */
public class PopulateNextRightPointer {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root = pointToNextRightNode(root);

        System.out.println(root.left.next.data + "should be 3");
        System.out.println(root.left.right.next.data + "should be 6");

    }

    private static TreeNode pointToNextRightNode(TreeNode root) {
        if (root == null) return null;

        // very good solution just visualize
        if(root.left!=null) root.left.next = root.right;
        if(root.right!=null && root.next!=null ) root.right.next = root.next.left;

        // keep the recursion for child.
        pointToNextRightNode(root.left);
        pointToNextRightNode(root.right);
        return root;
    }
}
