package com.koko.problems.print;

public class PrintStaircase {

    // Question: Write a program that prints a staircase of size n.
    // Its base and height are both equal to n.
    // It is drawn using # symbols and spaces.
    // The last line is not preceded by any spaces.

    // Example:
    //    #
    //   ##
    //  ###
    // ####


    public static void drawStair(int size) {
        int level = size-1;
        for(int i = 0; i < size; i++) {
            StringBuilder s = new StringBuilder();
            for(int k = 0; k < level; k++) {
                s.append(" ");
            }
            for(int k = 0; k < size - level; k ++){
                s.append("#");
            }
            level -= 1;
            System.out.println(s.toString());
        }
    }
}
