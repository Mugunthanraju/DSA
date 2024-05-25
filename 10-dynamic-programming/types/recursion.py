def fibonacci(n):
    if n < 2:
        return n
    return fibonacci(n - 1) + fibonacci(n - 2)


def main():
    print(fibonacci(5))
    print(fibonacci(7))
    print(fibonacci(8))


if __name__ == "__main__":
    main()
