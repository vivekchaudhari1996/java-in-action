package com.koko.dataStructures.Misc;

import java.util.stream.IntStream;

public class LastDayToCrossLands {

    // Q:
    /*
    There is a 1-based binary matrix where 0 represents land and 1 represents water.
    You are given integers row and col representing the number of rows and columns in the matrix, respectively.

Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water.
You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day,
the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).

You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells.
You can start from any cell in the top row and end at any cell in the bottom row.
You can only travel in the four cardinal directions (left, right, up, and down).

Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
     */



    // Solution1:
    // DP with Binary Search


    int[][] dir = new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        int grid[][] = new int[row][col];
        int low = 0, high = cells.length - 1;
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            for(int i = 0; i <= mid; i++)
                grid[cells[i][0] -1][cells[i][1] - 1] = 1;

            if(helper(grid, new boolean[row][col])){
                ans = mid;
                low = mid + 1;
            }

            else high = mid - 1;

            for(int i = 0; i < grid.length; i++)
                for(int j = 0; j < grid[i].length; j++)
                    grid[i][j] = 0;
        }

        return ans + 1;
    }

    public boolean helper(int[][] grid, boolean[][] visited){
        for(int i = 0; i < grid[0].length; i++)
            if(grid[0][i] == 0 && !visited[0][i] &&safe(0, i, grid, visited)) return true;
        return false;
    }

    public boolean safe(int i, int j, int[][] cells, boolean[][] visited){
        if(i < 0 || j < 0 || i >= visited.length || j >= visited[i].length || visited[i][j] || cells[i][j] == 1) return false;
        if(i == cells.length - 1 && j < cells[i].length && cells[i][j] == 0) return true;

        visited[i][j] = true;
        for(int k = 0; k < dir.length; k++)
            if(safe(i + dir[k][0], j + dir[k][1], cells, visited)) return true;
        return false;
    }




    // Sol2:
    // Disjoint Set Union Find

    // Here is the union find approach,
    // I assign m*n to be the dummy head of the first row and m*n+1 to be the dummy tail of the last row.
    // Then we iterate the cells backwards to add lands back,
    // as soon as two dummy head & tail are connected, we return that day.

    // Time Complexity O(MN)

    public int latestDayToCross2(int m, int n, int[][] cells) {
        UF uf = new UF(m*n+2);
        for (int i = 0; i < n; i++){ // dummy connection
            uf.union(m*n, i);
            uf.union(m*n+1, m*n-i-1);
        }
        int ans = m*n-1;
        for (; !uf.isConnected(m*n, m*n+1); ans--){ // loop until two dummies are connected
            int x = cells[ans][0]-1, y = cells[ans][1]-1, cur = x*n+y;
            uf.isLand[cur] = true;
            uf.unite(cur, (x-1)*n+y); // unite 4 neighbors
            uf.unite(cur, (x+1)*n+y);
            uf.unite(cur, x*n+Math.min(n-1, y+1));
            uf.unite(cur, x*n+Math.max(0, y-1));
        }
        return ++ans;
    }

    private class UF { // normal UF template
        int[] parent;
        int[] rank;
        boolean[] isLand;
        UF (int n){
            parent = IntStream.range(0, n).toArray();
            rank = new int[n];
            isLand = new boolean[n];
        }

        int find(int x){
            return x == parent[x]? x : (parent[x] = find(parent[x]));
        }

        void unite(int x, int y){
            if (y < 0 || y >= rank.length-2 || !isLand[y])
                return;
            union(x, y);
        }

        void union(int x, int y){
            x = find(x);
            y = find(y);
            if (x == y)
                return;
            if (rank[x] > rank[y]){
                parent[y] = x;
            }else{
                parent[x] = y;
                if (rank[x] == rank[y]){
                    rank[y]++;
                }
            }
        }

        boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
    }



    // Sol3:
    // DFS and Binary Search

    // TC: O(MNlogMN)

    public int latestDayToCross3(int row, int col, int[][] cells) {
        int first = 1;
        int last = cells.length;

        while(first <= last) {
            int mid = (first + last) / 2;
            boolean p_mid = solve(row, col, cells, mid);
            boolean p_mid1 = solve(row, col, cells, mid + 1);
            if (p_mid == true && p_mid1 == false) {
                return mid;
            } else if (p_mid == false) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return - 1;
    }

    boolean solve(int row, int col, int[][] cells, int mid) {
        int[][] grid = new int[row][col];
        for(int i = 0; i < mid; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        for(int j = 0; j < col; j++) {
            if (grid[0][j] == 0) {
                boolean reach = dfs(0, j, grid);
                if (reach == true) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 1 || grid[i][j] == 2) return false;

        if (i == grid.length - 1) {
            return true;
        }

        grid[i][j] = 2;

        if (dfs(i + 1, j, grid) == true || dfs(i - 1, j, grid) == true || dfs(i, j + 1, grid) == true || dfs(i, j - 1, grid) == true) {
            return true;
        } else {
            return false;
        }
    }
}
