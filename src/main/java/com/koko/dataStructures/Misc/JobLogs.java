package com.koko.dataStructures.Misc;

import java.util.*;
import java.util.stream.Collectors;

public class JobLogs {

    // Input
    // E B 200
    //G null 5
    //B A 50
    //F B 300
    //D A 10
    //A null 10
    //C A 125
    //H G 10

    static class JobLog{
        private String id;
        private String parentId;
        private int time;
        private List<JobLog> children;

        public String getId() {
            return id;
        }

        public String getParentId() {
            return parentId;
        }

        public int getTime() {
            return time;
        }

        public List<JobLog> getChildren() {
            return children;
        }
    }

    public static void main(String[] args) {
        List<JobLog> list = new ArrayList<>();
        HashMap<String, JobLog> map = new HashMap<>();
        for (JobLog job: list
        ) {
            if(!map.containsKey(job.getId())){
                map.put(job.getId(), job);
            }
            if(map.containsKey(job.getParentId())){
                JobLog temp = map.get(job.getParentId());
                temp.getChildren().add(job);
            }
        }
        List<JobLog> parentList = list.stream().filter(e-> e.getParentId().equals("null")).collect(Collectors.toList());
        for (JobLog j: parentList) {
            int sum = 0;
            Queue<JobLog> queue = new LinkedList<>();
            for (JobLog child: j.getChildren())
            {
                queue.add(child);
                while(!queue.isEmpty()){
                    JobLog temp = queue.poll();
                    sum+= temp.getTime();
                    List<JobLog> children = temp.getChildren();
                    if(children.size() > 0){
                        queue.addAll(children);
                    }
                }
            }
            System.out.println(j.getId() + ": " + sum);
        }
    }
}
