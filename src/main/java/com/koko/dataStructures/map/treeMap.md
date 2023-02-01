## TreeMap



1. A **Red-Black tree based NavigableMap** implementation.

2. The map is **sorted according to the natural ordering of its keys**, or by a **Comparator provided at map creation time**, depending on which constructor is used.

3. This implementation provides **guaranteed log(n) time cost** for the containsKey, get, put and remove operations.

4. this implementation is **not synchronized**.

5. The map could be "wrapped" using the **Collections.synchronizedSortedMap** method.

6. This is best done at creation time, to prevent accidental unsynchronized access to the map:

   `SortedMap m = Collections.synchronizedSortedMap(new TreeMap(...));`

7. The iterators returned by the iterator method of the collections returned by all of this class's "collection view methods" are **fail-fast**.

8. Fail-fast iterators throw ConcurrentModificationException on a best-effort basis. Therefore, it would be wrong to write a program that depended on this exception for its correctness.





## Class Definitions



1. **Class**

```

public class TreeMap<K,V>

    extends AbstractMap<K,V>

    implements NavigableMap<K,V>, Cloneable, java.io.Serializable

```

2. **Fields**

    1. final Comparator<? super K> comparator;

    2. transient Entry<K,V> root;

    3. transient int modCount = 0;

    4. transient int size = 0;



3. **Constructor**

    1. TreeMap()

        1. comparator = null;

        2. All keys inserted into the map must implement the **Comparable interface**.

        3. Furthermore, all such keys must be mutually comparable: k1.compareTo(k2) must not throw a **ClassCastException** for any keys k1 and k2 in the map.

    2. TreeMap(Comparator<? super K> comparator)

        1. If comparator is null, natural ordering of keys will be used.

        2. All keys inserted into the map must be mutually comparable by the given comparator: **comparator.compare(k1, k2)** must not throw a ClassCastException for any keys k1 and k2 in the map.

    3. TreeMap(Map<? extends K, ? extends V> m)

        1. Constructs a new tree map containing the same mappings as the given map,

        2. ordered according to the **natural ordering of its keys**.

        3. All keys inserted into the new map must implement the Comparable interface.

        4. This method runs in **TC:** n*log(n) time.

    4. TreeMap(SortedMap<K, ? extends V> m)

        1. Constructs a new tree map containing the same mappings

        2. and using the same ordering as the **specified sorted map**.

        3. This method runs in **TC:** linear time.



4. **Methods**

    1. get

    2. containsKey

    3. containsValue

    4. size

    5. Comparator<? super K> **comparator**()

        1. returns the comparator being used.

    6. K **firstKey**()

        1. returns the first key or root.

        2. throws NoSuchElementException

    7. Entry<K,V> **firstEntry**()

    8. Entry<K,V> **pollFirstEntry**()

    7. K **lastKey**()

        1. throws NoSuchElementException

    8. Map.Entry<K,V> **lastEntry**()

    9. Map.Entry<K,V> **pollLastEntry**()

    8. void **putAll**(Map<? extends K, ? extends V> map)

        1. These mappings replace any mappings that this map had for any of the keys currently in the specified map.

    9. Map.Entry<K,V> **lowerEntry**(K key)

    10. K **lowerKey**(K key)

    11. Map.Entry<K,V> **floorEntry**(K key): If key is found, returns that.

    12. K **floorKey**(K key)

    13. Map.Entry<K,V> **ceilingEntry**(K key): If key is found, returns that.

    14. K **ceilingKey**(K key)

    15. Map.Entry<K,V> **higherEntry**(K key)

    16. K **higherKey**(K key)

    14. V **put**(K key, V value)

    15. V **remove**(Object key)

    16. void **clear**()

    17. Object **clone**()

        1. Returns a shallow copy of this TreeMap instance. (The keys and values themselves are not cloned.)

    18. Set<K> **keySet**() :

        1. Set's iterator returns the keys in ascending order.

        2. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.

    19. NavigableSet<K> **navigableKeySet**()

    20. NavigableSet<K> **descendingKeySet**()

    21. Collection<V> **values**()

        1. The collection's iterator returns the values in ascending order of the corresponding keys.

        2. The collection is backed by the map, so changes to the map are reflected in the collection, and vice-versa.

    22. Set<Map.Entry<K,V>> **entrySet**()

        1. The set's iterator returns the entries in ascending key order

        2. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.





## Iterations



1. The **reverseOrder() method of the Collections** class returns a Comparator that imposes the reverse of the natural ordering of the objects.

2. `TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(Collections.reverseOrder());`

```

// for keys in descending order

Set<Integer> keySet = treeMap.descendingKeySet();

 

// The descendingMap() method of the TreeMap class returns a map containing a reverse view

// of the mappings. Iterate over the map using the iterator of the entry set.

Map<Integer, String> reverseMap = treeMap.descendingMap();

 

 

```