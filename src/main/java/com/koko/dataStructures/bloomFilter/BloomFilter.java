//package com.koko.dataStructures.bloomFilter;
//
////import java.nio.charset.Charset;
////import com.google.common.hash.BloomFilter;
////import com.google.common.hash.Funnels;
//
//import java.nio.charset.Charset;
//
//public class BloomFilter {
//
//    // Bloom filters are for set membership which determines whether an element is present in a set or not.
//    // Bloom filter is a probabilistic data structure that works on hash-coding methods (similar to HashTable).
//    // The more number of the hash function we take,
//    // the more accurate result we get, because of lesser chances of a collision.
//    // Therefore it can be said that Bloom filter is a good choice in a situation
//    // where we have to process large data set with low memory consumption.
//    // k = mlnP
//    // m = -n(lnP)/(ln2^2)
//
//    // Time complexity: O(H), where H is the number of hash functions used
//
//
//    // Java program to implement
//    // Bloom Filter using Guava Library
//    // Java code may return a 3% false-positive probability by default.
//
//
//        public static void main(String[] args)
//        {
//            // Create a Bloom Filter instance
//            BloomFilter<String> blackListedIps
//                    = BloomFilter.create(
//                    Funnels.stringFunnel(
//                            Charset.forName("UTF-8")),
//                    10000);
//
//            // Add the data sets
//            blackListedIps.put("192.170.0.1");
//            blackListedIps.put("75.245.10.1");
//            blackListedIps.put("10.125.22.20");
//
//            // Test the bloom filter
//            System.out.println(
//                    blackListedIps
//                            .mightContain(
//                                    "75.245.10.1"));
//            System.out.println(
//                    blackListedIps
//                            .mightContain(
//                                    "101.125.20.22"));
//        }
//    }
//}
