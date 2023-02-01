## Sorted Map



1. A Map that further provides a **total ordering on its keys**.

2. The map is ordered according to the natural ordering of its keys,

3. or by a Comparator typically provided at sorted map creation time.

4. All such keys must be **mutually comparable**: k1.compareTo(k2) (or comparator.compare(k1, k2))

5. Must not throw a **ClassCastException** for any keys k1 and k2 in the sorted map.

6. All general-purpose sorted map implementation classes should provide **four "standard" constructors.**

    1. no args, natural ordering

    2. comparator arg

    3. Map, natural ordering

    4. SortedMap

7. It provides option for **SubMaps** because of the ordering.





## Class Definitions



1. **Class**

`public interface SortedMap<K,V> extends Map<K,V>`

2. **Methods**

    1. Comparator<? super K> **comparator**();

        1. Returns the comparator used to order the keys in this map,

        2. or null if this map uses the natural ordering of its keys.

    2. SortedMap<K,V> **subMap**(K fromKey, K toKey)

        1. **keys range from fromKey, inclusive, to toKey, exclusive.**

        2. (If fromKey and toKey are equal, the returned map is empty.)

        3. The returned map is **backed by this map**, so changes in the returned map are reflected in this map, and vice-versa.

        4. The returned map will throw an **IllegalArgumentException** on an attempt to insert a key outside its range.

        5. If you need a **closed range (which includes both endpoints)**, and the key type allows for calculation of the successor of a given key, merely request the subrange from lowEndpoint to successor(highEndpoint).

        6. For example, suppose that m is a map whose keys are strings. The following idiom obtains a view containing all of the key-value mappings in m whose keys are between low and high, inclusive:

        7. `SortedMap<String, V> sub = m.subMap(low, high+"\0");`

        8.  low and high, exclusive

        8. `SortedMap<String, V> sub = m.subMap(low+"\0", high);`

    3. SortedMap<K,V> **headMap**(K toKey);

        1. Returns a view of the portion of this map whose keys are **strictly less than toKey.**

    4. SortedMap<K,V> **tailMap**(K fromKey);

        1. Returns a view of the portion of this map whose keys are **greater than or equal to fromKey.**

    5. K **firstKey()**; Returns the first (lowest) key currently in this map

    6. K **lastKey()**; Returns the last (highest) key currently in this map.