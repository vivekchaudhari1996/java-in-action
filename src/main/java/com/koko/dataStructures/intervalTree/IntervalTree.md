## Interval tree

1. Consider a situation where we have a set of intervals and we need following operations to be implemented efficiently.
1) Add an interval
2) Remove an interval
3) Given an interval x, find if x overlaps with any of the existing intervals.
4. **Interval Tree**: The idea is to augment a **self-balancing Binary Search Tree (BST)** 
5. like Red Black Tree, AVL Tree, etc to maintain set of intervals so that all operations can be done in **O(Logn)** time.
6. Every node of Interval Tree stores following information.
   1. i: An interval which is represented as a pair [low, high]
   2. max: Maximum high value in subtree rooted with this node.
7. The low value of an interval is used as key to maintain order in BST. 
8. The insert and delete operations are same as insert and delete in self-balancing BST used. 

## Algo

1. Interval overlappingIntervalSearch(root, x)
2. If x overlaps with root's interval, return the root's interval.

3. If left child of root is not empty and the max  in left child
   is greater than x's low value, recur for left child

4. Else recur for right child.