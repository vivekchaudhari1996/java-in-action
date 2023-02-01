package com.koko.dataStructures.string;

import java.util.*;

public class MagicDictionaryDifferBy1Char {

    // ###GeneralisedNeighbours



    // Q:
    /*
    Design a data structure that is initialized with a list of different words.
    Provided a string, you should determine if you can change exactly one character
    in this string to match any word in the data structure.

Implement the MagicDictionary class:

MagicDictionary() Initializes the object.
void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
bool search(String searchWord) Returns true if you can change exactly one character in
searchWord to match any string in the data structure, otherwise returns false.

     */



    // Example:
    /*
    Input
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
Output
[null, null, false, true, false, false]

Explanation
MagicDictionary magicDictionary = new MagicDictionary();
magicDictionary.buildDict(["hello", "leetcode"]);
magicDictionary.search("hello"); // return False
magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
magicDictionary.search("hell"); // return False
magicDictionary.search("leetcoded"); // return False
     */





    // Solution1:
    // Approach #1: Brute Force with Bucket-By-Length [Accepted]


    // IDEA: Call two strings neighbors if exactly one character can be changed in one to make the
    // strings equal (ie. their hamming distance is 1.)
    //
    //Strings can only be neighbors if their lengths are equal.
    // When searching a new word, let's check only the words that are the same length.



    // Time Complexity: O(S) to build and O(NK) to search,
    // where N is the number of words in our magic dictionary, S is the total number of letters in it,
    // and K is the length of the search word.
    //
    // Space Complexity: O(S), the space used by buckets.

    class MagicDictionary {
        Map<Integer, ArrayList<String>> buckets;
        public MagicDictionary() {
            buckets = new HashMap();
        }

        public void buildDict(String[] words) {
            for (String word: words) {
                buckets.computeIfAbsent(word.length(), x -> new ArrayList()).add(word);
            }
        }

        public boolean search(String word) {
            if (!buckets.containsKey(word.length())) return false;
            for (String candidate: buckets.get(word.length())) {
                int mismatch = 0;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) != candidate.charAt(i)) {
                        if (++mismatch > 1) break;
                    }
                }
                if (mismatch == 1) return true;
            }
            return false;
        }
    }








    // Sol2:
    // Approach #2: Generalized Neighbors [Accepted]



    // IDEA: Let's say a word 'apple' has generalized neighbors
    // '*pple', 'a*ple', 'ap*le', 'app*e', and 'appl*'.
    // When searching for whether a word like 'apply' has a neighbor like 'apple',
    // we only need to know whether they have a common generalized neighbor.



    // TC: O(sigma wi^2) to build and O(K^2) to search
    // where wi is the length of words[i], and K is the length of search word.
    // SC: O(sigma wi^2) : the space used by count map.

    public class MagicDictionary1 {
        Set<String> words;
        Map<String, Integer> count;

        public MagicDictionary1() {
            words = new HashSet();
            count = new HashMap();
        }

        private ArrayList<String> generalizedNeighbors(String word) {
            ArrayList<String> ans = new ArrayList();
            char[] ca = word.toCharArray();
            for (int i = 0; i < word.length(); ++i) {
                char letter = ca[i];
                ca[i] = '*';
                String magic = new String(ca);
                ans.add(magic);
                ca[i] = letter;
            }
            return ans;
        }

        public void buildDict(String[] words) {
            for (String word: words) {
                this.words.add(word);
                for (String nei: generalizedNeighbors(word)) {
                    count.put(nei, count.getOrDefault(nei, 0) + 1);
                }
            }
        }

        public boolean search(String word) {
            for (String nei: generalizedNeighbors(word)) {
                int c = count.getOrDefault(nei, 0);
                if (c > 1 || c == 1 && !words.contains(word)) return true;
            }
            return false;
        }
    }


}
