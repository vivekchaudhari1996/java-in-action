package com.koko.striver.day23Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {

    // Kahn's Algo
    // 1. populate indegree array.
    // 2. Find indegree 0 Nodes and push them to Queue.
    // 3. BFS and add to final Sort array once you pop an element.

    /**
     * Topological sort mean - if there is edge between 2 node u and v then u appears before v
     *      5     4
     *    /  \   / \
     *   <    ><    >
     *   2     0     1
     *    \        />
     *     >3 -- /
     *
     *  Output: 4 5 2 0 3 1
     *  4 is appearing before its neighbours (1,0)
     *  5 is appearing before its neighbours (0,2)
     *  2 is appearing before its neighbours (3)
     *  3 is appearing before its neighbours (1)
     *
     *  topo sort is only possible in Directed acyclic graph (DAG) kyuki cyclic hoga then how can we identify which
     *  come first 1->2->3----->1
     *
     *  intuition-
     *  we have to start from node which does not have upcoming node.
     *  to find the node which does not have any we will use the indegree==0
     *  put all the 0 indegree element in queue and start the BFS
     *
     * @param N
     * @param adj
     * @return
     */

    // TC: O(N)
    // SC: O(N)

    //bfs logic hi hai bus thoda modified :)
    public static int[] isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int topo[] = new int[N];
        int indegree[] = new int[N];

        // finding the indegree
        /**
         * 5==> 2, 0  // 2 ki indegree++ same as 0 ki bhi ++
         * 4==> 0, 1  // 0 and 1 ki degree++
         * 2==>3
         * 3==>1
         * 0==>
         * agar observe karo to 5 and 4 ki indegree 0 hi hai
         *
         */
        for(int i = 0;i<N;i++) {
            for(Integer it: adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i<N;i++) {
            if(indegree[i] == 0) {
                q.add(i); // put all the 0 degree in q
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

    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();

        // adding new arraylists to 'adj' to add neighbour nodes
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList < > ());
        }


        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(3).add(1);
        adj.get(2).add(3);


        int[] ans = isCyclic(6,adj);
        for (int i=0; i< ans.length; i++) {
            System.out.print(" "+ ans[i]);
        }
    }
}
