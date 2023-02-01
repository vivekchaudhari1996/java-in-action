## HashTable



1. Any **non-null object** can be used as a key or as a value.

2. The objects used as **keys must implement the hashCode method and the equals method**.

3. The iterators are fail fast.

4. The **Enumerations** returned by Hashtable's keys and elements methods are **not fail-fast**; if the Hashtable is structurally modified at any time after the enumeration is created then the **results of enumerating are undefined**.

5. Hashtable is **synchronized.**, still :

    1. If a thread-safe implementation is not needed: Hashmap

    2. If a thread-safe highly-concurrent implementation is desired, then it is recommended to use **java.util.concurrent.ConcurrentHashMap** in place of Hashtable.

6. Default **Initial capacity** = 11

7. Load factor = 0.75F





## Class Definitions



1. **Class**

    1. `public class Hashtable<K,V> extends Dictionary<K,V> implements Map<K,V>, Cloneable, java.io.Serializable`

2. **Methods**

    1. synchronized Enumeration<K> **keys**()

        1. Returns an enumeration of the keys in this hashtable.

    2. synchronized Enumeration<V> **elements**()

        1. Returns an enumeration of the values in this hashtable

        ```

        Enumeration<String> e = ht.elements();

        while (e.hasMoreElements()){

            System.out.println(e.nextElement());

        }

        ```

    3. synchronized boolean **contains**(Object value)

        1. identical in functionality to containsValue,

    4. boolean **containsValue**(Object value)

    5. synchronized boolean **containsKey**(Object key)

    6. synchronized String **toString**()

        1. Key=Value, Key2=value2

    7. Set<K> **keySet**()

    8. Set<Map.Entry<K,V>> **entrySet**()

    9. Collection<V> **values**()