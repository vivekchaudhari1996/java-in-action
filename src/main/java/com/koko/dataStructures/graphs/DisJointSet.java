package com.koko.dataStructures.graphs;

public class DisJointSet {

    // TC: O(4*alpha) ~ O(4) ~ constant time for both union and findPar.
    // SC: O(N)

    static int [] parent = new int[1000];
    static int [] rank = new int[1000];
    static void makeSet(int n){
        for(int i=1;i<=n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int findPar(int node){
        if(node == parent[node])
            return node;
        return parent[node] = findPar(parent[node]);
        // Doing path compression, so as to not make recursive calls everytime.
    }

    static void union(int node1, int node2){
        node1 = findPar(node1);
        node2 = findPar(node2);

        if(rank[node1] < rank[node2]){
            parent[node1] = node2;
        }else if(rank[node1] > rank[node2]){
            parent[node2] = node1;
        }else{
            parent[node1] = node2;
            rank[node2]++;

        }
    }
    public static void main(String[] args) {
        makeSet(5);
        // call Union function to form the set.
        // To check if 2 nodes belong to same component

        // match their findPar(node1) == findPar(node2)
        // otherwise not.
    }
}
