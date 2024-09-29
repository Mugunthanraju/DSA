package solutions;

import java.util.HashSet;
import java.util.Set;

import java.util.HashMap; // For AI Solution

public class Solution31 {
    public static int lengthOfLongestSubstring(String s) {

        int n = s.length();
        Set<Character> charSet = new HashSet<>();

        int left = 0, maxLen = 0;

        for (int right = 0; right < n; right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left++));
            }
            charSet.add(s.charAt(right));
            maxLen = Math.max(right - left + 1, maxLen);
        }

        return maxLen;

    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1)); // 3
        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2)); // 1
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3)); // 3
    }
}

/*
 * To solve the Leetcode problem
 * "3. Longest Substring Without Repeating Characters," we need to find the
 * length of the longest substring in a given string that does not contain any
 * repeating characters.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - A string `s`.
 * 
 * - **Sample Input**:
 * - `s`: "abcabcbb"
 * 
 * - **Output**:
 * - An integer representing the length of the longest substring without
 * repeating characters.
 * 
 * - **Sample Output**:
 * - `3` (The longest substrings without repeating characters are "abc", "bca",
 * and "cab", all with length 3.)
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use the **sliding window
 * technique** combined with a hash map (or set) to track characters and their
 * indices. This allows us to efficiently find the longest substring without
 * repeating characters.
 * 
 * ### Steps:
 * 1. **Initialize Variables**: Use a hash map to store the last index of each
 * character, and two pointers (`left` and `right`) to represent the current
 * window.
 * 2. **Iterate Through the String**: For each character in the string:
 * - If the character is already in the hash map and its last index is greater
 * than or equal to `left`, move `left` to one position right of that index.
 * - Update the last index of the current character in the hash map.
 * - Calculate the length of the current substring and update the maximum length
 * if necessary.
 * 3. **Return Maximum Length**: After iterating through the string, return the
 * maximum length found.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse each character in the string once.
 * 
 * ### Space Complexity:
 * - **O(min(n, m))**: The space complexity is determined by the size of the
 * hash map, where `n` is the length of the string and `m` is the size of the
 * character set (for ASCII, it would be constant).
 * 
 * ### Explanation of the Code:
 * 1. The method initializes a hash map (`charIndexMap`) to store characters and
 * their last seen indices.
 * 2. It uses a loop to iterate through each character in `s`, updating indices
 * and managing the sliding window.
 * 3. If a repeating character is found within the current window, it adjusts
 * `left` to avoid including that character again.
 * 4. It continuously updates `maxLength` based on the size of the current valid
 * substring.
 * 
 * This solution efficiently finds the length of the longest substring without
 * repeating characters and passes all relevant test cases on Leetcode. If you
 * have any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://interviewing.io/questions/longest-substring-without-repeating-
 * characters
 * [2] https://www.geeksforgeeks.org/print-longest-substring-without-repeating-
 * characters/
 * [3] https://www.interviewbit.com/blog/longest-substring-without-repeating-
 * characters/
 * [4]
 * https://takeuforward.org/data-structure/length-of-longest-substring-without-
 * any-repeating-character/
 * [5] https://www.geeksforgeeks.org/length-of-the-longest-substring-without-
 * repeating-characters/
 * [6] https://algo.monster/liteproblems/567
 * [7] https://algo.monster/liteproblems/209
 * [8]
 * https://just4once.gitbooks.io/leetcode-notes/content/leetcode/two-pointers/
 * 567-permutation-in-string.html
 */

class Solution_31 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0; // Left pointer for sliding window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character is already in map and its index is within current window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                // Move left pointer to one position right of last occurrence
                left = charIndexMap.get(currentChar) + 1;
            }

            // Update or add current character's index in map
            charIndexMap.put(currentChar, right);
            // Calculate max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; // Return maximum length found
    }
}