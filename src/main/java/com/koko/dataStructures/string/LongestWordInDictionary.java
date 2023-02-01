package com.koko.dataStructures.string;

import java.util.*;

public class LongestWordInDictionary {

    // ###Trie
    // ###PrefixTrie



    // Q:
    /*
    Given an array of strings words representing an English Dictionary,
    return the longest word in words that can be built one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order.
If there is no answer, return the empty string.

Note that the word should be built from left to right with each additional character
being added to the end of a previous word.
     */



    // Example:
    /*
    Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".



Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary.
However, "apple" is lexicographically smaller than "apply".
     */






    // Solution1:
    // Approach #1: Brute Force [Accepted]

    // For each word, check if all prefixes word[:k] are present.
    // We can use a Set structure to check this quickly.
    // Alternatively, we could have sorted the words beforehand,
    // so that we know the word we are considering would be the answer if all it's prefixes are present.


    // TC: O(sigma wi^2) - wi is the length of word[i]
    // SC: O(sigma wi^2) - to create the substrings

    public String longestWord(String[] words) {
        Set<String> wordset = new HashSet();
        for (String word: words) wordset.add(word);
        Arrays.sort(words, (a, b) -> a.length() == b.length()
                ? a.compareTo(b) : b.length() - a.length());
        for (String word: words) {
            boolean good = true;
            for (int k = 1; k < word.length(); ++k) {
                if (!wordset.contains(word.substring(0, k))) {
                    good = false;
                    break;
                }
            }
            if (good) return word;
        }

        return "";
    }






    // Sol2:
    // Approach #2: Trie + Depth-First Search [Accepted]



    // IDEA:
    // As prefixes of strings are involved,
    // this is usually a natural fit for a trie (a prefix tree.)
    // Put every word in a trie, then depth-first-search from the start of the trie,
    // only searching nodes that ended a word.
    // Every node found (except the root, which is a special case) then represents a word
    // with all it's prefixes present. We take the best such word.

    // If we used a BFS instead of a DFS, and ordered the children in an array,
    // we could drop the need to check whether the candidate word at each node is better than the answer,
    // by forcing that the last node visited will be the best answer.
    // BFS solution after this


    // TC: O(sigma wi) : wi is the length of word[i]
    // for building and searching
    // SC: O(sigma wi): the space used by trie

    class Solution {
        public String longestWord(String[] words) {
            Trie trie = new Trie();
            int index = 0;
            for (String word: words) {
                trie.insert(word, ++index); //indexed by 1
            }
            trie.words = words;
            return trie.dfs();
        }
    }
    class Node {
        char c;
        HashMap<Character, Node> children = new HashMap();
        int end;
        public Node(char c){
            this.c = c;
        }
    }

    class Trie {
        Node root;
        String[] words;
        public Trie() {
            root = new Node('0');
        }

        public void insert(String word, int index) {
            Node cur = root;
            for (char c: word.toCharArray()) {
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.end = index;
        }

        public String dfs() {
            String ans = "";
            Stack<Node> stack = new Stack();
            stack.push(root);
            while (!stack.empty()) {
                Node node = stack.pop();
                if (node.end > 0 || node == root) {
                    if (node != root) {
                        String word = words[node.end - 1];
                        if (word.length() > ans.length() ||
                                word.length() == ans.length() && word.compareTo(ans) < 0) {
                            ans = word;
                        }
                    }
                    for (Node nei: node.children.values()) {
                        stack.push(nei);
                    }
                }
            }
            return ans;
        }
    }




    // BFS+ Trie




    class Solution1 {
        class TrieNode {
            TrieNode[] children;
            boolean isWord;
            String word;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        class Trie {
            private TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    int idx = word.charAt(i) - 'a';
                    if (node.children[idx] == null) {
                        node.children[idx] = new TrieNode();
                    }
                    node = node.children[idx];
                }
                node.isWord = true;
                node.word = word;
            }

            public String findLongestWord() {
                String result = null;
                Queue<TrieNode> queue = new LinkedList<>();
                queue.offer(root);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        TrieNode node = queue.poll();
                        for (int j = 25; j >= 0; j--) {
                            if (node.children[j] != null && node.children[j].isWord) {
                                result = node.children[j].word;
                                queue.offer(node.children[j]);
                            }
                        }
                    }
                }
                return result;
            }
        }

        public String longestWord(String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            return trie.findLongestWord();
        }
    }
}
