package com.koko.dataStructures.Misc;

import java.util.HashSet;
import java.util.PriorityQueue;

public class ShortestPathInGridWithObstacles {

    // Q:
    // You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle).
    // You can move up, down, left, or right from and to an empty cell in one step.
    //
    //Return the minimum number of steps to walk from the upper left corner (0, 0)
    // to the lower right corner (m - 1, n - 1)
    // given that you can eliminate at most k obstacles.
    // If it is not possible to find such walk return -1.


    // Example:
    /*
    Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation:
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).


Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
Output: -1
Explanation: We need to eliminate at least two obstacles to find such a walk.
     */




    // Solution : Using A star algo
    // https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/solution/


    // In the BFS approach, one might notice that when at any specific position,
    // we would systematically explore the surrounding neighbors in all four directions,
    // due to the nature of BFS.
    //
    //However, the action might seem conterintuitive or sub-optimal.
    // Since the destination is located in the lower-right corner of the grid,
    // in order to find the shortest path, the optimal directions to explore should be either right or down,
    // rather than left or up.



    // Time Complexity: O(N*K*log(N*K))
    // BFS: N*K, PQ: log N*K

    // SC: O(N*K)


    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        int[] target = {rows - 1, cols - 1};

        PriorityQueue<StepState> queue = new PriorityQueue<>();
        HashSet<StepState> seen = new HashSet<>();

        // (steps, row, col, remaining quota to eliminate obstacles)
        StepState start = new StepState(0, 0, 0, k, target);
        queue.offer(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            StepState curr = queue.poll();

            // we can reach the target in the shortest path (manhattan distance),
            //   even if the remaining steps are all obstacles
            int remainMinDistance = curr.estimation - curr.steps;
            if (remainMinDistance <= curr.k) {
                return curr.estimation;
            }

            int[] nextSteps = {curr.row, curr.col + 1, curr.row + 1, curr.col,
                    curr.row, curr.col - 1, curr.row - 1, curr.col};

            // explore the four directions in the next step
            for (int i = 0; i < nextSteps.length; i += 2) {
                int nextRow = nextSteps[i];
                int nextCol = nextSteps[i + 1];

                // out of the boundary of grid
                if (0 > nextRow || nextRow == rows || 0 > nextCol || nextCol == cols) {
                    continue;
                }

                int nextElimination = curr.k - grid[nextRow][nextCol];
                StepState newState = new StepState(
                        curr.steps + 1, nextRow, nextCol, nextElimination, target);

                // add the next move in the queue if it qualifies.
                if (nextElimination >= 0 && !seen.contains(newState)) {
                    seen.add(newState);
                    queue.offer(newState);
                }
            }
        }

        // did not reach the target
        return -1;
    }

    static class StepState implements Comparable {
        /**
         * state info for each step:
         * <estimation, steps, row, col, remaining_eliminations>
         */
        public int estimation, steps, row, col, k;
        private int[] target;

        public StepState(int steps, int row, int col, int k, int[] target) {
            this.steps = steps;
            this.row = row;
            this.col = col;
            this.k = k;

            this.target = target;
            int manhattanDistance = target[0] - row + target[1] - col;
            // h(n) = manhattan distance,  g(n) = 0
            // estimation = h(n) + g(n)
            this.estimation = manhattanDistance + steps;
        }

        @Override
        public int hashCode() {
            return (this.row + 1) * (this.col + 1) * this.k;
        }

        @Override
        public int compareTo(Object o) {
            // order the elements solely based on the 'estimation' value
            StepState other = (StepState) o;
            return this.estimation - other.estimation;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof StepState)) {
                return false;
            }
            StepState newState = (StepState) o;
            return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
        }

        @Override
        public String toString() {
            return String.format("(%d %d %d %d %d)",
                    this.estimation, this.steps, this.row, this.col, this.k);
        }
    }




}
