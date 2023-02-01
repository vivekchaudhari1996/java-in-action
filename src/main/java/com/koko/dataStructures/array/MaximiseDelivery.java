package com.koko.dataStructures.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaximiseDelivery {

    // ###PriorityQueue



    // Q:
    /*
    You have n items, cost is c(i) and delivery cost is d(i).
    If customer orders more than one item, then they get it for the minimum delivery cost.
    How do you find the maximum amount of money you can make after delivering m items?
     */



    // Example:
    /*
    cost and delivery cost respectively (first column being cost, second being delivery cost):
Item 1: 7, 10
Item 2: 4, 15
Item3: 8, 1

m = 2

Input format (java): int n, int m, int[][] arr where n is the total number of items,
m is the maximum number of items you can deliver,
arr has each row with first element being cost, second being delivery cost.

Output: 31 (You choose the first two items because if you chose the 3rd item,
the delivery cost for 2 items would be 1 + 1 (since 1 is the mimimum delivery cost)
so you would end up with 23 + 2 = 25.
     */





    // Solution:
    // problem will be solved by priority_queue by sorting by delivering cost.

        public static void main(String[] args) {
            int n = 3;
            int m = 2;

            List<Pair> list = new ArrayList<>();
            list.add(new Pair(7, 10));
            list.add(new Pair(4, 15));
            list.add(new Pair(8, 1));

            // We will first sort on the basis of delivery cost,
            // as we need to choose the max possible delivery price to maximize the cost
            list.sort((o1, o2) -> o2.delivery - o1.delivery);

            //Create a priority queue to offer the items with the least price
            PriorityQueue<Integer> queue = new PriorityQueue<>();


            long maxSale = Integer.MIN_VALUE;
            long totalCost = 0;

            for (Pair item : list) {
                //If the queue of items is full. Remove the least price item
                if (queue.size() == m) {
                    totalCost -= queue.poll();
                }
                //Add the new item to the cost
                totalCost += item.cost;
                queue.add(item.cost);

                //Check for the max sale made after item addition
                maxSale = Math.max(maxSale, totalCost + ((long) queue.size() * item.delivery));
            }

            System.out.println("Total delivery: " + maxSale);
        }

        private static class Pair {
            int cost;
            int delivery;

            public Pair(int cost, int delivery) {
                this.cost = cost;
                this.delivery = delivery;
            }
        }

}
