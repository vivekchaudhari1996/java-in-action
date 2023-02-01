package com.koko.dataStructures.Misc;

import java.util.Scanner;

public class HouseRobber2D {

    // Q: Given a mxn matrix int[][] nums, representing the money in each house.
    // When you rob a house (i, j), you cannot rob the 8 houses nearby.
    // The matrix[i][j]'s 8 neighbors are: matrix[i-1][j], matrix[i+1][j], matrix[i][j+1],
    // matrix[i][j-1], matrix[i+1][j+1], matrix[i-1][j-1], matrix[i+1][j-1], matrix[i-1][j+1]
    // Find the maximum amount of money you can rob.

    // Example:
    /*
    House money:
example:
10 20 10
20 30 20
10 20 10

the best way is

1 0 1
0 0 0
1 0 1
which is 40

or

0 1 0
0 0 0
0 1 0
which is also 40
     */



    // Solution1: Not sure
    // Solution 2: Not sure
    // Using DP: https://pastebin.com/Lpu5f6KA
    // Using Max flow: python below

    public int solve(int[][] matrix) {
        int N = matrix.length;
        if(N == 0)
            return 0;
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = DP(matrix[i]);
        int ans = DP(arr);
        return ans;
    }

    public int DP(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[0] = 0;
        dp[1] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            dp[i + 1] = Math.max(dp[i],dp[i - 1] + arr[i]);
        }
        return dp[arr.length];
    }


    // Sol2

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        solve1(in);
    }


    private static void solve1(Scanner in){
        int grid[][] =
                new int[][]{

                        {1,4},
                        {4,5}

                };

        solve2(grid);
    }

    private static String getM1Zero(int m){
        String ans = "";
        for(int i=0;i<=m;i++) ans+="0";
        return ans;
    }

    private static void solve2(int[][] grid){

        int n = grid.length;
        int m = grid[0].length;

        int ans = getMax(grid, 0, 0, n, m, getM1Zero(m));
        System.out.println(ans);

    }

    private static int getUp(String mask, int x, int y, int n, int m){
        return mask.charAt(1)=='1'?1:0;
    }

    private static int getLeftUp(String mask, int x, int y, int n, int m){
        if(y==0) return 0;
        return mask.charAt(0)=='1'?1:0;
    }

    private static int getRightUp(String mask, int x, int y, int n, int m){
        if(y==m-1) return 0;
        return mask.charAt(2)=='1'?1:0;
    }

    private static int getLeft(String mask, int x, int y, int n, int m){
        if(y==0) return 0;
        return mask.charAt(m)=='1'?1:0;
    }

    private static int getMax(int[][] grid, int x, int y, int n, int m, String mask){

        if(x==n) return 0;

        if(y==m){
            y=0;
            x++;
            return getMax(grid, x, y, n, m, mask);
        }

        int up = getUp(mask, x, y, n, m);
        int leftUp = getLeftUp(mask, x, y, n, m);
        int rightUp = getRightUp(mask, x, y, n, m);
        int left = getLeft(mask, x, y, n, m);

        String oldMask = mask;

        // try to fill

        int ans = 0;

        if(up==0 && leftUp==0 && rightUp==0 && left==0){
            mask += "1";
            mask = mask.substring(1, mask.length());
            ans = Math.max(ans, grid[x][y]+getMax(grid, x, y+1, n, m, mask));
            mask = oldMask;
        }

        //don't fill

        mask += "0";
        mask = mask.substring(1, mask.length());
        ans = Math.max(ans, getMax(grid, x, y+1, n, m, mask));

        mask = oldMask;

        return ans;
    }



    /*
    Solution using Flow:

This is essentially a Maximum Bipartite matching problem.

The grid graph is bipartite, so separate the nodes into two sets, U and V.
Create the following flow network:
 *  create a vertex for the source S and sink T.
 *  for every node u in U with weight w, add an edge from S to u with capacity w
 *  for every node v in V with weight w, add an edge from v to T with capacity w
 *  for every edge (u,v) in the graph, add an edge from u to v with arbitrarily
        large weight, such that any min cut would be better off cutting all the
        other edges instead of any one of these.

The min cut will cut edges adjacent to S and T.
Suppose we have cut this graph.
Then for every edge (u,v) with large capacity, either (S,u) was cut,
or (u,T) was cut.
This cut is isomorphic to a selection of vertices.
Thus for every edge (u,v) either u was selected or v was selected.
Thus our min cut actually corresponds to a min vertex cover.
Once we have the min vertex cover, we can take its complement to get
the max weighted independent set.
"""

def printm(m):
    print("----"*len(m[0]))
    for row in m:
        print(' '.join("%3d"%x for x in row))
    print("----"*len(m[0]))

def flow_solver_update_main(C,tbl,ali,i,j,x,y):
    """ compute flow from s->u->v->t
    node u = (i,j) and node v=(x,y)
    """
    u = tbl[i][j]
    v = tbl[x][y]
    f = min(u,v)
    if f!=0:
        tbl[i][j] -= f
        tbl[x][y] -= f
        if tbl[x][y]==0:
            print("cut %d->t"%((C+1)*x+y+1))
            ali[x][y]=0
        if tbl[i][j]==0:
            print("cut s->%d"%((C+1)*i+j+1))
            ali[i][j]=0

    return f

def flow_solver_update(R,C,tbl,ali,i,j):
    """compute flow from path s to u (i,j) to each adjacent node v"""
    flow = 0
    if i>0:
        flow+=flow_solver_update_main(C,tbl,ali,i,j,i-1,j)
    if j>0:
        flow+=flow_solver_update_main(C,tbl,ali,i,j,i,j-1)
    if j<C:
        flow+=flow_solver_update_main(C,tbl,ali,i,j,i,j+1)
    if i<R:
        flow+=flow_solver_update_main(C,tbl,ali,i,j,i+1,j)
    return flow

def flow_solver(R,C,tbl):
    """return optimal alignment for a given 2d house-robber matrix"""

    printm(tbl)

    # start with an alignment which selects all indices
    # then eliminate any index corresponding to the min cut
    ali=[[1,]*C for i in range(R)]

    #Given:  Partition:  valid paths:
    # 1 2 3      u v u    s->1->2->t
    # 4 5 6  =>  v u v    s->1->4->t
    # 7 8 9      u v u    s->5->8->t (etc)
    # calculate flow passing through all nodes u in U.
    # this is effectivly Dinic's Algorithm for flow.
    # perform a depth first search s->u->v->t
    # all u->v links are implied connections based on locality in the grid.
    f = 0
    for i in range(R):
        for j in range(i%2,C,2):
            f+=flow_solver_update(R-1,C-1,tbl,ali,i,j)

    print("tbl:")
    printm(tbl)
    print("ali:")
    printm(ali)

    print("max flow / min cut :",f) # equal to the min cut

    return ali


def main():

    #
    # 1 2 3
    # 4 5 6
    # 7 8 9

    tbla = [
          [10,20,10], # min cut / max flow is 70
          [20,30,20],
          [10,20,10],
    ]

    tblb = [
          [25, 1,25], # min cut / max flow is 21
          [ 2, 3, 4],
          [ 5,25, 6],
    ]

    tblc = [
          [10,20,10,20,],
          [20,30,20,90,],
          [10,20,10,20,],
    ]

    #C = 5
    #R = 5
    #tblr = [ [random.randint(0,20) for c in range(C)] for r in range(R) ]

    tbl=tbla
    R = len(tbl)
    C = len(tbl[0])
    flow_solver(R,C,tbl)

if __name__ == '__main__':
    main()
     */

}
