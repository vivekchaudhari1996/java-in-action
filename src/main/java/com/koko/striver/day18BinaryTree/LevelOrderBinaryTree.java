package com.koko.striver.day18BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
public class LevelOrderBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);

        ArrayList<Integer> ans;
        ans = levelOrder(root);

        System.out.println("Level order");
        for (int it: ans) {
            System.out.print(" " + it);
        }
    }

    /**
     * O(n) and O(n)
     * moto is - put the left and right of node and keep removing the using one.
     * have the while loop so remaining non required bhi remove karke add karte rho.
     * @param root
     * @return
     */
    public static ArrayList<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            if(q.peek().left != null) q.add(q.peek().left); // dont get confuse, peek means jo sabse pahle insert hua hoga
            if(q.peek().right != null) q.add(q.peek().right);
            ans.add(q.poll().data); // dont think it will cause issue if only one, check the heightofTreecode in case needed easy solution
        }
        return ans;
    }
}
