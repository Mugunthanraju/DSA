"""
Leetcode Problem 392: Is Subsequence

Approach:
1. Use two pointers, one for the subsequence string `s` and one for the main string `t`.
2. Traverse the main string `t` while checking if characters in `s` appear in order.
3. If all characters in `s` are matched by the end of `t`, return True; otherwise, return False.

Time Complexity: O(n + m) - Where n is the length of `s` and m is the length of `t`.
Space Complexity: O(1) - No additional space is used.

"""

def is_subsequence(s, t):
    # Initialize two pointers
    i, j = 0, 0
    while i < len(s) and j < len(t):
        if s[i] == t[j]:
            i += 1  # Move pointer for `s` if characters match
        j += 1  # Always move pointer for `t`
    
    # If `i` has traversed all of `s`, it is a subsequence
    return i == len(s)


def main():
    # Example usage
    s = "abc"
    t = "ahbgdc"
    result = is_subsequence(s, t)
    print(f"Is '{s}' a subsequence of '{t}'? {result}")

    s = "axc"
    t = "ahbgdc"
    result = is_subsequence(s, t)
    print(f"Is '{s}' a subsequence of '{t}'? {result}")

if __name__ == "__main__":
    main()