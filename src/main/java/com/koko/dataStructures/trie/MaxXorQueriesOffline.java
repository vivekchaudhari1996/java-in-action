package com.koko.dataStructures.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaxXorQueriesOffline {

    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<ArrayList<Integer>>();
        int m = queries.size();
        for(int i = 0;i<m;i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(queries.get(i).get(1)); // Ai
            temp.add(queries.get(i).get(0)); // Xi
            temp.add(i); // Index of online query
            offlineQueries.add(temp);
        }
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0)); // Sort based on Ai
            }
        });
        int ind = 0;
        int n = arr.size();
        Trie trie = new Trie();
        ArrayList<Integer> ans = new ArrayList<Integer>(m);
        for(int i = 0;i<m;i++) ans.add(-1);

        // TC: O(M*32 + N*32)
        for(int i = 0;i<m;i++) {
            while(ind<n && arr.get(ind) <= offlineQueries.get(i).get(0)) {
                trie.insert(arr.get(ind)); // TC: 32
                ind++;
            }
            int queryInd = offlineQueries.get(i).get(2);
            if(ind!=0) ans.set(queryInd, trie.getMax(offlineQueries.get(i).get(1))); // TC: 32
            else ans.set(queryInd, -1);
        }
        return ans;
    }

}

