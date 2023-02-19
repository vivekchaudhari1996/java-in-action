package com.koko.striver.day23Graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraphBFS {

    // Q: Problem Statement:
    // Given an undirected Graph, check for a cycle using BFS (Breadth-First Search) Traversal.


    // Solution:
    // The intuition behind this is to check for the visited element if it is found again,
    // and the repeated Node is not the parent of current Node.
    // this means the cycle is present in the given undirected graph.


    // Time Complexity: O(N+E),  N is the time taken and E is for traveling through adjacent nodes overall.
    // Space Complexity: O(N+E) +  O(N) + O(N) , space for adjacent list , array and queue

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++)
            if(vis[i]==false)
                if(checkForCycle(adj, i,vis))
                    return true;

        return false;
    }

    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
                                 boolean vis[])
    {
        Queue<Node> q =  new LinkedList<>(); //BFS
        q.add(new Node(s, -1)); // parent of first Node is -1.
        vis[s] =true;

        while(!q.isEmpty())
        {
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();

            for(Integer it: adj.get(node))
            {
                if(vis[it]==false)
                {
                    q.add(new Node(it, node));
                    vis[it] = true;
                }
                /**
                 * if visited == true thats means someone already visited and
                 * this can happen only if have the cycle.
                 * this par!=it is really needed attention because kyuki
                 * for 5 adj list is = {2, 7} and whenever it will reach to 2 at that time also visited true hi hoga
                 * but we will not say ki cyclic hai kyuki 2, 5 ka parent hai.
                 * but this will not be the case for 7, 7 agar visited hai to thats means already someone visited.
                 *    / 2--5\
                 *   1       7
                 *    \3--6 /
                 *     |
                 *     4
                 */

                else if(par != it) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException
    {

        int V = 5;
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0; i < V; i++)
            adj.add(i, new ArrayList<Integer>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(3);
        adj.get(1).add(3);
        adj.get(2).add(4);

        boolean ans = isCycle(V, adj);
        if(ans)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static class Node {
        int first;
        int second;
        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

}
