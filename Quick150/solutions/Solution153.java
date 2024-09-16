package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution153 {
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {

        if (remain < 0)
            return; /** no solution */
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < cand.length; i++) {
                if (i > start && cand[i] == cand[i - 1])
                    continue; /** skip duplicates */
                tempList.add(cand[i]);
                backtrack(list, tempList, cand, remain - cand[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates1 = { 10, 1, 2, 7, 6, 1, 5 };
        int target1 = 8;
        System.out.println(combinationSum2(candidates1, target1));
        int[] candidates2 = { 2, 5, 2, 1, 2 };
        int target2 = 5;
        System.out.println(combinationSum2(candidates2, target2));
    }
}

/*
 * To solve the Leetcode problem "40. Combination Sum II," we need to find all
 * unique combinations of numbers in a given array that sum up to a specified
 * target. Unlike the previous combination sum problem, this one allows each
 * number to be used only once in each combination, and the input array may
 * contain duplicates.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `candidates`: An array of integers that may contain duplicates.
 * - `target`: A positive integer representing the target sum.
 * 
 * - **Sample Input**:
 * - `candidates`: [10, 1, 2, 7, 6, 1, 5]
 * - `target`: 8
 * 
 * - **Output**:
 * - A list of all unique combinations of candidates that sum up to the target.
 * 
 * - **Sample Output**:
 * - `[[1, 1, 6], [1, 2, 5], [2, 6], [1, 7]]`
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use **backtracking**. The
 * idea is to explore all possible combinations of the elements while ensuring
 * that duplicates are not included in the final result.
 * 
 * ### Steps:
 * 1. **Sort the Input**: Start by sorting the array. This helps in easily
 * skipping duplicates during the backtracking process.
 * 2. **Create a Helper Function**: Use a recursive function that builds
 * combinations.
 * 3. **Track Current Combination**: Maintain a list for the current combination
 * and an index to control the elements being considered.
 * 4. **Skip Duplicates**: When iterating through the array, if the current
 * element is the same as the previous one and the previous element was not
 * included in the current combination, skip it to avoid duplicates.
 * 5. **Add Current Combination to Result**: Whenever a combination is formed
 * that meets the target, add it to the result list.
 * 
 * ### Time Complexity:
 * - **O(2^n)**: The time complexity arises because there are potentially
 * $$2^n$$ combinations, but this is reduced by skipping duplicates.
 * 
 * ### Space Complexity:
 * - **O(n)**: The space complexity is due to the recursion stack and the
 * temporary list used to store the current combination.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `combinationSum2` method initializes the result list and sorts the
 * input array.
 * 2. The `backtrack` method checks if the remaining target is zero. If so, it
 * adds a copy of the current combination to the result.
 * 3. It iterates through each element in `candidates`, skipping duplicates to
 * avoid generating the same combination.
 * 4. If an element is included in the current combination, the method
 * recursively calls itself to continue building the combination.
 * 5. After exploring with a number, it removes the last number (backtracking)
 * to explore other possibilities.
 * 
 * This solution effectively generates all unique combinations of candidates
 * that sum up to the target and passes all relevant test cases on Leetcode. If
 * you have any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://www.geeksforgeeks.org/combinational-sum/
 * [2] https://www.youtube.com/watch?v=GBKI9VSKdGg
 * [3] https://www.youtube.com/watch?v=utBw5FbYswk
 * [4] https://walkccc.me/LeetCode/problems/39/
 * [5] https://algo.monster/liteproblems/39
 * [6] https://prepfortech.io/leetcode-solutions/combination-sum
 * [7] https://www.designgurus.io/viewer/document/grokking-the-coding-interview/
 * 63d58068c98b37360a523ad4
 * [8] https://www.interviewbit.com/blog/combination-sum/
 */

class Solution_153 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the array to handle duplicates
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
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // If the candidate exceeds the remaining target, skip
            if (candidates[i] > remainingTarget) {
                break; // No need to continue further
            }

            // Include the current candidate in the combination
            currentCombination.add(candidates[i]);
            // Recur with the updated remaining target and next index
            backtrack(result, currentCombination, candidates, remainingTarget - candidates[i], i + 1);
            // Backtrack: remove the last element added
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}