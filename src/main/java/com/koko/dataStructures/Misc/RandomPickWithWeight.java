package com.koko.dataStructures.Misc;

import java.util.ArrayList;
import java.util.Random;

public class RandomPickWithWeight {

    //Q:
    /*
    You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.

You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive)
and returns it. The probability of picking an index i is w[i] / sum(w).

For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%),
and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
     */


    // Example:
    /*
    Input
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output
[null,1,1,1,1,0]

Explanation
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.
     */



    //Solution:
    // 1. Easiest, add each index to an arraylist for each weight -- note memory limit exceeds.
    // Then pick a random value from the arraylist.

    class Solution {

        private ArrayList<Integer> nums;
        private Random rand;

        public Solution(int[] w) {
            this.nums = new ArrayList<>();
            this.rand = new Random();

            for (int i = 0; i < w.length; i++)
                for (int j = 0; j < w[i]; j++)
                    this.nums.add(i);
        }

        public int pickIndex() {
            int n = this.rand.nextInt(nums.size());
            return nums.get(n);
        }
    }


    // 2. Next solution, let's keep a running total of the weight.
    // Then draw a random number based on the total.
    // Find the first element's value in an index, that is below this weight


    class Solution2 {

        private int[] nums;
        private int total;
        private Random rand;

        public Solution2(int[] w) {
            this.nums = new int[w.length];
            this.rand = new Random();

            int runningTotal = 0;
            for (int i = 0; i < w.length; i++) {
                runningTotal += w[i];
                this.nums[i] = runningTotal;
            }

            this.total = runningTotal;
        }

        public int pickIndex() {
            // no numbers to pick!
            if (this.total == 0)
                return -1;

            int n = this.rand.nextInt(this.total);
            for (int i = 0; i < this.nums.length; i++) {
                if (n < this.nums[i])
                    return i;
            }

            return - 1;
        }
    }


    // 3. Optimized -- use binary search to find the index.
    // Also made the calculations of the cumulative value run in place,
    // which isn't necessary but is a little bit cleaner


    class Solution3 {

        private int[] nums;
        private int total;
        private Random rand;

        public Solution3(int[] w) {
            this.rand = new Random();

            for (int i = 1; i < w.length; i++) {
                w[i] += w[i - 1];
            }

            this.nums = w;
            this.total = w[w.length - 1];
        }

        public int pickIndex() {
            // no numbers to pick!
            if (this.total == 0)
                return -1;

            int n = this.rand.nextInt(this.total) + 1; // the value pulled for {2, 5, 7} could be 0, 1, 2 all the way up to 7; we want a pulled value of 2 to actually coordinate with the second index (5), because three numbers do not fall into the range!

            //I actually used random.nextInt( wSums[len-1] + 1), and I know why it failed. For wsum[] = {2,7,10,14}, it generates a random value in range [0, 14], totally 15 numbers. If the random number is 0, 1, 2, our code will return index 0, so the probability for selecting the first one is 3/15.

            // this is the implementation of a left searching binary search
            int lo = 0, hi = this.nums.length - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                // pulled the exact value of an index
                if (this.nums[mid] == n)
                    return mid;
                else if (this.nums[mid] < n)
                    lo = mid + 1;
                else
                    hi = mid; // find the leftmost value incase two of the indexes are the same and one is zero
            }
            return lo;
        }
    }

}
