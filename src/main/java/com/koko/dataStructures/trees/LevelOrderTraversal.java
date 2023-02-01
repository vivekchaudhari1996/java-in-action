package com.koko.dataStructures.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // TC: O(N)
    // SC: O(N)

    public List<Integer> levelOrder(Node root) {

        Queue<Node> queue = new LinkedList<Node>();
        List<Integer> wrapList = new LinkedList<>();

        if(root == null) return wrapList;
        queue.offer(root);

        while(!queue.isEmpty()){

            if(queue.peek().left != null)
                queue.offer(queue.peek().left);

            if(queue.peek().right != null)
                queue.offer(queue.peek().right);

            wrapList.add(queue.poll().data);
        }
        return wrapList;
    }

    // To have levels in List
    public List<List<Integer>> levelOrderLevl(Node root) {

        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if(root == null) return wrapList;
        queue.offer(root);

        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> sublist = new LinkedList<>();
            for(int i=0;i<level;i++){
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);

                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);
                sublist.add(queue.poll().data);
            }
            wrapList.add(sublist);
        }
        return wrapList;
    }
}
