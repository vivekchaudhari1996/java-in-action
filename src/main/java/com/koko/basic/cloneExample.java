package com.koko.basic;

/** The clone() method saves the extra processing task for creating the exact copy of an object.
 * just need to  implement Cloneable in it.
 * and define the definition of clone
 * dis -Object.clone() supports only shallow copying but we will need to override it if we need deep cloning.
 *
 */

class cloneExample implements Cloneable{ // cloneable is marker(does not have method inside it) interface,
    // it is just to inform JVM that it have special behaviour
    int rollno;
    String name;

    cloneExample(int rollno,String name){
        this.rollno=rollno;
        this.name=name;
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String args[]){
        try{
            cloneExample s1=new cloneExample(102,"amit");

            cloneExample s2=(cloneExample)s1.clone();

            System.out.println(s1.rollno+" "+s1.name);
            System.out.println(s2.rollno+" "+s2.name);

        }catch(CloneNotSupportedException c){}

    }
}