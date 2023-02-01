package com.koko.dataStructures.trees;

import java.util.*;

public class TopViewBinaryTree {

    // We can mark straight lines like in the image below and mark them with +ve and -ve indexes.
    // The first node of every line will be my top view.

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

    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.hd;
            Node temp = it.node;
            map.computeIfAbsent(hd, k -> temp.data);
            if(temp.left != null) {

                q.add(new Pair(temp.left, hd - 1));
            }
            if(temp.right != null) {

                q.add(new Pair(temp.right, hd + 1));
            }
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;

    }
}
