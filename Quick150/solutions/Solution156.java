package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution156 {

    private static Map<Character, String> charWord = new HashMap<>();
    private static Set<String> visit = new HashSet<>();

    public static boolean wordPatternMatch(String pattern, String s) {

        boolean result = dfs(pattern, s, 0, 0);
        charWord.clear();
        visit.clear();

        // boolean result = backtrack(pattern, s, 0, 0, new HashMap<>(), new
        // HashSet<>());

        return result;
    }

    private static boolean dfs(String matcher, String s, Integer mIndex, Integer sIndex) {

        if (mIndex == matcher.length() && sIndex == s.length())
            return true;

        if (mIndex == matcher.length() || sIndex == s.length())
            return false;

        Character currentCharacter = matcher.charAt(mIndex);

        for (int len = 1; len <= s.length() - sIndex; len++) {
            String currentWord = s.substring(sIndex, sIndex + len);

            if (charWord.containsKey(currentCharacter)) {

                if (!charWord.get(currentCharacter).equals(currentWord))
                    continue;

                if (dfs(matcher, s, mIndex + 1, sIndex + len))
                    return true;
            } else {
                if (visit.contains(currentWord))
                    continue;

                charWord.put(currentCharacter, currentWord);
                visit.add(currentWord);

                if (dfs(matcher, s, mIndex + 1, sIndex + len))
                    return true;

                charWord.remove(currentCharacter);
                visit.remove(currentWord);

            }
        }

        return false;
    }

    private static boolean backtrack(String pattern, String s, int pIndex, int sIndex,
            Map<Character, String> charToWord, Set<String> visited) {
        // If both pattern and string are fully matched
        if (pIndex == pattern.length() && sIndex == s.length()) {
            return true;
        }
        // If one is exhausted while the other is not
        if (pIndex == pattern.length() || sIndex == s.length()) {
            return false;
        }

        char currentChar = pattern.charAt(pIndex);

        // Try every possible substring for the current character
        for (int len = 1; len <= s.length() - sIndex; len++) {
            String currentWord = s.substring(sIndex, sIndex + len);

            // Check if the character is already mapped
            if (charToWord.containsKey(currentChar)) {
                // If mapped, check if it matches the current substring
                if (!charToWord.get(currentChar).equals(currentWord)) {
                    continue; // Mismatch found, try next length
                }
                // Continue to the next character and the next part of the string
                if (backtrack(pattern, s, pIndex + 1, sIndex + len, charToWord, visited)) {
                    return true;
                }
            } else {
                // If not mapped, check if the current substring is already used
                if (visited.contains(currentWord)) {
                    continue; // Current word is already mapped to another character
                }
                // Create a new mapping
                charToWord.put(currentChar, currentWord);
                visited.add(currentWord);
                // Continue to the next character and the next part of the string
                if (backtrack(pattern, s, pIndex + 1, sIndex + len, charToWord, visited)) {
                    return true;
                }
                // Backtrack: remove the mapping
                charToWord.remove(currentChar);
                visited.remove(currentWord);
            }
        }

        return false; // No valid mapping found
    }

    public static void main(String[] args) {
        String pattern1 = "abab";
        String s1 = "redblueredblue";
        System.out.println("Pattern Matched? " + wordPatternMatch(pattern1, s1));
        String pattern2 = "abab";
        String s2 = "xyzabcxzyabc";
        System.out.println("Pattern Matched? " + wordPatternMatch(pattern2, s2));
        String pattern3 = "aaaa";
        String s3 = "asdasdasdasd";
        System.out.println("Pattern Matched? " + wordPatternMatch(pattern3, s3));
        String pattern4 = "aabb";
        String s4 = "xyzabcxyzabc";
        System.out.println("Pattern Matched? " + wordPatternMatch(pattern4, s4));
    }
}

/*
 * Leetcode : "291. Word Pattern II" (premium)
 * 
 * ### Problem Breakdown
 * 
 * - **Input**:
 * - `pattern`: A string consisting of lowercase letters.
 * - `s`: A string consisting of lowercase letters only (no spaces).
 * 
 * - **Sample Input**:
 * - `pattern`: "abab"
 * - `s`: "redblueredblue"
 * 
 * - **Output**:
 * - A boolean value indicating whether `s` follows the same pattern as
 * `pattern`.
 * 
 * - **Sample Output**:
 * - `true` (In this case, 'a' maps to "red" and 'b' maps to "blue.")
 * 
 * ### Approach
 * 
 * We'll use a backtracking approach to explore all possible mappings from
 * characters in the `pattern` to substrings in `s`. We'll maintain two
 * mappings:
 * 1. From characters in `pattern` to substrings in `s`.
 * 2. From substrings in `s` to characters in `pattern`.
 * 
 * ### Steps:
 * 1. Use a recursive backtracking function to try to map each character in
 * `pattern` to substrings in `s`.
 * 2. For each character in the pattern, try every possible substring from `s`
 * that hasn't been used yet.
 * 3. If a character is already mapped, check if it maps to the current
 * substring.
 * 4. If the current substring is already mapped to a different character,
 * return `false`.
 * 5. If all characters are successfully mapped, return `true`.
 * 
 * Time Complexity:
 * O(n * m): In the worst case, we may check each character in the pattern
 * against each possible substring in s. Here, n is the length of the pattern
 * and m is the length of the string s. The backtracking may lead to multiple
 * recursive calls, but each call checks a substring.
 * 
 * Space Complexity:
 * O(n + m): The space complexity comes from the hash maps used for
 * character-to-word and word-to-character mappings, as well as the recursion
 * stack. In the worst case, we may store all characters in the pattern and all
 * unique substrings in s.
 * 
 * ### Explanation of the Code:
 * 1. The `wordPatternMatch` method initializes the backtracking process.
 * 2. The `backtrack` method checks if both the pattern and the string have been
 * fully matched.
 * 3. It iterates through possible substring lengths from the current index in
 * `s`, trying to map the current character in `pattern` to each possible
 * substring.
 * 4. If the character is already mapped, it checks for consistency. If it’s not
 * mapped, it checks if the substring is already used.
 * 5. If a valid mapping is found, it continues recursively; otherwise, it
 * backtracks.
 * 
 * ### Test Case Example
 * - **Input**: `pattern = "abab"`, `s = "redblueredblue"`
 * - **Output**: `true`
 * 
 * This implementation should now correctly handle the specified input format
 * and pass all relevant test cases on Leetcode. If you have any further
 * questions or need additional examples, feel free to ask!
 */