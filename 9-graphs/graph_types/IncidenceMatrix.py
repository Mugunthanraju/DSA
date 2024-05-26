class Imatrix:
    def __init__(self, num_vertices, num_edges):
        self.num_vertices = num_vertices
        self.num_edges = num_edges
        self.inc_matrix = [[0] * num_edges for _ in range(num_vertices)]

    def add_edge(self, v1, v2, edge_num):
        self.inc_matrix[v1][edge_num] = 1
        self.inc_matrix[v2][edge_num] = 1

    def print_matrix(self):
        for row in self.inc_matrix:
            print(row)


if __name__ == "__main__":
    # Example Usage
    g = Imatrix(4, 3)
    g.add_edge(0, 1, 0)
    g.add_edge(0, 2, 1)
    g.add_edge(1, 3, 2)
    g.print_matrix()
