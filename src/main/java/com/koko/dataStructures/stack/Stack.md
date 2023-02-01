## Stacks



1. The Stack class represents a **last-in-first-out (LIFO)** stack of objects.

2. It **extends class Vector** with five operations that allow a vector to be treated as a stack

3. A more complete and consistent set of LIFO stack operations is provided by the **Deque interface and its implementations**, which should be **used in preference to this class**. For example:

4. `Deque<Integer> stack = new ArrayDeque<Integer>();`



## Class

1. `class Stack<E> extends Vector<E>`

2. **Methods**

    1. E **push**(E item):

        1. Pushes an item onto the top of this stack.

        2. Returns:the item argument itself.

    2. synchronized E **pop**()

        1. Removes the object at the top of this stack and returns that object.

    3. synchronized E **peek**()

        1. Looks at the object at the top of this stack without removing it from the stack.

        2. Returns: the object at the top of this stack

    4. boolean **empty**()

    5. synchronized int **search**(Object o)

        1. Returns: the 1-based position from the top of the stack where the object is located;

        2. the return value -1 indicates that the object is not on the stack.

        3. this method returns the distance from the top of the stack of the occurrence nearest the top of the stack;