package com.koko.striver.day23Graph;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraphDFS {

    // Problem Statement:
    // Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.

    //Time Complexity: O(N)
    //Space Complexity: O(N)

    public static boolean checkForCycle(int node, int parent, boolean vis[], ArrayList <ArrayList
            < Integer >> adj) {
        vis[node] = true;
        for (Integer it: adj.get(node)) {
            if (vis[it] == false) {
                if (checkForCycle(it, node, vis, adj)) // exact same as DFS traversal but yha tru hote hi true return karao
                    return true;
            } else if (it != parent) // whi if visited then parent wala visit nhi hona chahiye. for more explanation check
                return true;
        }
        return false;
    }

    // 0-based indexing Graph
    public static boolean isCycle(int V, ArrayList < ArrayList < Integer >> adj) {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (checkForCycle(i, -1, vis, adj))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList < > ());
        }
        // edge 0---1
        adj.get(0).add(1);
        adj.get(1).add(0);

        // edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // adge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // adge 3--4
        adj.get(3).add(4);
        adj.get(4).add(3);

        // adge 1--4
        adj.get(1).add(4);
        adj.get(4).add(1);

        boolean ans = isCycle(V, adj);
        if (ans) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Detected");

        }
    }
}