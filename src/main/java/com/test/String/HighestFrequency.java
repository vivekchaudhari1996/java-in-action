package com.test.String;

import java.util.*;

public class HighestFrequency {

    public static void main(String args[]){
        String a  = "ABABABABBACCCCCCCCCC";
        printFrePriority(a,2);
    }

    public static void printFreq(String a, int k) {
        int n = a.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue() == o2.getValue() ?
                        o2.getKey() - o1.getKey() : o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < list.size() && i < k; i++) {
            System.out.println(list.get(i).getKey());
        }
    }

    public static void printFrePriority(String a, int k){
        int n = a.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> list =
                new PriorityQueue<>((o1, o2) -> o1.getValue().equals(o2.getValue()) ?
                        Integer.compare(o2.getKey(),o1.getKey()) :
                        Integer.compare(o2.getValue(),o1.getValue()));
        for(Map.Entry<Character,Integer> s : map.entrySet()){
            list.offer(s);
        }
        for (int i = 0; i < list.size() && i < k; i++) {
            System.out.println(list.poll().getKey());
        }
    }
}
