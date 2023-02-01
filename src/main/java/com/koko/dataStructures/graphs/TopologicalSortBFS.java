package com.koko.dataStructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {

    // Kahn's Algo
    // 1. populate indegree array.
    // 2. Find indegree 0 Nodes and push them to Queue.
    // 3. BFS and add to final Sort array once you pop an element.

    // TC: O(N)
    // SC: O(N)

    public int[] isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int topo[] = new int[N];
        int indegree[] = new int[N];
        for(int i = 0;i<N;i++) {
            for(Integer it: adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i<N;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            Integer node = q.poll();
            topo[cnt++] = node;
            for(Integer it: adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }
}
