package com.koko.dataStructures.graphs;

import java.util.ArrayList;

public class ShortestPathWeightedDirectedBellmanFord {

    // Bellman Ford Algo
    // 1. you have edges array.
    // Relax all the edges N-1 times.
    // 2. By relax means-> if(dist[u] + wt < dist[v]) dist[v] = dist[u] + wt;
    // 3. Run above condition for all edges, N-1 times.
    // 4. This will give you shortest distance array for all Nodes.
    // 5. Now, if you try to relax one more time, and dist[] reduces ;
    // 6. That means it has a -ve cycle in it.

    // TC: O(N-1)*O(E)
    // SC: O(N)

    static class Node
    {
        private int u;
        private int v;
        private int weight;

        Node(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }

        Node() {}
        int getV() { return v; }
        int getU() { return u; }
        int getWeight() { return weight; }

    }

    static void bellmanFord(ArrayList<Node> edges, int N, int src)
    {
        int dist[] = new int[N];
        for(int i = 0;i<N;i++) dist[i] = 10000000;

        dist[src] = 0;

        for(int i = 1;i<=N-1;i++) {
            for(Node node : edges) {
                if(dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                    dist[node.getV()] = dist[node.getU()] + node.getWeight();
                }
            }
        }

        int fl = 0;
        for(Node node: edges) {
            if(dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                fl = 1;
                System.out.println("Negative Cycle");
                break;
            }
        }

        if(fl == 0) {
            for(int i = 0;i<N;i++) {
                System.out.println(i + " " + dist[i]);
            }
        }
    }
    public static void main(String args[])
    {
        int n = 6;
        ArrayList<Node> adj = new ArrayList<Node>();

        adj.add(new Node(3, 2, 6));
        adj.add(new Node(5, 3, 1));
        adj.add(new Node(0, 1, 5));
        adj.add(new Node(1, 5, -3));
        adj.add(new Node(1, 2, -2));
        adj.add(new Node(3, 4, -2));
        adj.add(new Node(2, 4, 3));

        bellmanFord(adj, n, 0);
    }
}
