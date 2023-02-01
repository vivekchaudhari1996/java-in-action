package com.koko.dataStructures.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistanceBwBinaryStrings {

    // Q:
    // The distance between 2 binary strings is the sum of their lengths after removing the common prefix.
    // For example: the common prefix of 1011000 and 1011110 is 1011 so the distance is len("000") + len("110") = 3 + 3 = 6.
    //
    //Given a list of binary strings,
    // pick a pair that gives you maximum distance among all possible pair and return that distance.



    // Solution:
    // Trie + DFS
    //
    //Build a binary Trie
    //2)Find the diameter of the tree from the node where the left and right both are not null
    // which means the bit of any two strings are different here
    //3)we can do this using DFS


    // Sol1:


    public class Google_DistanceBetween2BinaryString {
        public int findLength(String[] a){
            BinaryTrie b = new BinaryTrie(a);
            return b.maxDistance;
        }

        private class BinaryTrie{
            private TreeNode root;
            int maxDistance;
            BinaryTrie(String[] a){
                root = new TreeNode('\0'); // null
                for(String t : a) insert(t);
                maxDistance = 0;
                maxDist();
            }

            private void insert(String a){
                TreeNode curr = root;
                for(char c : a.toCharArray()){
                    if(c == '0'){
                        if(curr.left == null){
                            TreeNode t = new TreeNode(c);
                            curr.left = t;
                        }
                        curr = curr.left;
                    }else{
                        if(curr.right == null){
                            TreeNode t = new TreeNode(c);
                            curr.right = t;
                        }
                        curr = curr.right;
                    }
                }
                curr.end = true;
            }

            private int findDist(TreeNode node){
                if(node == null) return 0;
                int l = findDist(node.left);
                int r = findDist(node.right);

                // whenever there is split into left and right we take a measurement
                // or where a node ends for cases like 11001, 110 in this case answer is 2
                if(node.end || (node.right != null && node.left != null))
                    maxDistance = Math.max(maxDistance, l+r);

                return 1 + Math.max(l,r);
            }

            private int maxDist(){
                return this.findDist(root);
            }
        }

        private class TreeNode{
            char c;
            // left is 0 and right is 1
            TreeNode left = null, right = null;
            boolean end = false;
            TreeNode(char c){
                this.c = c;
            }
        }

    }





    // Sol2:


    static class BinaryTrieNode {
        private char ch;

        // as we only have binary 0 and 1, we can restrict our trie node to have only two children
        BinaryTrieNode left;
        BinaryTrieNode right;

        public BinaryTrieNode(char c) {
            ch = c;
        }

        public void set(char ch, BinaryTrieNode node) {
            if (ch == '0') {
                left = node;
            } else if (ch == '1') {
                right = node;
            }
        }

        public BinaryTrieNode get(char ch) {
            if (ch == '0') {
                return left;
            } else if (ch == '1') {
                return right;
            }
            return null;
        }
    }

    static class BinaryTrie {
        private BinaryTrieNode root;
        private int maxDiff;

        public BinaryTrie(List<String> binaries) {
            root = new BinaryTrieNode('\0');
            maxDiff = 0;

            // insert each binary string into Trie
            for (String str : binaries) {
                BinaryTrieNode curr = root;

                for (char ch : str.toCharArray()) {
                    BinaryTrieNode child = curr.get(ch);

                    if (child == null) {
                        child = new BinaryTrieNode(ch);
                        curr.set(ch, child);
                    }

                    curr = child;
                }
            }
        }

        public int getMaxDiff() {
            getMaxDepth(root);

            return maxDiff;
        }

        // helper method to calculate depth of a trie node.
        private int getMaxDepth(BinaryTrieNode root) {
            if (root == null)
                return 0;

            // calculate left child depth
            int leftDepth = getMaxDepth(root.left);

            // calculate rightt child depth
            int rightDepth = getMaxDepth(root.right);

            // this check is imp here
            // we only need to update the max, iff both left AND right depths are greater than 0.
            // if we dont do this, here's is an example where it would fail:
            // two strings are 10100, 10111. The actual ans here is 4.
            // but at root node, the left depth is 0 and right depth is 5. left depth is 0 as we dont have a left child (node with char 0 at root as both strings start with 1)
            // right depth is 5. so max would be left + right =5 which is incorrect.
            // so we only need to update max if both left and right depths are > 0.
            // if both are > 0, it means that the curr node splits two diff binary strings and this is the case where we want to add the lengths and update the max.
            // in the above example, the strings split at 3rd index 1.

            if (leftDepth > 0 && rightDepth > 0) {
                maxDiff = Math.max(maxDiff, leftDepth + rightDepth);
            }

            // send max depth between left and right to upper recursive level
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }

    public static void main(String[] args) {
        List<String> binaries = new ArrayList(Arrays.asList("1011100", "1011011","1001111"));

        BinaryTrie trie = new BinaryTrie(binaries);

        System.out.println(trie.getMaxDiff()); // gives 10 (1011100, 1001111) differ by 10.

        binaries = new ArrayList(Arrays.asList("101", "111","000"));

        trie = new BinaryTrie(binaries);

        System.out.println(trie.getMaxDiff()); // return 6 (101, 000)
    }



    // Sol3:



//    static class BinaryNode{
//        char ch;
//        boolean isEnd;
//        BinaryNode left;
//        BinaryNode right;
//
//        public BinaryNode( char ch){
//            this.ch = ch;
//            left = null;
//            right = null;
//            this.isEnd = false;
//        }
//    }
//    public static int findMaxLength( List<String> list ){
//
//        BinaryNode root = new BinaryNode('A');
//        BinaryNode temp = root;
//        for( String str : list ){
//            buildTrieTree( str, temp);
//        }
//
//        printTrieTree( root );
//
//        temp = giveStartingNode( root );
//        System.out.println("temp::"+ temp.ch);
//
//        int l = findMaxLenChild( temp.left);
//        int r = findMaxLenChild( temp.right);
//        System.out.println("l+r::"+(l+r));
//        return 0;
//    }
//    public static int findMaxLenChild( BinaryNode  current ){
//        if( current == null ){
//            return 0;
//        }
//        return 1 + Math.max( findMaxLenChild(current.left),findMaxLenChild(current.right) );
//    }
//    public static BinaryNode giveStartingNode( BinaryNode current ){
//        if( current.left != null && current.right != null ){
//            return current;
//        }
//        if( current.left != null ){
//            return giveStartingNode( current.left);
//        }else{
//            return giveStartingNode( current.right);
//        }
//    }
//    public static void printTrieTree( BinaryNode current  ){
//        if( current == null ){
//            return;
//        }
//        System.out.println( current.ch);
//        printTrieTree( current.left);
//        printTrieTree( current.right);
//    }
//    public static void buildTrieTree( String str, BinaryNode current ){
//        for( char ch : str.toCharArray() ){
//            if( ch == '0'){
//                if( current.left != null ){
//                    current = current.left;
//                }else{
//                    BinaryNode child = new BinaryNode( ch );
//                    current.left = child;
//                    current = current.left;
//                }
//            }else{
//                if( current.right != null ){
//                    current = current.right;
//                }else{
//                    BinaryNode child = new BinaryNode( ch );
//                    current.right = child;
//                    current = current.right;
//                }
//                current.isEnd = true;
//            }
//        }
//    }
//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        List<String> binaries = new ArrayList(Arrays.asList("1011100", "1011011","1001111"));
//        findMaxLength(binaries);
//        binaries = new ArrayList(Arrays.asList("101", "111","000"));
//        findMaxLength(binaries);
//    }
}
