## Collections



1. **java.util.Collections**

2. This class consists exclusively of **static methods** that operate on or return collections.

3. The methods of this class **all throw a NullPointerException** if the collections or class objects provided to them are null.





## Methods



1. static <T extends Comparable<? super T>> void **sort**(List<T> list)

    1. Sorts the specified list into **ascending order**,

    2. According to the natural ordering of its elements. All elements in the list must implement the **Comparable interface**.

    3. Equal elements will not be reordered as a result of the sort.

2. static <T> void **sort**(List<T> list, Comparator<? super T> c)

    1. Sorts the specified list according to the order induced by the specified comparator.

    2. ` {list.sort(c);}`

3. int **binarySearch**(List<? extends Comparable<? super T>> list, T key)

    1. Searches the specified list for the specified object using the binary search algorithm.

    2. If the list contains multiple elements equal to the specified object, there is no guarantee which one will be found.

    3. Returns the index of the search key, if it is contained in the list;

    4. otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the list: the index of the first element greater than the key,

    5. or list.size() if all elements in the list are less than the specified key.

4. static <T> int **binarySearch**(List<? extends T> list, T key, Comparator<? super T> c)

    1. Searches the specified list for the specified object using the binary search algorithm.

    2. The list must be sorted into ascending order according to the specified comparator (as by the sort(List, Comparator) method), prior to making this call.

5. static void **reverse**(List<?> list)

    1. Reverses the order of the elements in the specified list.

    2. This method runs in linear time.

6. static void **swap**(List<?> list, int i, int j)

    1. Swaps the elements at the specified positions in the specified list.

7. static <T> void **fill**(List<? super T> list, T obj)

    1. Replaces all of the elements of the specified list with the specified element.

8. static <T> void **copy**(List<? super T> dest, List<? extends T> src)

    1. Copies all of the elements from one list into another.

    2. After the operation, the index of each copied element in the destination list will be identical to its index in the source list.

    3. The destination list's size must be greater than or equal to the source list's size.

    4. **If it is greater, the remaining elements in the destination list are unaffected**.

9. static <T extends Object & Comparable<? super T>> T **min**(Collection<? extends T> coll)

    1. Returns the minimum element of the given collection, according to the natural ordering of its elements.

10. static <T> T **min**(Collection<? extends T> coll, Comparator<? super T> comp)

    1. Returns the minimum element of the given collection, according to the order induced by the specified comparator.

11. static <T extends Object & Comparable<? super T>> T **max**(Collection<? extends T> coll)

12. static <T> T **max**(Collection<? extends T> coll, Comparator<? super T> comp)

13. static <T> boolean **replaceAll**(List<T> list, T oldVal, T newVal)

    1. Replaces all occurrences of one specified value in a list with another.

    2. Returns true if list contained one or more elements e such that (oldVal==null ? e==null : oldVal.equals(e)).

14. static int **indexOfSubList**(List<?> source, List<?> target)

    1. Returns the starting position of the first occurrence of the specified target list within the specified source list, or -1 if there is no such occurrence.

15. static int **lastIndexOfSubList**(List<?> source, List<?> target)

    1. Returns the starting position of the last occurrence of the specified target list within the specified source list, or -1 if there is no such occurrence.

16. static <T> Collection<T> **synchronizedCollection**(Collection<T> c)

    ```

    Collection c = Collections.synchronizedCollection(myCollection);

           ...

        synchronized (c) {

            Iterator i = c.iterator(); // Must be in the synchronized block

            while (i.hasNext())

               foo(i.next());

        }

    ```

17. static <T> Set<T> **synchronizedSet**(Set<T> s)

18. static <T> SortedSet<T> **synchronizedSortedSet**(SortedSet<T> s)

    ```

    SortedSet s = Collections.synchronizedSortedSet(new TreeSet());

        SortedSet s2 = s.headSet(foo);

            ...

        synchronized (s) {  // Note: s, not s2!!!

            Iterator i = s2.iterator(); // Must be in the synchronized block

            while (i.hasNext())

                foo(i.next());

        }

    ```

19. static <T> NavigableSet<T> **synchronizedNavigableSet**(NavigableSet<T> s)

`NavigableSet s = Collections.synchronizedNavigableSet(new TreeSet());`

20. static <T> List<T> **synchronizedList**(List<T> list)

21. static <K,V> Map<K,V> **synchronizedMap**(Map<K,V> m)

```

Map m = Collections.synchronizedMap(new HashMap());

            ...

        Set s = m.keySet();  // Needn't be in synchronized block

            ...

        synchronized (m) {  // Synchronizing on m, not s!

            Iterator i = s.iterator(); // Must be in synchronized block

            while (i.hasNext())

                foo(i.next());

        }

```

22. static <K,V> SortedMap<K,V> **synchronizedSortedMap**(SortedMap<K,V> m)

```

SortedMap m = Collections.synchronizedSortedMap(new TreeMap());

        SortedMap m2 = m.subMap(foo, bar);

            ...

        Set s2 = m2.keySet();  // Needn't be in synchronized block

            ...

        synchronized (m) {  // Synchronizing on m, not m2 or s2!

            Iterator i = s2.iterator(); // Must be in synchronized block

            while (i.hasNext())

                foo(i.next());

        }

```

23. static <K,V> NavigableMap<K,V> **synchronizedNavigableMap**(NavigableMap<K,V> m)

    1. `NavigableMap m = Collections.synchronizedNavigableMap(new TreeMap());`

24. static <T> Iterator<T> **emptyIterator**()

    1. Returns an iterator that has no elements. More precisely,

    2. hasNext always returns false.

    3. next always throws NoSuchElementException.

    4. remove always throws IllegalStateException.

25. static <T> ListIterator<T> **emptyListIterator**()

26. static <T> Set<T> **singleton**(T o)

    1. Returns an immutable set containing only the specified object.

    2. The returned set is serializable.

27. static <T> List<T> **singletonList**(T o)

28. static <K,V> Map<K,V> **singletonMap**(K key, V value)

29. static <T> Comparator<T> **reverseOrder**()

    1. Returns a comparator that imposes the reverse of the natural ordering on a collection of objects that implement the Comparable interface.

30. static <T> Comparator<T> **reverseOrder**(Comparator<T> cmp)

    1. Returns a comparator that imposes the reverse ordering of the specified comparator.

    2. `TreeMap<String, String> newHashMap = new TreeMap<>(Collections.reverseOrder());`

31. static <T> Enumeration<T> **enumeration**(final Collection<T> c)

32. static int **frequency**(Collection<?> c, Object o)

    1. Returns the number of elements in the specified collection equal to the specified object.

33. static <T> boolean **addAll**(Collection<? super T> c, T... elements)

    1. Adds all of the specified elements to the specified collection.

    2. identical to that of `c.addAll(Arrays.asList(elements))`,

    3. Returns true if the collection changed as a result of the call.

34. static boolean **disjoint**(Collection<?> c1, Collection<?> c2)

    1. Returns:true if the two specified collections have no elements in common.