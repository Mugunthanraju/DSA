package solutions;

public class Solution39 {

    public static boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > ransomNote.length())
            return false;

        // Initializing the char count array
        int[] count = new int[26];

        // Storing the frequency character count of string (magazine)
        for (char c : magazine.toCharArray())
            count[c - 'a']++;

        // Checking whether charcter count of string (ransomNote) is less than or equal
        // 0
        // If so, then return false else reduce the count by one.
        for (char c : ransomNote.toCharArray())
            if (count[c - 'a']-- <= 0)
                return false;

        // After all operation, we can say that we can construct it.
        return true;
    }

    public static void main(String[] args) {
        String ransomNote1 = "a";
        String magazine1 = "b";
        System.out.println(canConstruct(ransomNote1, magazine1)); // false
        String ransomNote2 = "aa";
        String magazine2 = "ab";
        System.out.println(canConstruct(ransomNote2, magazine2)); // false
        String ransomNote3 = "aa";
        String magazine3 = "aab";
        System.out.println(canConstruct(ransomNote3, magazine3)); // true
    }
}

/*
 * To solve the Leetcode problem "383. Ransom Note," we need to determine if a
 * ransom note can be constructed using the letters from a given magazine. Each
 * letter in the magazine can only be used once in the ransom note.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `ransomNote`: A string representing the ransom note.
 * - `magazine`: A string representing the letters available in the magazine.
 * 
 * - **Sample Input**:
 * - `ransomNote`: "a"
 * - `magazine`: "b"
 * 
 * - **Output**:
 * - A boolean value indicating whether the ransom note can be constructed from
 * the magazine.
 * 
 * - **Sample Output**:
 * - `false`
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use a character count
 * method. We can count the occurrences of each character in both strings and
 * compare these counts.
 * 
 * ### Steps:
 * 1. **Count Characters**: Use an array or hash map to count the occurrences of
 * each character in the magazine.
 * 2. **Check Ransom Note**: Traverse through each character in the ransom note
 * and check if it can be constructed using the characters from the magazine.
 * 3. **Return Result**: If any character in the ransom note cannot be matched
 * with enough characters from the magazine, return false. Otherwise, return
 * true.
 * 
 * ### Time Complexity:
 * - **O(n + m)**: Where `n` is the length of `ransomNote` and `m` is the length
 * of `magazine`.
 * 
 * ### Space Complexity:
 * - **O(1)**: Since we are using a fixed size array (for lowercase English
 * letters).
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `canConstruct` method initializes an array to keep track of character
 * counts for letters in `magazine`.
 * 2. It iterates through each character in `magazine`, incrementing the
 * corresponding index in `charCount`.
 * 3. It then checks each character in `ransomNote`. If a character is not
 * available (count is zero), it returns false.
 * 4. If all characters are available, it decrements their counts and eventually
 * returns true.
 * 
 * This solution efficiently determines whether the ransom note can be
 * constructed from the magazine and passes all relevant test cases on Leetcode.
 * If you have any further questions or need additional examples, feel free to
 * ask!
 * 
 * Citations:
 * [1]
 * https://github.com/doocs/leetcode/blob/main/solution/0300-0399/0383.Ransom%
 * 20Note/README_EN.md
 * [2] https://just4once.gitbooks.io/leetcode-notes/content/leetcode/string/383-
 * ransom-note.html
 * [3] https://www.youtube.com/watch?v=9UOmXgG4h2U
 * [4] https://www.youtube.com/watch?v=9UtInBqnCgA
 * [5] https://www.youtube.com/watch?v=N0MgLvceX7M
 * [6] https://www.youtube.com/watch?v=GBKI9VSKdGg
 * [7] https://www.youtube.com/watch?v=aYqYMIqZx5s
 * [8] https://www.youtube.com/watch?v=utBw5FbYswk
 */

class Solution_39 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26]; // Array to count characters (assuming lowercase letters)

        // Count characters in magazine
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Check characters in ransomNote
        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false; // Not enough characters
            }
            charCount[c - 'a']--; // Use one character
        }

        return true; // All characters matched
    }
}