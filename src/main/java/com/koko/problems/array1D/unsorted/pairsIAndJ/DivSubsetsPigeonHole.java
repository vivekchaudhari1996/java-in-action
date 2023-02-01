package com.koko.problems.array1D.unsorted.pairsIAndJ;

public class DivSubsetsPigeonHole {

    // Question:
    // You are given a multiset of N integers.
    // Please find such a nonempty subset of it that the sum of the subset's elements is divisible by N.
    // Otherwise, state that this subset doesn't exist.

    // Example:
    /*
    Input:
4 6 10
Output:
1

We can pick {6} as the subset, then its sum is 6 and this is divisible by 3 - the size of the initial multiset.
Its index is 1.
     */


    // Solution:
    // Using Pigeonhole Principle : we can say that A subarray will always exist
    // such that sum of its elem % N = 0
    // And every subaaray is also a subset.
    // Maintain a cumulative sum array.
    // Now, choosing two indices ; i and j
    // (sum[j] -sum[i])%N = 0
    // sum[j]%N = sum[i]%N
    // So, just find sum[j]= sum[i]
    // And those two points will be the answer (i+1 ...j)



}
