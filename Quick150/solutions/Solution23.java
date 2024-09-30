package solutions;

public class Solution23 {

    public static int strStr(String haystack, String needle) {

        /* _________________________ With Inbuilt Method __________________________ */
        // return haystack.indexOf(needle);

        /* ________________________ Without Inbuilt Method _________________________ */

        // The length of haystack
        for (int i = 0;; i++) {
            // The length of needle
            for (int j = 0;; j++) {
                // If at this point we have navigated through the entire length of needle, we
                // have found a solution, haystack[i].
                if (j == needle.length())
                    return i;
                // This happens when we run out of elements in haystack, but there are still
                // elements in needle.
                if (i + j == haystack.length())
                    return -1;
                // We stop comparing after needle[j], so i will be incremented and cycle repeats
                // itself.
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
        }
    }

    public static void main(String[] args) {
        String hayStack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(strStr(hayStack1, needle1)); // 0
        String hayStack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(strStr(hayStack2, needle2)); // -1
    }
}

/*
 * To solve the Leetcode problem
 * "28. Find the Index of the First Occurrence in a String," we need to find the
 * first occurrence of a substring (needle) within another string (haystack). If
 * the substring is found, we return the starting index; if not, we return -1.
 * An empty needle should return 0, as it is considered a substring of any
 * string.
 * 
 * ### Approach
 * 
 * 1. **Edge Case Handling**: If the needle is empty, immediately return 0.
 * 2. **Iterate Through the Haystack**: Loop through the haystack string and
 * check for matches:
 * - For each position in the haystack, check if the substring starting from
 * that position matches the needle.
 * - If a match is found, return the current index.
 * 3. **Return -1**: If no match is found after checking all possible starting
 * positions, return -1.
 * 
 * ### Time Complexity:
 * - **O((m - n) * n)** in the worst case, where $$ m $$ is the length of the
 * haystack and $$ n $$ is the length of the needle.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The method `strStr` checks if the needle is empty and returns 0 if it is.
 * 2. It calculates the lengths of both strings.
 * 3. A loop iterates through each possible starting index in the haystack.
 * 4. At each index, it checks if the substring from that index matches the
 * needle.
 * 5. If a match is found, it returns the index; otherwise, it continues until
 * all possibilities are exhausted.
 * 6. Finally, it returns -1 if no match is found.
 * 
 * This solution effectively finds the first occurrence of a substring within a
 * string and handles edge cases appropriately. If you have any further
 * questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://algo.monster/liteproblems/28
 * [2] https://www.w3schools.com/java/ref_string_indexof.asp
 * [3] https://www.w3schools.com/jsref/jsref_indexof.asp
 * [4] https://walkccc.me/LeetCode/problems/28/
 * [5] https://takeuforward.org/data-structure/find-the-position-of-a-substring-
 * within-a-string/
 * [6] https://stackoverflow.com/questions/3221891/how-can-i-find-the-first-
 * occurrence-of-a-sub-string-in-a-python-string
 * [7]
 * https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-
 * sum-exists-in-array/
 * [8] https://www.youtube.com/watch?v=A8NUOmlwOlM
 */

class Solution_23 {
    public int strStr(String haystack, String needle) {
        // Edge case: if needle is empty, return 0
        if (needle.isEmpty()) {
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        // Iterate through haystack
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            // Check for substring match
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i; // Return starting index
            }
        }

        return -1; // Needle not found
    }
}