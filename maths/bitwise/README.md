# Python bitwise operators:


## Bitwise AND Operator (&)
The bitwise AND operator (&) compares each bit of the first operand to the corresponding bit of the second operand. If both bits are 1, the corresponding result bit is set to 1, otherwise it is set to 0[1][4].

Usage:
- Masking bits to extract desired bits from an integer[1][4]
- Checking if a number is even or odd by checking the least significant bit[1][4]
- Turning off certain bits in a number[1]

Tips:
- Use bitwise AND to efficiently extract bits from an integer by masking unwanted bits with 0s[1][4]
- Combine bitwise AND with left/right shift operators to extract bits at specific positions[1][4]
- Avoid using bitwise AND when logical AND is more appropriate for readability[1]

## Bitwise OR Operator (|)
The bitwise OR operator (|) compares each bit of the first operand to the corresponding bit of the second operand. If either or both bits are 1, the corresponding result bit is set to 1, otherwise it is set to 0[1][4].

Usage:
- Setting flags or options in bit fields[1][4]
- Combining bits to create a bit pattern[1]

Tips:
- Use bitwise OR to efficiently set bits in an integer by ORing with 1s at desired positions[1][4]
- Combine bitwise OR with left/right shift operators to set bits at specific positions[1][4]
- Avoid using bitwise OR when logical OR is more appropriate for readability[1]

## Bitwise XOR Operator (^)
The bitwise XOR operator (^) compares each bit of the first operand to the corresponding bit of the second operand. If both bits are 0 or both bits are 1, the corresponding result bit is set to 0, otherwise it is set to 1[1][4].

Usage:
- Toggling bits (changing 0 to 1 and 1 to 0)[1][4]
- Implementing simple encryption/decryption algorithms[1]
- Finding unique elements in a list[2]

Tips:
- Use bitwise XOR to efficiently toggle bits in an integer by XORing with 1s at desired positions[1][4]
- Combine bitwise XOR with left/right shift operators to toggle bits at specific positions[1][4]
- Avoid using bitwise XOR when logical XOR is more appropriate for readability[1]

## Bitwise NOT Operator (~)
The bitwise NOT operator (~) is a unary operator that flips the bits, changing every 1 to 0 and every 0 to 1. It is the bitwise complement of its operand[1][4].

Usage:
- Flipping bits for various purposes, such as finding the negative of a number[1][4]
- Implementing simple encryption/decryption algorithms[1]

Tips:
- Use bitwise NOT to efficiently flip bits in an integer[1][4]
- Be aware that in Python, the result of `~x` is `-(x+1)` due to the use of two's complement representation[1][4]

## Bitwise Left Shift Operator (<<)
The bitwise left shift operator (<<) shifts the bits of the left operand to the left by the number of positions specified by the right operand. Zeros are shifted in from the right, and the leftmost bits are discarded[1][4].

Usage:
- Multiplying a number by a power of 2[1][4]
- Quickly creating bit masks[1][4]

Tips:
- Use bitwise left shift to efficiently multiply a number by a power of 2[1][4]
- Combine bitwise left shift with bitwise AND to create bit masks for extracting bits[1][4]

## Bitwise Right Shift Operator (>>)
The bitwise right shift operator (>>) shifts the bits of the left operand to the right by the number of positions specified by the right operand. Zeros are shifted in from the left, and the rightmost bits are discarded[1][4].

Usage:
- Dividing a number by a power of 2[1][4]
- Quickly shifting bits to the right for various purposes[1][4]

Tips:
- Use bitwise right shift to efficiently divide a number by a power of 2[1][4]
- Be aware that in Python, the result of right shifting a negative number is implementation-dependent[1][4]

By understanding and effectively using bitwise operators in Python, you can optimize code performance, implement low-level algorithms, and manipulate binary data efficiently.

Citations:
[1] https://www.tutorialsfreak.com/python-tutorial/python-bitwise-operators
[2] https://www.simplilearn.com/bitwise-operators-in-python-article
[3] https://www.w3schools.com/python/gloss_python_bitwise_operators.asp
[4] https://www.geeksforgeeks.org/python-bitwise-operators/
[5] https://www.upgrad.com/tutorials/software-engineering/python-tutorial/bitwise-operator-in-python/

