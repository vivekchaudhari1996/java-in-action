package com.koko.dataStructures.trees;

import java.util.LinkedList;

public class MaxDepth {

    // Q: Find the Maximum Depth of Binary Tree.
    // Maximum Depth is the count of nodes of the longest path from the root node to the leaf node.

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Recursive
    // 1 + max(depth of left subtree, depth of right subtree)

    // TC: O(N), since we have to visit every node.
    // SC: O(H) Recursion Stack space, where “H”  is the height of the binary tree.

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }

    // Iterative approach
    // the depth of the Binary Tree is the number of levels in the binary tree.
    // level order traversal on the binary tree and keep a count of the number of levels,
    // it will be our answer.

    // TC: O(N)
    // SC: O(N)
    private static int levelOrder( TreeNode root ){
        if( root == null ){
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int level = 0;
        while( queue.size() > 0 ){
            int size = queue.size();

            while( size-- > 0 ){
                TreeNode remNode = queue.removeFirst();
                if( remNode.left != null ){
                    queue.addLast( remNode.left );
                }
                if( remNode.right != null ){
                    queue.addLast( remNode.right );
                }
            }
            level++;
        }
        return level;
    }
}
