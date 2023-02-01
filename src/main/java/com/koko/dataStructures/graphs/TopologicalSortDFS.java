package com.koko.dataStructures.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {

    // Using visited array and stack to store Node after recursive call ends for that Node.
    // So this always maintains u->v ; stack has v before u.

    // TC: O(N)
    // SC: O(N)

    static void findTopoSort(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for(Integer it: adj.get(node)) {
            if(vis[it] == 0) {
                findTopoSort(it, vis, adj, st);
            }
        }
        st.push(node);
    }
    static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<Integer>();
        int vis[] = new int[N];

        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                findTopoSort(i, vis, adj, st);
            }
        }

        int topo[] = new int[N];
        int ind = 0;
        while(!st.isEmpty()) {
            topo[ind++] = st.pop();
        }
        // for(int i = 0;i<N;i++) System.out.println(topo[i] + " ");
        return topo;
    }
}
