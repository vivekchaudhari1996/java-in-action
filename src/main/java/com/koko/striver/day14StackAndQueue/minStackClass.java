package com.koko.striver.day14StackAndQueue;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * to implement the stack which can perform the push, pop, top, min in O(1)
 * here using the priority queue so O(logn) space complexity but dont think Min() have O(logn). it just have O(1)
 *
 */
public class minStackClass {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);

        System.out.println("Minimum " + stack.min());
        System.out.println("pop");
        stack.pop();
        System.out.println("Minimum " + stack.min());

    }
}

class MinStack {
    public MinStack() {
    }

    Stack<Integer> st = new Stack<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public void push(int val) {
        st.push(val);
        pq.add(val);
    }

    public void pop() {
        pq.remove(st.pop());
    }

    public int top() {
        return st.peek();
    }

    public int min() {
        return pq.peek();
    }
}
