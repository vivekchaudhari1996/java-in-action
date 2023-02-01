## Binary Trees

1. At max 2 children.
2. Root node, child nodes.
3. **Subtree** is the entire tree below the node.
4. **Ancestors** are the parents of the node till the root.
5. **5 Types** :
    1. **Full BT**: either 0 or 2 children.
    2. **Complete BT**: All levels are completely filled except the last level.
        1. Last level nodes should be as left as possible.
    3. **Perfect BT**: All leaf nodes at same level.
    4. **Balanced BT**: Height of tree at max log2N.
    5. **Degenerate Tree**: Or **Skew Tree** All nodes have single child. So just like a linked list.

## Structure

```
Node{
int data;
Node left;
Node right;
}
```

## Traversal

1. **DFS**:
    1. **Inorder**: Left, root, right
    2. **Preorder** Root, left, right
    3. **Postorder**: Left, right, root

2. **BFS**: Level wise traversal

