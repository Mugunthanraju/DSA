"""
Bottom-Up Approach (Tabulation):

In the bottom-up approach, also known as tabulation, we start with the smallest subproblems and gradually build up to the final solution. We store the results of solved subproblems in a table to avoid redundant calculations.

Lets breakdown Bottom-up approach:

- Starts with the smallest subproblems and gradually builds up to the final solution.
- Fills a table with solutions to subproblems in a bottom-up manner.
- Suitable when the number of subproblems is small and the optimal solution can be directly computed from the solutions to smaller subproblems.
"""


def fibonacci(n):
    if n < 2:
        return n
    else:
        # Below is different from memoization
        table = [-1] * (n + 1)
        table[0] = 0
        table[1] = 1

        for i in range(2, n + 1):
            table[i] = table[i - 1] + table[i - 2]

        return table[n]


def main():
    print(fibonacci(5))
    print(fibonacci(7))
    print(fibonacci(8))


if __name__ == "__main__":
    main()
