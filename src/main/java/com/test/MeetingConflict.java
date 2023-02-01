package com.test;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class MeetingConflict implements Comparable<MeetingConflict>{

    private double startTime;
    private double endTime;

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public MeetingConflict(double startTime, double endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public MeetingConflict() {
    }

    public String toString(){
        return "Start Time : " + this.startTime +
                " End Time : " + this.endTime;
    }

    public static void main(String[] args){
        List<MeetingConflict> list  = new ArrayList<>();
        list.add(new MeetingConflict(1,2));
        list.add(new MeetingConflict(2,3));
        list.add(new MeetingConflict(1.5,2.5));
        list.add(new MeetingConflict(2.5,3));
        list.add(new MeetingConflict(1,4));

        list.sort(Comparator.comparingDouble(MeetingConflict::getStartTime));

//        for(int j = list.size()-1;j>0;j--){
//            for(int i=0;i<j;i++){
//                if(list.get(i).getStartTime() > list.get(i+1).getStartTime()){
//                    MeetingConflict t = new MeetingConflict();
//                    t = list.get(i);
//                    list.set(i, list.get(i+1));
//                    list.set(i+1, t);
//                }
//            }
//        }
        int totalConflicts = 0;
        for(int i = 0;i<list.size()-1;i++){
            boolean flag  = true;
            int count = 1;
            while(flag){
                if((i+count) < list.size() && list.get(i).getEndTime() > list.get(i+count).getStartTime()){
                    System.out.println("Conflict between ->" +
                            list.get(i).toString() +
                            " and " + list.get(i+count).toString());
                    count++;
                }else{
                    flag = false;
                }
            }
            totalConflicts += count-1;
        }
        System.out.println("Total Conflicts : " + totalConflicts);


    }

    @Override
    public int compareTo(MeetingConflict o) {
        return Double.compare(this.getStartTime(), o.getStartTime());
    }
}
