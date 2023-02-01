package com.koko.dataStructures.Misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DeleteNodesReturnForest {

    // Q:
    /*
    Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.
     */



    // Example:
    /*
    Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]


Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]]
     */




    // Solution:
    // https://leetcode.com/problems/delete-nodes-and-return-forest/



    static class TreeNode{
        TreeNode right, left;
        int val;
    }
    HashSet<Integer> set = new HashSet<>();
    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int val: to_delete){
            set.add(val);
        }
        helper(root);
        if(!set.contains(root.val)){
            list.add(root);
        }
        return list;
    }

    public TreeNode helper(TreeNode node){
        if(node == null)
            return null;

        node.left = helper(node.left);
        node.right = helper(node.right);

        if(set.contains(node.val)){
            if(node.left != null){
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }
            return null;
        }
        return node;
    }
}
