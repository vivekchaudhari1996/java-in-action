package com.koko.striver.day13;

import java.util.Stack;

public class queueUsingStackClass {
    public static void main(String[] args) {
        queueUsingStack q = new queueUsingStack();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());


    }
}
class queueUsingStack {
    Stack<Integer> mainS = new Stack<Integer>();
    Stack<Integer> backUpS = new Stack<Integer>();

    void push(int x) {
        while (!mainS.empty()) {
            backUpS.push(mainS.pop());
        }
        mainS.push(x);
        while (!backUpS.isEmpty()) {
            mainS.push(backUpS.pop());
        }

    }

    int pop() {
        return mainS.pop();
    }

    int peek() {
        return mainS.peek();
    }

    public boolean empty() {
        return mainS.isEmpty();
    }

    int size() {
        return mainS.size();
    }
}
