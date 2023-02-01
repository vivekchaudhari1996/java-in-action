package com.koko.dataStructures.array;

import java.util.Arrays;

public class MinimumAbsDiffOfServerLoads {

    // ###MinimumSubsetSum
    // ###MinimumSumPartition
    // ###0/1Knapsack
    // ###DP



    // Q:
    /*
    There are some processes that need to be executed.
    The amount of load that process causes a server that runs it, is being represented
    by a single integer. The total load caused on a server is the sum of the loads of
    all the processes that run on that server. You have at your disposal two servers,
    on which the mentioned processes can be run.

    Your goal is to distribute given processes between those two servers in a way that,
    the absolute difference of their loads will be minimized.

Given an array of A[] of N integers, which represents loads caused by successive processes,
the task is to print the minimum absolute difference of server loads.
     */





    // Example:
    /*
    nput: A[] = {1, 2, 3, 4, 5}
Output: 1
Explanation:
Distribute the processes with loads {1, 2, 4} on the first server and
{3, 5} on the second server, so that their total loads will be 7 and 8, respectively.
The difference of their loads will be equal to 1.


Input: A[] = {10, 10, 9, 9, 2}
Output: 0
     */






    // Solution:
    // DP 0/1 Knapsack


    /*
    The problem can be visualized as a variation of the 0/1 Knapsack problem in which
    2 servers are given, and we have to distribute the loads as equally possible.
    Therefore, it can be solved using Dynamic Programming. Below are the steps:

Compute required_load, which is equal to (sum of all loads / 2),
since the loads need to distributed as equally possible.
Finally, DP[n][required_load] will contain the load on server1 which is as balanced as possible.
     */


    // Time Complexity: O(N*S) where N is the number of servers
    // and S is the sum of the load all servers.
    //Auxiliary Space: O(N*S)

    static int minServerLoads(int n, int[] servers)
    {
        // Compute the overall server load
        int totalLoad = Arrays.stream(servers).sum();

        int requiredLoad = totalLoad / 2;

        // Stores the results of subproblems
        int dp[][] = new int[n + 1][requiredLoad + 1];

        // Fill the partition table
        // in bottom up manner
        for (int i = 1; i < n + 1; i++)
        {
            for (int j = 1; j < requiredLoad + 1; j++)
            {
                // If i-th server is included
                if (servers[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];

                    // If i-th server is excluded
                else
                    dp[i][j] = Math.max(dp[i - 1][j],
                            servers[i - 1] +
                                    dp[i - 1][j - servers[i - 1]]);
            }
        }

        // Server A load: total_sum-ans
        // Server B load: ans
        // Diff: abs(total_sum-2 * ans)
        return totalLoad - 2 * dp[n][requiredLoad];
    }

    // Driver Code
    public static void main(String[] args)
    {
        int N = 5;
        int servers[] = {1, 2, 3, 4, 5};

        // Function call
        System.out.print(minServerLoads(N, servers));
    }




    // Sol2:
    // Using 1D dp array.


    public int getMinDifferenceServerLoads(int[] loads) {
        int sum = 0;
        for(int i : loads)
            sum+= i;
        int serverMax = sum/2;
        int[] dp = new int[serverMax+1];
        for(int load : loads) {
            if(dp[serverMax] == serverMax)
                break;
            if(load > serverMax)
                continue;
            for(int i=serverMax; i >= load; i--) {
                dp[i] = Math.max(dp[i], load + dp[i - load]);
            }
        }
        return (sum - dp[serverMax]) - dp[serverMax];
    }

}
