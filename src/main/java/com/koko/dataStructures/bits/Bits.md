## Bits operations

1. int -> 32 bits
2. long -> 64 bits

3. Bits are starting from right -> left
4. 2^0, 2^1, 2^2 ... from right side...uptil 2^31
5. **XOR**: same bits gives 0, diff bits give 1.
    1. 1^1 = 0 (even nbr of 1's give 0)
    2. 1^0 = 1 (odd nbr of 1's give 0)
    
6. **Check if a particular index bit is set or not?**
    1. Perform (n>>i) & 1 
    2. Here n is the number.
    3. i is the index you want to check.
    4. Right shift n by i and do Bitwise and with 1.
    5. (n>>i)&1 != 0 : Bit at i was set. 
    
7. **How do you turn on a bit?**
    1. Lets say you have to turn On ith bit in n.
    2. Perform: (1<<i) | n
    3. This will left shift 1 by i, and then bitwise Or with n.
    
8. **2's complement**
   1. 2’s complement of a binary number is 1 added to the 1’s complement of the binary number. 
   2. Note that 1’s complement is simply flip of given binary number. 
   3. 2's complement of "0111" is  "1001".
   4. Input:  str = "1000100"
   5. Output:        0111100
   6. Explanation: Starts traversing the string from last,
   7. we got first '1' at index 4 then just flip the bits
   8. of 0 to 3 indexes to make the 2's complement. 
   9. Input:  str =  "0000"
   10. Output:        10000
   11. Explanation: As there is no 1 in the string so just
   12. append '1' at starting.
   13. Time complexity : O(n)
   14. Auxiliary Space : O(1)
   ```
   static String findTwoscomplement(StringBuffer str)
    {
        int n = str.length();
      
        // Traverse the string to get first '1' from
        // the last of string
        int i;
        for (i = n-1 ; i >= 0 ; i--)
            if (str.charAt(i) == '1')
                break;
      
        // If there exists no '1' concat 1 at the
        // starting of string
        if (i == -1)
            return "1" + str;
      
        // Continue traversal after the position of
        // first '1'
        for (int k = i-1 ; k >= 0; k--)
        {
            //Just flip the values
            if (str.charAt(k) == '1')
                str.replace(k, k+1, "0");
            else
                str.replace(k, k+1, "1");
        }
      
        // return the modified string
        return str.toString();
    }
    ```