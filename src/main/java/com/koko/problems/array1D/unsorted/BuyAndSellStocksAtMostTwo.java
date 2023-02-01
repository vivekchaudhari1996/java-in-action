package com.koko.problems.array1D.unsorted;

public class BuyAndSellStocksAtMostTwo {

    // Question:
    // You are given an array prices where prices[i] is the price of a given stock on the ith day.
    // Find the maximum profit you can achieve. You may complete at most two transactions.
    // Note: You may not engage in multiple transactions simultaneously
    // (i.e., you must sell the stock before you buy again).


    // Example:
    /*
    Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later,
as you are engaging multiple transactions at the same time. You must sell before buying again.
     */


    // Solution:
    // TC: O(n)
    // SC: O(1)

    public static int maxProfit(int[] prices) {
        int minPrice1 = Integer. MAX_VALUE, minPrice2 = Integer. MAX_VALUE;
        int profit1 = 0, profit2 = 0;

        for (int currPrice : prices) {

            minPrice1 = Math.min(currPrice, minPrice1);
            profit1 = Math.max(profit1, currPrice - minPrice1);

            minPrice2 = Math.min(minPrice2, currPrice - profit1);
            profit2 = Math.max(profit2, currPrice - minPrice2);

        }
        return profit2;
    }

    public static void main(String[] args) {
        int [] prices = new int[]{3,3,5,0,0,3,1,4};
        int e = maxProfit(prices);
    }
}
