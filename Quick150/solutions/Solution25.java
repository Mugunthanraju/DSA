package solutions;

public class Solution25 {
    public static boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;

        int start = 0, end = s.length() - 1;

        while (start <= end) {
            char cs = s.charAt(start);
            char ce = s.charAt(end);

            if (!Character.isLetterOrDigit(cs))
                start++;
            else if (!Character.isLetterOrDigit(ce))
                end--;
            else {
                if (Character.toLowerCase(cs) != Character.toLowerCase(ce))
                    return false;

                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama"; // True
        String s2 = "race a car"; // False
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
    }
}

/*
 * To solve the Leetcode problem "125. Valid Palindrome," we need to determine
 * if a given string is a palindrome, considering only alphanumeric characters
 * and ignoring case sensitivity. A string is considered a palindrome if it
 * reads the same forwards and backwards.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - A string `s` that may contain letters, digits, spaces, and punctuation.
 * 
 * - **Output**:
 * - A boolean value indicating whether `s` is a valid palindrome.
 * 
 * ## Approach
 * 
 * The approach involves the following steps:
 * 1. Normalize the string by filtering out non-alphanumeric characters and
 * converting all letters to lowercase.
 * 2. Use a two-pointer technique to check if the string is a palindrome:
 * - One pointer starts at the beginning of the string, and the other starts at
 * the end.
 * - Compare the characters at these pointers. If they are not equal, the string
 * is not a palindrome.
 * - Move the pointers towards the center and continue the comparison until they
 * meet.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the string to filter and compare characters.
 * 
 * ### Space Complexity:
 * - **O(n)**: We create a new string to hold the filtered characters.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `isPalindrome` method initializes a `StringBuilder` to build the
 * filtered string.
 * 2. It iterates through each character in the input string `s`:
 * - It checks if the character is alphanumeric using
 * `Character.isLetterOrDigit`.
 * - If it is, the character is converted to lowercase and appended to
 * `filteredString`.
 * 3. After filtering, two pointers (`left` and `right`) are initialized to the
 * start and end of the `filteredString`.
 * 4. The loop compares characters at these pointers:
 * - If they are not equal, it returns `false`.
 * - If they match, the pointers are moved towards the center.
 * 5. If the loop completes without finding mismatches, it returns `true`,
 * indicating that the input string is a valid palindrome.
 * 
 * This solution efficiently checks if the given string is a palindrome while
 * adhering to the problem's constraints and passes all test cases on Leetcode.
 */

class Solution_25 {
    public boolean isPalindrome(String s) {
        // Normalize the string: filter out non-alphanumeric characters and convert to
        // lowercase
        StringBuilder filteredString = new StringBuilder();

        for (char c : s.toCharArray()) {
            // Check if the character is alphanumeric
            if (Character.isLetterOrDigit(c)) {
                filteredString.append(Character.toLowerCase(c)); // Convert to lowercase and append
            }
        }

        // Use two pointers to check if the filtered string is a palindrome
        int left = 0;
        int right = filteredString.length() - 1;

        while (left < right) {
            // Compare characters from both ends
            if (filteredString.charAt(left) != filteredString.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }

        return true; // If all characters matched, it's a palindrome
    }
}