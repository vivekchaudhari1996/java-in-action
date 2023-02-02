//package com.koko.striver.day13;
//
//import java.util.*;
//
///**
// * Like you said, Queue is an interface, an Abstract Data Type, it specifies operations and their semantics (namely, FIFO discipline).
//
// LinkedList is a class provided by the Java.util library, meaning it implements the methods of all interfaces it declares to... implement. The fact that it's name is "Linkedlist" means that it uses a... LinkedList (nodes containing the elements allocated in the heap with pointers from a node to the next one). It's an ordered data structure.
//
// If you declare a Queue (left-hand, interface) and instantiate it with a LinkedList (right-hand, class), you'll only have the Queue operations, not the List methods.
//
// */
//
//public class stackUsingQueueClass {
//    public static void main(String[] args) {
//        stackUsingQueue s = new stackUsingQueue();
//        s.push(3);
//        s.push(2);
//        s.push(4);
//        s.push(1);
//        System.out.println("Top of the stack: " + s.top());
//        System.out.println("Size of the stack before removing element: " + s.size());
//        System.out.println("The deleted element is: " + s.pop());
//        System.out.println("Top of the stack after removing element: " + s.top());
//        System.out.println("Size of the stack after removing element: " + s.size());
//    }
//}
//class stackUsingQueue {
//    Queue<Integer> q = new LinkedList<Integer>();
//
////    public void push(int x) {
////        int s = q.size();
////        q.add(x);
////        for(int i=0; i<s; i++) {
////            q.add(q.remove());
////        }
////    }
////
////    public int pop() {
////        return q.remove();
////    }
////
////    public int top() {
////        return q.peek();
////    }
////
////    public boolean empty() {
////        if(q.size()!= 0) return false;
////        return true;
////    }
//}
