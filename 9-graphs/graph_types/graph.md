# Graph

A graph data structure is a collection of nodes or vertices connected by edges. It's used to represent relationships between different entities. 

**Graph Algorithm**: Graph algorithms are methods used to manipulate and analyze graphs, solving various problems like finding the shortest path or detecting cycles.

"""

### Graph Terminology

- **Vertex/Node**: A fundamental unit in a graph, representing a point or object within the structure.

- **Edge**: Connects two vertices in a graph, forming relationships between them.

- **Adjacency**: Describes vertices that are connected by an edge.

- **Path**: A sequence of edges allowing traversal from one vertex to another.

- **Directed Graph**: Contains edges with specific directions, not necessarily bidirectional.

- **Adjacency Matrix**: A 2D array representing connections between vertices.

- **Adjacency List**: An array of linked lists indicating vertices connected to each vertex.

- **Weighted Graph**: Contains edges with assigned values like distance or time. If a weight of edge is missing then we should assume the weight of that edge by default as One(1).

- **Connected Graph**: Ensures all vertices are interconnected within the structure.

- **Degree of a Vertex**: The number of edges incident to a vertex, further categorized in directed graphs as in-degree and out-degree.

- **Total Degree Property**: Total Degree of a grpah = 2 x Edges (Twice the count of Edges)

- **Strong Connectivity**: In a directed graph, the existence of a directed path between every pair of vertices.

- **Disconnected Graph**: Contains isolated components not connected to each other.

- **Tree**: A connected graph with no cycles, commonly used in algorithms like binary search trees.

- **Cyclic Graph**: A graph that contains a cycle, which is a closed path where the first and last vertices are the same, with at least three edges.

- **Acyclic Graph**: A graph that does not contain any cycles, ensuring there are no closed paths within the structure.

- **Complete Graph**: Every pair of distinct vertices is connected by a unique edge. A complete graph contain n(n-1)/2 edges where n is the number of nodes in the graph.

- **Indegree**: The number of edges coming to a vertex in a directed graph.

- **Outdegree**: The number of edges going out from a vertex in a directed graph.


### Types Of Graph


- **Null Graph**: A graph is known as a null graph if there are no edges in the graph.

- **Trivial Graph**: Graph having only a single vertex, it is also the smallest graph possible.

- **Undirected Graph**: A graph in which edges do not have any direction. That is the nodes are unordered pairs in the definition of every edge. 

- **Directed Graph**: A graph in which edge has direction. That is the nodes are ordered pairs in the definition of every edge.

- **Connected Graph**: The graph in which from one node we can visit any other node in the graph is known as a connected graph. 

- **Disconnected Graph**: The graph in which at least one node is not reachable from a node is known as a disconnected graph.

- **Regular Graph**: The graph in which the degree of every vertex is equal to K is called K regular graph.

- **Complete Graph**: The graph in which from each node there is an edge to each other node.

- **Cycle Graph**: The graph in which the graph is a cycle in itself, the degree of each vertex is 2. 

- **Cyclic Graph**: A graph containing at least one cycle is known as a Cyclic graph.

- **Directed Acyclic Graph**: A Directed Graph that does not contain any cycle. 

- **Bipartite Graph**: A graph in which vertex can be divided into two sets such that vertex in each set does not contain any edge between them.

- **Connected component**: In an undirected graph refers to a group of vertices that are connected to each other through edges, but not connected to other vertices outside the group. For traversal, we need to keep visited vertex(node) list so that if we can visit each node in all the component graph.

- **Weighted Graph**: A graph in which the edges are already specified with suitable weight is known as a weighted graph. Weighted graphs can be further classified as:
    - directed weighted graphs
    - undirected weighted graphs