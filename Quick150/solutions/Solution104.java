package solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution104 {

    private static void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] n, int k, int start) {
        if (k < 0)
            return;
        else if (k == 0)
            ans.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < n.length; i++) {
                temp.add(n[i]);
                backtrack(ans, temp, n, k - n[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates1 = { 2, 3, 6, 7 };
        int target1 = 7;
        System.out.println(combinationSum(candidates1, target1));
        int[] candidates2 = { 2, 3, 5 };
        int target2 = 8;
        System.out.println(combinationSum(candidates2, target2));
        int[] candidates3 = { 2 };
        int target3 = 1;
        System.out.println(combinationSum(candidates3, target3));
    }
}

/*
 * To solve the Leetcode problem "39. Combination Sum," we need to find all
 * unique combinations of numbers from a given list (candidates) that add up to
 * a specified target. Each number in the candidates can be used multiple times
 * in the combination.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `candidates`: An array of distinct integers.
 * - `target`: A positive integer representing the target sum.
 * 
 * - **Sample Input**:
 * - `candidates`: [2, 3, 6, 7]
 * - `target`: 7
 * 
 * - **Output**:
 * - A list of all unique combinations of candidates that sum up to the target.
 * 
 * - **Sample Output**:
 * - `[[2, 2, 3], [7]]` (These are the combinations that sum to 7.)
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use **backtracking**. The
 * idea is to explore all possible combinations by recursively building
 * combinations and checking if they meet the target.
 * 
 * ### Steps:
 * 1. Create a helper function that takes the current combination, the remaining
 * target, and the starting index for candidates.
 * 2. If the remaining target is zero, add the current combination to the result
 * list.
 * 3. Iterate through the candidates starting from the current index:
 * - If the candidate can be included (i.e., it does not exceed the remaining
 * target), add it to the current combination and recursively call the helper
 * function with the updated target.
 * - After exploring with a candidate, remove it from the current combination
 * (backtrack) and continue to explore further candidates.
 * 
 * ### Time Complexity:
 * - **O(target / min(candidates))**: The time complexity can be approximated
 * based on how many times we can use the smallest candidate to reach the
 * target.
 * 
 * ### Space Complexity:
 * - **O(target / min(candidates))**: The space complexity is due to the
 * recursion stack and the temporary list used to store the current combination.
 * 
 * ### Explanation of the Code:
 * 1. The `combinationSum` method initializes the result list and starts the
 * backtracking process.
 * 2. The `backtrack` method checks if the remaining target is zero. If so, it
 * adds a copy of the current combination to the result.
 * 3. It iterates through each candidate starting from the given index, checking
 * if the candidate can be included in the current combination.
 * 4. If it can be included, it adds the candidate to the current combination
 * and recursively calls itself with the updated remaining target.
 * 5. After exploring with a candidate, it removes the last candidate
 * (backtracking) to explore other possibilities.
 * 
 * This solution effectively generates all combinations of candidates that sum
 * up to the target and passes all relevant test cases on Leetcode. If you have
 * any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://walkccc.me/LeetCode/problems/39/
 * [2] https://www.youtube.com/watch?v=utBw5FbYswk
 * [3] https://algo.monster/liteproblems/39
 * [4] https://www.youtube.com/watch?v=GBKI9VSKdGg
 * [5] https://leetcode.ca/all/39.html
 * [6] https://www.youtube.com/watch?v=q0s6m7AiM7o
 * [7] https://walkccc.me/LeetCode/problems/77/
 * [8] https://www.youtube.com/watch?v=DcUkm8CPeaY
 */

class Solution_104 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination,
            int[] candidates, int remainingTarget, int start) {
        // If the remaining target is zero, we found a valid combination
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // Iterate through the candidates
        for (int i = start; i < candidates.length; i++) {
            // If the candidate exceeds the remaining target, skip
            if (candidates[i] > remainingTarget) {
                continue;
            }

            // Choose the current candidate
            currentCombination.add(candidates[i]);
            // Recurse with the updated remaining target
            backtrack(result, currentCombination, candidates, remainingTarget - candidates[i], i);
            // Backtrack: remove the last number added
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}