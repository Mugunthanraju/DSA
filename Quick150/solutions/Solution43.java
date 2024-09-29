package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution43 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            // To sort the characters in string
            char[] c = word.toCharArray();
            // Sorting the characters
            Arrays.sort(c);
            // Converting the sorted characters into string
            String sortedWord = new String(c);

            // Compute Operation if it is absent, here the operation is put()
            map.putIfAbsent(sortedWord, new ArrayList<>());

            // Adding Anagrams as value in the list for the key sortedWord
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] s1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        // [["eat","tea","ate"],["tan","nat"],["bat"]]
        System.out.println(groupAnagrams(s1));
        String[] s2 = { "" };
        // [[""]]
        System.out.println(groupAnagrams(s2));
        String[] s3 = { "a" };
        // [["a"]]
        System.out.println(groupAnagrams(s3));
    }
}

/*
 * To solve the Leetcode problem "49. Group Anagrams," we need to group a list
 * of strings such that each group contains strings that are anagrams of each
 * other. An anagram is a word formed by rearranging the letters of another
 * word.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - An array of strings.
 * 
 * - **Sample Input**:
 * - `strs`: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 
 * - **Output**:
 * - A list of lists, where each inner list contains words that are anagrams.
 * 
 * - **Sample Output**:
 * - `[["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]`
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use a hash map (or
 * dictionary) to group words by their sorted character representation. This
 * way, all anagrams will have the same key when sorted.
 * 
 * ### Steps:
 * 1. **Create a Hash Map**: Use a hash map where the key is the sorted version
 * of each string, and the value is a list of strings (anagrams) that match this
 * key.
 * 2. **Iterate Over the List**: For each string in the input list:
 * - Sort the characters in the string to form the key.
 * - Add the original string to the corresponding list in the hash map.
 * 3. **Extract Results**: Return the values of the hash map as a list of lists.
 * 
 * ### Time Complexity:
 * - **O(n * k log k)**: Where `n` is the number of strings and `k` is the
 * maximum length of a string (due to sorting).
 * 
 * ### Space Complexity:
 * - **O(n * k)**: To store the hash map and output lists.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `groupAnagrams` method initializes a hash map to store groups of
 * anagrams.
 * 2. It iterates through each string in `strs`, sorts its characters, and uses
 * this sorted string as a key in the hash map.
 * 3. If the key does not exist in the map, it creates a new entry with an empty
 * list.
 * 4. It then adds the original string to the corresponding list in the map.
 * 5. Finally, it returns all values from the hash map as a list of lists.
 * 
 * This solution efficiently groups anagrams together and passes all relevant
 * test cases on Leetcode. If you have any further questions or need additional
 * examples, feel free to ask!
 * 
 * Citations:
 * [1] https://www.linkedin.com/pulse/exploring-group-anagrams-problem-strategy-
 * complexity-adjanohoun-5n8nc
 * [2] https://favtutor.com/blogs/group-anagrams
 * [3] https://algo.monster/liteproblems/49
 * [4] https://www.reddit.com/r/leetcode/comments/vxbnz4/
 * how_do_you_guys_solve_group_anagrams_problems/
 * [5] https://prepfortech.io/leetcode-solutions/group-anagrams
 * [6]
 * https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-
 * together/
 * [7] https://www.youtube.com/watch?v=9UOmXgG4h2U
 * [8] https://www.youtube.com/watch?v=cRBSOz49fQk
 */

class Solution_43 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // Sort the string to form a key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Group anagrams in the map
            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            anagramMap.get(sortedStr).add(str);
        }

        // Return all groups of anagrams
        return new ArrayList<>(anagramMap.values());
    }
}