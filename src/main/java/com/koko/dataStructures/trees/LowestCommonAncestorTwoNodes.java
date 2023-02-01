package com.koko.dataStructures.trees;

public class LowestCommonAncestorTwoNodes {

    // Q: the lowest node in T that has both x and y as descendants (where we allow a node to be a descendant of itself.


    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // TC: O(N)
    // SC: O(N)

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //result
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { //both left and right are not null, we found our result
            return root;
        }
    }
}
