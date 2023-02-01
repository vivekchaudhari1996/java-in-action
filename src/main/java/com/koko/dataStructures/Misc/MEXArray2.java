package com.koko.dataStructures.Misc;

public class MEXArray2 {

    // Q:
    // Define the MEX of an array to be the minimum non negative integer
    // that is not contained in that array. for ex. [1,2,3] => 0
    //Given an array of length n that contains unique integer from 0 to n-1,
    // return an array of length n+1 where array[i] = the number of contiguous subarray of arr such that mex(subarray) = i
    //
    //For ex. if arr = [3,0,2,1] output = [4,4,0,1,1]
    //(four subarrays have mex 0, four subarray have mex 1 and so on.)




    // Solution
    /*
    Let's define gauss(n) = n * (n + 1) / 2 for any natural number n. I'll be indexing by 0.

MEX = 0: count all subarrays that don't include 0.
So if the index of 0 is i, then we include all subarrays on [0, i-1] and [i+1, n-1].
 This is equal to gauss(i) + gauss(n - i - 1).

MEX = 1: include 0, don't include 1. Let's say the index of 0 is i again, and the index of 1 is j.
Two cases:
i < j: then we include all subarrays that start at the left of i or equal,
and end before j.
(i + 1) possible starting elements, (j - i) possible ends.
Total number is (i + 1) * (j - 1).

j < i: similar case, but we include all subarrays that start strictly right of j,
and end at or after i. (i - j) possible starting elements, (n - i) possible ends.
(i - j) * (n - i) total.

MEX = 2: include 0 and 1, don't include 2.
Again, index of 0 is i, index of 1 is j, and now index of 2 is k.
Three cases this time (I promise I'm going somewhere with this):
max(i, j) < k. Then we have the same case as i < j above: start left of min(i, j) and end before k.
k < min(i, j): Same as j < i above, start after k and end after j.
min(i, j) < k < max(i, j): This is a new case. If 2 is between 0 and 1,
then we can't possibly have a mex of 2 in any subarray,
because it's impossible to have both 0 and 1 without 2.
So it's 0 in this case.


We can generalize the strategy for MEX = 2; for MEX = K, keep track of the leftmost and rightmost occurrences of any element you've seen from [0, K - 1]. If K is between the min and max, you can't get MEX = K in any subarray. If it isn't, you can count the number of possible subarrays using the strategies I mentioned above, depending on whether K is to the left of the min or right of the max. For MEX = N, it's always 1 - we need every element in the permutation. Time/space complexity are both O(N), see my code below. I also included code at the end to test it automatically against 1000 random test cases.
     */







    // Python code

    /*
    def gauss(n):
    return n * (n + 1) // 2

def numMexSubarrays(a):
    n = len(a)
    ret = []
    index = [-1 for _ in range(n)]
    for i,el in enumerate(a):
        index[el] = i

    zeroIndex = index[0]
    ret = [gauss(zeroIndex) + gauss(n - zeroIndex - 1)]
    mini = maxi = index[0]
    for k in range(1, n):
        ind = index[k]
        this = None
        if ind < mini:
            this = (mini - ind) * (n - maxi)
            mini = ind
        elif ind > maxi:
            this = (mini + 1) * (ind - maxi)
            maxi = ind
        else:
            this = 0

        ret.append(this)

    # mex = n will *always* be the whole array, nothing else
    ret.append(1)

    return ret

#### AUTOMATED TESTING BELOW

def getMex(a):
    ret = 0
    seen = set()
    for el in a:
        seen.add(el)
        while ret in seen:
            ret += 1

    return ret

def brute(a):
    n = len(a)
    ret = [0 for _ in range(n+1)]
    for i in range(n):
        for j in range(i, n):
            sub = a[i:j+1]
            ret[getMex(sub)] += 1

    return ret

N = 1000
L = 50
from random import shuffle, randint
for _ in range(N):
    l = randint(1, L)
    a = list(range(l))
    shuffle(a)

    mine = numMexSubarrays(a)
    actual = brute(a)

    if mine != actual:
        print("Bad")
        print(a)
        print(mine, actual)
        break
     */
}
