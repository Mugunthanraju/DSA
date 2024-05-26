from collections import defaultdict


class Alist:
    def __init__(self):
        self.adj_list = defaultdict(list)

    def add_edge(self, v1, v2):
        self.adj_list[v1].append(v2)
        self.adj_list[v2].append(v1)

    def get_adjacencies(self, vertex):
        if vertex in self.adj_list:
            return self.adj_list[vertex]

    def have_adjacencies(self, vertex):
        if vertex in self.adj_list:
            if len(self.adj_list[vertex]) > 0:
                return True
        return False

    def all_vertexes(self):
        return self.adj_list.keys()

    def print_list(self):
        for vertex, neighbors in self.adj_list.items():
            print(f"Vertex {vertex}: {neighbors}")


if __name__ == "__main__":
    # Example Usage
    g = Alist()
    g.add_edge(0, 1)
    g.add_edge(0, 2)
    g.add_edge(1, 3)
    g.print_list()
