package com.koko.dataStructures.Misc;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticExpressionConstruct {

    // Q1 :

    // Given an array nums of positive and negative integers and an int target.
    // You have +, -, *, / and () operators.
    // Find out if it's possible to build an expression that evaluates to the target value.
    // Each operator can only be used once.
    // Return any solution or an empty string if it's not possible.

    // Example:
    // Input: nums = [1, 2, 3, 8, 4], target = 44
    // Output: "(3+8)*4"

    // Input: nums = [2, 3, 4, 1, 9, 2], target = 21
    // Output: "3+2*9"



    // Solution: DFS

    public boolean isReachable(ArrayList<Integer> list, int target) {
        if (list == null || list.size() == 0)
            return false;

        int i = 0;
        int j = list.size() - 1;

        ArrayList<Integer> results = getResults(list, i, j);

        for (int num : results) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Integer> getResults(ArrayList<Integer> list,
                                         int left, int right) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (left > right) {
            return result;
        } else if (left == right) {
            result.add(list.get(left));
            return result;
        }

        for (int i = left; i < right; i++) {

            ArrayList<Integer> result1 = getResults(list, left, i);
            ArrayList<Integer> result2 = getResults(list, i + 1, right);

            for (int x : result1) {
                for (int y : result2) {
                    result.add(x + y);
                    result.add(x - y);
                    result.add(x * y);
                    if (y != 0)
                        result.add(x / y);
                }
            }
        }

        return result;
    }


    // Q2:
    // You are given an integer array cards of length 4.
    // You have four cards, each containing a number in the range [1, 9].
    // You should arrange the numbers on these cards in a mathematical expression using the operators
    // ['+', '-', '*', '/'] and the parentheses '(' and ')' to get the value 24.


    // SC: O(N^2)
    // TC: O(N^3)

    // https://leetcode.com/problems/24-game/solution/


    // All possible operations we can perform on two numbers.
    private List<Double> generatePossibleResults(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (b != 0) {
            res.add(a / b);
        }
        if (a != 0) {
            res.add(b / a);
        }
        return res;
    }

    // Check if using current list we can react result 24.
    private boolean checkIfResultReached(List<Double> list) {
        if (list.size() == 1) {
            // Base Case: We have only one number left, check if it is approximately 24.
            return Math.abs(list.get(0) - 24) <= 0.1;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                // Create a new list with the remaining numbers and the new result.
                List<Double> newList = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != j && k != i) {
                        newList.add(list.get(k));
                    }
                }

                // For any two numbers in our list,
                // we perform every operation one by one.
                for (double res : generatePossibleResults(list.get(i), list.get(j))) {
                    // Push the new result in the list
                    newList.add(res);

                    // Check if using this new list we can obtain the result 24.
                    if (checkIfResultReached(newList)) {
                        return true;
                    }

                    // Backtrack: remove the result from the list.
                    newList.remove(newList.size() - 1);
                }
            }
        }
        return false;
    }

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }

        return checkIfResultReached(list);
    }
}
