## Navigable Map



1. A **SortedMap extended with navigation methods** returning the closest matches for given search targets.

2. Methods **lowerEntry, floorEntry, ceilingEntry, and higherEntry** return Map.

3. Similarly, methods **lowerKey, floorKey, ceilingKey, and higherKey** return only the associated keys.

4. All of these methods are **designed for locating, not traversing entries**.

5. A NavigableMap may be accessed and traversed in **either ascending or descending key** order.

6. The **descendingMap** method returns a view of the map with the senses of all relational and directional methods inverted.

7. Methods **subMap(K, boolean, K, boolean), headMap(K, boolean), and tailMap(K, boolean)** differ from the like-named SortedMap methods in accepting additional arguments describing **whether lower and upper bounds are inclusive versus exclusive**

8. This interface additionally defines methods **firstEntry, pollFirstEntry, lastEntry, and pollLastEntry** that return and/or remove the least and greatest mappings, if any exist, else returning null.



## Class Definitions



1. **Class**

`public interface NavigableMap<K,V> extends SortedMap<K,V>`

2. **Methods**

    1. Map.Entry<K,V> **lowerEntry**(K key)

        1. Returns a key-value mapping associated with the greatest key strictly less than the given key, or null if there is no such key.

    2. K **lowerKey**(K key); Returns the greatest key strictly less than the given key, or null if there is no such key.

    3. Map.Entry<K,V> **floorEntry**(K key);

        1. Returns a key-value mapping associated with the greatest key less than or equal to the given key, or null if there is no such key.

    4. K **floorKey**(K key);

    5. Map.Entry<K,V> **ceilingEntry**(K key);

        1. Returns a key-value mapping associated with the least key greater than or equal to the given key, or null if there is no such key.

    6. K **ceilingKey**(K key);

    7. Map.Entry<K,V> **higherEntry**(K key);

        1. Returns a key-value mapping associated with the least key strictly greater than the given key, or null if there is no such key.

    8. K **higherKey**(K key);

    9. Map.Entry<K,V> **firstEntry**();

        1. Returns a key-value mapping associated with the least key in this map, or null if the map is empty.

    10. Map.Entry<K,V> **lastEntry**();

        1. Returns a key-value mapping associated with the greatest key in this map, or null if the map is empty.

    11. Map.Entry<K,V> **pollFirstEntry**();

        1. Removes and returns a key-value mapping associated with the least key in this map, or null if the map is empty.

    12. Map.Entry<K,V> **pollLastEntry**();

    13. NavigableMap<K,V> **descendingMap**();

        1. Returns a **reverse order view** of the mappings contained in this map.

        2. The descending map is backed by this map, so changes to the map are reflected in the descending map, and vice-versa.

        3. The returned map has an ordering equivalent to **Collections.reverseOrder(comparator()).**

    14. NavigableSet<K> **navigableKeySet**();

        1. Returns a NavigableSet view of the keys contained in this map.

        2. The set's iterator returns the **keys in ascending order**.

        3. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.

    15. NavigableSet<K> **descendingKeySet**();

        1. Returns a reverse order NavigableSet view of the keys contained in this map.

        2. The set's iterator returns the **keys in descending order**

        3. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.

    16. NavigableMap<K,V> **subMap**(K fromKey, boolean fromInclusive, K toKey,   boolean toInclusive)

        1. Returns a view of the portion of this map whose keys range from fromKey to toKey.

        2. The returned map is backed by this map, so changes in the returned map are reflected in this map, and vice-versa.

    17. NavigableMap<K,V> **headMap**(K toKey, boolean inclusive)

        1. Returns a view of the portion of this map whose keys are less than (or equal to, if inclusive is true) toKey.

        2. The returned map is backed by this map, so changes in the returned map are reflected in this map, and vice-versa.

    18. NavigableMap<K,V> **tailMap**(K fromKey, boolean inclusive)

        1. Returns a view of the portion of this map whose keys are greater than (or equal to, if inclusive is true) fromKey.

        2. The returned map is backed by this map, so changes in the returned map are reflected in this map, and vice-versa.

    19. SortedMap<K,V> **subMap**(K fromKey, K toKey)

        1. Equivalent to subMap(fromKey, true, toKey, false)

    20. SortedMap<K,V> **headMap**(K toKey);

        1. Equivalent to headMap(toKey, false)

    21. SortedMap<K,V> **tailMap**(K fromKey)

        1. Equivalent to tailMap(fromKey, true).