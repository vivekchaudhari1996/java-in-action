package com.koko.dataStructures.string;

import java.util.HashSet;
import java.util.Set;

public class StringsThatDifferBy1Char {

    // ###GeneralisedNeighbours
    // ###String hashing


    // Q:
    // Given a list of n strings.
    // Each string has length k. Return true if there're 2 strings that only differ by 1 character,
    // otherwise false.
    // You can assume that all strings contain only lowercase English letters [a-z].


    // Example:
    // Input: ["abc", "xyz", "abd"]
    //Output: true
    //Explanation: "abc" and "abd" only differ by 1 character.





    // Sol1:
    // Rabin-Karp
    // TC: O(nm)

    /* IDEA:
    First, we compute a hash for each string i in [0, n) as
    hash[i] = a[0] * 26 ^ (m - 1) + a[1] * 26 ^ (m - 2) + ... + a[m - 2] * 26 + a[m - 1],
    where n is the number of strings, and m - the number of characters in a string.

Then, we go through each character position j in [0, m), and compute a hash without that character:
h = hash[i] - a[j] * 26 ^ (m - j - 1). We track h in a hash set so we can detect
if there is another string with the same hash.
Ideally, we should check for collisions as we are using mod to keep hashes within the integer range.
Since the solution below is accepted, I am keeping it simple here.

Note that in the second loop we are going right-to-left so it's easier to compute 26 ^ (m - j - 1).
     */

    public boolean differByOne(String[] dict) {
        HashSet<Long> set = new HashSet<>();
        long mod = (long) Math.pow(10, 20) + 7;

        int len = dict[0].length();
        long[] word2hash = new long[dict.length];
        for (int i = 0; i < dict.length; i++) {
            for (int j = 0; j < len; j++) {
                word2hash[i] = (word2hash[i] * 26 + dict[i].charAt(j) - 'a') % mod;
            }
        }

        long base = 1;
        for (int j = len - 1; j >= 0; j--) {
            set.clear();
            for (int i = 0; i < dict.length; i++) {
                long newHash = (word2hash[i] - base * (dict[i].charAt(j) - 'a')) % mod;
                if (set.contains(newHash)) {
                    return true;
                }
                set.add(newHash);
            }
            base = 26 * base % mod;
        }

        return false;
    }




    // Solution2:

    // Using extra space - hashset
    // TC: O(N*K) : N is nbr of words, k is the length of word.
    // MLE error comes in this.


    /*
    // Idea:

    //The idea is very simple. To begin with, for each word, we convert it to a list of possible representations.
    //
    //Example:
    //
    //"abc" => ["*bc", "a*c", "ab*"]
    //"afc" =>  ["*fc",  "a*c", "af*"]
    //This is what the generalized function below does.
    //
    //And the rest is very straight forward, we grouped all the strings, and count the number of duplicates in each group.
    //If there exists a count that is greater than 1, then we know 2 strings that only differ by 1 character.
    //
    //Example, here are how the counts look like given the input ["abc", "afc"] above.
    //
    //"*bc" -> 1
    //"a*c" -> 2
    //"ab*" -> 1
    //"af*" -> 1
    //Since we have two "a*c", we know that the result is True.
     */

    public boolean differByOne2(String[] dict) {
        Set<String> set = new HashSet<>();

        // takes care of new test cases
        if(dict.length == 2){
            int countDiff = 0;
            for(int i=0;i<dict[0].length();i++){
                if(dict[0].charAt(i)!=dict[1].charAt(i)) countDiff++;
                if(countDiff > 1) return false;
            }
            return true;
        }

        StringBuilder sb = null; //define just one string builder to save memory
        for (String d : dict) {
            sb = new StringBuilder(d);
            for (int i = 0; i < d.length(); i++) {
                char origin = sb.charAt(i);
                sb.setCharAt(i, '*');
                String candidate = sb.toString();
                if (!set.add(candidate)) return true;
                sb.setCharAt(i, origin);
            }
            sb.setLength(0);
        }
        return false;
    }

}
