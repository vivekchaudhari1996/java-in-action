package com.koko.dataStructures.Misc;

import java.util.*;

public class OnCallRotationSchedule {

    // Q: We are given on-call rotation schedule for multiple people by:
    // their name, start time and end time of the rotation:

    //Abby 1 10
    //Ben 5 7
    //Carla 6 12
    //David 15 17
    //Abby 8 13

    // Question: Giving a T time, return all people names who are oncall during that time.
    //So for T = 9; Expected output: [Abby, Carla]

    // Your goal is to return rotation table without overlapping periods representing who is on call during that time.
    // 1 5 Abby
    //5 6 Abby, Ben
    //6 7 Abby, Ben, Carla
    //7 10 Abby, Carla
    //10 12 Carla
    //15 17 David


    static Set<String>[] begins = new HashSet[53];
    static Set<String> [] ends = new HashSet[53];

    //~ A
    static Set<String> onCalls(int wk) {
        return begins[wk];
    }

    //~ B
    static List<Rotation> create(List<Schedule> schedules) {
        Arrays.setAll(begins, o -> new HashSet<>());
        Arrays.setAll(ends, o -> new HashSet<>());

        int start = 53;
        int end = -1;
        for(Schedule schedule : schedules) {
            begins[schedule.st].add(schedule.name);
            ends[schedule.ed].add(schedule.name);
            start = Math.min(schedule.st, start);
            end = Math.max(schedule.ed, end);
        }

        List<Rotation> rotations = new ArrayList<>();
        int frm = start;
        for(int wk=start+1; wk <= end; ++wk) {
            begins[wk].addAll(begins[wk-1]);
            begins[wk].removeAll(ends[wk]);
            ends[wk].clear();
            if(!begins[wk].equals(begins[wk-1])) {
                //~ IMO - end should be wk-1, but expected o/p is with wk
                Rotation rotation  = Rotation.of(frm, wk);
                rotation.names.addAll(begins[wk-1]);
                rotations.add(rotation);
                frm = wk;
            }
        }
        return rotations;
    }

    public static void main(String[] args) {
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(Schedule.of("Abby", 1, 10));
        schedules.add(Schedule.of("Ben", 5, 7));
        schedules.add(Schedule.of("Carla", 6, 12));
        schedules.add(Schedule.of("David", 15, 17));
        schedules.add(Schedule.of("Abby", 8, 13));
        List<Rotation> rotations = create(schedules);
        System.out.println(rotations);
        System.out.println(onCalls(9));
    }

    // data classes
    public static class Schedule {
        String name;
        int st;
        int ed;
        public static Schedule of(String name, int st, int ed) {
            Schedule schedule = new Schedule();
            schedule.name = name;
            schedule.st = st;
            schedule.ed = ed;
            return schedule;
        }
    }

    public static class Rotation {
        List<String> names = new ArrayList<>();
        int st;
        int ed;
        public static Rotation of(int st, int ed) {
            Rotation rotation = new Rotation();
            rotation.st = st;
            rotation.ed = ed;
            return rotation;
        }

        @Override
        public String toString() {
            return "(" + st + ":" + ed + "->" + names + ')';
        }
    }
}
