## Set



1. A collection that contains **no duplicate elements**.

2. At most **one null element**.

3. The **Set.of and Set.copyOf static factory methods** provide a convenient way to create **unmodifiable sets.**

    1. They disallow null elements.



## Class



1. `interface Set<E> extends Collection<E>`

2. **Methods**

    1. boolean **isEmpty**();

    2. boolean **contains**(Object o)

    3. Iterator<E> **iterator**();

    4. Object[] **toArray**();

    5. boolean **add**(E e)

        1. Returns: true if this set did not already contain the specified element.

    6. boolean **remove**(Object o)

        1. Returns: true if this set contained the specified element

    7. boolean **containsAll**(Collection<?> c)

        1. Returns: true if this set contains all of the elements of the specified collection.

    8. boolean **addAll**(Collection<? extends E> c)

        1. Adds all of the elements in the specified collection to this set if they're not already present.

        2. Returns: true if this set changed as a result of the call

    9. boolean **retainAll**(Collection<?> c)

        1. Retains only the elements in this set that are contained in the specified collection.

        2. Removes from this set all of its elements that are not contained in the specified collection.

        3. Returns: true if this set changed as a result of the call.

    10. boolean **removeAll**(Collection<?> c)

        1. Removes from this set all of its elements that are contained in the specified collection.

        2. Returns: true if this set changed as a result of the call

    11. void **clear**()

    12. int **hashCode**()

        1. Returns the hash code value for this set.

        2. The hash code of a set is defined to be the sum of the hash codes of the elements in the set,

        3. where the hash code of a null element is defined to be zero.

    13. static <E> Set<E> **of**()

        1. Returns an unmodifiable set containing zero elements.

    14. static <E> Set<E> **of**(E e1)

        1. Returns an unmodifiable set containing one element.

        2. Uptil 10 elems.

    15. static <E> Set<E> **of**(E... elements)

        1. Arbitrary nbr of elems.

    16. static <E> Set<E> **copyOf**(Collection<? extends E> coll)

        1. Returns an unmodifiable Set containing the elements of the given Collection.

        2. Collection must not be null, and it must not contain any null elements.