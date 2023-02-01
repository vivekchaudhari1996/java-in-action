package com.koko.dataStructures.Misc;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    //Q:
    /*
    The median is the middle value in an ordered integer list.
    If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far.
Answers within 10^-5 of the actual answer will be accepted.
     */


    // Example:
    /*
    Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
     */



    // Solution:
    // TC: O(logN)
    // SC: O(1)

    static class MedianFinder {

        // To store lower half of data stream eg. 1, 2, 3, 6
        PriorityQueue<Integer> lowerHalf;
        // To store upper half of data stream eg. 8, 9, 11
        PriorityQueue<Integer> upperHalf;

        /** initialize your data structure here. */
        public MedianFinder() {
            lowerHalf = new PriorityQueue<>((a,b) -> b - a); // Max heap : To fetch largest
            // lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
            // element from lower half in O(1) time
            upperHalf = new PriorityQueue<>(); // Min heap : To fetch lowest
            // element from upper half in O(1) time
        }

        public void addNum(int num) {
            // Insert in lowerHalf is it's empty or if number being inserted is less than the peek of lowerHalf otherwise insert in upperHalf
            if(lowerHalf.isEmpty() || num <= lowerHalf.peek()){
                lowerHalf.add(num);
            }else{
                upperHalf.add(num);
            }

            // We also need to ensure that the halves are balanced i.e.
            // there is no more than a difference of 1 in size of both halves
            // Let lowerHalf be the one to hold one extra element if the size of total data stream is odd
            // otherwise be equal to upperHalf

            if(upperHalf.size() > lowerHalf.size()){ // If an element added above made upperHalf have one more element than lowerHalf then we poll it and put it into lowerHalf
                lowerHalf.add(upperHalf.poll());
            } else if(lowerHalf.size() > upperHalf.size() + 1){
                // If an element added above, made lowerHalf have 2 more elements then upperHalf then we put one into upperHalf from lowerHalf
                upperHalf.add(lowerHalf.poll());
            }
        }

        public double findMedian() {
            if(lowerHalf.size() == upperHalf.size()){
                return (double)(lowerHalf.peek() + upperHalf.peek())/2;
            }else{
                return (double)(lowerHalf.peek());
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */



// Q Variant:
    /*
    Supposing that you have a stream of integer,
    implement the following two methods to return the median value (value of the middle. It's not the mean).
    The median value does not need to be exact. It can be within a range of 2^n-1 to 2^n+1.
For example:
addValue(1)
addValue(6)
addValue(10)
getMedian() can return any value between 4 to 7.
     */



    // Idea1:


    // Bucket 1 : [1,2)
    //Bucket 2 : [2,4)
    //Bucket 3: [4,8)
    //Bucket 4: [8,16)
    //Bucket 5: [16, 32)
    //Bucket 6: [32, 64)
    //So on.
    //Given a incoming stream of numbers we have to return any number in the bucket, in which the median lies in
    //Ex: 1,6,10
    //Median is 6, it lies in bucket 3, you can return any number from 4 to 7.
    //The observation here is, all numbers with same MSB(most significant bit) lie in the same bucket,
    // so here we care only about MSB of incoming numbers.
    //Assuming the integers fit in 64 bit, we can create an array of size 64, every time integer comes,
    // we can increment the count of that bucket.
    // Now we just need to find the median in elements of array cnt,
    // only including numbers with MSB as i and cnt[i] > 0.



    // Idea 2:
    // Ex: 1,6,10
    //Median is 6, it lies in bucket 3, you can return any number from 4 to 7.
    //The observation here is, all numbers with same MSB(most significant bit) lie in the same bucket,
    // so here we care only about MSB of incoming numbers.
    //Assuming the integers fit in 64 bit, we can create an array of size 64,
    // every time integer comes, we can increment the count of that bucket.
    // Now we just need to find the median in elements of array cnt,
    // only including numbers with MSB as i and cnt[i] > 0.

    // We can use a variable to track number of elements that are added till now.
    // Then we can traverse buckets array from 0 index to 63 till the time Σ buckets (from 0...i)
    // is less than elements/2. Then our answer would be 2^(i+1)


}
