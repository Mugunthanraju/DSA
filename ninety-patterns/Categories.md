
---

## 🔁 1. **Two Pointers**

### ▸ Opposite Ends

* Use two pointers starting from each end of the array.
* Common in palindrome checks, two-sum variants, and sorted array operations.

### ▸ Sliding Window

* A form of two pointers to maintain a window (subarray or substring) while processing.
* Efficient for subarray/substring problems.

### ▸ Fast and Slow Pointers

* Often used for cycle detection (e.g., Floyd’s Cycle Algorithm).
* Useful in linked list problems like finding the middle or detecting loops.

---

## 📏 2. **Sliding Window**

### ▸ Fixed-size Window

* Problems requiring calculations over a window of fixed length.
* E.g., maximum sum of a subarray of size k.

### ▸ Variable-size Window

* Expand and shrink the window based on constraints.
* E.g., longest substring without repeating characters.

### ▸ Max/Min/Longest Subarray

* Optimized tracking of max/min/longest window satisfying a condition.

### ▸ Anagram or Pattern Matching

* Track character counts within a sliding window to match patterns.

---

## 🔍 3. **Binary Search**

### ▸ Standard Binary Search

* Find an element in a sorted array.

### ▸ Binary Search on Answer

* Use binary search when the answer lies in a numeric range (e.g., minimum largest subarray sum).

### ▸ Search in Rotated Array

* Modify standard binary search to account for rotation.

### ▸ First/Last Occurrence

* Variants that require finding the first or last instance of a target.

### ▸ Lower/Upper Bound

* Find the smallest index greater than or equal to (lower), or strictly greater than (upper).

---

## 🌲 4. **Depth-First Search (DFS)**

### ▸ Recursive DFS

* Used for tree and graph traversal, especially when exploring all paths.

### ▸ Iterative DFS

* Stack-based approach when recursion is not viable.

### ▸ Backtracking

* A type of DFS that explores all configurations and undoes decisions.

### ▸ Path Finding

* Explore valid paths in trees or grids.

---

## 🌊 5. **Breadth-First Search (BFS)**

### ▸ Level Order Traversal

* Used in trees to process nodes level by level.

### ▸ Shortest Path (Unweighted)

* Find the shortest path in a grid or graph (e.g., word ladder, maze).

### ▸ Bi-directional BFS

* Faster BFS by searching from both start and target.

---

## 📐 6. **Dynamic Programming (DP)**

### ▸ 0/1 Knapsack

* Pick or skip items to maximize profit under capacity constraint.

### ▸ Unbounded Knapsack

* Items can be chosen multiple times (coin change, rod cutting).

### ▸ Subset Sum

* Determine if a subset sums to a given value.

### ▸ LCS (Longest Common Subsequence)

* Sequence comparison problems (LCS, edit distance).

### ▸ LIS (Longest Increasing Subsequence)

* Track increasing sequences in arrays.

### ▸ Matrix DP

* DP problems represented in a 2D grid (e.g., unique paths, min path sum).

### ▸ Bitmask DP

* Use bitmasking to represent states (used in TSP or subset problems).

### ▸ DP on Trees

* Solve subproblems on tree nodes (e.g., robbing nodes, diameter).

---

## 💡 7. **Greedy**

### ▸ Interval Scheduling

* Select non-overlapping intervals (e.g., meeting rooms).

### ▸ Activity Selection

* Choose maximum activities under constraints.

### ▸ Huffman Coding

* Greedy encoding scheme using frequencies.

### ▸ Greedy + Sorting

* Sort input to make greedy decisions more easily.

---

## 🧩 8. **Divide and Conquer**

### ▸ Merge Sort / Quick Sort

* Classic sorting algorithms.

### ▸ Binary Search-based Divide

* Problems where dividing input reduces complexity.

### ▸ Closest Pair of Points

* Advanced D\&C with geometric implications.

---

## 🔄 9. **Recursion and Backtracking**

### ▸ Combinations / Permutations

* Generate all valid orderings.

### ▸ Sudoku Solver

* Classic backtracking puzzle.

### ▸ N-Queens

* Place queens such that they don’t attack each other.

### ▸ Word Search

* Search grid-based words with backtracking.

### ▸ Subsets

* All combinations of a set.

---

## 🔗 10. **Graph Algorithms**

### ▸ DFS / BFS

* Explore graphs for connectivity or traversal.

### ▸ Union Find (DSU)

* Track disjoint sets for connected components or cycle detection.

### ▸ Topological Sort

* Order nodes such that all dependencies are met.

### ▸ Dijkstra’s Algorithm

* Shortest path in weighted graphs.

### ▸ Bellman-Ford

* Handles negative weights.

### ▸ Floyd-Warshall

* All pairs shortest path.

### ▸ Prim’s / Kruskal’s

* Minimum Spanning Tree.

---

## 🧵 11. **Linked List**

### ▸ Reverse a Linked List

* Iteratively or recursively reverse the list.

### ▸ Cycle Detection

* Use fast and slow pointers.

### ▸ Merge K Lists

* Merge multiple sorted linked lists.

### ▸ Intersection

* Detect the node where two lists merge.

### ▸ Palindrome

* Check if the list is a palindrome.

---

## 🌳 12. **Trees**

### ▸ Tree Traversals

* Preorder, Inorder, Postorder.

### ▸ BST Operations

* Insert, delete, search in BST.

### ▸ LCA

* Find the Lowest Common Ancestor.

### ▸ Serialization/Deserialization

* Convert trees to/from strings.

### ▸ Balanced Tree Check

* Verify AVL, red-black properties.

---

## 📚 13. **Tries**

### ▸ Word Search

* Efficiently search for words/prefixes.

### ▸ Autocomplete

* Suggest words based on prefix.

### ▸ Longest Common Prefix

* Use trie to find shared prefixes.

---

## 🔺 14. **Heaps / Priority Queue**

### ▸ Top K Elements

* Maintain a heap of size k.

### ▸ Median in Data Stream

* Use two heaps.

### ▸ Merge K Sorted Lists

* Use min heap to merge lists.

### ▸ Heap Sort

* Sorting algorithm based on heap.

---

## 🧮 15. **Hashing and Prefix Sum**

### ▸ Subarray Sum = K

* Use hashmap to store prefix sums.

### ▸ Count Distinct Elements

* Frequency map.

### ▸ Frequency Map

* Store character/element counts.

### ▸ Rolling Hash

* Used in Rabin-Karp for pattern matching.

---

## 🧱 16. **Stack / Monotonic Stack**

### ▸ Next Greater Element

* Find next larger item for each element.

### ▸ Valid Parentheses

* Use stack to validate symbols.

### ▸ Largest Rectangle in Histogram

* Classic monotonic stack.

### ▸ Daily Temperatures

* Monotonic decreasing stack.

---

## 🚪 17. **Queue / Deque**

### ▸ Sliding Window Maximum

* Monotonic deque to track max in window.

### ▸ Circular Queue

* Efficient queue using array wrap-around.

### ▸ Monotonic Queue

* Maintain increasing or decreasing order.

---

## ⚙️ 18. **Bit Manipulation**

### ▸ XOR Tricks

* Find unique numbers.

### ▸ Bitmasking

* Represent subsets or states.

### ▸ Set Bit Count

* Count 1’s in binary.

### ▸ Subset Generation

* Use bits to generate all combinations.

---

## 🔗 19. **Union Find (Disjoint Set)**

### ▸ Connected Components

* Track components in a graph.

### ▸ Cycle Detection

* Detect cycles in undirected graphs.

### ▸ Kruskal’s Algorithm

* For MST using DSU.

---

## 🔄 20. **Topological Sort**

### ▸ Course Scheduling

* Determine if order is possible.

### ▸ Build Systems

* Order tasks based on dependencies.

---

## 🔢 21. **Math and Number Theory**

### ▸ GCD / LCM

* Euclidean algorithm.

### ▸ Primes

* Sieve of Eratosthenes.

### ▸ Modular Arithmetic

* Used in large number problems.

### ▸ Combinatorics

* Calculate combinations/permutations.

---

## 🔡 22. **String Algorithms**

### ▸ KMP Algorithm

* Efficient string matching.

### ▸ Z-Algorithm

* Pattern matching using Z-values.

### ▸ Rabin-Karp

* Rolling hash for matching.

### ▸ Manacher’s

* Find longest palindromic substring.

---

## 📏 23. **Geometry**

### ▸ Convex Hull

* Find convex envelope of points.

### ▸ Line Sweep

* Sort and sweep through events.

### ▸ Area/Perimeter

* Grid-based geometry.

---

## 🎮 24. **Simulation**

### ▸ Game of Life

* Simulate cell state changes.

### ▸ Spiral Matrix

* Traverse matrix in spiral.

### ▸ Robot Movement

* Simulate direction/path.

---

## 🏗️ 25. **Design**

### ▸ LRU / LFU Cache


* Use LinkedHashMap or double linked list + hashmap.

### ▸ Rate Limiter / Hit Counter

* Track events within time.

---

## 🧠 26. **Bitmask + DP**

### ▸ TSP (Traveling Salesman Problem)

* Use bitmask for visited cities.

### ▸ Assignment Problems

* Assign tasks/states using bits.

---
---
---

### 🎯 1. Two Pointers

* **Opposite Ends**: *Container With Most Water* (LC 11), *Trapping Rain Water* (LC 42) ([readmedium.com][1])
* **Fast & Slow Pointers**: *Linked List Cycle* (LC 141), *Middle of Linked List* (LC 876) ([leetpattern.com][2])

---

### 🔁 2. Sliding Window

* **Fixed-size Window**: *Maximum Average Subarray I* (LC 643), *Minimum Window Substring* (LC 76) ([leetpattern.com][3])
* **Variable-size Window**: *Subarray Product Less Than K* (LC 713) ([levelup.gitconnected.com][4])
* **Anagram / Pattern Matching**: *Find All Anagrams in a String* (LC 438) ([leetpattern.com][5])

---

### 🔎 3. Binary Search

* **Rotated Array**: *Search in Rotated Sorted Array* (LC 33) ([reddit.com][6])
* **Lower/Upper Bound**: *Kth Smallest Subarray Sum* (LC 1918) ([leetpattern.com][5])

---

### 🌲 4. Depth-First Search (DFS)

* **Backtracking**: *N-Queens* (LC 51), *Word Search* (LC 79)
* **Path Finding**: *Binary Tree Maximum Path Sum* (LC 124)

---

### 🌊 5. Breadth-First Search (BFS)

* **Level Order (Tree)**: *Binary Tree Level Order Traversal* (LC 102)
* **Shortest Path (Grid)**: *01 Matrix* (LC 542) ([reddit.com][7], [reddit.com][6])

---

### 📐 6. Dynamic Programming (DP)

* **LIS**: *Longest Increasing Subsequence* (LC 300)
* **Knapsack**: *Coin Change* (LC 322)
* **Matrix DP**: *Minimum Path Sum* (LC 64)

---

### 💡 7. Greedy

* **Interval Scheduling**: *Non-overlapping Intervals* (LC 435)
* **Huffman (Greedy + Heap)**: (conceptual; LC doesn't offer literal Huffman problem)

---

### ⚖️ 8. Divide & Conquer

* **Merge Sort**: *Sort Colors* (LC 75)
* **Closest Pair (D\&C)**: *Median of Two Sorted Arrays* (LC 4) ([blog.csdn.net][8], [reddit.com][9], [sanurb.github.io][10])

---

### 🔄 9. Recursion / Backtracking

* **Permutations/Subsets**: *Permutations* (LC 46), *Subsets* (LC 78)
* **Sudoku Solver**: (LC 37)
* **N-Queens**: (LC 51)

---

### 🔗 10. Graph Algorithms

* **DFS/BFS (Connectivity)**: *Number of Islands* (LC 200)
* **Union Find**: *Redundant Connection* (LC 684)
* **Topological Sort**: *Course Schedule* (LC 207)
* **Dijkstra’s**: *Network Delay Time* (LC 743)

---

### 🧵 11. Linked List

* **Reverse List**: *Reverse Linked List* (LC 206)
* **Cycle Detection**: LC 141, 142 ([reddit.com][11])
* **Merge K Lists**: *Merge k Sorted Lists* (LC 23) ([hengyiwang.github.io][12])
* **Intersection**: LC 160 ([hengyiwang.github.io][12])
* **Palindrome**: *Palindrome Linked List* (LC 234) ([leetpattern.com][2])

---

### 🌳 12. Trees

* **Traversals**: Inorder, Preorder, Postorder
* **BST Ops**: *Insert/Delete/Search in BST* (LC 701, 450)
* **LCA**: *Lowest Common Ancestor* (LC 236)
* **Serialize/Deserialize**: LC 297
* **Balanced Check**: *Balanced Binary Tree* (LC 110)

---

### 📚 13. Tries

* **Prefix Search**: *Implement Trie* (LC 208)
* **Autocomplete**: *Search Suggestions System* (LC 1268)
* **Longest Common Prefix**: LC 14

---

### 🔺 14. Heaps / Priority Queue

* **Top K Elements**: *Kth Largest Element in an Array* (LC 215) ([reddit.com][6], [reddit.com][13])
* **Median Stream**: *Find Median from Data Stream* (LC 295)
* **Merge K Sorted**: LC 23

---

### 🧮 15. Hashing & Prefix Sum

* **Subarray Sum = K**: (LC 560) ([reddit.com][6])
* **Distinct Count/Maps**: (LC 3, 76)
* **Rabin-Karp**: *Substring with Concatenation of All Words* (LC 30)

---

### 🧱 16. Stack / Monotonic Stack

* **Next Greater**: *Next Greater Element* I/II (LC 496, 503)
* **Valid Parentheses**: LC 20
* **Histogram Area**: (LC 84)
* **Daily Temperatures**: LC 739

---

### 🚪 17. Queue / Deque

* **Sliding Window Max**: (LC 239)
* **Circular Queue**: (Design problem)
* **Monotonic Queue**: (used in multiple sliding window problems)

---

### ⚙️ 18. Bit Manipulation

* **XOR Tricks**: *Single Number* (LC 136)
* **Bitmasking Subsets**: *Subsets* (LC 78)
* **Count Bits**: (LC 338)
* **Bit DP TSP**: Advanced example

---

### 🔗 19. Union Find (DSU)

* **Connected Components**: (LC 547)
* **Cycle Detection**: (LC 684)
* **Kruskal’s MST**: (Graph examples)

---

### 🔄 20. Topological Sort

* **Course Schedule**: LC 207
* **Alien Dictionary**: LC 269

---

### 🔢 21. Math / Number Theory

* **GCD/LCM**: (LC 2485 or utility)
* **Primes**: *Count Primes* (LC 204), Sieve
* **Modular**: *Pow(x, n)* (LC 50)
* **Combinatorics**: *Catalan Number* cases

---

### 🔡 22. String Algorithms

* **KMP**: (Pattern matching problems)
* **Manacher**: Longest Palindromic Substring (LC 5)
* **Z-Algorithm**: Advanced string queries

---

### 📏 23. Geometry

* **Convex Hull**: (Gift wrapping / Graham scan tasks)
* **Line Sweep**: *Skyline problem*
* **Area/Perimeter**: *Island Perimeter* (LC 463)

---

### 🎮 24. Simulation

* **Spiral Matrix**: LC 54
* **Game of Life**: LC 289
* **Robot Movement**: Simulation challenges

---

### 🏗️ 25. Design

* **LRU Cache**: LC 146
* **LFU Cache**: LC 460
* **Rate Limiter / Hit Counter**: (Design problems)

---

### 🧠 26. Bitmask DP

* **TSP**: Travelling salesman formulations
* **Assignment Problems**

---

