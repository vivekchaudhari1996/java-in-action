package com.koko.striver.day14StackAndQueue;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * We are given the total possible page numbers that can be referred to. We are also given a cache
 * (or memory) size (The number of page frames that the cache can hold at a time). The LRU caching
 * scheme is to remove the least recently used frame when the cache is full and a new page is
 * referenced which is not there in the cache. Please see the Galvin book for more details
 * (see the LRU page replacement slide here)
 *
 * Queue is implemented using a doubly-linked list. The maximum size of the queue will be equal
 * to the total number of frames available (cache size). The most recently used pages will be near
 * the front end and the least recently used pages will be near the rear end.
 *
 * A Hash with the page number as key and the address of the corresponding queue node as value.
 */
public class LRUCache {


    /**
     * /* We can use Java inbuilt Deque as a double
     *    ended queue to store the cache keys, with
     *    the descending time of reference from front
     *    to back and a set container to check presence
     *    of a key. But remove a key from the Deque using
     *    remove(), it takes O(N) time. This can be
     *    optimized by storing a reference (iterator) to
     *    each key in a hash map. *
     */
    // store keys of cache
    private Deque<Integer> doublyQueue;

    // store references of key in cache
    private HashSet<Integer> hashSet;

    // maximum capacity of cache
    private final int CACHE_SIZE;

    LRUCache(int capacity)
    {
        doublyQueue = new LinkedList<>();
        hashSet = new HashSet<>();
        CACHE_SIZE = capacity;
    }

    /* Refer the page within the LRU cache */
    public void refer(int page)
    {
        if (!hashSet.contains(page)) {
            if (doublyQueue.size() == CACHE_SIZE) {
                int last = doublyQueue.removeLast();
                hashSet.remove(last);
            }
        }
        else { /* The found page may not be always the last
                element, even if it's an intermediate
                element that needs to be removed and added
                to the start of the Queue */
            doublyQueue.remove(page);
        }
        doublyQueue.push(page);
        hashSet.add(page);
    }
    // display contents of cache
    public void display()
    {
        Iterator<Integer> itr = doublyQueue.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.display();
    }
}

/**
 * Time Complexity: The time complexity of the refer() function is O(1) as it does a constant amount of work.
 * Auxiliary Space: The space complexity of the LRU cache is O(n), where n is the maximum size of the cache.
 */