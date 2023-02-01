package com.koko.striver.day8;

import java.util.*;

/**
 * Input:  N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
 * Output: 1 2 4 5
 * Explanation: See the figure for a better understanding.
 * start time  1 | 3 | 0 | 5 | 8 | 5
 * end time    2 | 4 | 5 | 7 | 9 | 9
 * in above only 1, 2, 4, 5 is possible
 *
 * To proceed we need a vector of three quantities: the starting time, ending time, meeting number. Sort this data structure in ascending order of end time.
 *
 * We need a variable to store the answer. Initially, the answer is 1 because the first meeting can always be performed. Make another variable, say limit that keeps track of the ending time of the meeting that was last performed. Initially set limit as the end time of the first meeting.
 *
 * Start iterating from the second meeting. At every position we have two possibilities:-
 *
 * If the start time of a meeting is  strictly greater than limit we can perform the meeting. Update the answer.Our new limit is the ending time of the current meeting  since it was last performed.Also update limit.
 *  If the start time is less than or equal to limit  ,skip and move ahead.
 * Let’s have a dry run by taking the following example.
 *
 * N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
 *
 * Initially set answer =[1],limit = 2.
 *
 * For Position 2 –
 *
 * Start time of meeting no. 2 = 3 > limit. Update answer and limit.
 *
 * Answer = [1, 2], limit = 4.
 *
 * For Position 3 –
 *
 * Start time of meeting no. 3 = 0 < limit.Nothing is changed.
 *
 * For Position 4 –
 *
 * Start time of meeting no. 4 = 5 > limit. Update answer and limit.
 *
 * Answer = [1,2,4], limit = 7.
 *
 * For Position 5 –
 *
 * Start time of meeting no. 5 = 8 > limit.Update answer and limit.
 *
 * Answer = [1,2,4,5], limit = 9.
 *
 * For Position 6 –
 *
 * Start time of meeting no. 6 = 8 < limit.Nothing is changed.
 *
 * Final answer  =  [1,2,4,5]
 */

// the starting time, ending time, meeting number
class meeting{
    int start;
    int end;
    int position;
     meeting(int s, int e, int p) {
         this.start = s;
         this.end = e;
         this.position = p; // issi ko store karna hai ans me
     }
}
class meetingComparator implements Comparator<meeting> {
    @Override
    public int compare(meeting o1, meeting o2)
    {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.position < o2.position)
            return -1;
        return 1;
    }
}
public class NMeetingInADay {
    public static void main(String[] args) {
        int n = 6; // koi use nhi
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,5,7,9,9};
        maxMeetings(start,end,n);

    }

    private static void maxMeetings(int[] start, int[] end, int n) {
        ArrayList<meeting> meet = new ArrayList<>();

        for (int i = 0; i<start.length; i++) {
            meet.add(new meeting(start[i], end[i], i+1)); // +1 kiya kyuki atleast 1 to hoga hi
        }
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).position);
        int limit = meet.get(0).end;

        for (int i=1; i<start.length; i++) {
            if (meet.get(i).start>limit) {
                answer.add(meet.get(i).position);
                limit = meet.get(i).end;
            }
        }

        System.out.println("The order in which the meetings will be performed is ");
        for(int i = 0;i<answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }

    }


}
