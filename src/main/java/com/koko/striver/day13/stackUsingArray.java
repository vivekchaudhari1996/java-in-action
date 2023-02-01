package com.koko.striver.day13;



public class stackUsingArray {
    public static void main(String[] args) {
        stack st = new stack();
        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println("Top of the stack before deleting any element " + st.top());
        System.out.println("Size of the stack before deleting any element " + st.size());
        System.out.println("The element deleted is " + st.pop());
        System.out.println("Size of the stack after deleting an element " + st.size());
        System.out.println("Top of the stack after deleting an element " + st.top());


    }
}
class stack{ // if keep the public type then need to declare this class in the stack.java
    int top = -1;
    int size = 1000;
    int[] arr = new int[size];

    void push(int x) {
        arr[++top] = x;
    }

    int pop() {
        int x = arr[top--];
        return x;
    }

    int top() {
        return arr[top];
    }

    int size() {
        return top+1;
    }
}
