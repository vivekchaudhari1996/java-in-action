package com.koko.dataStructures.Misc;

import java.util.*;

public class CurrencyConversion {

    // Q:
    /*
    Paramenters:

array of currency conversion rates. E.g. ['USD', 'GBP', 0.77] which means 1 USD is equal to 0.77 GBP
an array containing a 'from' currency and a 'to' currency
Given the above parameters, find the conversion rate that maps to the 'from' currency to the 'to' currency.
Your return value should be a number.

Example:
You are given the following parameters:

Rates: ['USD', 'JPY', 110] ['US', 'AUD', 1.45] ['JPY', 'GBP', 0.0070]
To/From currency ['GBP', 'AUD']
Find the rate for the 'To/From' curency. In this case, the correct result is 1.89.
     */




    // Solution1:

    // // TC : O(M * N) -> M = queries.size() && N = 2 * equations.size() ->
    // dfs in worst can go on every key of the map
    //// SC : O(N)



    public static double bestExchangeRate(String[][] rates, double[] values, String src, String dst) {
        double result = Double.MIN_VALUE;
        //Build graph
        HashMap<String,HashMap<String,Double>> graph = new HashMap<>();
        for(int i = 0; i < rates.length; i++) {
            String source = rates[i][0];
            String destination = rates[i][1];
            double exchangeRate = values[i];
            if(source.equals(src) && destination.equals(dst)) {
                result = Math.max(exchangeRate, result);
            }else if(source.equals(dst) && destination.equals(src)) {
                result = Math.max(1 / exchangeRate, result);
            }else {
                if(!graph.containsKey(source))
                    graph.put(source, new HashMap<String,Double>());
                if(!graph.containsKey(destination))
                    graph.put(destination, new HashMap<String,Double>());
                graph.get(source).put(destination, exchangeRate);
                graph.get(destination).put(source, 1 / exchangeRate);
            }
        }
        HashSet<String> visited = new HashSet<String>();
        if(graph.containsKey(src) && graph.containsKey(dst))
            result =  Math.max(result,backtrackEvaluate(graph,src,dst,1.0,visited));
        return result == Double.MIN_VALUE? -1: result;
    }

    private static double backtrackEvaluate(HashMap<String, HashMap<String, Double>> graph,String currNode, String targetNode, double accProduct, Set<String> visited){
        //mark visited
        visited.add(currNode);
        double ret = -1;
        Map<String, Double> neighbors = graph.get(currNode);
        if(neighbors.containsKey(targetNode)){
            ret = accProduct * neighbors.get(targetNode);
        }else{
            for(Map.Entry<String, Double> pair : neighbors.entrySet()){
                String nextNode = pair.getKey();
                if(!visited.contains(nextNode))
                    ret = backtrackEvaluate(graph, nextNode, targetNode, accProduct * pair.getValue(), visited);
                if(ret != -1.0)
                    break;
            }
        }
        return ret;
    }




    // Sol2:




    public static void main1(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> eq1 = new ArrayList<>(Arrays. asList("USD", "JPY"));
        List<String> eq2 = new ArrayList<>(Arrays. asList("USD", "AUD"));
        List<String> eq3 = new ArrayList<>(Arrays. asList("JPY", "GBP"));
        equations.add(eq1);
        equations.add(eq2);
        equations.add(eq3);

        double[] values = {110.0, 1.45, 0.0070};

        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>(Arrays. asList("GBP", "AUD"));
        queries.add(q1);

        System.out.println(calcEquation(equations, values, queries)[0]);

    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Weighted Directed Graph
        Map<String, Map<String, Double>> weightedDirectedGraph = new HashMap<>();
        // key -> 'start' in the equations && value -> 'end' in equations mapped with the value
        int valueIdx = 0;

        // create the weighted directed graph
        for(List<String> equation : equations) {
            String start = equation.get(0);
            String end = equation.get(1);
            double weight = values[valueIdx++];

            weightedDirectedGraph.putIfAbsent(start, new HashMap<>()); // staraight connection
            weightedDirectedGraph.get(start).put(end, weight);

            weightedDirectedGraph.putIfAbsent(end, new HashMap<>()); // also do reverse connection
            weightedDirectedGraph.get(end).put(start, 1.0/weight);
        }

        double[] res = new double[queries.size()]; // to be returned, must of queries size
        int resIdx = 0;
        for(List<String> query : queries) { // we need to do this for every query
            String start = query.get(0);
            String end = query.get(1);

            if(!weightedDirectedGraph.containsKey(start) || !weightedDirectedGraph.containsKey(end)) { // if either start or end is not present in map, we cannot reach the answer
                res[resIdx++] = -1.0;
                continue;
            }

            res[resIdx++] = dfs(weightedDirectedGraph, start, end, new HashSet<>());
        }

        return res;
    }

    private static double dfs(Map<String, Map<String, Double>> weightedDirectedGraph, String start, String end, HashSet<String> visited) {
        if(weightedDirectedGraph.get(start).containsKey(end)) { // if the start's map of connections has the end we are looking for, we have got the result so return
            return weightedDirectedGraph.get(start).get(end);
        }

        visited.add(start); // to avoid cyclic dependency

        for(Map.Entry<String, Double> entry : weightedDirectedGraph.get(start).entrySet()) { // read all the entries of the map of 'start'
            if(visited.contains(entry.getKey())) continue;
            double res = dfs(weightedDirectedGraph, entry.getKey(), end, visited); // dfs on new key using this key as the start (still looking for end)
            if(res == -1.0) continue;

            return res * entry.getValue(); // if a/b = 2.0 and b/c = 3.0 then a/c = 2.0 * 3.0 = 6.0
        }

        return -1.0;
    }






    // Solution3:
    // build graph relationship
    // BFS+HashSet to store visited Node

    public static void main(String[] args) {
        List<Node> data = new ArrayList<Node>();
        data.add(new Node("USD", "JPY", 110));
        data.add(new Node("USD", "AUD", 1.45));
        data.add(new Node("JPY", "GBP", 0.0070));
        System.out.println(getRatio("GBP", "AUD", data));
    }
    public static double getRatio(String start, String end, List<Node> data) {
        Map<String, Map<String, Double>> map = new HashMap();
        for (Node node: data) {
            if (!map.containsKey(node.start)) map.put(node.start, new HashMap());
            map.get(node.start).put(node.end, node.ratio);
            if (!map.containsKey(node.end)) map.put(node.end, new HashMap());
            map.get(node.end).put(node.start, 1.0/node.ratio);
        }
        Queue<String> q = new LinkedList();
        Queue<Double> val = new LinkedList();
        q.offer(start);
        val.offer(1.0);
        Set<String> visited = new HashSet();
        while(!q.isEmpty()) {
            String cur = q.poll();
            double num = val.poll();
            if (visited.contains(cur)) continue;
            visited.add(cur);
            if (map.containsKey(cur)) {
                Map<String, Double> next = map.get(cur);
                for (String key: next.keySet()) {
                    if (!visited.contains(key)) {
                        q.offer(key);
                        if (key.equals(end)) return num*next.get(key);
                        val.offer(num*next.get(key));
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        String start;
        String end;
        double ratio;
        public Node(String s, String e, double r) {
            this.start = s;
            this.end = e;
            this.ratio = r;
        }
    }






}
