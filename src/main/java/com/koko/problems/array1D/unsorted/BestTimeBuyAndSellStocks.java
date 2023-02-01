package com.koko.problems.array1D.unsorted;

public class BestTimeBuyAndSellStocks {

    // Question:
    // You are given an array prices where prices[i] is the price of a given stock on the ith day.
    // You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
    // in the future to sell that stock.
    // Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    // Example:
    /*
    Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
     */



    // Solution:
    // STEPS:
//    1) Finding minimum element of prices array- that will be the day to buy the stock
//    2) Finding maximum profit by subtracting minimum element with the current element of prices array

    // TC: O(n)
    // SC: O(1)


    public int maxProfit(int[] arr) {
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxPro = Math.max(maxPro, arr[i] - minPrice);
        }
        return maxPro;
    }
}
