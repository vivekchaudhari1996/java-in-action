package com.koko.striver.day23Graph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Time complexity - for undirected O(N)+O(2E)
 * Space - O(3N), for dfs-stack, visited-array, adjacency-List
 */
public class DFSTraversal {
    public static void main(String[] args) {

        // creating the array which have 5 vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0; i<5; i++) {
            adj.add(new ArrayList<>());
        }

        /**
         *         0----- 1
         *         |    / | \
         *         |  /   |   2
         *         4------3 /
         */
//        adj.get(0).add(1);
//        adj.get(0).add(4);
//
//        adj.get(1).add(0);
//        adj.get(1).add(2);
//        adj.get(1).add(3);
//        adj.get(1).add(4);
//
//        adj.get(2).add(1);
//        adj.get(2).add(3);
//
//        adj.get(3).add(1);
//        adj.get(3).add(2);
//        adj.get(3).add(4);
//
//        adj.get(4).add(0);
//        adj.get(4).add(1);
//        adj.get(4).add(3);


        /**
         *        0
         *      / | \
         *     1  3  2
         *           |
         *           4
         */

        /**
         *  dfs of 0 ho sakta hai bas adj list banate samay change kar do sequence
         *  0 1 3 2 4
         *  0 3 1 2 4
         *  0 2 4 1 3
         *  0 2 4 3 1
         */

        adj.get(0).add(1);
        adj.get(0).add(3);
        adj.get(0).add(2);

        adj.get(1).add(0);

        adj.get(2).add(0);
        adj.get(2).add(4);

        adj.get(3).add(0);

        adj.get(4).add(2);

        // printGraph(adj);

        ArrayList<Integer> ans = new ArrayList<>(); // ans
        boolean visited[] = new boolean[6];
        visited[0] = true;
        dfsOfGraph(0, adj, visited, ans);
        for (int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    private static void dfsOfGraph(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        // marking current node as visited
        visited[node] = true;
        ans.add(node);

        // getting neighbour nodes
        for (Integer it: adj.get(node)) {
            if (visited[it] == false) {
                dfsOfGraph(it, adj, visited, ans);
            }
        }
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i=0; i<adj.size(); i++) {
            System.out.println("Adjacency list of vertex" + i);
            System.out.print("head");
            for (int j=0; j<adj.get(i).size(); j++) {
                System.out.print("->" +  adj.get(i).get(j));
            }
            System.out.println();
        }
    }
}
