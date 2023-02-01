package com.koko.dataStructures.Misc;

public class RemoveLeafNodesBST {

    // Q:
    // We have given a binary search tree and we want to delete the leaf nodes from the binary search tree.



    // Solution:
    // We traverse given Binary Search Tree in inorder way.
    // During traversal, we check if current node is leaf, if yes, we delete it.
    // Else we recur for left and right children.
    // An important thing to remember is, we must assign new left and right children
    // if there is any modification in roots of subtrees.



    // Java program to delete leaf Node from
// binary search tree.

        static class Node {
            int data;
            Node left;
            Node right;
        }

        // Create a newNode in binary search tree.
        static Node newNode(int data)
        {
            Node temp = new Node();
            temp.data = data;
            temp.left = null;
            temp.right = null;
            return temp;
        }

        // Insert a Node in binary search tree.
        static Node insert(Node root, int data)
        {
            if (root == null)
                return newNode(data);
            if (data < root.data)
                root.left = insert(root.left, data);
            else if (data > root.data)
                root.right = insert(root.right, data);
            return root;
        }

        // Function for inorder traversal in a BST.
        static void inorder(Node root)
        {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.data + " ");
                inorder(root.right);
            }
        }

        // Delete leaf nodes from binary search tree.
        static Node leafDelete(Node root)
        {
            if (root == null) {
                return null;
            }
            if (root.left == null && root.right == null) {
                return null;
            }

            // Else recursively delete in left and right
            // subtrees.
            root.left = leafDelete(root.left);
            root.right = leafDelete(root.right);

            return root;
        }

        // Driver code
        public static void main(String[] args)
        {
            Node root = null;
            root = insert(root, 20);
            insert(root, 10);
            insert(root, 5);
            insert(root, 15);
            insert(root, 30);
            insert(root, 25);
            insert(root, 35);
            System.out.println("Inorder before Deleting the leaf Node. ");
            inorder(root);
            System.out.println();
            leafDelete(root);
            System.out.println("INorder after Deleting the leaf Node. ");
            inorder(root);
        }

// This code is contributed by Prerna saini

}
