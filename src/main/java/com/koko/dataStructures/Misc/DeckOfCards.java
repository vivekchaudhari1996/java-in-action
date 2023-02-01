package com.koko.dataStructures.Misc;

import java.util.HashMap;

public class DeckOfCards {

    // Q:
    /*
    In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split
the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.
     */



    // Example:
    /*
    Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].


Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.
     */




    // Solution1:
    // Idea: GCD

    // Again, say there are C_i cards of number i.
    // These must be broken down into piles of X cards each, ie. C_i % X == 0 for all i.
    //
    //Thus, X must divide the greatest common divisor of C_i.
    // If this greatest common divisor g is greater than 1, then X = g will satisfy. Otherwise, it won't.

    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }




    // Sol2:
    // Using map

    // we iterate through the hash and try to identify if s number between the lowest value
    // and 2 can divide all of hash cleanly. If it can, return true.

    public boolean hasGroupsSizeX2(int[] deck) {

        // Hashmap to store cards and the number of times they occurr
        HashMap<Integer, Integer> hash = new HashMap<>();

        // Loop through the deck building the hashmap
        for (int i = 0; i < deck.length; i++) {
            hash.put(deck[i], hash.getOrDefault(deck[i], 0)+1);
        }

        // Get the lowest count value of a card
        int lowest = Integer.MAX_VALUE;
        for (int i : hash.keySet()) {
            lowest = Math.min(lowest, hash.get(i));
        }

        // Iterate from lowest integer down to 2 to see if a least common denominator exists
        for (int i = lowest; i >= 2; i--) {
            // Flag to detect if a number is a lcd
            boolean lcd = true;

            // Loop through the HashMap
            for (int j : hash.keySet()) {
                if (hash.get(j) % i != 0) lcd = false;
            }

            // If lcd is true, then the j value can divide all items in hash
            if (lcd == true) return true;
        }

        return false;
    }
}
