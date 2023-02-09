package com.koko.striver.day17BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Pair { // node and position
    Node node;
    int num;
    Pair(Node _node, int _num) {
        num = _num;
        node = _node;
    }
}
public class maxWidthOfTree {
    public static void main(String[] args) {
        /**
         *             1
         *           /  \
         *          3     2
         *         /       \
         *        5         4
         *       /           \
         *      7             6
         */
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(5);
        root.left.left.left = new Node(7);
        root.right = new Node(2);
        root.right.right = new Node(4);
        root.right.right.right = new Node(6);

        int maxWidth = widthOfBinaryTree(root);
        System.out.println("The maximum width of the Binary Tree is "+maxWidth);

    }



    /**
     * moto is find the last and first node position at every level and (r-l+1) calculate
     * we will use the queue to to store the pair(node, position)
     * one imp catch here is - at every level we will assign the fist element as (real) index to avoid the overflow
     *
     * Time Complexity: O(N)
     *
     * Reason: We are doing a simple level order traversal. The inner loop simply traverses the nodes level-wise and doesn’t add to the complexity.
     *
     * Space Complexity: O(N)
     *
     * @param root
     * @return
     */
    private static int widthOfBinaryTree(Node root) {

        if (root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {
            int size = q.size(); // checking the size of queue which will help to get first and last at next level
            int mmin = q.peek().num; // position of current node, will use to reset the next level's first element
            int first = 0, last=0;

            for (int i=0; i<size; i++) {
                int curr_id = q.peek().num-mmin;
                Node node = q.peek().node;
                q.poll();
                if(i==0) first = curr_id;
                if(i==size-1) last = curr_id;
                if(node.left!=null)
                    q.add(new Pair(node.left, curr_id*2+1));
                if(node.right!=null)
                    q.add(new Pair(node.right, curr_id*2+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}
