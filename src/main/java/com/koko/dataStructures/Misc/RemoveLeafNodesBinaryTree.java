package com.koko.dataStructures.Misc;

import java.util.ArrayList;
import java.util.List;

public class RemoveLeafNodesBinaryTree {

    //Q:
    // Given a binary tree, the task is to:
    //
    //Print all the leaf nodes and then delete them all.
    //Repeat this process till the tree becomes empty.


    // Solution:

    // Instead of doing the traversal multiple time simply traverse only once
    // and at the same time calculate the depth of each node.
    //Then sort the nodes as per depth and will get first leaf nodes at depth 0,
    // second iteration leaf nodes at depth 1 and so on.
    // Store the node value in a map as per depth (depth being key and value of the node as an element in the vector)



    // Sol1:
    // Using DFS without sorting
    // https://leetcode.com/problems/find-leaves-of-binary-tree/solution/

    // TC: O(N)
    // SC: O(N)

    static class TreeNode{
        TreeNode left, right;
        int val;
    }

    class Solution {

        private List<List<Integer>> solution;

        private int getHeight(TreeNode root) {

            // return -1 for null nodes
            if (root == null) {
                return -1;
            }

            // first calculate the height of the left and right children
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            int currHeight = Math.max(leftHeight, rightHeight) + 1;

            if (this.solution.size() == currHeight) {
                this.solution.add(new ArrayList<>());
            }

            this.solution.get(currHeight).add(root.val);

            return currHeight;
        }

        public List<List<Integer>> findLeaves(TreeNode root) {
            this.solution = new ArrayList<>();

            getHeight(root);

            return this.solution;
        }
    }



    // Sol2:
    // C++ code
    // TC: O(N), SC: O(N)


    /*
    // A Binary Tree Node
struct Node {
    int data;
    struct Node *left, *right;
};

map<int, vector<int> > resultMap;

// Function to store depth of each nodes
int fillMap(Node* root)
{
    if (root == nullptr)
        return 0;
    int LsubTreeDepth = fillMap(root->left);
    int RsubTreeDepth = fillMap(root->right);
    int depth = max(LsubTreeDepth,
                    RsubTreeDepth)
                + 1;
    resultMap[depth].push_back(root->data);
    return depth;
}

// Print and remove leaf nodes
void printLeafNodes(Node* root)
{

    // If node is null, return
    if (!root)
        return;

    // maxDepth from tree
    int maxDepth = fillMap(root);
    for (int i = 1; i <= maxDepth; i++) {
        vector<int> tempVector
            = resultMap[i];
        int vSize = tempVector.size();

        // Print leaf nodes
        // from each iteration
        cout << "Iteration " << i << " : ";
        for (int j = 0; j < vSize; j++)
            cout << tempVector[j] << " ";
        cout << "\n";
    }
}

// Utility function to
// create a new tree node
Node* newNode(int data)
{
    Node* temp = new Node;
    temp->data = data;
    temp->left = temp->right = NULL;
    return temp;
}

// Driver Code
int main()
{
    // Create binary tree
    Node* root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);

    // Print leaf nodes of the given tree
    printLeafNodes(root);
    return 0;
}
     */
}
