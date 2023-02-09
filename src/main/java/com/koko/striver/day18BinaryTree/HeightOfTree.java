package com.koko.striver.day18BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);

        int ans;
        ans = heightUsingRecursionOrder(root);

        System.out.println("height using recursion= " + ans);

        int ans1;
        ans1 = heightUsinglevelOrder(root);

        System.out.println("height using level order= " + ans);

    }

    /** post order traversal lagega
     *
     * @param root
     * @return
     */
    public static int heightUsingRecursionOrder(TreeNode root) {
        if (root==null) return 0;

        int leftSubTreeHeight = heightUsingRecursionOrder(root.left);
        int rightSubTreeHeight = heightUsingRecursionOrder(root.right);

        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }

    /**
     * level order traversal use karenge.
     * each level par level++ karnege and final value of level will the height
     */

    public static int heightUsinglevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> levelOrder = new ArrayList<>();
        int level_or_height = 0;
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);
                levelOrder.add(q.poll().data);
            }
            level_or_height++;
        }
        return level_or_height;
    }
}
