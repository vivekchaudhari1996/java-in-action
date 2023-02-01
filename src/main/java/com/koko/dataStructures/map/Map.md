## Map



1. An object that maps keys to values.

2. A map **cannot contain duplicate keys**; each key can map to at most one value.

3. This interface takes the **place of the Dictionary class**

4. The Map interface provides **three collection views**, which allow a map's contents to be viewed as a set of keys, collection of values, or set of key-value mappings.

5. The **Object.hashCode()** specification guarantees that two objects with unequal hash codes cannot be equal.

6. The **Map.of, Map.ofEntries, and Map.copyOf** static factory methods provide a convenient way to create **unmodifiable maps**. The Map instances created by these methods have the following characteristics:

    1. They are unmodifiable. Keys and values cannot be added, removed, or updated. Calling any mutator method on the Map will always cause **UnsupportedOperationException** to be thrown.

    2. They **disallow null keys and values**. Attempts to create them with null keys or values result in NullPointerException.





## Class Definitions



1. **Class**

`interface Map<K, V>`

2. **Methods**

    1. void **replaceAll**(BiFunction<? super K, ? super V, ? extends V> function)

        1. Replaces each entry's value with the result of invoking the given Bifunction on that entry until all entries have been processed or the function throws an exception.

    2. boolean **remove**(Object key, Object value)

        1. Removes the entry for the specified key only if it is currently mapped to the specified value.

    3. boolean **replace**(K key, V oldValue, V newValue)

        1. Replaces the entry for the specified key only if currently mapped to the specified value.

    4. V **replace**(K key, V value)

        1. Returns the previous value associated with the specified key, or null if there was no mapping for the key.

    5. V **compute**(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)

        1. map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))

        2. Attempts to compute a mapping for the specified key and its current mapped value (or null if there is no current mapping).

        3. Returns the new value associated with the specified key, or null if none.

    6. V **merge**(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)

        1. If the specified key is not already associated with a value or is associated with null, associates it with the given non-null value.

        2. Otherwise, replaces the associated value with the results of the given remapping function, or removes if the result is null.

        3. For example, to either create or append a String msg to a value mapping:

        4. `map.merge(key, msg, String::concat)`

        5. If the remapping function returns null, the mapping is removed.

        6. Returns the new value associated with the specified key, or null if no value is associated with the key

    7. static <K, V> Map<K, V> **of()** { return ImmutableCollections.emptyMap(); }

        1. Here arguments can contain **upto 10 k,v pairs** like:

        2. static <K, V> Map<K, V> **of(K k1, V v1)**

        3. `Map.of("a1","v1","a2","v2");`

    8. static <K, V> Map<K, V> **ofEntries**(Entry<? extends K, ? extends V>... entries)

        1. Returns an unmodifiable map containing keys and values extracted from the given entries.

    9. static <K, V> Map<K, V> **copyOf**(Map<? extends K, ? extends V> map)

        1. Returns an unmodifiable Map containing the entries of the given Map.

        2. The given Map must not be null, and it must not contain any null keys or values.

        3. If the given Map is subsequently modified, the returned Map will not reflect such modifications.