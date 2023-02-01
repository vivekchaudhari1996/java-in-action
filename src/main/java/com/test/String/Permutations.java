package com.test.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {

    private List<String> result = new ArrayList<>();
    private HashSet<String> resultHash = new HashSet<>();

    public HashSet<String> getResultHash() {
        return resultHash;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public List<String> getResult() {
        return result;
    }

    public static void main(String[] args){
        String s = "ABA";
        int n = s.length();
        Permutations permutations = new Permutations();
        permutations.compute(s,0,n-1);
        permutations.getResultHash().forEach(System.out::println);

    }

    public void compute(String a , int left, int right){
        if(left == right){
//            if(!this.result.contains(a)){
//                this.result.add(a);
//            }
            resultHash.add(a);


        }else{
            for(int i = left ;i<=right; i++){
                a = swap(a, left, i);
                compute(a,left+1, right);
                a = swap(a, left, i);
            }
        }
    }

    public String swap(String a, int l, int r){
        char [] c = a.toCharArray();
        char temp;
        temp = c[l];
        c[l] = c[r];
        c[r] = temp;
        return String.valueOf(c);
    }
}
