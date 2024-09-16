package solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution102 {

    // ____________________ Number Combination ______________________________

    private static void backtrack(int n, int k, List<List<Integer>> ans, List<Integer> temp, int index) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = index; i < n + 1; i++) {
                temp.add(i);
                backtrack(n, k, ans, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, result, new ArrayList<>(), 1);
        return result;
    }

    // ____________________ Letter Combination ______________________________

    public static List<String> combine(String s) {
        List<String> result = new ArrayList<>();
        for (int range = 1; range <= s.length(); range++) {
            backtrack(s.toCharArray(), result, range, 0, "");
        }
        ;
        return result;
    }

    private static void backtrack(char[] letters, List<String> ans, int range, int index, String tempString) {
        if (tempString.length() == range) {
            ans.add(tempString);
        } else {
            for (int i = index; i < letters.length; i++) {
                backtrack(letters, ans, range, i + 1, tempString + letters[i]);
                ;
            }
        }
    }

    public static void main(String[] args) {
        // Combination of Numbers

        int n1 = 4, k1 = 2;
        System.out.println("Number Combinations: " + combine(n1, k1));
        int n2 = 1, k2 = 1;
        System.out.println("Number Combinations: " + combine(n2, k2));

        // Letter Combination

        String abcd = "abcd";
        // Result = {a, b, c, d, ab, ac, ad, bc, bd, cd, abc, abd, acd, bcd, abcd}
        System.out.println("Letter Combinations: " + combine(abcd));
    }
}

/*
 * To solve the Leetcode problem "77. Combinations," we need to generate all
 * possible combinations of `k` numbers out of the range from `1` to `n`. Each
 * combination should be unique, and the order of numbers in combinations does
 * not matter.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `n`: An integer representing the range of numbers from `1` to `n`.
 * - `k`: An integer representing the number of elements in each combination.
 * 
 * - **Sample Input**:
 * - `n`: 4
 * - `k`: 2
 * 
 * - **Output**:
 * - A list of all possible combinations of `k` numbers from `1` to `n`.
 * 
 * - **Sample Output**:
 * - `[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]`
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use **backtracking**. The
 * idea is to explore all possible combinations by recursively building
 * combinations and adding valid ones to the result.
 * 
 * ### Steps:
 * 1. Create a helper function that takes the current combination, the starting
 * number, and the remaining count of numbers to choose.
 * 2. If the current combination has `k` numbers, add it to the result list.
 * 3. Iterate through the numbers from the starting point to `n`, adding each
 * number to the current combination and recursively calling the helper function
 * to continue building the combination.
 * 4. After exploring with a number, remove it from the current combination
 * (backtrack) and continue to the next number.
 * 
 * ### Time Complexity:
 * - **O(C(n, k) * k)**: The time complexity arises from generating all
 * combinations, where $$C(n, k)$$ is the binomial coefficient representing the
 * number of combinations, and we are constructing each combination of size `k`.
 * 
 * ### Space Complexity:
 * - **O(C(n, k))**: The space complexity is due to storing the combinations in
 * the result list.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `combine` method initializes the result list and starts the
 * backtracking process.
 * 2. The `backtrack` method checks if the current combination has reached the
 * desired size `k`. If so, it adds a copy of the combination to the result.
 * 3. It iterates through the numbers starting from `start` to `n`, adding each
 * number to the current combination and recursively calling itself to continue
 * building the combination.
 * 4. After exploring with a number, it removes the last number (backtracking)
 * to explore the next possibilities.
 * 
 * This solution effectively generates all combinations of `k` numbers from `1`
 * to `n` and passes all relevant test cases on Leetcode. If you have any
 * further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://www.youtube.com/watch?v=DcUkm8CPeaY
 * [2] https://walkccc.me/LeetCode/problems/77/
 * [3] https://www.youtube.com/watch?v=q0s6m7AiM7o
 * [4] https://www.youtube.com/watch?v=_LkzXsBKa2Q
 * [5] https://www.youtube.com/watch?v=W9ohcDTkUko
 * [6] https://algo.monster/liteproblems/290
 * [7] https://www.youtube.com/watch?v=W_akoecmCbM
 * [8] https://algo.monster/liteproblems/291
 */

class Solution_102_Number {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int n, int k, int start) {
        // If the current combination is of size k, add it to the result
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // Iterate through the range from start to n
        for (int i = start; i <= n; i++) {
            combination.add(i); // Add the current number to the combination
            backtrack(result, combination, n, k, i + 1); // Recurse with the next number
            combination.remove(combination.size() - 1); // Backtrack
        }
    }
}

class Solution_102_Letter {

    public void combineLetter(String[] args) {
        String str = "abcd";
        ArrayList<String> result = new ArrayList<>();

        // Generate combinations of all lengths
        for (int r = 1; r <= str.length(); r++) {
            generateCombinations(str.toCharArray(), r, 0, "", result);
        }

        // Print the results
        for (String combination : result) {
            System.out.println(combination);
        }

        // Print the number of combinations
        System.out.println("Total combinations: " + result.size());
    }

    // Recursive function to generate combinations
    private static void generateCombinations(char[] arr, int r, int index, String current, ArrayList<String> result) {
        // If the current combination is of the desired length
        if (current.length() == r) {
            result.add(current);
            return;
        }

        // Loop through the characters in the array
        for (int i = index; i < arr.length; i++) {
            // Include the current character and move to the next
            generateCombinations(arr, r, i + 1, current + arr[i], result);
        }
    }
}