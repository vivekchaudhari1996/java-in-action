package com.test.String;

public class Singleton {

    private Object obj;
    private Singleton(){

    }
    public Object getInstance(){
    if(obj == null ){
        obj = new Singleton();
    }
        return obj;
    }
}
