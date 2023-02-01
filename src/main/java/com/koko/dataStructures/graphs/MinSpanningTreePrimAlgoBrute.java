package com.koko.dataStructures.graphs;

import java.util.ArrayList;

public class MinSpanningTreePrimAlgoBrute {

    // Solution:
    // Prim's Algo Brute

    // 1. Find minimum in key.
    // 2. Mark that node as true in mst.
    // 3. Iterate over its adj nodes, and update key with minimum value
    // 4. and set node as parent for these adj nodes.
    // 5. parent array will contain parent value for child index nodes.

    // TC: O(N) + O(n*(N+E)) ~ O(N^2)
    // SC: O(N)

    static class Node
    {
        private int v;
        private int weight;

        Node(int _v, int _w) { v = _v; weight = _w; }

        Node() {}

        int getV() { return v; }
        int getWeight() { return weight; }
    }

    static void primsAlgo(ArrayList<ArrayList<Node>> adj, int N)
    {
        int key[] = new int[N];
        int parent[] = new int[N];
        boolean mstSet[] = new boolean[N];
        for(int i = 0;i<N;i++) {
            key[i] = 100000000;
            mstSet[i] = false;
            parent[i] = -1;
        }

        key[0] = 0;

        for(int i = 0;i<N-1;i++) { // Spanning tree has N-1 edges.
            int mini = 100000000, u = 0;
            for(int v = 0;v<N;v++) {
                if(mstSet[v] == false && key[v] < mini) {
                    mini = key[v];
                    u = v;
                }
            }

            mstSet[u] = true;

            for(Node it: adj.get(u)) {
                if(mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                }
            }
        }

        for(int i = 1;i<N;i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Node>());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));

        primsAlgo(adj, n);

    }
}
