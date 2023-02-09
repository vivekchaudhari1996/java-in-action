package com.koko.striver.day15String;

/**
 * We start traversing the string from the end until we hit a space. It indicates that we have gone
 * past a word and now we need to store it.
 * We check if our answer variable is empty or not
 * If it’s empty, it indicates that this is the last word we need to print, and hence, there shouldn’t
 * be any space after this word.
 * If it’s empty we add it to our result with a space after it. Here’s a quick demonstration of the same
 *
 * Time Complexity: O(N), N~length of string
 *
 * Space Complexity: O(1), Constant Space
 */
public class reverseWordInSentence {
    public static void main(String[] args) {
        String s = "My Name is Vivek Chaudhari";
        System.out.println("String " + s);
        System.out.println("After reverse the word " + reverseWord(s));
    }

    private static String reverseWord(String s) {
        int left = 0;
        int right = s.length() - 1;

        String temp = "";
        String ans = "";

        //Iterate the string and keep on adding to form a word
        //If empty space is encountered then add the current word to the result
        while (left <= right)
        {
            char ch = s.charAt(left);
            if (ch != ' ')
            {
                temp += ch;
            }
            else if (ch == ' ')
            {
                if (!ans.equals(""))
                {
                    ans = temp + " " + ans;
                }
                else
                {
                    ans = temp;
                }
                temp = "";
            }
            // System.out.println(ans);
            left++;
        }

        //If not empty string then add to the result(Last word is added)
        if (!temp.equals(""))
        {
            if (!ans.equals(""))
            {
                ans = temp + " " + ans;
            }
            else
            {
                ans = temp;
            }
        }

        return ans;
    }
}
