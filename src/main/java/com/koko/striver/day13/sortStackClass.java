package com.koko.striver.day13;

import java.util.Stack;

public class sortStackClass {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(3);
        st.push(1);
        st.push(6);
        st.push(5);

        Stack<Integer> ans1  = sortStackUsingExtraStack(st);
        System.out.println("sorted numbers are:");

        while (!ans1.isEmpty()) {
            System.out.println(ans1.pop() + " ");
        }
    }

    /**
     * keep popping from temp stack if number is small and push in original stack
     * then push the element in stack
     * @param st
     * @return
     */
    private static Stack<Integer> sortStackUsingExtraStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()) {
            int t = st.pop();

            while(!temp.isEmpty() && temp.peek() < t) {
                st.push(temp.pop());
            }

            temp.push(t);
        }
        return temp;
    }
}
