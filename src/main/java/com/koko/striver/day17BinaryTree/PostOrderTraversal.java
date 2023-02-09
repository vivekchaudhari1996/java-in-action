package com.koko.striver.day17BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * exact same as preorder so yaad kar lo usse
 * bas yha 2 stack hai and push ka sequence changes hai left followed by right
 */
public class PostOrderTraversal {
    static ArrayList< Integer > postOrderTrav(Node curr) {

        ArrayList < Integer > postOrder = new ArrayList < > ();
        if (curr == null) return postOrder;

        Stack< Node > s1 = new Stack < > ();
        Stack < Node > s2 = new Stack < > ();
        s1.push(curr);
        while (!s1.isEmpty()) {
            curr = s1.peek();
            s1.pop();
            s2.push(curr); // in preorder yha ans me add karte hai but yha nhi karenge yha extra stack me store karenge
            if (curr.left != null)
                s1.push(curr.left);
            if (curr.right != null) // sequence change hai
                s1.push(curr.right);
        }
        while (!s2.isEmpty()) { // reverse the s2 and we will have the ans.
            postOrder.add(s2.peek().data);
            s2.pop();
        }
        return postOrder;
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

        ArrayList < Integer > postOrder;
        postOrder = postOrderTrav(root);

        System.out.println("The postOrder Traversal is : ");
        for (int i = 0; i < postOrder.size(); i++) {
            System.out.print(postOrder.get(i) + " ");
        }

        ArrayList < Integer > postOrder1 = new ArrayList<>();
        postOrderRecursive(root, postOrder1);

        System.out.println("The postOrder Traversal is : ");
        for (int i = 0; i < postOrder1.size(); i++) {
            System.out.print(postOrder1.get(i) + " ");
        }
    }

    private static void postOrderRecursive(Node root, ArrayList<Integer> postOrder1) {
        if(root==null) return;
        postOrderRecursive(root.left, postOrder1);
        postOrderRecursive(root.right, postOrder1);
        postOrder1.add(root.data);
    }
}
