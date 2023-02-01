package com.koko.dataStructures.trie;

import java.util.ArrayList;
import java.util.*;
class Node {
    Node[] links = new Node[2];

    public Node() {
    }
    boolean containsKey(int ind) {
        return (links[ind] != null);
    }
    Node get(int ind) {
        return links[ind];
    }
    void put(int ind, Node node) {
        links[ind] = node;
    }
}

class Trie {

    // While inserting the number’s into the trie consider the binary format
    // (Integer – 32bit) of the arr[i] and treat it as a string and insert the value.

    private static Node root;

    //Initialize your data structure here
    Trie() {
        root = new Node();
    }

    //Inserts a word into the trie
    public static void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

public class MaximumXorBetweenNumbers {
    public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2)
    {
        Trie trie = new Trie();
        for(int i = 0;i<n;i++) {
            trie.insert(arr1.get(i));
        }
        int maxi = 0;
        for(int i = 0;i<m;i++) {
            maxi = Math.max(maxi, trie.getMax(arr2.get(i)));
        }
        return maxi;
    }

    public static void main(String[] args) {
        int n = 2,m = 3;
        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(6,8));
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(7,8, 2));
        System.out.println(maxXOR(n,m,arr1,arr2));
    }
}