package com.koko.striver.day18BinaryTree;

import java.util.ArrayList;

public class ArrayListInsertInReverse {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        for (int it: arr) {
            System.out.print(" "+it);
        }

        System.out.println();
        ArrayList<Integer> arr1 = new ArrayList<>();
        /**
         * so basically if want to add in reverse form just simply add the index.
         */
        arr1.add(0, 1);
        arr1.add(0,2);
        arr1.add(0, 3);
        arr1.add(0, 4);
        arr1.add(0, 5);

        for (int it: arr1) {
            System.out.print(" "+it);
        }
    }
}
