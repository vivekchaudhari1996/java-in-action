package com.koko.striver.day19BinaryTree;

import com.koko.dataStructures.trees.MaximumPathSumBinaryTree;

class TreeNode {
    TreeNode left;
    int data;
    TreeNode right;
    TreeNode (int data){
        this.left = null;
        this.data = data;
        this.right = null;
    }
}

// Idea:
// Calculate the maxPath through the node as val + (leftMaxPath + rightMaxPath) and update maxi accordingly.
// Return the maxPath when node is not the curving point as val + max(leftMaxPath, rightMaxPath)

public class maxPathSumClass {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int answer = maxPathSum(root);
        System.out.println("The Max Path Sum for this tree is " + answer);
    }

    public static int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    public static int maxPathDown(TreeNode node, int maxValue[]) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left, maxValue));
        int right = Math.max(0, maxPathDown(node.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + node.data);
        return Math.max(left, right) + node.data;
    }
}
