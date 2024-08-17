def singleOccurance(nums=None):
    """
    Find element that appears once, every other element appears twice | Find Unique Element XOR Operator
    """
    nums = [5, 2, 7, 8, 2, 7, 5]

    ans = 0

    for num in nums:
        # Using XOX operator (^)
        ans = ans ^ num

    print(ans)
    return ans


def evenOrOdd():
    """
    Check Even or Odd using Bitwise AND operator
    """

    num = 4

    # Using AND operator (&)
    if num & 1 == 0:
        print(f"{num} is even")
    else:
        print(f"{num} is odd")


def extractKthBit(num=None, k=None):
    """
    Check if K-th Bit is set or not | Extract ith bit of number

    (0 <= K <= 10)th bit
    """
    num = 12
    k = 2

    mask = 1 << k
    # print(num, k, mask)
    # print(bin(num), bin(mask))
    ans = num & mask  # Checking the bits
    # print(ans)

    """
    num  =  1100    (12)
         &
    mask =  0100    (1<<k)=(1<<2)=(4)
    ____________
    ans  =  0100    (4){left(starts from zeroth bit) to right 2nd bit}
    """

    if ans > 0:
        print(f"{k}th bit in {num} is {1}")
        return 1
    else:
        print(f"{k}th bit in {num} is {0}")
        return 0


def setKthBit(num=None, k=None):
    """
    Set ith bit to 1 : Change ith bit to 1 : Set Kth bit of a binary number

    num  =  1011    (11)
         |
    mask =  0100    (1<<k)=(1<<2)=(4)
    ____________
    ans  =  1111    (15){left(starts from zeroth bit) to right 2nd bit}
    """

    num = 11
    k = 2

    mask = 1 << k
    ans = num | mask
    print(f"For {num} set {k}th bit to 1 then answer is {ans}")
    return ans


def resetKthBitZero(num=None, k=None):
    """
    Reset ith bit to 0 : Change ith bit to 0 : Clear Kth bit of binary number
    """
    num = 15
    k = 2

    mask = ~(1 << k)  # ~(1 << 2)= ~(4)= ~(100) = -(1011) = -5
    ans = num & mask  # (15 & -5) = (1111 & 1011)

    # print(bin(num), bin(mask), bin(ans), mask, 1 << k)
    print(f"For {num} set {k}th bit to 0 then answer is {ans}")
    return ans


def main():
    # singleOccurance()
    # evenOrOdd()
    # extractKthBit()
    # setKthBit()
    resetKthBitZero()


if __name__ == "__main__":
    main()
