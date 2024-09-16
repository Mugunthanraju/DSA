package solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution41 {
    public static boolean wordPattern(String pattern, String s) {

        String[] sList = s.split(" ");
        int len = sList.length;

        if (pattern.length() != len)
            return false;

        // Map<String, Integer> wordIndex = new HashMap<>();
        // Map<Character, Integer> patternIndex = new HashMap<>();

        // The map without key and value types will initialize it with Object
        Map wordIndex = new HashMap(); // This will act as Map<Object, Object> index = new HashMap();

        for (Integer i = 0; i < len; i++) {
            // The put method of map returns returns previous value associated with the key
            // if present, else return -1
            if (wordIndex.put(pattern.charAt(i), i) != wordIndex.put(sList[i], i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern0 = "abba";
        String s0 = "dog cat cat dog";
        System.out.println("Is pattern? " + wordPattern(pattern0, s0)); // true
        String pattern1 = "abba";
        String s1 = "dog cat cat fish";
        System.out.println("Is pattern? " + wordPattern(pattern1, s1)); // false
        String pattern2 = "aaaa";
        String s2 = "dog cat cat dog";
        System.out.println("Is pattern? " + wordPattern(pattern2, s2)); // false

    }
}

/*
 * To solve the Leetcode problem "290. Word Pattern," we need to determine if a
 * given string `s` follows the same pattern as a given string `pattern`. Each
 * letter in `pattern` corresponds to a non-empty word in `s`, and the
 * relationship between the letters and the words must be a bijection.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `pattern`: A string consisting of lowercase letters.
 * - `s`: A string consisting of lowercase letters and spaces, which represents
 * a sequence of words.
 * 
 * - **Output**:
 * - A boolean value indicating whether `s` follows the same pattern as
 * `pattern`.
 * 
 * ## Approach
 * 
 * The solution involves using two hash maps (or dictionaries):
 * 1. One map to track the mapping from characters in `pattern` to words in `s`.
 * 2. Another map to track the mapping from words in `s` to characters in
 * `pattern`.
 * 
 * ### Steps:
 * 1. Split the string `s` into individual words using whitespace as the
 * delimiter.
 * 2. Check if the number of characters in `pattern` matches the number of words
 * in `s`. If they don't match, return `false`.
 * 3. Iterate through the characters in `pattern` and the corresponding words in
 * `s`:
 * - For each character-word pair, check:
 * - If the character is already mapped to a different word, return `false`.
 * - If the word is already mapped to a different character, return `false`.
 * - If neither mapping exists, create the mappings in both directions.
 * 4. If no inconsistencies are found during the iteration, return `true`.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the string and the pattern once.
 * 
 * ### Space Complexity:
 * - **O(n)**: We use space for the hash maps.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `wordPattern` method splits the string `s` into an array of words.
 * 2. It checks if the lengths of `pattern` and `words` match; if not, it
 * returns `false`.
 * 3. Two hash maps are initialized to track the mappings:
 * - `charToWordMap` maps characters in `pattern` to words in `s`.
 * - `wordToCharMap` maps words in `s` to characters in `pattern`.
 * 4. The loop iterates through each character and word:
 * - It checks if the current character is already mapped to a different word or
 * if the current word is already mapped to a different character.
 * - If either condition is violated, it returns `false`.
 * - If the mappings are valid, it updates both maps.
 * 5. If the loop completes without inconsistencies, it returns `true`.
 * 
 * This solution efficiently checks if the string `s` follows the pattern
 * defined by `pattern` and passes all test cases on Leetcode.
 * 
 * Citations:
 * [1] https://algo.monster/liteproblems/290
 * [2] https://walkccc.me/LeetCode/problems/290/
 * [3]
 * https://prepinsta.com/leetcode-top-100-liked-questions-with-solution/word-
 * pattern/
 * [4]
 * https://github.com/Seanforfun/Algorithm-and-Leetcode/blob/master/leetcode/290
 * .%20Word%20Pattern.md
 * [5]
 * https://just4once.gitbooks.io/leetcode-notes/content/leetcode/hash-table/290-
 * word-pattern.html
 * [6] https://www.youtube.com/watch?v=W_akoecmCbM
 * [7] https://leetcode.ca/all/290.html
 * [8] https://www.youtube.com/watch?v=99RVfqklbCE
 */

class Solution_41 {
    public boolean wordPattern(String pattern, String s) {
        // Split the input string into individual words
        String[] words = s.split(" ");

        // If the number of characters in the pattern does not match the number of
        // words, return false
        if (pattern.length() != words.length) {
            return false;
        }

        // Initialize two dictionaries to track the mappings from characters to words
        // and vice versa
        Map<Character, String> charToWordMap = new HashMap<>();
        Map<String, Character> wordToCharMap = new HashMap<>();

        // Iterate over the pattern
        for (int i = 0; i < words.length; ++i) {
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];

            // Check if the current mapping from char to word or word to char is
            // inconsistent
            if (!charToWordMap.getOrDefault(currentChar, currentWord).equals(currentWord) ||
                    wordToCharMap.getOrDefault(currentWord, currentChar) != currentChar) {
                return false;
            }

            // Update the mappings
            charToWordMap.put(currentChar, currentWord);
            wordToCharMap.put(currentWord, currentChar);
        }

        // If no inconsistencies are found, return true
        return true;
    }
}