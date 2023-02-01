## LinkedHash Map



1. It maintains a **doubly-linked list** running through all of its entries.

2. This linked list defines the iteration ordering, which is normally the order in which keys were inserted into the map **(insertion-order)**.

3. Insertion order is **not affected if a key is re-inserted into the map**.

4. A **special constructor** is provided to create a linked hash map whose order of iteration is the order in which its entries were last accessed, **from least-recently accessed to most-recently (access-order)**. This kind of map is well-suited to **building LRU caches**.

5. The **removeEldestEntry(Map.Entry)** method may be **overridden to impose a policy** for removing stale mappings automatically when new mappings are added to the map.

6. permits **null elements**. Like HashMap

7. **Performance** is likely to be just **slightly below that of HashMap**, due to the added expense of maintaining the linked list, **with one exception**

    1. Iteration over the collection-views of a LinkedHashMap requires time proportional to the **size of the map, regardless of its capacity**.

    2. Iteration over a HashMap is likely to be more expensive, requiring time proportional to its capacity.

8. this implementation is **not synchronized**.

9. `Map m = Collections.synchronizedMap(new LinkedHashMap(...));`

10. In **access-ordered linked hash maps**, merely querying the map with get is a structural modification.





## Class Definitions



1. **Class**

    1. `public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V>`

2. **Entry Node**

```

static class Entry<K,V> extends HashMap.Node<K,V> {

        Entry<K,V> before, after;

        Entry(int hash, K key, V value, Node<K,V> next) {

            super(hash, key, value, next);

        }

    }

```

3. **Fields**

    1. LinkedHashMap.Entry<K,V> **head**;

        1. The head (eldest) of the doubly linked list.

    2. LinkedHashMap.Entry<K,V> **tail**;

        1. The tail (youngest) of the doubly linked list.

    3. final boolean **accessOrder**;

        1. The iteration ordering method for this linked hash map: **true for access-order, false for insertion-order**.

4. **Constructor**

    1. No args

    2. capacity

    3. capacity and loadF

    4. Map

    5. capacity, loadF, accessOrder