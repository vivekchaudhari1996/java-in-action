package com.koko.dataStructures.trees;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Iterative approach using Stack
    // Time Complexity: O(N).
    // SC: O(N) - worst case all nodes are in a list structure.

    static ArrayList< Integer > preOrderTrav(Node curr) {
        ArrayList < Integer > preOrder = new ArrayList < Integer > ();
        if (curr == null)
            return preOrder;

        Stack< Node > s = new Stack < > ();
        s.push(curr);

        while (!s.isEmpty()) {
            Node topNode = s.peek();
            preOrder.add(topNode.data);
            s.pop();
            if (topNode.right != null)
                s.push(topNode.right);
            if (topNode.left != null)
                s.push(topNode.left);
        }
        return preOrder;

    }

    // Recursive approach
    static void preOrderTrav(Node curr, ArrayList < Integer > preOrder) {
        if (curr == null)
            return;

        preOrder.add(curr.data);
        preOrderTrav(curr.left, preOrder);
        preOrderTrav(curr.right, preOrder);
    }

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        ArrayList < Integer > preOrder = new ArrayList < > ();
        preOrder = preOrderTrav(root);

        System.out.print("The preOrder Traversal is : ");
        for (int i = 0; i < preOrder.size(); i++) {
            System.out.print(preOrder.get(i) + " ");
        }

    }

}
