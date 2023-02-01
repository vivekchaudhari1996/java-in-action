package com.koko.dataStructures.trees;

import java.util.*;

public class BottomViewBinaryTree {

    // Q: A node is included in the bottom view if it can be seen when we look at the tree from the bottom.
    // We can mark straight lines like in the image below and mark them with +ve and -ve indexes.
    // The Last node of every line will be my Bottom view.


    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Pair{
        Node node;
        int hd;

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // TC: O(N)
    // SC: O(N)

    public ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()) {
            Pair temp = q.remove();
            int hd = temp.hd;
            map.put(hd, temp.node.data);
            if(temp.node.left != null) {
                q.add(new Pair(temp.node.left, hd-1));
            }
            if(temp.node.right != null) {
                q.add(new Pair(temp.node.right, hd+1));
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;

    }
}
