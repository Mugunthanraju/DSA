"""
Top-Down Approach (Memoization):

In the top-down approach, also known as memoization, we start with the final solution and recursively break it down into smaller subproblems. To avoid redundant calculations, we store the results of solved subproblems in a memoization table.

Lets breakdown Top down approach:

- Starts with the final solution and recursively breaks it down into smaller subproblems.
- Stores the solutions to subproblems in a table to avoid redundant calculations.
- Suitable when the number of subproblems is large and many of them are reused.
"""


def fibonacci(n, map):
    if n < 2:
        # Below is different from tatbulation
        map[n] = n
        return n

    if n in map:
        return map[n]

    map[n] = fibonacci(n - 1, map) + fibonacci(n - 2, map)

    return map[n]


def main():
    map = dict()
    print(fibonacci(5, map))
    print(fibonacci(7, map))
    print(fibonacci(8, map))
    # print(map)


if __name__ == "__main__":
    main()
