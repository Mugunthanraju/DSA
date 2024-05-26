from graph_types.IncidenceMatrix import Imatrix as IM
from graph_types.AdjacencyMatrix import Amatrix as AM
from graph_types.AdjacencyList import Alist as AL


def createGraphAL(wantVertexes=False):
    vertexes = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    al = AL()
    al.add_edge(1, 2)
    al.add_edge(1, 6)
    al.add_edge(2, 3)
    al.add_edge(2, 4)
    al.add_edge(4, 5)
    al.add_edge(5, 8)
    al.add_edge(6, 7)
    al.add_edge(6, 9)
    al.add_edge(7, 8)

    if wantVertexes:
        return al, vertexes
    return al


def breadth_first_search(graph, vertexes, start_node=1):
    """
    SC : visited(N) + queue(N) + bfs(N) = O(3N) ~ O(N)
    TC : While(N) + For(2xE) = O(N + 2E)
    """
    visited = dict.fromkeys(vertexes, False)
    queue = list()
    queue.append(vertexes[0])
    bfs = list()
    visited[queue[0]] = True

    while queue:
        if graph.have_adjacencies(queue[0]):
            for i in graph.get_adjacencies(queue[0]):
                if not visited[i]:
                    visited[i] = True
                    queue.append(i)
        bfs.append(queue.pop(0))
    print(bfs)


def depth_first_search(graph, vertexes, start_node=1):
    """
    SC : visited O(N) + result O(N) + recursionStack O(N) = O(3N) ~ O(N)
    TC : vertexes O(N) + Sum of Degree O(2xEdges) = O(N + 2xE) ~ O(N + 2E)

    Note : above TC is for undirected graph
           for directed graph it will be
           total count of edges and not 2xEdges. So, O(N + E)
    """
    visited = dict.fromkeys(vertexes, False)
    result = list()

    def dfs(node):
        nonlocal visited, result
        if visited[node]:
            return

        visited[node] = True
        result.append(node)
        for i in graph.get_adjacencies(node):
            if not visited[i]:
                dfs(i)

    dfs(vertexes[0])
    print(result)


def numberOfProvinces(isConnected=None):
    """
    LC - 547 : Number of Provinces

    SC : O(N){Visited} + O(N){StackCalls} = O(2N) ~ O(N)
    TC : [O(N^2)]-ByAll (or) [O(N){For loop} + O(V+2E){DFS}]-Striver
    """
    isConnected = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]  # 2
    # isConnected = [[1, 0, 0], [0, 1, 0], [0, 0, 1]]  # 3

    visited = set()
    provinces = 0

    def dfs(city):
        for neighbour, connected in enumerate(isConnected[city]):
            if connected and neighbour not in visited:
                visited.add(neighbour)
                dfs(neighbour)

    for city in range(len(isConnected)):
        if city not in visited:
            provinces += 1
            dfs(city)

    print(f"Number of provinces are : {provinces}")
    return provinces


def numIsLands(grid=None):
    """
    LC - 200 : Number of Islands

    SC : {Seen}O(Rows*Cols)~O(N^2) + {DFS}O(Rows*Cols)~O(N^2) = O(N^2) + O(N^2)

    TC : {Visiting each node if all are 1}O(Rows*Cols)~O(N^2) + {DFS performs a constant amount of work for each cell it visits}O(K) = O(N^2)
    """

    # grid = [
    #     ["1", "1", "1", "1", "0"],
    #     ["1", "1", "0", "1", "0"],
    #     ["1", "1", "0", "0", "0"],
    #     ["0", "0", "0", "0", "0"],
    # ] # 1

    grid = [
        ["1", "1", "0", "0", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "1", "0", "0"],
        ["0", "0", "0", "1", "1"],
    ]  # 3

    if not grid:
        return 0

    rows = len(grid)
    cols = len(grid[0])
    seen = [[False] * cols for row in range(rows)]

    islands = 0

    def dfs(row, col):
        if (
            row < 0
            or col < 0
            or row >= rows
            or col >= cols
            or grid[row][col] == "0"
            or seen[row][col] == True
        ):
            return
        seen[row][col] = True  # Seen(Visited)
        dfs(row - 1, col)  # -1  0
        dfs(row, col - 1)  #  0 -1
        dfs(row, col + 1)  #  0 +1
        dfs(row + 1, col)  # +1  0

    for row in range(rows):
        for col in range(cols):
            if seen[row][col] != True and grid[row][col] == "1":
                dfs(row, col)
                islands += 1

    print(f"Number of islands are : {islands}")
    return islands


def floodFill(image=None, sr=None, sc=None, color=None):
    """
    LC - 733 : Flood Fill

    SC : {Seen}O(Rows*Cols)~O(N^2) + {DFS}O(Rows*Cols)~O(N^2) = O(N^2) + O(N^2)

    TC : {Visiting each pixel node if all are same}O(Rows*Cols)~O(N^2) + {DFS performs a constant amount of work for each cell it visits}O(K) = O(N^2)
    """
    image = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
    sr = 1
    sc = 1
    color = 2

    rows = len(image)
    cols = len(image[0])

    seen = [[False] * cols for row in range(rows)]
    s = image[sr][sc]

    def dfs(row, col):
        nonlocal image, rows, cols, s, color

        if (
            row < 0
            or col < 0
            or row >= rows
            or col >= cols
            or image[row][col] != s
            or seen[row][col]
        ):
            return
        seen[row][col] = True
        image[row][col] = color
        dfs(row, col - 1)
        dfs(row, col + 1)
        dfs(row - 1, col)
        dfs(row + 1, col)

    dfs(sr, sc)

    print(image)
    return image


def oragneRotting(grid=None):
    """
    LC - 994 : Rotting Oranges

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.

    SC : {Queue using deque}O(N x M)

    TC : {Running 4 times all over grid}O(N x M)
    """
    grid = [[2, 1, 1], [1, 1, 0], [0, 1, 1]]

    from collections import deque

    rows = len(grid)
    cols = len(grid[0])

    rot = deque()
    fresh = 0
    mins = 0

    for row in range(rows):
        for col in range(cols):
            if grid[row][col] == 2:
                rot.append((row, col))
            elif grid[row][col] == 1:
                fresh += 1
            else:
                continue

    while rot and fresh > 0:
        mins += 1
        for _ in range(len(rot)):
            row, col = rot.popleft()

            for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                r, c = row + dx, col + dy

                if r < 0 or c < 0 or r >= rows or c >= cols or grid[r][c] != 1:
                    continue
                else:
                    fresh -= 1
                    grid[r][c] = 2
                    rot.append((r, c))

    result = -1 if fresh > 0 else mins
    print(f"Total time taken to rot : {result}")
    return result


def isCycleUsingBfs(V=None, adj=None):
    """
    GFG : Detect cycle in an undirected graph

    SC : {seen}O(V) + {queue}O(V) = O(2V) =~ O(N)
    TC : O(V[Neighbour])~O(N x 2E) + {forLoop}O(N)
    """
    V = 5
    adj = [[1], [0, 2, 4], [1, 3], [2, 4], [1, 3]]

    from collections import deque

    seen = set()
    q = deque()

    def bfs(src):
        nonlocal seen, q, adj

        q.append((src, -1))
        seen.add(src)

        while q:
            node, parent = q.popleft()
            # print(node, adj[node])
            for neighbour in adj[node]:
                if neighbour not in seen:
                    seen.add(neighbour)
                    q.append((neighbour, node))
                elif neighbour != parent:
                    return True
        return False

    for i in range(V):
        if i not in seen:
            if bfs(i):
                print("True, cycle exist")
                return True
    print("False, cycle does not exist")
    return False


def isCycleUsingDfs(V=None, adj=None):
    """
    GFG : Detect cycle in an undirected graph

    SC : {seen}O(V) + {Call Stack}O(V) = O(2V) =~ O(N)
    TC : O(V[Neighbour])~O(N x 2E) + {forLoop}O(N)
    """
    V = 7
    adj = [[1, 2], [0, 4], [0, 3, 5], [2], [1, 6], [2, 6], [4, 5]]
    # V = 5
    # adj = [[1], [0, 2, 4], [1, 3], [2, 4], [1, 3]]

    seen = set()

    def dfs(node, parent):
        nonlocal adj, seen
        seen.add(node)
        for neighbour in adj[node]:
            if neighbour not in seen:
                if dfs(neighbour, node):
                    return True
            elif parent != neighbour:
                return True
        return False

    for vertex in range(V):
        if vertex not in seen:
            if dfs(vertex, -1):
                print("True, cycle exist")
                return True
    print("False, cycle does not exist")
    return False


def matrix01(mat=None):
    """
    LC - 542 : 01 Matrix

    SC : {distanc-matrix}O(NxM) + {BFS-queue-worst-case}O(NxM) = O(2(NxM)) ~ O(NxM)

    TC : {visiting zero}O(NxM) + {BFS-traversing-in-4-directions}O(4(NxM)) = O(5(NxM)) ~ O(NxM)
    """
    mat = [[0, 0, 0], [0, 1, 0], [1, 1, 1]]

    from collections import deque

    rows = len(mat)
    cols = len(mat[0])
    dist = [[float("inf")] * cols for _ in range(rows)]
    q = deque()

    # collecting zeros
    for r in range(rows):
        for c in range(cols):
            if mat[r][c] == 0:
                dist[r][c] = 0
                q.append((r, c))

    while q:
        row, col = q.popleft()

        for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            r = row + dx
            c = col + dy

            if (
                r < 0
                or c < 0
                or r >= rows
                or c >= cols
                or dist[r][c] <= dist[row][col] + 1
            ):
                continue
            else:
                dist[r][c] = dist[row][col] + 1
                q.append((r, c))

    print(dist)
    return dist


def surroundRegion(board=None):
    """
    LC - 130 : Surrounded Regions

    SC :  O(1) since in-place and we don't use extra space

    TC : O(m * n) since we iterate over total m * n elements twice
    """

    board = [
        ["X", "O", "X", "O", "X", "O"],
        ["O", "X", "O", "X", "O", "X"],
        ["X", "O", "X", "O", "X", "O"],
        ["O", "X", "O", "X", "O", "X"],
    ]

    rows = len(board)
    cols = len(board[0])

    def dfs(r, c):
        if r < 0 or c < 0 or r >= rows or c >= cols or board[r][c] != "O":
            return
        board[r][c] = "T"
        dfs(r, c - 1)
        dfs(r, c + 1)
        dfs(r - 1, c)
        dfs(r + 1, c)

    for r in range(rows):
        for c in range(cols):
            if board[r][c] == "O" and (r in [0, rows - 1] or c in [0, cols - 1]):
                dfs(r, c)

    for r in range(rows):
        for c in range(cols):
            if board[r][c] == "O":
                board[r][c] = "X"
            if board[r][c] == "T":
                board[r][c] = "O"

    print(board)
    word = set()
    return board


def numEnclaves(grid=None):
    """
    LC - 1020 : Number of Enclaves
    """

    grid = [[0, 0, 0, 0], [1, 0, 1, 0], [0, 1, 1, 0], [0, 0, 0, 0]]

    if not grid:
        return 0

    rows = len(grid)
    cols = len(grid[0])

    def dfs(r, c):
        nonlocal grid, rows, cols
        if r < 0 or c < 0 or r >= rows or c >= cols or grid[r][c] != 1:
            return
        grid[r][c] = 2
        dfs(r, c - 1)
        dfs(r, c + 1)
        dfs(r - 1, c)
        dfs(r + 1, c)

    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == 1 and (r in [0, rows - 1] or c in [0, cols - 1]):
                dfs(r, c)
    result = 0
    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == 1:
                result += 1

    print(f"Number of land cells : {result}")
    return result


def wordLadder1(beginWord=None, endWord=None, wordList=None):
    """
    LC - 127 : Word Ladder
    """

    # input
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot", "dot", "dog", "lot", "log", "cog"]

    from collections import deque

    wordList = set(wordList)

    if endWord not in wordList:
        print(0)
        return 0  # If there is not endWord in list

    queue = deque([beginWord])
    queue.pop
    seen = set([beginWord])
    path_count = 0
    alphabets = "abcdefghijklmnopqrstuvwxyz"
    while queue:
        path_count += 1
        for _ in range(len(queue)):
            word = queue.popleft()
            if word == endWord:
                print(path_count)
                # Found endWord in list
                return path_count
            for i in range(len(word)):
                prefix = word[:i]
                suffix = word[i + 1 :]
                for letter in alphabets:
                    made = prefix + letter + suffix
                    if made in wordList and made not in seen:
                        queue.append(made)
                        seen.add(made)
    print(0)
    return 0  # # Found endWord in list but cannot connect


def numDistinctIslands(grid=None):
    """
    LC - 694 : Number of distinct islands
    GFG : Number of Distinct Islands

    Time complexity: O(rows * cols * log(rows * cols)) ~ {visiting matrix cells}(rows*cols), {adding pairs in set}(log(rows * cols))

    Space complexity: O(rows * cols){we add almost rows * cols entry}
    """

    # grid = [[1, 1, 0, 0, 0], [1, 1, 0, 0, 0], [0, 0, 0, 1, 1], [0, 0, 0, 1, 1]]  # 1
    grid = [[1, 1, 0, 1, 1], [1, 0, 0, 0, 0], [0, 0, 0, 0, 1], [1, 1, 0, 1, 1]]  # 3

    if not grid:
        return 0

    rows = len(grid)
    cols = len(grid[0])
    seen = [[False] * cols for _ in range(rows)]
    result = set()

    def dfs(r, c, dx, dy, i):
        if r < 0 or c < 0 or r >= rows or c >= cols or seen[r][c] or grid[r][c] != 1:
            return
        seen[r][c] = True
        i.append((r - dx, c - dy))
        dfs(r - 1, c, dx, dy, i)
        dfs(r + 1, c, dx, dy, i)
        dfs(r, c - 1, dx, dy, i)
        dfs(r, c + 1, dx, dy, i)

    island = list()
    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == 1 and seen[r][c] == False:
                dfs(r, c, r, c, island)
                if island:
                    result.add(tuple(island[:]))
                    island.clear()

    print("Unique number of islands :", len(result))
    return len(result)


def isBipartite(graph=None):
    """
    LC - 785 : Is Graph Bipartite?
    """

    graph = [[1, 3], [0, 2], [1, 3], [0, 2]]  # True
    # graph = [[1, 2, 3], [0, 2], [0, 1, 3], [0, 2]]  # False

    if not graph:
        print(f"Is Graph Bipartite? {False}")
        return False

    import collections

    n = len(graph)
    queue = collections.deque()

    visit = [-1] * n
    for i in range(n):
        if visit[i] == -1:
            queue.append(i)
            visit[i] = 0
        while queue:
            for _ in range(len(queue)):
                node = queue.popleft()  # BFS
                # node = queue.pop()  # DFS
                for adj in graph[node]:
                    if visit[adj] != -1:
                        if visit[adj] == visit[node]:
                            print(f"Is Graph Bipartite? {False}")
                            return False
                        else:
                            continue
                    queue.append(adj)
                    if visit[node] == 0:
                        visit[adj] = 1
                    else:
                        visit[adj] = 0
    print(f"Is Graph Bipartite? {True}")
    return True


def detectCycleDirectedGraph(graph=None):
    """
    GFG : Detect Cycle in a Directed Graph
    LC - 207. Course Schedule & 210. Course Schedule II

    SC : {Visit & Path}O(2N) + {Recursion Stack of DFS}O(N) =~ O(N)

    TC : O(V + E){DFS}
    """

    graph = [[1, 2], [2], [0, 3], []]

    n = len(graph)
    visit = [False] * n
    path = [False] * n

    def dfs(node):
        nonlocal graph, visit, path

        visit[node] = True
        path[node] = True

        for adj in graph[node]:
            if visit[adj]:
                if path[adj]:
                    return True
            else:
                if dfs(adj):
                    return True
        path[node] = False
        return False

    for i in range(n):
        if not visit[i]:
            if dfs(i):
                print("Graph contains cycle")
                return True
    print("Graph doesn't contain cycle")
    return False


def eventualSafeNodesCyclic(graph=None):
    """
    LC - 802 : Find Eventual Safe States

    SC : {Visit & Path}O(2N) + {Recursion Stack of DFS}O(N) =~ O(N)

    TC : O(V + E){DFS}
    """
    graph = [[1, 2], [2, 3], [5], [0], [5], [], []]  # [2, 4, 5, 6]

    # graph = [[1, 2, 3, 4], [1, 2], [3, 4], [0, 4], []] # [4]

    if not graph:
        return []

    n = len(graph)
    visit = [False] * n
    path = [False] * n

    def dfs(node):
        nonlocal graph, visit, path

        visit[node] = True
        path[node] = True

        for adj in graph[node]:
            if not visit[adj]:
                if dfs(adj):
                    return True
            elif path[adj]:
                return True

        path[node] = False
        return False

    result = list()
    for i in range(n):
        #  Here is the difference from Detect Cycle in a Directed Graph
        if not path[i]:
            if not dfs(i):
                result.append(i)

    print(f"Safe nodes are {result}")
    return result


def eventualSafeNodesOptimized(graph=None):
    """
    LC - 802 : Find Eventual Safe States

    SC : {Visit & Path}O(2N) + {Recursion Stack of DFS}O(N) =~ O(N)

    TC : O(V + E){DFS}
    """

    graph = [[1, 2], [2, 3], [5], [0], [5], [], []]  # [2, 4, 5, 6]

    # graph = [[1, 2, 3, 4], [1, 2], [3, 4], [0, 4], []] # [4]

    if not graph:
        return []

    n = len(graph)
    state = [0] * n  # 0: unvisited, -1: in-process, 1: safe
    result = list()

    def dfs(node):
        nonlocal graph, state

        if state[node] != 0:
            return state[node] == 1

        state[node] = -1

        for adj in graph[node]:
            if not dfs(adj):
                return False

        state[node] = 1
        return True

    for i in range(n):
        if dfs(i):
            result.append(i)

    print(f"Safe nodes are {result}")
    return result


def topologicalSort(graph=None):
    """
    Only valid for Direct Acyclic Graph

    This algorithm uses DFS to solve

    TC : O(V+E){Directed Graph Traversal} + O(V){at most V components}

    SC : {Visit + Stack + RecursionStack}O(3N) ~ O(N)
    """
    # graph = [[], [], [1], [0, 2], [0, 1], [0, 3]]  # [5, 4, 2, 3, 1, 0]
    # graph = [[], [0], [0], [0]]  # [3, 2, 1, 0]
    graph = [[2, 3], [], [], [1], [1, 2], [0, 2]]

    if not graph:
        return []

    n = len(graph)
    visit = [False] * n

    def dfs(node, passGraph, visit, stack):
        visit[node] = True
        for adj in passGraph[node]:
            if not visit[adj]:
                dfs(adj, passGraph, visit, stack)
        stack.append(node)

    def topoSort(graph, visit, N):
        from collections import deque

        stack = deque()
        for i in range(N):
            if not visit[i]:
                dfs(i, graph, visit, stack)
        output = list()
        while stack:
            output.append(stack.pop())
        return output

    result = topoSort(graph, visit, n)
    print(f"Topological sortings of the graph : {result}")
    return result


def kahnsAlgo(graph=None):
    """
    Only valid for Direct Acyclic Graph

    This algorithm uses BFS to solve

    TC : O(V+E){Directed Graph Traversal}

    SC : {IndegreeArray + Queue}O(2N) ~ O(N)

    Note : If result list length is not equal to number of vertexes then there is a cycle in graph.
    """
    # graph = [[], [], [1], [0, 2], [0, 1], [0, 3]]  # [5, 4, 2, 3, 1, 0]
    # graph = [[], [0], [0], [0]]  # [3, 2, 1, 0]
    graph = [[2, 3], [], [], [1], [1, 2], [0, 2]]

    if not graph:
        return []

    n = len(graph)
    indegree = [0] * n

    for node in range(n):
        for adj in graph[node]:
            # storing indegree of each node
            indegree[adj] += 1

    from collections import deque

    queue = deque()

    for node in range(n):
        if indegree[node] == 0:
            # enqueuing node with 0 indegree
            queue.append(node)

    topo = list()
    while queue:
        node = queue.popleft()
        topo.append(node)

        for adj in graph[node]:
            # reducing degree of a adj-node due to removing of node.
            indegree[adj] -= 1
            if indegree[adj] == 0:
                # enqueuing node with 0 indegree
                queue.append(adj)

    if len(topo) == n:
        print(f"Kahn's algorithm of the graph : {topo}")
        return topo

    print(f"Kahn's algorithm deteced cycle in graph, so : {[]}")
    return []


def main():
    graph, vertexes = createGraphAL(True)
    # graph.print_list()
    # breadth_first_search(graph, vertexes)
    # depth_first_search(graph, vertexes)
    # numberOfProvinces()
    # numIsLands()
    # floodFill()
    # oragneRotting()
    # isCycleUsingBfs()
    # isCycleUsingDfs()
    # matrix01()
    # surroundRegion()
    # numEnclaves()
    # wordLadder1()
    # numDistinctIslands()
    # isBipartite()
    # detectCycleDirectedGraph()
    # eventualSafeNodesCyclic()
    # eventualSafeNodesOptimized()
    topologicalSort()
    kahnsAlgo()


if __name__ == "__main__":
    main()
