package com.koko.striver.day17BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
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
        ArrayList<Integer> preOrder; // yha new object nhi banaya as we are assigning it with return value
        preOrder = preOrder(root);

        for (int i=0; i<preOrder.size(); i++) {
            System.out.println(" " + preOrder.get(i));
        }

        // recursive
        ArrayList<Integer> preOrder1 = new ArrayList<>(); // jabki yha banaya new object kyuki isika ref pass kar rhe
        preOrderRecursive(root, preOrder1);

        for (int i=0; i<preOrder1.size(); i++) {
            System.out.println(" " + preOrder1.get(i));
        }
    }

    /**
     * O(n), O(n)
     * @param root
     * @param
     */
    private static void preOrderRecursive(Node root, ArrayList<Integer> preOrder1) {
        if (root == null) return;
        preOrder1.add(root.data);
        preOrderRecursive(root.left, preOrder1);
        preOrderRecursive(root.right, preOrder1);
    }

    /**
     * O(n), O(n)
     * moto is - first push the root
     * then run the loop until stack will get empty
     * pop and store in ans then push the right (kyuki stack hai)
     * then push the left
     *
     * @param root
     * @return
     */
    private static ArrayList<Integer> preOrder(Node root) {
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        st.push(root); // isse to daal hi do

        while(!st.isEmpty()) {
            Node topNode = st.peek();
            ans.add(topNode.data);
            st.pop();  // nikaal diya stack se
            // right first add karenge as
            if (topNode.right!=null) st.push(topNode.right);
            if (topNode.left!=null) st.push(topNode.left);
        }
        return ans;
    }
}
