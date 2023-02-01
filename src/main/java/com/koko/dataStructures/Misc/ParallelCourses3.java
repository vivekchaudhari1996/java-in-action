package com.koko.dataStructures.Misc;

import java.util.*;

public class ParallelCourses3 {

    // Q:
    /*
    You are given an integer n, which indicates that there are n courses labeled from 1 to n.
    You are also given a 2D integer array relations where relations[j] = [prevCoursej, nextCoursej]
    denotes that course prevCoursej has to be completed before course nextCoursej
    (prerequisite relationship).

    Furthermore, you are given a 0-indexed integer array time where time[i] denotes how many months
    it takes to complete the (i+1)th course.

You must find the minimum number of months needed to complete all the courses following these rules:

You may start taking a course at any time if the prerequisites are met.
Any number of courses can be taken at the same time.
Return the minimum number of months needed to complete all the courses.
     */



    // Example:
    /*
    Input: n = 3, relations = [[1,3],[2,3]], time = [3,2,5]
Output: 8
Explanation: The figure above represents the given graph and the time required to complete each course.
We start course 1 and course 2 simultaneously at month 0.
Course 1 takes 3 months and course 2 takes 2 months to complete respectively.
Thus, the earliest time we can start course 3 is at month 3, and the total time required is 3 + 5 = 8 months.
     */



    // Sol1:
    // idea:
    /*
    Use in-degree to find the courses to start with.
    i.e. Courses with no prerequisite will be added first in the pool(in-degree == 0)
    and set completionTime = time[currentCourse].

After completing a course, we update prerequisite courses remaining i.e. decrement (--indegree[v])
and update next course.
completionTime[nextCourse] = max(completionTime[nextCourse], completionTime[prevCourse] + time[nextCourse])
If all prerequisite are complete(indegree == 0) we add it to queue
After visiting all courses we take maximum of completionTime from all courses.
     */


    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer> adj[] = new ArrayList[n];
        int indegree[] = new int[n];
        int completionTime[] = new int[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for(int relation[]: relations){
            int u = relation[0]-1, v = relation[1]-1;
            adj[u].add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){ // if no prerequisite add it to queue
                completionTime[i] = time[i];
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            for(int v: adj[u]){
                completionTime[v] = Math.max(completionTime[v], completionTime[u] + time[v]);
                if(--indegree[v] == 0){ // when all prerequisite are complete add the next course
                    q.add(v);
                }
            }
        }
        int res=0;
        for(int x: completionTime) res = Math.max(res, x);
        return res;
    }





    // Solution2:

    // idea:
    /*
    This is kind of topological sort, but I always forget that sort so I use a simpler (to remember) version.

When we build our dependency tree al (short for adjacency list),
we track how many prereq each course has.
Then, we find courses with no prereq and put them in the queue.
As we "take" a course, we decrease prereq of dependent courses.
Courses with prereq == 0 can be taken during the next iteration.

For each node, we track the lead time - minimum time to complete all prerequisites.
As we "take" a course, we set its completion time (which is, lead[i] + time[i]) as the lead[j] time
for all dependent courses. Note that we need to use the maximum completion time among all prerequisites.
     */

    public int minimumTime2(int n, int[][] relations, int[] time) {
        List<List<Integer>> al = new ArrayList<>();
        int[] prereq = new int[n], lead = new int[n];
        for (int i = 0; i < n; ++i)
            al.add(new ArrayList<Integer>());
        for (var r : relations) {
            ++prereq[r[1] - 1];
            al.get(r[0] - 1).add(r[1] - 1);
        }
        List<Integer> q = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (prereq[i] == 0)
                q.add(i);
        while(!q.isEmpty()) {
            List<Integer> q1 = new ArrayList<>();
            for (int i : q) {
                lead[i] += time[i];
                for (int j : al.get(i)) {
                    lead[j] = Math.max(lead[j], lead[i]);
                    if (--prereq[j] == 0)
                        q1.add(j);
                }
            }
            q = q1;
        }
        return Arrays.stream(lead).max().getAsInt();
    }
}

