package com.koko.dataStructures.Misc;

import java.util.*;

public class WagesQuality {

    public static void main(String[] args) {
        int [] wages = new int[]{4,8,2,2,7};
        int [] quality = new int[]{3,1,10,10,1};
        int k =3 ; //k<n

        int n = wages.length;
        Integer [] ratio= new Integer[n];
        ArrayList<List<Integer>> final_ratio = new ArrayList<List<Integer>>();

        for(int i=0;i<n;i++){
            ratio[i]= (int) Math.floor(wages[i]/quality[i]);
            final_ratio.add(Arrays.asList(wages[i],quality[i],ratio[i]));
        }
        Collections.sort(final_ratio, Comparator.comparingInt(o -> o.get(2)));
        int sum=final_ratio.get(n-1).get(0);
        for(int i=n-2;i>=n-k;i--){

                sum+= final_ratio.get(i).get(1)*final_ratio.get(n-1).get(2);
        }
        System.out.println("Sum: "+ sum);


    }


}
