package solutions;

import java.util.Arrays;

public class Solution20 {

    public static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        // Since we want to find common prefix without missing any words
        // So, we compare it first and last word.
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;

        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx))
                idx++;
            else
                break;
        }

        return s1.substring(0, idx);
    }

    public static void main(String[] args) {
        String[] s1 = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(s1)); // "fl"
        String[] s2 = { "dog", "racecar", "car" };
        System.out.println(longestCommonPrefix(s2)); // ""
    }
}

/*
 * To solve the Leetcode problem "14. Longest Common Prefix," we need to find
 * the longest common prefix string amongst an array of strings. If there is no
 * common prefix, we should return an empty string.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - An array of strings `strs`.
 * 
 * - **Sample Input**:
 * - `strs`: `["flower","flow","flight"]`
 * 
 * - **Output**:
 * - A string representing the longest common prefix.
 * 
 * - **Sample Output**:
 * - `"fl"`
 * 
 * ## Approach
 * 
 * The approach involves comparing characters of the strings at each position
 * until a mismatch is found or one of the strings runs out of characters.
 * 
 * ### Steps:
 * 1. **Edge Case Handling**: If the input array is empty, return an empty
 * string.
 * 2. **Initialize the Prefix**: Start with the first string as the initial
 * prefix.
 * 3. **Iterate Through Strings**: For each subsequent string:
 * - Compare characters with the current prefix.
 * - Update the prefix to be the common portion found so far.
 * - If at any point the prefix becomes empty, return it immediately.
 * 4. **Return the Result**: After processing all strings, return the longest
 * common prefix.
 * 
 * ### Time Complexity:
 * - **O(n * m)**: Where `n` is the number of strings and `m` is the length of
 * the shortest string.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space for variables.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `longestCommonPrefix` method checks for an empty input array and
 * initializes the prefix with the first string.
 * 2. It iterates through each subsequent string in `strs`.
 * 3. For each string, it checks if it starts with the current prefix using
 * `indexOf`.
 * 4. If not, it reduces the length of the prefix until a match is found or it
 * becomes empty.
 * 5. Finally, it returns the longest common prefix found.
 * 
 * This solution efficiently finds and returns the longest common prefix among
 * an array of strings and handles edge cases appropriately. If you have any
 * further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://www.youtube.com/watch?v=wtOQaovlvhY
 * [2] https://walkccc.me/LeetCode/problems/14/
 * [3] https://algo.monster/liteproblems/14
 * [4] https://www.romannumerals.org/converter
 * [5] https://www.youtube.com/watch?v=0sWShKIJoo4
 * [6] https://redquark.org/leetcode/0014-longest-common-prefix/
 * [7] https://takeuforward.org/data-structure/trapping-rainwater/
 * [8] https://www.rapidtables.com/convert/number/roman-numerals-converter.html
 */

class Solution_20 {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: if input array is empty
        if (strs.length == 0) {
            return "";
        }

        // Start with the first string as the initial prefix
        String prefix = strs[0];

        // Compare with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // Update prefix based on current string
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce prefix length until a match is found
                prefix = prefix.substring(0, prefix.length() - 1);
                // If there's no common prefix, return ""
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix; // Return the longest common prefix
    }
}