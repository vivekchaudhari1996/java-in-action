package com.test.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {

//    public static void main(String args[]){
//        int[] original = new int[]{1,0,2,0,5,0};
//        int count = 0;
//        for(int i=0;i<original.length;i++){
//            if(original[i] != 0){
//                if(i != count){
//                    int temp = original[i];
//                    original[count++] = temp;
//                    original[i] = 0;
//                }else{
//                    count++;
//                }
//            }
//        }
//        //for(int i=0;i<original.length)
//    }

    public static void main(String args[]){
        int[] array = new int[]{4,5,1,3,1,3,5};
        Arrays.sort(array);
        int target = 9;
        int match = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            map.put(array[i],map.getOrDefault(array[i], 0) + 1);
        }
        for(int i=0;i<array.length;i++){
            int secondComp = target - array[i];
            if(secondComp == array[i]){
                if(map.containsKey(secondComp) && map.get(secondComp) > 1){
                    System.out.println("True");
                    match++;
                }
            }
            else if(map.containsKey(secondComp) && map.get(secondComp) > 0 ){
                System.out.println("True");
                match++;
            }
        }
        if(match != 1){
            System.out.println("False");
        }


    }
}
