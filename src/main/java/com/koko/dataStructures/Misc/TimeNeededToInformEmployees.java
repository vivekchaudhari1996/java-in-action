package com.koko.dataStructures.Misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToInformEmployees {

    // Q:
    /*
    A company has n employees with a unique ID for each employee from 0 to n - 1.
    The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager
of the i-th employee, manager[headID] = -1.
Also, it is guaranteed that the subordination relationships have a tree structure.

Return the number of minutes needed to inform all the employees about the urgent news.
     */


    // Example:
    /*
    Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
Output: 1
Explanation: The head of the company with id = 2 is the direct manager of all the employees
in the company and needs 1 minute to inform them all.
The tree structure of the employees in the company is shown.
     */



    // Solution:
    // 1. Using DFS

    // TC: O(N)


    ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    //dfs
    private int dfs(int node,int[] informTime){

        int max = 0;
        for(int i:a.get(node)){
            max = Math.max(max,dfs(i,informTime)+informTime[node]);
        }
        return max;
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // graph creation
        for(int i=0;i<n;i++){
            a.add(new ArrayList<Integer>());
        }

        for(int i=0;i<manager.length;i++){
            if(manager[i]>=0)
                a.get(manager[i]).add(i);
        }
        return dfs(headID,informTime);

    }




    // 2. Using BFS
    // TC: O(N)

    public int numOfMinutes2(int n, int headID, int[] manager, int[] informTime) {
        // graph creation
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(new ArrayList<Integer>());
        }

        for(int i=0;i<manager.length;i++){
            if(manager[i]>=0)
                a.get(manager[i]).add(i);
        }

        //bfs
        Queue<int[]> q = new LinkedList<>();
        int max=0;
        q.add(new int[]{headID,0});
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                int[] temp = q.poll();
                max= Math.max(max,temp[1]);
                if(a.get(temp[0]).size()==0) continue;
                for(int j:a.get(temp[0])){
                    q.add(new int[]{j,temp[1]+informTime[temp[0]]});
                }
            }
        }
        return max;

    }
}
