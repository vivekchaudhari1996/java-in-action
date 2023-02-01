package com.koko.Enum;

public class TestEnum {
    
    public  static  void main(String[] args){
        EnumTypes s = EnumTypes.MEAT;
        System.out.println(s);

        for (EnumTypes e: EnumTypes.values()) {
            System.out.println(e);
        }
        
    }
}
