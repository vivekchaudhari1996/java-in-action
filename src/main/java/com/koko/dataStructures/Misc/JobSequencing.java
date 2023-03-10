package com.koko.dataStructures.Misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JobSequencing {

    // Q: Given an array of jobs where every job has a deadline and associated profit if the job
    // is finished before the deadline. It is also given that every job takes a single unit of time,
    // so the minimum possible deadline for any job is 1.
    // Maximize the total profit if only one job can be scheduled at a time.


    // Using Max Heap

    static class Job {
        char job_id;
        int deadline;
        int profit;
        Job(char job_id, int deadline, int profit)
        {
            this.deadline = deadline;
            this.job_id = job_id;
            this.profit = profit;
        }
    }

    // Time Complexity: O(N log N)
    // Auxiliary Space: O(N)

    static void printJobScheduling(ArrayList<Job> arr)
    {
        int n = arr.size();

        // sorting the array on the
        // basis of their deadlines
        Collections.sort(arr, Comparator.comparingInt(a -> a.deadline));

        // initialise the result array and maxHeap
        ArrayList<Job> result = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>(
                (a, b) -> { return b.profit - a.profit; });

        // starting the iteration from the end
        for (int i = n - 1; i > -1; i--) {
            int slot_available;

            // calculate slots between two deadlines
            if (i == 0) {
                slot_available = arr.get(i).deadline;
            }
            else {
                slot_available = arr.get(i).deadline
                        - arr.get(i - 1).deadline;
            }

            // include the profit of job(as priority),
            // deadline and job_id in maxHeap
            maxHeap.add(arr.get(i));

            while (slot_available > 0
                    && maxHeap.size() > 0) {

                // get the job with max_profit
                Job job = maxHeap.remove();

                // reduce the slots
                slot_available--;

                // include the job in the result array
                result.add(job);
            }
        }

        // jobs included might be shuffled
        // sort the result array by their deadlines
        Collections.sort(result, Comparator.comparingInt(a -> a.deadline));

        for (Job job : result) {
            System.out.print(job.job_id + " ");
        }

        System.out.println();
    }

    // Driver's Code
    public static void main(String[] args)
    {
        ArrayList<Job> arr = new ArrayList<Job>();

        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));

        System.out.println("Following is maximum "
                + "profit sequence of jobs");

        // Function call
        printJobScheduling(arr);
    }
}
