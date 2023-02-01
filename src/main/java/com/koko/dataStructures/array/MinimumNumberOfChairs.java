package com.koko.dataStructures.array;

import java.util.Arrays;

public class MinimumNumberOfChairs {

    // ###MaximumIntervalsOverlap
    // ###MaximumNumberOfGuestsAtATime


    // Q:
    /*
    There are n guests who are invited to a party.
    The k-th guest will attend the party at time S[k] and leave the party at time E[k].

Given an integer array S and an integer array E, both of length n,
return an integer denoting the minimum number of chairs you need such
that everyone attending the party can sit down.

     */




    // Example:
    /*
    Input: S = [1, 2, 6, 5, 3], E = [5, 5, 7, 6, 8]
Output: 3
Explanation:
There are five guests attending the party.
The 1st guest will arrive at time 1. We need one chair at time 1.
The 2nd guest will arrive at time 2. There are now two guests at the party, so we need two chairs at time 2.
The 5th guest will arrive at time 3. There are now three guests at the party, so we need three chairs at time 3.
The 4th guest will arrive at time 5 and, at the same moment, the 1st and 2nd guests will leave the party.
There are now two (the 4th and 5th) guests at the party, so we need two chairs at time 5.
The 3rd guest will arrive at time 6, and the 4th guest will leave the party at the same time.
There are now two (the 3rd and 5th) guests at the party, so we need two chairs at time 6.
So we need at least 3 chairs.
     */





    // Solution1:
    // The idea is to consider all events (all arrivals and exits) in sorted order.
    // Once we have all events in sorted order, we can trace the number of guests at any time
    // keeping track of guests that have arrived, but not exited.

    // TC: O(nlogn)
    // SC: O(1)

    private static int minChairs(int[] S, int[] E) {
        Arrays.sort(S);
        Arrays.sort(E);

        int i=0, j=0;
        int chairs=1;
        int count =0;

        while(i<S.length) {

            if(S[i] <E[j]) {
                chairs = Integer.max(++count, chairs);
                i++;
            }
            else{
                count --;
                j++;
            }
        }
        return chairs;
    }



    // Sol2:

    // Time Complexity : O(max(departure time))
    // Auxiliary Space : O(max(departure time))

    public static void maxOverlap(int []start,int [] end ,int n)
    {
        // Finding maximum starting time
        int maxa = Arrays.stream(start).max().getAsInt();

        // Finding maximum ending time
        int maxb = Arrays.stream(end).max().getAsInt();

        int maxc = Math.max(maxa,maxb);

        int []x = new int[maxc + 2];
        Arrays.fill(x, 0);

        int cur=0,idx=0;

        // Creating an auxiliary array
        for(int i = 0; i < n; i++)
        {
            // Lazy addition
            ++x[start[i]];
            --x[end[i]+1];
        }

        int maxy=Integer.MIN_VALUE;

        //Lazily Calculating value at index i
        for(int i = 0; i <= maxc; i++)
        {
            cur+=x[i];
            if(maxy < cur)
            {
                maxy = cur;
                idx = i;

            }
        }
        System.out.println("Maximum value is:"+
                maxy+" at position: "+idx+"");

    }
}
