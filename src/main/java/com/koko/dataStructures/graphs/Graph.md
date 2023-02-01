## Basics

1. Node/ Vertex.
2. Edge (connecting Nodes)

### Types

1. **Undirected graph**
    1. Node u to Node v ; Node v to Node u (Both are true)

2. **Directed Graph**
    1. Node u -> Node v

3. **Bipartite Graph**
    1. If all nodes can be coloured by 2 colors,
    2. such that no 2 adjacent nodes are of same color.
    3. If a Graph has an **Odd length cycle**, it **cant** be Bipartite.

4. **Cyclic**
    1. If you can reach the same node from where you started the Path.


### Degrees

1. Number of edges incoming or outgoing to a Node, is the degree of Node.
2. Undirected graph: 
    1. There is no incoming or outgoing, so just count the edges connected to a Node.
    2. **Total Sum of degree** of all nodes = 2 * Number of edges.

3. Directed Graph:
    1. **Incoming edges or outgoing edges**.
    2. Indegree = nbr of incoming edges.
    3. Outdegree = nbr of edges going outwards.


### Paths

1. Undirected graph: Sequence of Nodes in which Node should not be repeated.
2. Directed: Sequence of Nodes without repetition and following the direction of edge.


### Cyclic graphs

1. If you can make a Path such that you reach the starting node.
2. Its Cyclic graphs (together with Undirected or Directed)
3. If no cycle can be formed, its **Acyclic**.
4. Directed Acyclic Graph : **DAG**
5. Tree can be example of Acyclic.

### Weights

1. Edges can have their weights.
2. If not given, assume weight 1.
3. Weighted Undirected or directed graphs.

## Take Inputs

1. Input will be given as N,M ; and then M lines of Node pairs.
2. N = total nbr of Nodes
3. M = total nbr of edges
4. Next M lines = Node pairs connected by 1 edge.

### Store with Adjacency Matrix

1. Take 2D array with N+1*N+1 size.
2. int [][] arr = new int[N+1][N+1]
3. Run a loop for all M edge pairs.
4. Mark arr[u][v] = 1 ; arr[v][u] = 1 ( For Undirected )
5. **Drawbacks** : Only use if N is small. 
6. If N is of range 10^5 , that will be wastage of space with this storing.

### Store with Adjacency List

1. Store adjacent Nodes List with each Node, taking it as index.
2. `List<List<integer>> arr [6] for N=5`
3. Node values are 1 index based. So, to keep them in list, we take N+1 as size.
4. If there is a edge between 1-2, 1-5
5. Store it as arr[1] = 2,5 ; arr[2] = 1 ; arr[5] = 1
6. arr.get(u).add(v) ; arr.get(v).add(u)
7. **SC** : O(N + 2*M)  : For Undirected
8. ....
9. If there are **weights** also given;
10. Store Values as pairs(Int, int); where adjacent Node and its weight. 
11. `Vector<pair<int,int>> arr`
12. **SC** : O(N + 2*M + 2*M)  : For Weighted Undirected


## Disconnected Graph

1. It can have various disconnected **Components**.
2. Even a single Node can be called as a Component.


## Traversal techniques

1. **BFS**
2. Breadth First means: Traverse the **adjacent Nodes first**.
3. Take a **visited array** and mark all Nodes as 0.
4. That means, no Node has been visited uptil now.
5. Take a **Queue** data structure.
```
for(i=1;i<N;i++){. // If there are multiple components and Node value starts from 1->N.
  if(!visited[i]){
    // Bfs(i).  // use adjacency list to get adjacent Nodes of i.
  } 
}
```
6. **TC**: O(N + E) ~ O(N)
7. N = Nodes , E = travelling through adjacent nodes
8. **SC**: O(N + E) + O(N) + O(N) ~ O(N)
9. Space comprises of Adjacency List, visited array and Queue.


10. **DFS**
11. Depth First Search: Traverse the depth first.
12. Take a **visited array** and mark all Nodes as 0.
13. boolean vis[] = new boolean[V+1];
```
for(i=1;i<N;i++){. // If there are multiple components and Node value starts from 1->N.
  if(!visited[i]){
    // Dfs(i)
  } 
}
```
13. DFS is a **recursive call** with all Adjacent Nodes in the list.
14. It starts traversal through any one of its neighbour nodes and explores the farthest possible node 
15. in each path/branch and then starts **Back-tracking**.
16. **TC**: O(N + E) ~ O(N)
17. N = Nodes , E = travelling through adjacent nodes
18. **SC**: O(N + E) + O(N) + O(N) ~ O(N)
19. Space comprises of Adjacency List, visited array and Auxilliary Space Recursion.



## Sorting

1. **Topological Sort**
    1. **Linear** ordering of vertices such that 
    2. If there is an edge u->v, u will come before v in the ordering.
    3. Hence, it is not possible for Cyclic graphs because of this condition.
    4. There can be **multiple** Topological sorts of same graph.
    5. Only **possible for DAG**.

2. **Using DFS**
    1. It uses a **Visited array and Stack**.
    8. **TC**: O(N + E) ~ O(N)
    9. N = Nodes , E = travelling through adjacent nodes
    18. **SC**: O(N + E) + O(N) + O(N) + O(N) ~ O(N)
    19. Space comprises of Adjacency List, visited array , Stack and Auxilliary Space Recursion.
    
    
3. **Using BFS**
    1. **Kahn's Algorithm**
    2. It uses a **Queue and Array** to store **Indegree** of all Nodes.
    3. Start with a Node having Indegree=0; i.e no dependency.
    4. Once these nodes are done, remove their dependency from other Nodes.
    5. This makes other nodes to try become independent and Indegree -> 0.
    6. **TC**: O(N + E) ~ O(N)
    9. N = Nodes , E = travelling through adjacent nodes
    18. **SC**: O(N + E) + O(N) + O(N) ~ O(N)
    19. Space comprises of Adjacency List, indegree array , Queue.

4. **Dijkstra's Algo**
    1. Finding the shortest distance between two nodes/ or from source node to all Nodes.
    2. Undirected Weighted graph: PriorityQueue( MinHeap as per distance,Node) and dist array.

5. **Bellman Ford Algo**
    1. Dijkstra algo will fail if we have a **-ve edge**.
    2. It will go on **Infinite** cycles.
    3. So, Bellman Ford works for both +ve or -ve edges.
    4. So, Bellman Ford helps to find a **-ve cycle exists or not**.
    5. It works only on **Directed** graphs.
    6. So, for Undirected, convert it into a Directed graph and then apply.
    7. Steps:
        1. Relax all the edges N-1 times.
        2. By relax means-> if(dist[u] + wt < dist[v]) dist[v] = dist[u] + wt;
        3. Run above condition for all edges, N-1 times.
        4. This will give you shortest distance array for all Nodes.
        5. Now, if you try to relax one more time, and dist[] reduces ;
        6. That means it has a -ve cycle in it.
    8. Idea behind N-1 relaxes is that for worst ordering of graph, src and last node will be extreme apart.
    9. So, two update dist array for all nodes, we need N-1 cycles.
    10. **TC**: O(n-1)*O(E)
    11. **SC**: O(N)

5. **Minimum Spanning Tree**
    1. If we want to convert a graph to a tree;
    2. With exactly N nodes and N-1 edges;
    3. Then it is said to be a Spanning Tree. There can be multiple. 
    4. If the sum of weights of N-1 edges are minimum: Minimum ST.
    5. Two implementations:
        1. **Prim's Algo**
            1. compute minimum edges of nodes, and keep on connecting.
            2. Take three arrays: Key, Mst, parent
            3. For efficient approach: use PQ also.
            4. TC: O NlogN
            5. SC: O N
        2. **KrusKal's Algo**
            1. Sort all edges according to weights.
            2. And store it in a linear Data structure.
            3. Pick one edge at a time, and check if both nodes belong to same component.
            4. Use Disjoint sets to find the parents.
            5. Sort guarantees Minimum part. (MlogM)
            6. Disjoint sets guarantees Nodes are picked only once. O(1)
            7. **TC**: O(M*logM) + O(M * constant) ~ O(MlogM) 
            8. **SC**: O(M)
      

6. **Disjoint Sets**
    1. Lets assume all nodes are separate components.
    2. Each node is a parent of itself.
    3. Then we have two operations: **findPar() and Union()**
    4. After every Union operation, we have to make a node as parent for that compoent.
    5. To check if two nodes belong to same component, just match their parents.
    6. Two implementations:
        1. **Union By Rank and Path Compression**
            1. We take **Rank** array and initialze rank of all Nodes as 0.
            2. Once we do any Union operation, we check their extreme parents. **(Path compression)**
            3. If **parents have same rank**, we attach one node to other, and increase its rank by 1.
            4. If **parents have diff rank**, we attach lower rank node to higher rank Node.
            5. This is done to **keep the height of tree Minimum** as possible.
            6. **TC**: O(4*alpha) ~ O(4) constant time
            7. For both findPar() and Union() operations.
            8. **SC**: O(N) for rank array.


7. **Bridges in a Graph**
    1. Bridges are those edges on whose removal, Graph is divided in two or more components.
    2. And when we remove edge, that node is no longer reachable from current component.
    3. Take two arrays : time[] and lowestTime[]
    4. Condition: low[it] > time[node]
    5. condition tell you that adj node can not be reached before node.
    6. Do DFS and TC: O(N), SC: O(N)
    
8. **Articulation Point**
    1. Nodes on whose removal the graph is divided into two or more components.
    2. Take two arrays : time[] and lowestTime[]
    3. Conditions: low[it] >= time[node] && parent != -1
        1. This first condition tell you that adj node can not be reached before node. 
    5. Second condition tells you that it is not the starting node.
        1. Independent child >1 && parent == -1
    7. Hence, articulation point.
    8. Do DFS and TC: O(N), SC: O(N)

9. **Kosaraju Algo**
    1. Find out strongly connected components in a directed graph.
    2. Strongly connected component is a component where every node is reachable by every other node.
    3. A single node is a SCC.
    4. We have to do DFS but from last Node.
    5. Three steps:
        1. Sort all nodes in order of finishing time. (Topological sort) -O(N+E)
        2. Transpose the graph (reverse the edges) - O(N+E)
        3. DFS acc to the finishing time array in step 1 on Transposed graph - O(N+E)
    6. TC: O(N+E)
    7. SC: O(N+E)

10. ****

















  



