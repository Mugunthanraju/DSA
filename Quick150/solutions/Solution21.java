package solutions;

public class Solution21 {

    public static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        for (String word : s.split(" ")) {
            if (!word.isBlank()) {
                sb.insert(0, " ");
                sb.insert(0, word);
            }
        }

        int n = sb.length();
        if (n > 0)
            sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "the sky is blue";
        System.out.println(reverseWords(s1)); // blue is sky the
        String s2 = "  hello world  ";
        System.out.println(reverseWords(s2)); // world hello
        String s3 = "a good   example";
        System.out.println(reverseWords(s3)); // example good a
    }
}

/*
 * To solve the Leetcode problem "151. Reverse Words in a String," we need to
 * reverse the order of words in a given string while removing any extra spaces
 * between words.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - A string `s` that may contain leading, trailing, and multiple spaces
 * between words.
 * 
 * - **Sample Input**:
 * - `s`: "  Hello   World!  "
 * 
 * - **Output**:
 * - A string with the words in reverse order and no extra spaces.
 * 
 * - **Sample Output**:
 * - `"World! Hello"`
 * 
 * ## Approach
 * 
 * The solution involves the following steps:
 * 
 * 1. **Trim the Input String**: Remove leading and trailing spaces.
 * 2. **Split the String into Words**: Use a space as a delimiter to split the
 * string into words, ignoring extra spaces.
 * 3. **Reverse the Words**: Use a data structure (like a list) to store the
 * words and then reverse their order.
 * 4. **Join the Words**: Concatenate the reversed words into a single string
 * with a single space between each word.
 * 
 * ### Time Complexity:
 * - **O(n)**: Where `n` is the length of the input string, as we traverse it a
 * few times.
 * 
 * ### Space Complexity:
 * - **O(n)**: For storing the words in a list.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `reverseWords` method first trims any leading or trailing spaces from
 * the input string.
 * 2. It splits the trimmed string into an array of words using a regular
 * expression (`"\\s+"`) that matches one or more whitespace characters,
 * effectively ignoring extra spaces.
 * 3. A `StringBuilder` is used to efficiently build the resulting string.
 * 4. It iterates backward through the array of words, appending each word to
 * `reversed`. A space is added between words, but not after the last word.
 * 5. Finally, it returns the constructed reversed string.
 * 
 * This solution effectively reverses the order of words in a given string and
 * passes all relevant test cases on Leetcode. If you have any further questions
 * or need additional examples, feel free to ask!
 */

class Solution_21 {
    public String reverseWords(String s) {
        // Trim leading and trailing spaces
        s = s.trim();

        // Split by whitespace and filter out empty strings
        String[] words = s.split("\\s+");

        // Use StringBuilder for efficient string concatenation
        StringBuilder reversed = new StringBuilder();

        // Reverse the order of words
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" "); // Add space between words
            }
        }

        return reversed.toString(); // Return the final reversed string
    }
}