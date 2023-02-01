## HashMap



1. **Hash table based implementation** of the Map interface.

2. **Permits null values and the null key**.

3. HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls.

    1. **Hashtable** does not allow null keys but HashMap allows one null key and any number of null values.

    2. put() method in hashmap does not call hashcode() when null is passed as key and null Key is handled as a special case.

    3. checks if the key is null and call **putForNullKey(value)** and return.

    4. This putForNullKey will create a **entry in bucket at 0** index.

    5. Index zero is always reserved for null key in the bucket.

    6. On the other hand, in case of **hashtable objects used as keys** must implement the hashCode method and the equals method.

    7. Since **null is not an object**, it can’t implement these methods.



4. HashMap is **non-synchronized**. It is not thread-safe and can’t be shared between many threads

5. without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.

6. This class makes **NO guarantees as to the order of the map**; in particular,

7. it does not guarantee that the order will remain constant over time.

8. This implementation provides **constant-time performance for the basic operations (get and put)**,

9. assuming the hash function disperses the elements properly among the buckets.

10. HashMap has two parameters that affect its performance: **initial capacity and load factor**.

11. The **capacity** is the number of buckets in the hash table, and the initial capacity is simply the capacity at the time the hash table is created.

12. The **load factor** is a measure of how full the hash table is allowed to get before its capacity is automatically increased.

13. When the number of entries in the hash table exceeds the **product of the load factor and the current capacity**, the hash table is **rehashed** (that is, internal data structures are rebuilt) so that the hash table has approximately twice the number of buckets.

14. It's very important NOT to set the initial capacity too high (or the load factor too low) if iteration performance is important.

15. The **default load factor (.75)** offers a good tradeoff between time and space costs. Higher values decrease the space overhead but increase the lookup cost.

16. If multiple threads access a hash map **concurrently**, and at least one of the threads modifies the map structurally, it throws a **ConcurrentModificationException.**

17. A **structural modification** is any operation that adds or deletes one or more mappings; merely changing the value associated with a key is not a structural modification.

18. The map could be "wrapped" using the **Collections.synchronizedMap** method. This is best done at creation time, to prevent accidental unsynchronized access to the map:

19. **Map m = Collections.synchronizedMap(new HashMap(...));**

20. The **iterators** returned by all of this class's "collection view methods" are **fail-fast**: if the map is structurally modified at any time after the iterator is created, in any way except through the iterator's own remove method, the iterator will throw a ConcurrentModificationException.

21. Thus, in the face of concurrent modification, the **iterator fails quickly and cleanly**, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.

22. Fail-fast iterators throw ConcurrentModificationException on a **best-effort basis**. Therefore, it would be **wrong to write a program that depended on this exception** for its correctness: the fail-fast behavior of iterators should be used only to detect bugs.

23. We cannot iterate a Map directly using iterators, because **Map are not Collection**.



## Class Definitions



1. **Class Definition**

public class HashMap<K,V> extends AbstractMap<K,V>

    implements Map<K,V>, Cloneable, Serializable { }

24. **SerialVersionUID**

    private static final long serialVersionUID = 362498820763181265L;

25. **Default Initial Capacity**: The default initial capacity - **MUST be a power of two**

`static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16`

26. **Max capacity**: The maximum capacity, used if a higher value is implicitly specified by either of the constructors with arguments. **MUST be a power of two <= 1<<30**

    `static final int MAXIMUM_CAPACITY = 1 << 30;`

27. **Load factor**: The load factor used when none specified in constructor.

`static final float DEFAULT_LOAD_FACTOR = 0.75f;`

28. **Treeify Threshold**:  HashMap replaces **linked list with a binary tree** when the number of elements in a bucket reaches certain threshold.. The value must be greater than 2 and should be at least 8.

`static final int TREEIFY_THRESHOLD = 8;`

29. **Untreeify threshold**:. Should be less than TREEIFY_THRESHOLD, and at most 6 to mesh with shrinkage detection under removal.

`static final int UNTREEIFY_THRESHOLD = 6;`

30. **Minimum Treeify capacity**: The smallest table capacity for which bins may be treeified. (Otherwise the table is resized if too many nodes in a bin.) Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts between resizing and treeification thresholds.

`static final int MIN_TREEIFY_CAPACITY = 64;`





## Code Snippets



1. **Node class** which forms the building block.

```

static class Node<K,V> implements Map.Entry<K,V> {

        final int hash;

        final K key;

        V value;

        Node<K,V> next;

 

        Node(int hash, K key, V value, Node<K,V> next) {

            this.hash = hash;

            this.key = key;

            this.value = value;

            this.next = next;

        }

 

        public final K getKey()        { return key; }

        public final V getValue()      { return value; }

        public final String toString() { return key + "=" + value; }

 

        public final int hashCode() {

            return Objects.hashCode(key) ^ Objects.hashCode(value);

        }

 

        public final V setValue(V newValue) {

            V oldValue = value;

            value = newValue;

            return oldValue;

        }

 

        public final boolean equals(Object o) {

            if (o == this)

                return true;

            if (o instanceof Map.Entry) {

                Map.Entry<?,?> e = (Map.Entry<?,?>)o;

                if (Objects.equals(key, e.getKey()) &&

                    Objects.equals(value, e.getValue()))

                    return true;

            }

           return false;

        }

    }

```



2. **Static hash util**

```

static final int hash(Object key) {

        int h;

        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

    }

```

3. **Fields**

    1. transient Node<K,V>[] table;

    2. transient int modCount;: number of times this HashMap has been structurally modified.



4. **Constructors**

    1. HashMap(int initialCapacity, float loadFactor)

    2. HashMap(int initialCapacity) : default load factor (0.75).

    3. HashMap() : empty HashMap with the default initial capacity (16) and the default load factor (0.75).

    4. Constructs a new HashMap with the same mappings as the specified Map.

    ```

    public HashMap(Map<? extends K, ? extends V> m) {

        this.loadFactor = DEFAULT_LOAD_FACTOR;

        putMapEntries(m, false);

    }

    ```



5. **Size**

    1. public int size() : Return nbr of key-Value mappings in the map.

    2. public boolean isEmpty() {

       return size == 0;

   }

6. **Methods**

    1. V **Get**(Object key)

        1. Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.

        2. Throws ClassCastException – if the key is of an inappropriate type for this map.

    2. boolean **containsKey**(Object key)

        1. Returns true if this map contains a mapping for the specified key

    3. V **put**(K key, V value)

        1. Returns: the previous value associated with key, or null if there was no mapping for key.

        2. (A null return can also indicate that the map previously associated null with key, if the implementation supports null values.)

    4. V **remove**(Object key)

        1. Returns the previous value associated with key, or null if there was no mapping for key.

    5. void **clear**()

        1. Removes all of the mappings from this map. The map will be empty after this call returns.

    6. boolean **containsValue**(Object value)

        1. Returns true if this map maps one or more keys to the specified value.

    7. Set<K> **keySet**()

        1. Returns a Set view of the keys contained in this map.

        2. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.

    8. Collection<V> **values**()

        1. Returns a Collection view of the values contained in this map.

        2. The collection is backed by the map, so changes to the map are reflected in the collection, and vice-versa.

    9. Set<Map.Entry<K,V>> **entrySet**()

        1. Returns a Set view of the mappings contained in this map.

        2. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa.

    10. V **getOrDefault**(Object key, V defaultValue)

        1. Returns value otherwise defultValue.

    11. V **putIfAbsent**(K key, V value)

        1. Returns the previous value associated with the specified key, or null if there was no mapping for the key.

        2. (A null return can also indicate that the map previously associated null with the key, if the implementation supports null values.)

    12. boolean **remove**(Object key, Object value)

    13. boolean **replace**(K key, V oldValue, V newValue)

    14. V **replace**(K key, V value)

        1. Returns old value or null.

    15. V **computeIfAbsent**(K key, Function<? super K, ? extends V> mappingFunction)

        1. Returns: This method returns current (existing or computed) value associated with the specified key, or null if mapping returns null.

        2. used to compute value for a given key using the given mapping function,

        2. if key is not already associated with a value (or is mapped to null) and enter that computed value in Hashmap else null.

        3. If mapping function of this method returns null, then no mapping is recorded for that key.

        4. At time of computation if remapping function throws an exception, the exception is rethrown, and the no mapping is recorded.

        5. During computation, modification of this map using this method is not allowed.

        6. This method will throw a **ConcurrentModificationException** if the remapping function modified this map during computation.

        1. **Ex: map.computeIfAbsent**(key, k -> new Value(f(k)));

        2. `map.computeIfAbsent("key5", k -> 2000 + 33000);`

        2. **Ex: map.computeIfAbsent**(key, k -> new HashSet<V>()).add(v);

        3. The mapping function should **not modify this map during computation**.

    16. V **computeIfPresent**(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)

        1. Returns: This method returns new remapped value associated with the specified key, or null if mapping returns null.

        2. If the value for the specified key is present and non-null, attempts to compute a new mapping given the key and its current mapped value.

        2. If the remapping function returns null, the mapping is removed.

        3. If the remapping function throws an exception, the exception is rethrown, and the mapping is left unchanged.

        3. The remapping function should not modify this map during computation. This method will, on a best-effort basis, throw a ConcurrentModificationException if it is detected that the remapping function modifies this map during computation.

        4. **Ex**: `wordCount.computeIfPresent("Geek", (key, val) -> val + 100);`

    17. Object **clone**() : Returns a shallow copy of this HashMap instance: the keys and values themselves are not cloned.

    18.  void **putAll**(Map <map_name>): Copies whole map content to the other.

         1. `Map<String, String> copyHashMap = new HashMap<>();`

         2. `copyHashMap.putAll(origHashMap);`



## Iterations

```

// Iteration using EntrySet

        // using for-each loop for iteration over Map.entrySet()

        for (Map.Entry<String,String> entry : newHashMap.entrySet())

            System.out.println("Key = " + entry.getKey() +

                    ", Value = " + entry.getValue());

 

 

        // using keySet() for iteration over keys

        for (String name : newHashMap.keySet())

            System.out.println("key: " + name);

 

        // using values() for iteration over values

        for (String url : newHashMap.values())

            System.out.println("value: " + url);

 

 

        // using iterators

        Iterator<Map.Entry<String, String>> itr = newHashMap.entrySet().iterator();

        while(itr.hasNext())

        {

            Map.Entry<String, String> entry = itr.next();

            System.out.println("Key = " + entry.getKey() +

                    ", Value = " + entry.getValue());

        }

 

 

        // forEach(action) method to iterate map

        newHashMap.forEach((k,v) -> System.out.println("Key = "

                + k + ", Value = " + v));

               

                

```