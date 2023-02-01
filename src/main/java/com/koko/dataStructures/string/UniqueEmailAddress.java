package com.koko.dataStructures.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

    // ###SplitAndReplace
    // ###Set



    // Q:
    /*
    Every valid email consists of a local name and a domain name,
    separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.

For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
If you add periods '.' between some characters in the local name part of an email address,
mail sent there will be forwarded to the same address without dots in the local name.
Note that this rule does not apply to domain names.

For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.

If you add a plus '+' in the local name, everything after the first plus sign will be ignored.
This allows certain emails to be filtered. Note that this rule does not apply to domain names.

For example, "m.y+name@email.com" will be forwarded to "my@email.com".
It is possible to use both of these rules at the same time.

Given an array of strings emails where we send one email to each emails[i],
return the number of different addresses that actually receive mails.
     */




    // Example:
    /*
    Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com",
    "testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
     */




    // Solution1:
    // Approach 1: Linear Iteration


    /*
    Algorithm

For each email present in the emails array:
Iterate over the characters in the email and append each character to the local name if it is not '.'.
If the character is '+', do not append the character and break out of the loop.
Find the domain name using reverse traversal in the given email and append it to the string formed till now.
After cleaning the email insert it into the hash set.
Return the size of the hash set.
     */


    // Let NN be the number of the emails and MM be the average length of an email.
    // TC: O(N*M)
    // SC: O(N*M)

    public int numUniqueEmails(String[] emails) {
        // hash set to store all the unique emails
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            StringBuilder cleanMail = new StringBuilder();

            // iterate over each character in email
            for (int i = 0; i < email.length(); ++i) {
                char currChar = email.charAt(i);

                // stop adding characters to localName
                if (currChar == '+' || currChar == '@') break;

                // add this character if not '.'
                if (currChar != '.') cleanMail.append(currChar);
            }

            // compute domain name (substring from end to '@')
            StringBuilder domainName = new StringBuilder();

            for (int i = email.length() - 1; i >= 0; --i) {
                char currChar = email.charAt(i);
                domainName.append(currChar);
                if (currChar == '@') break;
            }

            domainName = domainName.reverse();
            cleanMail.append(domainName);
            uniqueEmails.add(cleanMail.toString());
        }

        return uniqueEmails.size();
    }





    // Sol2:
    // Approach 2: Using String Split Method


    // A more elegant way of cleaning emails is to leverage
    // built-in functions such as split and replace.


    // Let NN be the number of the emails and MM be the average length of an email.
    // TC: O(N*M)
    // SC: O(N*M)

    public int numUniqueEmails2(String[] emails) {
        // hash set to store all the unique emails
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            // split into two parts local and domain
            String[] parts = email.split("@");

            // split local by '+'
            String[] local = parts[0].split("\\+");

            // remove all '.', and concatenate '@' and append domain
            uniqueEmails.add(local[0].replace(".", "") + "@" + parts[1]);
        }

        return uniqueEmails.size();
    }

}
