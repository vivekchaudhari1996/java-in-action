package com.koko.dataStructures.trees;

import java.util.ArrayList;
import java.util.List;

public class RightLeftViewBinaryTree {


    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int data) {
            this.val = data;
            left = null;
            right = null;
        }
    }

    // Time Complexity: O(N)
    // Space Complexity: O(H)

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }

    public List<Integer> lightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        leftView(root, result, 0);
        return result;
    }

    public void leftView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        leftView(curr.left, result, currDepth + 1);
        leftView(curr.right, result, currDepth + 1);


    }
}
