package com.koko.dataStructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraphBFS {

    // Idea: Topological Sort is only possible with DAG.
    // So if we are not able to generate sort, that means
    // It is cyclic.
    // A successful toposort would contain all N nodes.
    // So, keep a counter variable and compare with N at end to get result.


    // TC: O(N)
    // SC: O(N)

    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[N];
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
            cnt++;
            for(Integer it: adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        if(cnt == N) return false;
        return true;
    }

}
