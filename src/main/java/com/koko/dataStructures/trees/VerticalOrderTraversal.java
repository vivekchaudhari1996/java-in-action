package com.koko.dataStructures.trees;

import java.util.*;

public class VerticalOrderTraversal {

    // we divide the binary tree in verticals from left to right,
    // and in every vertical, we print the nodes from top to bottom.

    // There can be duplicate values among the nodes.
    // If two or more nodes are overlapping at the same position(here 10 and 9),
    // then they will be printed in ascending order.


    // Idea:
    // Node(val, x-vertical, level)
    // left child -> val, x-vertical-1, level +1
    // right child-> val, x-vertical+1, level+1
    // TreeMap<Vertical, TreeMap<Level, PriorityQueue<Integer>>>


    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Tuple {
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode _node, int _row, int _col) {
            node = _node;
            row = _row;
            col = _col;
        }
    }

    // Time Complexity: O(N*logN)
    // Space Complexity: O(N)

    public static List < List < Integer >> findVertical(TreeNode root) {
        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue< Tuple > q = new LinkedList < Tuple > ();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;


            if (!map.containsKey(x)) {
                map.put(x, new TreeMap < > ());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue < > ());
            }
            map.get(x).get(y).offer(node.data);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap< Integer, PriorityQueue< Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List < List < Integer >> list = new ArrayList< >();
        list = findVertical(root);

        System.out.println("The Vertical Traversal is : ");
        for (List< Integer > it: list) {
            for (int nodeVal: it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }

    }


}
