package com.koko.striver.day18BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class zigzagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> zigzag;
        zigzag = zigzagUsingHeightConcept(root);

        for(int i=0; i<zigzag.size(); i++) {
            for(int j=0; j<zigzag.get(i).size(); j++) {
                System.out.print(" "+zigzag.get(i).get(j));
            }
            System.out.println();
        }
    }

    /**
     * moto is - use the levelorder travesal which is exact same as find the height
     * as well as maintain a flag to make it zigzag
     * Time Complexity: O(N)
     *
     * Space Complexity: O(N)
     * @param root
     * @return
     */
    private static ArrayList<ArrayList<Integer>> zigzagUsingHeightConcept(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> sublist = new ArrayList<>();
            flag = !flag;
            while(size-- > 0) {
                if (q.peek().left != null) q.add(q.peek().left);
                if (q.peek().right != null) q.add(q.peek().right);

                // trick here only, apart from this code is exact level order traversal
                if (flag) {
                    sublist.add(q.poll().data);
                } else {
                    sublist.add(0, q.poll().data); // in this way we can add in reverse order
                }
            }
            ans.add(sublist);
        }
        return ans;
    }
}
