package com.koko.striver.day13;

import java.util.Stack;

public class balanceParentheses {
    public static void main(String[] args) {
        String s = "(){}{}[]{[]}";
        System.out.println("isValidParentheses " + isValidParentheses(s));
        
    }
    private static boolean isValidParentheses(String s) {
        Stack<Character> st = new Stack<>();
        char c;
        for(int i = 0; i<s.length(); i++) {
            c = s.charAt(i);
            
            // if open bracket then simply push
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            }

            // base condition
            else if (st.isEmpty()) return false;

            // now poping
            else if (c == ')' && st.pop() != '(') return false;
            else if (c == '}' && st.pop() != '{') return false;
            else if (c == ']' && st.pop() != '[') return false;
        }
        return st.isEmpty();
    }
}
