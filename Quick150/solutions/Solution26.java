package solutions;

public class Solution26 {
    public static boolean isSubsequence(String s, String t) {
        int sLength = s.length(), tLength = t.length();

        if (sLength == 0)
            return true;

        int sPointer = 0, tPointer = 0;

        while (sPointer < sLength && tPointer < tLength) {
            if (s.charAt(sPointer) == t.charAt(tPointer))
                sPointer++;
            tPointer++;
            if (sPointer == sLength)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println(isSubsequence(s1, t1)); // true
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println(isSubsequence(s2, t2)); // false
    }
}

/*
 * To solve the Leetcode problem "392. Is Subsequence," we need to determine if
 * a string `s` is a subsequence of another string `t`. A string `s` is
 * considered a subsequence of `t` if all characters of `s` can be found in `t`
 * in the same order, but not necessarily consecutively.
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use a two-pointer technique.
 * We maintain two pointers, one for each string, and iterate through them to
 * check if all characters of `s` can be found in `t` in order.
 * 
 * ### Steps:
 * 1. Initialize two pointers: `i` for `s` and `j` for `t`.
 * 2. Iterate through the characters in `t` using the pointer `j`:
 * - If the character at `s[i]` matches `t[j]`, increment `i` to check the next
 * character in `s`.
 * - Always increment `j` to continue checking characters in `t`.
 * 3. If `i` reaches the length of `s`, it means all characters of `s` have been
 * found in `t` in order, so return `true`.
 * 4. If the loop ends and `i` has not reached the length of `s`, return
 * `false`.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the string `t` once, where `n` is the length of `t`.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space for the pointers.
 * 
 * 
 * ### Explanation of the Code:
 * - The `isSubsequence` method initializes two pointers, `i` for `s` and `j`
 * for `t`.
 * - It iterates through `t` and checks for matches with characters in `s`. When
 * a match is found, it increments the pointer `i`.
 * - The pointer `j` is always incremented to continue checking the next
 * character in `t`.
 * - Finally, it checks if `i` has reached the end of `s`. If it has, `s` is a
 * subsequence of `t`, and the method returns `true`; otherwise, it returns
 * `false`.
 * 
 * This solution efficiently determines if `s` is a subsequence of `t` and
 * passes all test cases on Leetcode.
 * 
 * Citations:
 * [1] https://walkccc.me/LeetCode/problems/392/
 * [2] https://www.youtube.com/watch?v=99RVfqklbCE
 * [3] https://www.youtube.com/watch?v=Gkz3SwtdSes
 * [4]
 * https://just4once.gitbooks.io/leetcode-notes/content/leetcode/binary-search/
 * 392-is-subsequence.html
 * [5] https://algo.monster/liteproblems/55
 * [6] https://stackoverflow.com/questions/74035067/python-solution-for-392-is-
 * subsequence
 * [7] https://www.youtube.com/watch?v=BHr381Guz3Y
 * [8] https://www.youtube.com/watch?v=9kyHYVxL4fw
 */

class Solution_26 {
    public boolean isSubsequence(String s, String t) {
        int i = 0; // Pointer for string s
        int j = 0; // Pointer for string t

        // Iterate through string t
        while (i < s.length() && j < t.length()) {
            // If characters match, move the pointer for s
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // Always move the pointer for t
            j++;
        }

        // If we have gone through all characters in s, it's a subsequence
        return i == s.length();
    }
}