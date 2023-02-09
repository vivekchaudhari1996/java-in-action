package com.koko.striver.day17BinaryTree;

import java.util.ArrayList;
import java.util.Stack;


class Node {
    Node left;
    int data;
    Node right;

    Node(int data) {
        left = null;
        this.data = data;
        right = null;
    }
}
public class InOrderTraversal {

    public static void main(String[] args) {
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


        // iterative method using stack
        ArrayList<Integer> inOrder; // yha new object nhi banaya as we are assigning it with return value
        inOrder = inOrder(root);

        for (int i=0; i<inOrder.size(); i++) {
            System.out.println(" " + inOrder.get(i));
        }

        // recursive
        ArrayList<Integer> inOrder1 = new ArrayList<>(); // jabki yha banaya new object kyuki isika ref pass kar rhe
        inOrderRecursive(root, inOrder1);

        for (int i=0; i<inOrder1.size(); i++) {
            System.out.println(" " + inOrder1.get(i));
        }


    }

    /**
     * time O(n) hi hai dont think it will be exponential
     * space O(n) as recursion have its own stack
     * @param root
     * @return
     */

    // if we want to return something then we can use the helper function same as we are using in leftSideView code
    private static void inOrderRecursive(Node root, ArrayList<Integer> inOder1) { // return type void hai so pass kiya inorder1
        if (root == null) return;
        inOrderRecursive(root.left, inOder1);
        inOder1.add(root.data);
        inOrderRecursive(root.right, inOder1);
    }

    /**
     * O(n) space due to auxilary stack and O(n) due to travesal
     * moto is - keep traversing to left of tree until we get the null also keep adding the element in stack
     * once we get the null pop the element from stack then move to right side of tree
     * @param root
     * @return
     */
    private static ArrayList<Integer> inOrder(Node root) {
        Stack<Node> st = new Stack<>(); // to store the element until we ge the null
        ArrayList<Integer> ans = new ArrayList<>();

        while(true) {
            if (root != null) { // left side move hona
                st.push(root);
                root = root.left;
            } else { // now it's time to pop the element as we are at left side of tree
                if(st.empty()) break; // complete ho gya hai traversal
                root = st.peek(); // currently root was null so assigning it correct node
                ans.add(root.data);
                st.pop();
                root = root.right;
            }
        }
        return ans;
    }
}
