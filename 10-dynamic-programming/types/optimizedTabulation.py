def fibonacci(n):
    if n < 2:
        return n
    else:
        # Below is different from tabulation, here space complexity has reduced from O(N) to O(1)
        beforePrevious = 0
        previous = 1

        for i in range(2, n + 1):
            current = previous + beforePrevious
            beforePrevious = previous
            previous = current

        return previous


def main():
    print(fibonacci(5))
    print(fibonacci(7))
    print(fibonacci(8))


if __name__ == "__main__":
    main()
