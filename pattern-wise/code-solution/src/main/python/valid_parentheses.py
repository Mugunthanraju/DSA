
def isValid(s: str) -> bool:
    """
        LeetCode Problem 20: Valid Parentheses

        Approach:
        We use a stack to keep track of the opening parentheses. When we encounter a closing parenthesis, we check if it matches the top of the stack. If it does, we pop the stack. If it doesn't, or if the stack is empty when we encounter a closing parenthesis, the string is not valid. Finally, if the stack is empty at the end, the string is valid.

        Time Complexity: O(n), where n is the length of the input string. We traverse the string once.
        Space Complexity: O(n), in the worst case, we push all opening parentheses onto the stack.
    """
    stack = []
    mapping = {')': '(', '}': '{', ']': '['}

    for char in s:
        if char in mapping:
            top_element = stack.pop() if stack else '#'
            if mapping[char] != top_element:
                return False
        else:
            stack.append(char)

    return not stack

# Example usage:
def main():
    test_string1 = "()[]{}"
    print(test_string1, "is this valid?", isValid(test_string1))  # Output: True
    test_string2 = "([)]"
    print(test_string2, "is this valid?", isValid(test_string2))  # Output: False

if __name__ == "__main__":
    main()