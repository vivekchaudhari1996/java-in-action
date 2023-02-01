package com.koko.dataStructures.Misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GridGameX {

    // Q:
    /*
    We're given a Grid which is initially empty.
    Now, we want to play a game on it by placing the character 'X'.
Each time, we can place an 'X' at one of the coordinates in the grid (i, j) and we need to return
whether the game has ended or not.

The game is considered to be won when there exists an 'X' path from the first column of the grid to the last column.
We need to efficiently play this game now.
For a path to be winning, we need to consider only the elements in the 4 directions from it...i.e.
we can't take up the diagonal elements.
     */


    // Solution1:

    // I Guess DSU is right for the first problem.
    // I don't know why your TC is O(M * N * N). we can maintain isLeftConnected , isRightConnected flags
    // with each component and during merging, we will just check if both these flags got true or not.
    // if both are true game is over. and TC is O(MN) with compression and size/rank. question
    //
    // close to it is https://leetcode.com/problems/last-day-where-you-can-still-cross/

    // For more details about TC is let's say Q moves will be played,
    // for each query we need to merge and find out if the connection has happened or not,
    // both can be done in O(alpha) , using DSU compression and size/rank.
    // as Q can be goes to MN we have TC of O(MNalpha) as alpha grow very slow we can assume it constant ~1.




    // Sol2:

    static int[] dir= new int[]{-1,0,1,0,-1};
    static Map<String, Boolean> map;
    public static void main(String[] args)throws Exception {
        boolean flag= false;
        Scanner sc= new Scanner(System.in);
        System.out.println("ROWS");
        int m= sc.nextInt();
        System.out.println("COLUMNS");
        int n= sc.nextInt();
        char[][] arr= new char[m][n];

        map= new HashMap<>();

        while(true){
            System.out.print("I  :");
            int row= sc.nextInt();
            System.out.print("J  :");
            int col= sc.nextInt();

            if(arr[row][col] == 'X'){
                System.out.println("WRONG INPUT.");
            }

            if(arr[row][col] != 'X'){
                arr[row][col]='X';
                for(int i=0;i<m;i++){
                    if(arr[i][0]=='X' && dfs(i, 0 , arr, new boolean[m][n])){
                        printArray(arr, m, n);
                        System.out.println("GAME ENDS.");
                        flag= true;
                        break;
                    }
                }
            }

            if(flag) break;

            System.out.println();

            printArray(arr, m, n);
        }
        sc.close();
    }

    private static void printArray(char[][] arr, int m, int n){
        for(int i=0;i<m;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static boolean dfs(int r, int c, char[][] arr, boolean[][] visited){
        String key= ""+r+"|"+c;

        if(map.containsKey(key)) {
            return map.get(key);
        }

        if(arr[r][c] == 'X' && c == arr[0].length-1) {
            return true;
        }

        visited[r][c]=true;

        boolean directions= false;
        for(int i=0;i<4;i++){
            int dirX= r+ dir[i];
            int dirY= c+dir[i+1];
            if(dirX < 0 || dirY < 0 || dirX >= arr.length || dirY >= arr[0].length || arr[dirX][dirY] != 'X' || visited[dirX][dirY]) continue;
            directions= directions || dfs(dirX, dirY, arr, visited);
        }

        map.put(key, directions);

        return directions;
    }
}
