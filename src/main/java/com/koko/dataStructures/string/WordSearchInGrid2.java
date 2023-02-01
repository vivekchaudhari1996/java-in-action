package com.koko.dataStructures.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchInGrid2 {

    // ###Trie
    // ###Backtracking
    // ###Backtracking+Trie


    // Q:
    /*
    Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once in a word.
     */



    // Example:
    /*
    Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
    words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
     */




    // Solution:
    // Backtracking + Trie

    /*
    IDEA:
    during the backtracking process, one would encounter more often the need to tell if there exists
    any word that contains certain prefix, rather than if a string exists as a word in the dictionary.
    Because if we know that there does not exist any match of word in the dictionary for a given prefix,
    then we would not need to further explore certain direction.
    And this, would greatly reduce the exploration space,
    therefore improve the performance of the backtracking algorithm.

The capability of finding matching prefix is where the data structure called Trie would shine,
comparing the hashset data structure.
     */


    // SC: O(N) : N is the total number of letters in the dictionary.
    // TC: O(M*(4*3^L-1) :
    // M is the number of cells in the board and L is the maximum length of words.

    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String word = null;
        public TrieNode() {}
    }

    class Solution {
        char[][] _board = null;
        ArrayList<String> _result = new ArrayList<String>();

        public List<String> findWords(char[][] board, String[] words) {

            // Step 1). Construct the Trie
            TrieNode root = new TrieNode();
            for (String word : words) {
                TrieNode node = root;

                for (Character letter : word.toCharArray()) {
                    if (node.children.containsKey(letter)) {
                        node = node.children.get(letter);
                    } else {
                        TrieNode newNode = new TrieNode();
                        node.children.put(letter, newNode);
                        node = newNode;
                    }
                }
                node.word = word;  // store words in Trie
            }

            this._board = board;
            // Step 2). Backtracking starting for each cell in the board
            for (int row = 0; row < board.length; ++row) {
                for (int col = 0; col < board[row].length; ++col) {
                    if (root.children.containsKey(board[row][col])) {
                        backtracking(row, col, root);
                    }
                }
            }

            return this._result;
        }

        private void backtracking(int row, int col, TrieNode parent) {
            Character letter = this._board[row][col];
            TrieNode currNode = parent.children.get(letter);

            // check if there is any match
            if (currNode.word != null) {
                this._result.add(currNode.word);
                currNode.word = null;
            }

            // mark the current letter before the EXPLORATION
            this._board[row][col] = '#';

            // explore neighbor cells in around-clock directions: up, right, down, left
            int[] rowOffset = {-1, 0, 1, 0};
            int[] colOffset = {0, 1, 0, -1};
            for (int i = 0; i < 4; ++i) {
                int newRow = row + rowOffset[i];
                int newCol = col + colOffset[i];
                if (newRow < 0 || newRow >= this._board.length || newCol < 0
                        || newCol >= this._board[0].length) {
                    continue;
                }
                if (currNode.children.containsKey(this._board[newRow][newCol])) {
                    backtracking(newRow, newCol, currNode);
                }
            }

            // End of EXPLORATION, restore the original letter in the board.
            this._board[row][col] = letter;

            // Optimization: incrementally remove the leaf nodes
            // Pruning: For a leaf node in Trie, once we traverse it (i.e. find a matched word),
            // we would no longer need to traverse it again.
            // As a result, we could prune it out from the Trie.
            if (currNode.children.isEmpty()) {
                parent.children.remove(letter);
            }
        }
    }

}
