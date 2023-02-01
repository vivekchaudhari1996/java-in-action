package com.koko.dataStructures.Misc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReplacementLibrary {

    // Q:
    // Suppose we are creating a string replacement library.
    // Given a map of string replacements, replace the value in the input string
    //
    //Given map {X=>123, Y=456}
    //Input: %X%_%Y%
    //Output: 123_456
    //
    //Given map {USER=>admin, HOME=>/%USER%/home}
    //Input: I am %USER% My home is %HOME%
    //Output: I am admin My home is /admin/home



    // Solution:

    // Using Topological sort

    static Pattern pattern = Pattern.compile("%(.+?)%");
    static Set<String> placeHolders(String text) {
        Matcher matcher = pattern.matcher(text);
        Set<String> set = new HashSet<>();
        while (matcher.find()) set.add(matcher.group(1));
        return set;
    }

    static Map<String, String> normalize(Map<String, String> dict) {
        Queue<String> queue = new LinkedList<>();

        //~ build graph
        Map<String, Set<String>> produces = new HashMap<>();
        Map<String, Set<String>> consumes = new HashMap<>();
        for(String key : dict.keySet()) {
            Set<String> phs = placeHolders(dict.get(key));
            consumes.putIfAbsent(key, new HashSet<>());
            consumes.get(key).addAll(phs);
            for(String ph : phs) {
                produces.putIfAbsent(ph, new HashSet<>());
                produces.get(ph).add(key);
            }
            if(consumes.get(key).isEmpty()) queue.add(key);
        }

        //top sort
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            String u = queue.poll();
            //if(visited.contains(u)) throw new IllegalArgumentException("can't resolve all placeholders");
            visited.add(u);
            Set<String> v = produces.getOrDefault(u, new HashSet<>());
            for(String next : v) {
                String value = dict.get(next);
                value = value.replaceAll("%"+u+"%", dict.get(u));
                dict.put(next, value);
                consumes.get(next).remove(u);
                if(consumes.get(next).isEmpty()) queue.add(next);
            }
        }

        if(visited.size() != dict.size()) throw  new IllegalArgumentException("unresolved place holders");

        return dict;
    }
    static String normalize(String text, Map<String, String> dict) {
        normalize(dict);
        Set<String> ph = placeHolders(text);
        for (String key : ph) text = text.replaceAll("%"+key+"%", dict.get(key));
        return text;
    }

    public static void main(String[] args) {

        String[][] s={{"USER","admin"},{"HOME","/%USER%/home"},{"A","123"},{"Y","456"}} ;
        HashMap<String,String> m=new HashMap<>();
        String str="%A%_%Y%I am %USER% My home is %HOME%";
        //String[][] s={{"X","123"},{"Y","456"}};
        //String str="%X%_%Y%";
        for(String[] s2:s){
            String a= s2[0];
            String b= s2[1];
            m.put(a,b);
        }
        System.out.println(normalize(str,m));
    }
}
