package com.koko.dataStructures.Misc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProcessTasksUsingServers {

    // Q:
    /*
    You are given two 0-indexed integer arrays servers and tasks of lengths n and m respectively.
    servers[i] is the weight of the ith server, and tasks[j] is the time needed to process
    the jth task in seconds.

Tasks are assigned to the servers using a task queue. Initially, all servers are free, and the queue is empty.
A server that is assigned task j at second t will be free again at second t + tasks[j].

Build an array ans of length m, where ans[j] is the index of the server the jth task will be assigned to.

Return the array ans.
     */


    // Example:
    /*
    Input: servers = [3,3,2], tasks = [1,2,3,2,1,2]
Output: [2,2,0,2,1,2]
Explanation: Events in chronological order go as follows:
- At second 0, task 0 is added and processed using server 2 until second 1.
- At second 1, server 2 becomes free. Task 1 is added and processed using server 2 until second 3.
- At second 2, task 2 is added and processed using server 0 until second 5.
- At second 3, server 2 becomes free. Task 3 is added and processed using server 2 until second 5.
- At second 4, task 4 is added and processed using server 1 until second 5.
- At second 5, all servers become free. Task 5 is added and processed using server 2 until second 7.
     */




    // Solution:

    // Idea:
    // Check all servers that are free at this point and add them to a PQ
    //Poll the PQ and assign tasks to the free servers


    private static class Server {
        int weight;
        int index;

        public Server(int weight, int index) {
            this.weight = weight;
            this.index = index;
        }
    }

    // Represents task-server assignment
    private static class Assign {
        // time at which this server will become free again
        int freeTime;
        Server server;

        public Assign(int freeTime, Server server) {
            this.freeTime = freeTime;
            this.server = server;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        // PQ to store servers (server with least weight or least index is polled first)
        Queue<Server> serverQueue = new PriorityQueue<>((s1, s2) -> {
            if (s1.weight - s2.weight != 0)
                return s1.weight - s2.weight;
            return s1.index - s2.index;
        });

        // PQ to store assigned servers (server with least freeTime is polled first)
        Queue<Assign> assignQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.freeTime));

        for (int i = 0; i < servers.length; ++i)
            serverQueue.add(new Server(servers[i], i));

        int j = 0;
        int time = 0;
        int[] ans = new int[tasks.length];

        while (j < tasks.length) {
            // check what all servers have become free
            while (!assignQueue.isEmpty() && assignQueue.peek().freeTime <= time) {
                serverQueue.add(assignQueue.poll().server);
            }
            // assign tasks to available servers
            // using condition "j <= time" because accd. to question "At second j, the jth task is inserted into the queue"
            while (!serverQueue.isEmpty() && j <= time && j < tasks.length) {
                int task = tasks[j];
                Server server = serverQueue.poll();
                ans[j] = server.index;
                assignQueue.add(new Assign(time + task, server));
                ++j;
            }
            // increase time, so that we can process next task
            if (!serverQueue.isEmpty())
                time++;
            else
                // when no servers are available, move to next available server's freeTime
                // this decreases loop iterations, since there can be a situation where time <<< next freeTime
            {
                assert assignQueue.peek() != null;
                time = assignQueue.peek().freeTime;
            }
        }

        return ans;
    }
}
