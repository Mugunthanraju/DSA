package solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution40 {

    // There are 2 approaches (i) Map (ii) Array - Faster {though the time
    // complexity is same}

    public static boolean isIsomorphicMap(String s, String t) {

        int sn = s.length(), tn = t.length(), sv, tv;

        // If the length is not equal then false.
        if (sn != tn)
            return false;

        // We store index + 1 to each corresponding char in str.
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < sn; i++) {

            // Retrive character from both the string
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);

            // Get the Value from the Map or default value zero (0)
            sv = sMap.getOrDefault(sc, 0);
            tv = tMap.getOrDefault(tc, 0);

            // Check the values if it is not same then false
            if (sv != tv)
                return false;

            // Store the index + 1 value to corresponding character
            sMap.put(sc, i + 1);
            tMap.put(tc, i + 1);
        }

        return true; // After doing all the operation.
    }

    public static boolean isIsomorphicArray(String s, String t) {

        int sn = s.length(), tn = t.length();

        // If the length is not equal then false.
        if (sn != tn)
            return false;

        // We store index + 1 to each corresponding char in str.
        int[] sa = new int[256];
        int[] ta = new int[256];

        for (int i = 0; i < sn; i++) {
            // Retrive character from both the string
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);

            // Check the values if it is not same then false
            if (sa[sc] != ta[tc])
                return false;

            // Store the index + 1 value to corresponding character
            sa[sc] = i + 1;
            ta[tc] = i + 1;
        }

        return true; // After doing all the operation.
    }

    public static void main(String[] args) {
        String s1 = "bbbaaaba";
        String t1 = "aaabbbba";
        System.out.println(isIsomorphicArray(s1, t1)); // false
        String s2 = "aa";
        String t2 = "ab";
        System.out.println(isIsomorphicMap(s2, t2)); // false
        String s3 = "egg";
        String t3 = "add";
        System.out.println(isIsomorphicArray(s3, t3)); // true
        String s4 = "foo";
        String t4 = "bar";
        System.out.println(isIsomorphicMap(s4, t4)); // false
        String s5 = "paper";
        String t5 = "title";
        System.out.println(isIsomorphicArray(s5, t5)); // true
    }
}

/*
 * To solve the Leetcode problem "205. Isomorphic Strings," we need to determine
 * if two strings can be transformed into each other by replacing characters in
 * a one-to-one mapping. This means that each character in the first string must
 * map to exactly one character in the second string and vice versa.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `s`: A string.
 * - `t`: A string.
 * 
 * - **Sample Input**:
 * - `s`: "egg"
 * - `t`: "add"
 * 
 * - **Output**:
 * - A boolean value indicating whether `s` and `t` are isomorphic.
 * 
 * - **Sample Output**:
 * - `true` (The mapping is: e -> a, g -> d)
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem involves using two hash maps (or
 * arrays) to track the mappings of characters from `s` to `t` and from `t` to
 * `s`. This ensures that both strings maintain a consistent one-to-one mapping.
 * 
 * ### Steps:
 * 1. **Check Lengths**: If the lengths of the two strings are not equal, return
 * false immediately.
 * 2. **Create Mappings**: Use two hash maps or arrays to store the mappings
 * from characters in `s` to characters in `t` and vice versa.
 * 3. **Iterate Through Characters**: For each character in both strings, check
 * if there is an existing mapping:
 * - If a mapping exists, ensure it matches the current character.
 * - If no mapping exists, create a new mapping.
 * 4. **Return Result**: If all characters can be mapped consistently, return
 * true; otherwise, return false.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse each string once.
 * 
 * ### Space Complexity:
 * - **O(1)**: The space complexity is constant since we only need a fixed size
 * array (for 256 ASCII characters) or hash maps.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `isIsomorphic` method first checks if the lengths of `s` and `t` are
 * equal.
 * 2. It initializes two hash maps to store mappings between characters of both
 * strings.
 * 3. It iterates through each character in both strings and checks for existing
 * mappings:
 * - If a character from `s` is already mapped to a different character in `t`,
 * it returns false.
 * - Similarly, it checks the reverse mapping.
 * 4. If all checks pass without mismatches, it returns true.
 * 
 * This solution efficiently checks if two strings are isomorphic and passes all
 * relevant test cases on Leetcode. If you have any further questions or need
 * additional examples, feel free to ask!
 * 
 * Citations:
 * [1]
 * https://www.educative.io/answers/how-to-check-if-two-strings-are-isomorphic
 * [2]
 * https://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-
 * each-other/
 * [3] https://www.javatpoint.com/isomorphic-string-in-java
 * [4]
 * https://stackoverflow.com/questions/77540503/leetcode-242-valid-anagram-why-
 * is-my-code-failing-this-test-case
 * [5] https://www.youtube.com/watch?v=9UtInBqnCgA
 * [6] https://www.youtube.com/watch?v=IRN1VcA8CGc
 * [7]
 * https://stackoverflow.com/questions/78641326/problem-in-solving-valid-anagram
 * -problem-in-leetcode
 * [8] https://www.youtube.com/watch?v=9UOmXgG4h2U
 */

class Solution_40 {
    public boolean isIsomorphic(String s, String t) {
        // If lengths are not equal, they cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapST = new HashMap<>(); // Map from s to t
        HashMap<Character, Character> mapTS = new HashMap<>(); // Map from t to s

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check mapping from s to t
            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) {
                    return false; // Mismatch found
                }
            } else {
                mapST.put(charS, charT); // Create new mapping
            }

            // Check mapping from t to s
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) {
                    return false; // Mismatch found
                }
            } else {
                mapTS.put(charT, charS); // Create new mapping
            }
        }

        return true; // All mappings are consistent
    }
}