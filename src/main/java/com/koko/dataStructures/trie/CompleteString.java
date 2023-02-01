package com.koko.dataStructures.trie;

public class CompleteString {

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

    private static Node root;

    //Initialize your data structure here
    CompleteString() {
        root = new Node();
    }

    //Inserts a word into the trie
    // TC: O(length)
    public void insert(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean checkIfPrefixExists(String word){
        Node node = root;
        boolean flag = true;
        for(int i=0;i<word.length() && flag;i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                flag = node.isEnd();
            }else
                return false;
        }
        return flag;
    }

    // TC: O(N) * O(length)
    public static String completeString(int n, String[] a){
        CompleteString cs = new CompleteString();
        for(int i=0;i<n;i++){
            cs.insert(a[i]);
        }
        String longest = "";
        for(int i=0;i<n;i++){
            if(cs.checkIfPrefixExists(a[i])){
                if(a[i].length() > longest.length())
                    longest = a[i];
                else if(a[i].length() == longest.length() &&
                        a[i].compareTo(longest) < 0)
                    longest = a[i];
            }
        }
        if(longest.length() == 0) return "None";
        else return longest;
    }
}
