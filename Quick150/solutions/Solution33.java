package solutions;

import java.util.HashMap; // For chat solution

public class Solution33 {

    public static String minWindow(String s, String t) {
        int count = t.length(), sLen = s.length();

        if (count > sLen)
            return "";

        int[] map = new int[128];

        for (char c : t.toCharArray())
            map[c] += 1;

        int low = 0, high = 0, minStart = 0, minLen = Integer.MAX_VALUE, curMin;

        while (high < sLen) {
            char c1 = s.charAt(high);
            if (map[c1] > 0)
                count--;

            map[c1]--;
            high++;

            while (count == 0) {
                curMin = high - low;
                if (minLen > curMin) {
                    minLen = curMin;
                    minStart = low;
                }

                char c2 = s.charAt(low);
                map[c2]++;

                if (map[c2] > 0)
                    count++;
                low++;
            }
        }

        return minLen == Integer.MAX_VALUE ? ""
                : s.substring(
                        minStart, minStart + minLen);

    }

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println(minWindow(s1, t1)); // "BANC"
        String s2 = "a";
        String t2 = "a";
        System.out.println(minWindow(s2, t2)); // "a"
        String s3 = "a";
        String t3 = "aa";
        System.out.println(minWindow(s3, t3)); // ""
    }
}

/*
 * To solve the Leetcode problem "76. Minimum Window Substring," we need to find
 * the smallest substring in a given string `s` that contains all the characters
 * from another string `t`, including duplicates. The goal is to return the
 * minimum window substring or an empty string if no such substring exists.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `s`: The source string.
 * - `t`: The target string containing characters that must be present in the
 * substring of `s`.
 * 
 * - **Sample Input**:
 * - `s`: "ADOBECODEBANC"
 * - `t`: "ABC"
 * 
 * - **Output**:
 * - A string representing the minimum window substring that contains all
 * characters of `t`.
 * 
 * - **Sample Output**:
 * - "BANC" (This is the smallest substring in `s` that contains all characters
 * from `t`.)
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use the **sliding window
 * technique** combined with a hash map (or array) to track character counts.
 * This allows us to efficiently find the smallest substring that meets the
 * criteria.
 * 
 * ### Steps:
 * 1. **Character Count**: Create a hash map to count occurrences of each
 * character in `t`.
 * 2. **Sliding Window**: Use two pointers (`left` and `right`) to represent the
 * current window in `s`.
 * 3. **Expand and Contract**: Expand the window by moving the right pointer and
 * include characters until all characters from `t` are covered. Once covered,
 * attempt to shrink the window from the left to find the minimum length.
 * 4. **Check Validity**: Use a variable to track how many unique characters
 * from `t` are currently satisfied in the window.
 * 5. **Update Minimum Length**: Whenever a valid window is found, update the
 * minimum length and store its starting index.
 * 
 * ### Time Complexity:
 * - **O(n + m)**: Where n is the length of `s` and m is the length of `t`.
 * 
 * ### Space Complexity:
 * - **O(m)**: The space complexity is determined by the size of the hash map
 * used for counting characters.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The method initializes a hash map (`targetCount`) to store character
 * counts from string `t`.
 * 2. It uses two pointers (`left` and `right`) to create a sliding window over
 * string `s`.
 * 3. As it expands the right pointer, it updates counts in another hash map
 * (`windowCount`) and checks if all required characters are matched.
 * 4. When a valid substring is found, it attempts to shrink it from the left
 * side while maintaining validity.
 * 5. Finally, it returns either the minimum length substring found or an empty
 * string if no valid substring exists.
 * 
 * This solution efficiently finds the minimum window substring containing all
 * characters from `t` and passes all relevant test cases on Leetcode. If you
 * have any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://algo.monster/liteproblems/76
 * [2]
 * https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing
 * -all-characters-of-another-string/
 * [3] https://walkccc.me/LeetCode/problems/76/
 * [4] https://www.youtube.com/watch?v=jSto0O4AJbM
 * [5] https://www.geeksforgeeks.org/length-of-the-longest-substring-without-
 * repeating-characters/
 * [6] https://interviewing.io/questions/longest-substring-without-repeating-
 * characters
 * [7] https://www.interviewbit.com/blog/longest-substring-without-repeating-
 * characters/
 * [8] https://www.geeksforgeeks.org/print-longest-substring-without-repeating-
 * characters/
 */

class Solution_33 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return ""; // If t is longer than s, return empty

        HashMap<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int required = targetCount.size(); // Number of unique characters in t
        int formed = 0; // Number of unique characters matched
        HashMap<Character, Integer> windowCount = new HashMap<>();

        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0; // Starting index of minimum window

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            // Check if this character satisfies one of the required characters
            if (targetCount.containsKey(c) && windowCount.get(c).intValue() == targetCount.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window until it ceases to be 'desirable'
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update minimum length and starting index if needed
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                // Remove this character from the window
                windowCount.put(c, windowCount.get(c) - 1);
                if (targetCount.containsKey(c) && windowCount.get(c).intValue() < targetCount.get(c).intValue()) {
                    formed--;
                }
                left++;
            }
            right++; // Expand the window
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}