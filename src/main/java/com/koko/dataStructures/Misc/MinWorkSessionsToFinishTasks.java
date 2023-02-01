package com.koko.dataStructures.Misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinWorkSessionsToFinishTasks {

    // Q:
    /*
    There are n tasks assigned to you.
    The task times are represented as an integer array tasks of length n,
    where the ith task takes tasks[i] hours to finish.
    A work session is when you work for at most sessionTime consecutive hours and then take a break.

You should finish the given tasks in a way that satisfies the following conditions:

If you start a task in a work session, you must complete it in the same work session.
You can start a new task immediately after finishing the previous one.
You may complete the tasks in any order.

Given tasks and sessionTime, return the minimum number of work sessions
needed to finish all the tasks following the conditions above.
     */



    // Example:
    /*
    Input: tasks = [1,2,3], sessionTime = 3
Output: 2
Explanation: You can finish the tasks in two work sessions.
- First work session: finish the first and the second tasks in 1 + 2 = 3 hours.
- Second work session: finish the third task in 3 hours.


Input: tasks = [3,1,3,1,1], sessionTime = 8
Output: 2
Explanation: You can finish the tasks in two work sessions.
- First work session: finish all the tasks except the last one in 3 + 1 + 3 + 1 = 8 hours.
- Second work session: finish the last task in 1 hour.

     */





    // Solution1:
    // Using bitmask

    // TC: O(n*2^n)

    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length, MAX = Integer.MAX_VALUE;
        int[][] dp = new int[1<<n][2];
        dp[0][0] = 1;
        dp[0][1] = 0;

        for(int i = 1; i < (1 << n); i++) {
            dp[i][0] = MAX;
            dp[i][1] = 0;

            for(int t = 0; t < n; t++) {
                if(((1<<t) & i) == 0) continue;

                int[] prev = dp[(1<<t) ^ i];
                if(prev[1] + tasks[t] <= sessionTime) {
                    dp[i] = min(dp[i], new int[]{prev[0], prev[1] + tasks[t]});
                }else{
                    dp[i] = min(dp[i], new int[]{prev[0] + 1, tasks[t]});
                }
            }
        }

        return dp[(1<<n) - 1][0];
    }

    private int[] min(int[] d1, int[] d2) {
        if(d1[0] > d2[0]) return d2;
        if(d1[0] < d2[0]) return d1;
        if(d1[1] > d2[1]) return d2;

        return d1;
    }




    // Sol2:
    // Using DFS


    int min;
    public int minSessions2(int[] tasks, int sessionTime) {
        min = tasks.length + 1; // upper bound, any result can't over this upper bound

        Arrays.sort(tasks);
        reverse(tasks);
        dfs(tasks, 0, new int[tasks.length], sessionTime, 0);
        return min;
    }
    private void dfs(int[] tasks, int start, int[] bucket, int target, int count) {
        if(count >= min) {
            return; // pruning
        }

        if (start == tasks.length) {
            min = count;
            return;
        }

        // refer to this: https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/discuss/1009817/One-branch-cutting-trick-to-solve-three-LeetCode-questions
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < bucket.length; i++) {
            if (seen.contains(bucket[i])) {
                continue;
            }
            if (tasks[start] + bucket[i] > target) {
                continue;
            }
            if(bucket[i] == 0) {
                // new task period, count++
                count++;
            }
            seen.add(bucket[i]);

            bucket[i] += tasks[start];
            dfs(tasks, start+1, bucket, target, count);
            bucket[i] -= tasks[start];
        }

    }

    private void reverse(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
