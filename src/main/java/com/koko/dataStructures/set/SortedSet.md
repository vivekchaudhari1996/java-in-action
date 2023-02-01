## Sorted Set



1. A Set that further provides a **total ordering** on its elements.

2. The elements are ordered using their **natural ordering, or by a Comparator** typically provided at sorted set creation time.

3. Provides **subSets**.

4. Does not allow **null** elements.





## Class



1. `interface SortedSet<E> extends Set<E>`

2. **Methods**

    1. Comparator<? super E> **comparator**()

        1. Returns the comparator used to order the elements in this set,

        2. or null if this set uses the natural ordering of its elements.

    2. SortedSet<E> **subSet**(E fromElement, E toElement)

        1. Returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive.

        2. The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.

    3. SortedSet<E> **headSet**(E toElement)

        1.  elements are strictly less than toElement.

    4. SortedSet<E> **tailSet**(E fromElement)

        1. elements are greater than or equal to fromElement.

    5. E **first**(): first or lowest elem.

    6. E **last**(): last or highest elem.