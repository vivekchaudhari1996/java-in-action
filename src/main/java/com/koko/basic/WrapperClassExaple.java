package com.koko.basic;

/**
 * The wrapper class in Java provides the mechanism to convert primitive into object and object into primitive.
 * Collection Framework: Java collection framework works with objects only. All classes of the collection framework (ArrayList, LinkedList, Vector, HashSet, LinkedHashSet, TreeSet, PriorityQueue, ArrayDeque, etc.) deal with objects only.
 * all 8 wrapper class - Boolean, Character, Byte, Short, Integer, Long, Float, Double
 * automatic conversion of primitive data type into its corresponding wrapper class is known as autoboxing,
 */

public class WrapperClassExaple {
    private int i;
    public WrapperClassExaple(){}
    public WrapperClassExaple(int i) {
        this.i = i;
    }
    public int getValue() {
        return i;
    }
    public void setValue(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }

    public static void main(String[] args) {

        int a = 20;
        Integer i = Integer.valueOf(a); // explicitly conversion before java 5
        Integer j = a; // autoboxing, after java 5 so no need to explicit

        Integer b = 3;
        int x = b.intValue(); // before 5 java
        int y = b; //unboxing

        // own wrapper
        WrapperClassExaple ownWrapper = new WrapperClassExaple(10);
        System.out.println(ownWrapper.i  );

    }
}
