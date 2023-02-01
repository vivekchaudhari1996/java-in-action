package com.koko.dataStructures.Misc;

import java.util.HashMap;
import java.util.Map;

public class NewHeightOfTreeAfterDeletingSubtree {

    //Q: For every non-root node in a binary tree, return the new height of the binary tree
    // if the subtree rooted at that node were deleted.
    // You are given a pointer to the root of the tree, you need to return a list of pair of integers
    // {X, F(X)} for every node X in the given tree.
    // Here, F(X) represents the updated height of the original tree if the subtree rooted at node X is deleted.

    // The goal is to compute this for all non-root nodes and thus arrive at: [{2, 3}, {3, 1}, {4, 3}, {5, 2}, {6, 2}].


    // Solution:
    // You need to do DFS x 2.
    // First pass to generate the height.
    // Second pass to merge the max(height of another sibling + current depth from root, current max)
    // when you go into a node.

    // OR

    // Run DFS to calculate the height for every node.
    // Run another DFS for calculate the result.
    // Logic : if we want to calculate result for right subtree-root,
    // 1. currDepth + height[root-left] // here root->left is sibling of root->right
    // vice versa for left node.


    // TC: O(N)

    static class Node{
        Node left;
        Node right;
        int val;
    }
    public static Map<Integer, Integer> newHeightOfBinaryTreeAfterDelete(Node root) {
        Map<Integer, Integer> keyToDepth = new HashMap<>();
        buildDepthMap(root, keyToDepth);
        Map<Integer, Integer> result = new HashMap<>();
        buildResult(root, keyToDepth, result, keyToDepth.get(root.val));
        return result;
    }

    private static void buildResult(Node node, Map<Integer, Integer> keyToDepth, Map<Integer, Integer> result, int depth) {

        if (node.left != null){
            int parentLevel = depth - keyToDepth.get(node.val);
            int newDepth = parentLevel + (node.right == null ? 0 :  keyToDepth.get(node.right.val) + 1);
            result.put(node.left.val, newDepth);
            buildResult(node.left, keyToDepth, result, depth);
        }
        if (node.right != null) {
            int parentLevel = depth - keyToDepth.get(node.val);
            int newDepth = parentLevel + (node.left== null ? 0 :  keyToDepth.get(node.left.val) + 1);
            result.put(node.right.val, newDepth);
            buildResult(node.right, keyToDepth, result, depth);
        }
    }

    public static int buildDepthMap(Node node, Map<Integer, Integer> map) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) {
            map.put(node.val, 0);
            return 0;
        }
        int depth = 1 + Math.max(buildDepthMap(node.left, map), buildDepthMap(node.right, map));
        map.put(node.val, depth);
        return depth;
    }
}
