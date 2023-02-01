package com.koko.dataStructures.Misc;


public class FindReplaceInString {

    // Q:
    /*

    You are given a 0-indexed string s that you must perform k replacement operations on.
    The replacement operations are given as three 0-indexed parallel arrays, indices, sources,
    and targets, all of length k.

To complete the ith replacement operation:

Check if the substring sources[i] occurs at index indices[i] in the original string s.
If it does not occur, do nothing.
Otherwise if it does occur, replace that substring with targets[i].
For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee",
then the result of this replacement will be "eeecd".

All replacement operations must occur simultaneously, meaning the replacement operations
should not affect the indexing of each other.
The testcases will be generated such that the replacements will not overlap.

For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be
generated because the "ab" and "bc" replacements overlap.
Return the resulting string after performing all replacement operations on s.

A substring is a contiguous sequence of characters in a string.
     */





    // Example:
    /*
    Input: s = "abcd", indices = [0, 2], sources = ["ab","ec"], targets = ["eee","ffff"]
Output: "eeecd"
Explanation:
"ab" occurs at index 0 in s, so we replace it with "eee".
"ec" does not occur at index 2 in s, so we do nothing.
     */





    // Solution:
    // Using hashmap and javafx Pair
    // U can use String[] also in place of Pair



//    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
//        Map<Integer , Pair> replacements = new TreeMap<>();
//        StringBuilder res = new StringBuilder();
//
//        for(int i = 0 ; i < indices.length ; i++)
//            if(s.substring(indices[i]).startsWith(sources[i]))
//                replacements.put(indices[i] , new Pair(targets[i] , sources[i].length()-1));
//
//        for(int i = 0 ; i < s.length() ; i++){
//            if(replacements.containsKey(i)){
//                Pair p = replacements.get(i);
//                res.append(p.getKey());
//                i += (int)p.getValue();
//            }
//            else
//                res.append(s.charAt(i));
//        }
//
//        return res.toString();
//    }
}