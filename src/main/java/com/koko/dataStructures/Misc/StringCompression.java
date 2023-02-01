package com.koko.dataStructures.Misc;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {

    // Q:
    /*
    Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead,
be stored in the input character array chars.
Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.


     */



    // TC: O(N)
    // SC: O(1)

    public int compress(char[] chars) {
        int ans = 0, i = 0;
        while(i < chars.length){
            char curr = chars[i];
            int count = 0;
            while(i < chars.length && chars[i] == curr){
                i++;
                count++;
            }
            chars[ans ++] = curr;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray())
                    chars[ans ++] = c;
        }
        return ans;
    }




    // Q2:
    // If the chars are in a continuous stream, use below chunk based encoding algorithm,
    // https://leetcode.com/problems/encode-and-decode-strings/solution/


    public class Codec {
        // Encodes string length to bytes string
        public String intToString(String s) {
            int x = s.length();
            char[] bytes = new char[4];
            for(int i = 3; i > -1; --i) {
                bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
            }
            return new String(bytes);
        }

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for(String s: strs) {
                sb.append(intToString(s));
                sb.append(s);
            }
            return sb.toString();
        }

        // Decodes bytes string to integer
        public int stringToInt(String bytesStr) {
            int result = 0;
            for(char b : bytesStr.toCharArray())
                result = (result << 8) + (int)b;
            return result;
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            int i = 0, n = s.length();
            List<String> output = new ArrayList();
            while (i < n) {
                int length = stringToInt(s.substring(i, i + 4));
                i += 4;
                output.add(s.substring(i, i + length));
                i += length;
            }
            return output;
        }
    }
}
