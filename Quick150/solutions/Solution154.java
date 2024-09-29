package solutions;

import java.util.Arrays;

public class Solution154 {

    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2)
            return false;

        int[] s1Frequency = new int[26];
        int[] s2WindowFrequency = new int[26];

        for (char c : s1.toCharArray()) {
            s1Frequency[c - 'a'] += 1;
        }

        int left = 0, right = 0, window;

        while (right < len2) {
            s2WindowFrequency[s2.charAt(right) - 'a']++;

            window = right - left + 1;

            if (window == len1) {
                if (Arrays.equals(s1Frequency, s2WindowFrequency))
                    return true;
            }

            if (window < len1) {
                right++;
            } else {
                s2WindowFrequency[s2.charAt(left) - 'a']--;
                left++;
                right++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s11 = "ab";
        String s12 = "eidbaooo";
        System.out.println(checkInclusion(s11, s12)); // true
        String s21 = "ab";
        String s22 = "eidboaoo";
        System.out.println(checkInclusion(s21, s22)); // false
        String s31 = "abc";
        String s32 = "bbbca";
        System.out.println(checkInclusion(s31, s32)); // true
        String s41 = "ab";
        String s42 = "ab";
        System.out.println(checkInclusion(s41, s42)); // true
        String s51 = "adc";
        String s52 = "dcda";
        System.out.println(checkInclusion(s51, s52)); // true
    }
}

/*
 * To solve the Leetcode problem "567. Permutation in String," we need to
 * determine if one string (`s1`) is a permutation of another string (`s2`). In
 * other words, we want to check if any substring of `s2` has the same
 * characters as `s1`, in any order.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `s1`: A string of characters.
 * - `s2`: A string in which we need to check for permutations of `s1`.
 * 
 * - **Sample Input**:
 * - `s1`: "abc"
 * - `s2`: "eidbacoo"
 * 
 * - **Output**:
 * - A boolean value indicating whether any permutation of `s1` is a substring
 * of `s2`.
 * 
 * - **Sample Output**:
 * - `true` (because "bac" is a permutation of "abc" and is present in `s2`).
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use the **sliding window
 * technique** combined with character counting. We will maintain a count of
 * characters in `s1` and compare it with the counts of characters in the
 * current window of `s2`.
 * 
 * ### Steps:
 * 1. **Character Count Array**: Create an array to count occurrences of each
 * character in `s1`.
 * 2. **Sliding Window**: Use two pointers to represent the current window in
 * `s2` that matches the length of `s1`.
 * 3. **Initial Count**: Initialize the character count for the first window
 * (the first `len(s1)` characters of `s2`).
 * 4. **Compare Counts**: Compare the character counts for the current window
 * with those from `s1`. If they match, return true.
 * 5. **Slide the Window**: Move the right pointer to expand the window and
 * update counts by adding the new character and removing the old character.
 * 6. **Continue Checking**: Repeat until you have traversed all possible
 * windows in `s2`.
 * 
 * ### Time Complexity:
 * - **O(n)**: Where n is the length of `s2`, since we traverse it once.
 * 
 * ### Space Complexity:
 * - **O(1)**: The space complexity is constant because we are using a
 * fixed-size array (size 26 for lowercase letters).
 * 
 * ### Explanation of the Code:
 * 1. The method initializes arrays to count character occurrences for both `s1`
 * and the current sliding window in `s2`.
 * 2. It checks if any permutation exists by comparing character counts.
 * 3. The sliding window is adjusted by adding a new character and removing an
 * old one as it moves through `s2`.
 * 4. If at any point, the counts match, it returns true; otherwise, it returns
 * false after checking all windows.
 * 
 * This solution efficiently checks if any permutation of `s1` exists as a
 * substring within `s2` and passes all relevant test cases on Leetcode. If you
 * have any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://algo.monster/liteproblems/567
 * [2]
 * https://just4once.gitbooks.io/leetcode-notes/content/leetcode/two-pointers/
 * 567-permutation-in-string.html
 * [3] https://walkccc.me/LeetCode/problems/567/
 * [4] https://www.geeksforgeeks.org/combinational-sum/
 * [5] https://www.youtube.com/watch?v=GBKI9VSKdGg
 * [6] https://www.youtube.com/watch?v=UuiTKBwPgAo
 * [7] https://www.youtube.com/watch?v=utBw5FbYswk
 * [8] https://www.youtube.com/watch?v=cRBSOz49fQk
 */

class Solution_154 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();

        // If length of s1 is greater than s2, permutation is not possible
        if (len1 > len2) {
            return false;
        }

        // Array to hold counts of characters
        int[] charCount = new int[26];

        // Populate charCount with characters from s1
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Initialize a sliding window
        int[] windowCount = new int[26];

        // Populate windowCount with first len1 characters from s2
        for (int i = 0; i < len1; i++) {
            windowCount[s2.charAt(i) - 'a']++;
        }

        // Compare counts for initial window
        if (Arrays.equals(charCount, windowCount)) {
            return true;
        }

        // Slide the window over s2
        for (int i = len1; i < len2; i++) {
            // Add new character to the window
            windowCount[s2.charAt(i) - 'a']++;
            // Remove old character from the window
            windowCount[s2.charAt(i - len1) - 'a']--;

            // Compare counts after sliding
            if (Arrays.equals(charCount, windowCount)) {
                return true;
            }
        }

        return false; // No permutation found
    }
}

/* Python Solution */

// class Solution:
// def checkInclusion(self, s1: str, s2: str) -> bool:
// s1_len = len(s1)

// s1_counts = [ 0 ] * 26
// s2_counts = [ 0 ] * 26

// for l in s1:
// s1_counts[ord(l) - ord('a')] += 1

// i = 0
// j = 0

// while (j < len(s2)):

// s2_counts[ord(s2[j]) - ord('a')] += 1

// window = j - i + 1

// if window == s1_len:
// if s1_counts == s2_counts:
// return True

// if window < s1_len:
// j += 1
// else:
// s2_counts[ord(s2[i]) - ord('a')] -= 1
// i += 1
// j += 1

// return False