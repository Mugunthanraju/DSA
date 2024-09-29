package solutions;

import java.util.HashMap; // For chat solution

public class Solution42 {

    public static boolean isAnagram(String s, String t) {

        // Both the length doesn't match then false.
        if (s.length() != t.length())
            return false;

        /* Approach 1 : Using Char Count Map */

        // // Map for having frequency count of characters
        // Map<Character, Integer> charCount = new HashMap<>();

        // // Storing the frequency character count in string (s)
        // for (Character c : s.toCharArray())
        // charCount.put(c, charCount.getOrDefault(c, 0) + 1);

        // // Traversing through string (t)
        // for (Character c : t.toCharArray()) {
        // // If the char doesn't exist in the Map then false.
        // if (!charCount.containsKey(c)) {
        // return false;
        // }
        // // Reduce the count by 1 for an existing char in both (s) & (t)
        // charCount.put(c, charCount.get(c) - 1);
        // // If count value is negative then false
        // if (charCount.get(c) < 0)
        // return false;
        // }

        /* Approach 2 : Using Char Count Array : (Faster) */

        int[] count = new int[26];

        // Storing the frequency character count of string (s)
        for (char c : s.toCharArray())
            count[c - 'a']++;

        // Checking whether charcter count of string (t) is less than or equal 0
        // If so, then return false else reduce the count by one.
        for (char c : t.toCharArray())
            if (count[c - 'a']-- <= 0)
                return false;

        // After all operation, we can say it is an Valid Anagram (for either approach)
        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(isAnagram(s1, t1)); // true
        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2, t2)); // false
        String s3 = "ab";
        String t3 = "a";
        System.out.println(isAnagram(s3, t3)); // false
    }
}

/*
 * To solve the Leetcode problem "242. Valid Anagram," we need to determine if
 * two strings are anagrams of each other. Two strings are considered anagrams
 * if they contain the same characters in the same frequency, but in a different
 * order.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `s`: A string.
 * - `t`: A string.
 * 
 * - **Sample Input**:
 * - `s`: "anagram"
 * - `t`: "nagaram"
 * 
 * - **Output**:
 * - A boolean value indicating whether `t` is an anagram of `s`.
 * 
 * - **Sample Output**:
 * - `true`
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use a character count
 * method. We can count the occurrences of each character in both strings and
 * compare these counts.
 * 
 * ### Steps:
 * 1. **Check Lengths**: If the lengths of the two strings are not equal, return
 * false immediately.
 * 2. **Count Characters**: Use a hash map (or an array) to count the
 * occurrences of each character in both strings.
 * 3. **Compare Counts**: Check if the counts for all characters in both strings
 * match.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse each string once.
 * 
 * ### Space Complexity:
 * - **O(1)**: The space complexity is constant since we only need a fixed size
 * array (for 26 letters) or a hash map.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `isAnagram` method first checks if the lengths of `s` and `t` are
 * equal.
 * 2. It creates a frequency map to count occurrences of each character in `s`.
 * 3. It then iterates through each character in `t`, decreasing the count in
 * the map.
 * 4. If any character from `t` does not exist in the map or exceeds the count
 * from `s`, it returns false.
 * 5. If all checks pass, it returns true, indicating that `t` is an anagram of
 * `s`.
 * 
 * This solution efficiently determines whether two strings are anagrams and
 * passes all relevant test cases on Leetcode. If you have any further questions
 * or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1]
 * https://stackoverflow.com/questions/78641326/problem-in-solving-valid-anagram
 * -problem-in-leetcode
 * [2] https://walkccc.me/LeetCode/problems/242/
 * [3]
 * https://stackoverflow.com/questions/77540503/leetcode-242-valid-anagram-why-
 * is-my-code-failing-this-test-case
 * [4] https://www.youtube.com/watch?v=9UtInBqnCgA
 * [5] https://www.youtube.com/watch?v=IRN1VcA8CGc
 * [6] https://www.youtube.com/watch?v=cRBSOz49fQk
 * [7] https://www.youtube.com/watch?v=utBw5FbYswk
 * [8] https://algo.monster/liteproblems/73
 */

class Solution_42 {
    public boolean isAnagram(String s, String t) {
        // If lengths are not equal, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Create a frequency map for characters in s
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Count characters in s
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Decrease counts based on characters in t
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false; // Character not found in s
            }
            charCount.put(c, charCount.get(c) - 1);
            if (charCount.get(c) < 0) {
                return false; // More occurrences in t than in s
            }
        }

        return true; // All counts matched
    }
}