package com.koko.basic;

/**
 * could have the varying the number of argument
 * varying the number of return-type
 * java dont support the overloading for the STATIC method
 * overloading ko - compile time polymorphism kahte hai
 */

class Adder{
    static int add(int a,int b){return a+b;}
    static int add(int a,int b,int c){return a+b+c;}
}
class TestOverloading1{
    public static void main(String[] args){
        System.out.println(Adder.add(11,11));
        System.out.println(Adder.add(11,11,11));
    }
}
