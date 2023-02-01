## Segment Tree

1. **Leaf Nodes** are the elements of the input array.
2. Each internal node represents some **merging of the leaf nodes**. 
3. The merging may be different for different problems. For this problem, merging is sum of leaf nodes under a node.
4. An array representation of tree is used to represent Segment Trees.
5. For each node at index i, the **left child** is at index (2*i+1), **right child** at (2*i+2) and the **parent** is at  ((i – 1) / 2).
6. ....
7. We start with a segment arr[0 . . . n-1]. and every time we divide the current segment into two 
8. (if it has not yet become a segment of length 1), and then call the same procedure on both halves, 
9. and for each such segment, we store the sum in the corresponding node.
10. The tree will be a **Full Binary Tree** because we always divide segment in two, at every level. 
11. Since the constructed tree is always a full binary tree with **n leaves, there will be n-1 internal nodes**. 
12. So the total number of nodes will be **2n – 1**.
13. **Height** of the segment tree will be ⌈log₂N⌉. 
14. **Size of memory** allocated for segment tree will be 2*( 2^ceil(log2n) ) – 1.

### Query for Sum/ Max

```
int getSum(node, l, r) 
{
   if the range of the node is within l and r
        return value in the node
   else if the range of the node is completely outside l and r
        return 0
   else
    return getSum(node's left child, l, r) + 
           getSum(node's right child, l, r)
}
```

### Update an index

1. Like tree construction and query operations, 
2. the update can also be done recursively. 
3. We are given an index which needs to be updated. Let diff be the value to be added. 
4. We start from the root of the segment tree and add diff to all nodes which have given index in their range. 
5. If a node doesn’t have a given index in its range, we don’t make any changes to that node. 
   