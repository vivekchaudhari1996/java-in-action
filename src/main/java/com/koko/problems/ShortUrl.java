package com.koko.problems;

import java.util.HashMap;
import java.util.Map;

public class ShortUrl {

    private static final Map<String, Integer> map = new HashMap<>();
    private static final Map<String, String> mapOfUrl = new HashMap<>();
    private static int id = 1;

    public static void main (String[] args)
    {
        String longUrl = "google";
        if(map.containsKey(longUrl)) {
            System.out.println("Short Url is:" + map.get(longUrl));
            System.exit(0);
        }
        map.put(longUrl, id++);

        String shorturl = generateShortUrl(longUrl);
        if(!mapOfUrl.containsKey(longUrl)) mapOfUrl.put(longUrl, shorturl);

        int index = shortURLtoID(shorturl);
        for (Map.Entry<String, Integer> entry: map.entrySet()
        ) {
            if(Integer.parseInt(String.valueOf(entry.getValue())) == index) {
                System.out.println("Long url is " + entry.getKey());
                break;
            }
        }
    }

    // Function to generate a short url from integer ID
    static String generateShortUrl(String longUrl)
    {
        // Map to store 62 possible characters
        char base[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuffer shorturl = new StringBuffer();

        int n = map.get(longUrl);
        // Convert given integer id to a base 62 number
        while (n > 0)
        {
            // use above map to store actual character
            // in short url
            shorturl.append(base[n % 62]);
            n = n / 62;
        }

        // Reverse shortURL to complete base conversion
        return shorturl.reverse().toString();
    }

    // Function to get integer ID back from a short url
    static int shortURLtoID(String shortURL)
    {
        int id = 0; // initialize result

        // A simple base conversion logic
        for (int i = 0; i < shortURL.length(); i++)
        {
            if ('a' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= 'z')
                id = id * 62 + shortURL.charAt(i) - 'a';
            else if ('A' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= 'Z')
                id = id * 62 + shortURL.charAt(i) - 'A' + 26;
            else if ('0' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= '9')
                id = id * 62 + shortURL.charAt(i) - '0' + 52;
        }
        return id;
    }


}
