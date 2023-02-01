package com.koko.String;

import java.util.Scanner;

public class Pallindrome {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter String");
        String input = in.nextLine();
        System.out.println("String is Pallindrome ? " + checkPal(input));
    }

    public static boolean checkPal(String s){
        for(int i=0, j =s.length()-1 ; i<j ;){
            if(!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')){
                i++;
            }else if(!(s.charAt(j) >= 'a' && s.charAt(j) <= 'z')){
                j--;
            }
            else if(s.charAt(i) == s.charAt(j)){
                i++;j--;
            }
            else
                return false;
        }
        return  true;
    }
}
