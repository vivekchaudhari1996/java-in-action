package com.koko.dataStructures.trie;

public class NumberOfDistinctSubstringsInAString {

    // This can be implemented by using Set.
    // Find all substrings and add them in Set.
    // But this will take more space for all substrings to store.
    // Also TC will be O(N^2) * O(logM) : M is size of set for add operation.

    // With Trie, similar prefix substrings can share space.
    // Also TC will be just O(N^2) for inserting.

    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        public Node() {

        }

        boolean containsKey(char ch) {
            return (links[ch - 'a'] != null);
        }
        Node get(char ch) {
            return links[ch-'a'];
        }
        void put(char ch, Node node) {
            links[ch-'a'] = node;
        }
        void setEnd() {
            flag = true;
        }
        boolean isEnd() {
            return flag;
        }
    }

    public static int countDistinctSubstrings(String s)
    {
        Node root = new Node();
        int n = s.length();
        int cnt = 0;
        for(int i = 0; i < n;i++) {
            Node node = root;
            for(int j = i;j<n;j++) {
                if(!node.containsKey(s.charAt(j))) {
                    node.put(s.charAt(j), new Node());
                    cnt++;
                }
                node = node.get(s.charAt(j));
            }
        }
        return cnt + 1; // For empty strings also increment count.
    }


}
