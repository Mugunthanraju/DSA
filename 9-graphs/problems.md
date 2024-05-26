# Graph Problems

1. LC - 547 : Number of Provinces

```python
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        # Initialize the number of cities (nodes)
        num_cities = len(isConnected)
        
        # Initialize a visited list to keep track of cities that have been visited
        visited = [False] * num_cities
        
        # Counter for the number of provinces (disconnected components)
        province_count = 0
        
        # Depth-First Search function which marks the nodes as visited
        def dfs(current_city: int):
            visited[current_city] = True  # Mark the current city as visited
            for adjacent_city, connected in enumerate(isConnected[current_city]):
                # If the adjacent city is not visited and there is a connection,
                # then continue the search from that city
                if not visited[adjacent_city] and connected:
                    dfs(adjacent_city)
        
        # Loop over each city and perform DFS if it hasn't been visited
        for city in range(num_cities):
            if not visited[city]:  # If the city hasn't been visited yet
                dfs(city)  # Start DFS from this city
                # After finishing DFS, we have found a new province
                province_count += 1
        
        # Return the total number of disconnected components (provinces) in the graph
        return province_count
```