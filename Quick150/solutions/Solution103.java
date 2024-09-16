package solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution103 {

    private static void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] used) {

        if (temp.size() == nums.length)
            ans.add(new ArrayList<>(temp));

        else {
            for (int i = 0; i < nums.length; i++) {

                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;

                temp.add(nums[i]);
                used[i] = true;
                backtrack(ans, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3 };
        System.out.println(permute(nums1));
        int[] nums2 = { 0, 1 };
        System.out.println(permute(nums2));
        int[] nums3 = { 1 };
        System.out.println(permute(nums3));
    }
}

/*
 * To solve the Leetcode problem "46. Permutations," we need to generate all
 * possible permutations of a given array of distinct integers. Each permutation
 * should be unique, and the order of elements in the permutations matters.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `nums`: An array of distinct integers.
 * 
 * - **Sample Input**:
 * - `nums`: [1, 2, 3]
 * 
 * - **Output**:
 * - A list of all possible permutations of the input array.
 * 
 * - **Sample Output**:
 * - `[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]`
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use **backtracking**. The
 * idea is to explore all possible arrangements of the numbers by recursively
 * building permutations.
 * 
 * ### Steps:
 * 1. Create a helper function that takes the current permutation and a boolean
 * array to track which numbers have been used.
 * 2. If the current permutation has the same length as `nums`, add it to the
 * result list.
 * 3. Iterate through the numbers in `nums`:
 * - If a number has not been used, add it to the current permutation and mark
 * it as used.
 * - Recursively call the helper function to continue building the permutation.
 * - After returning from recursion, remove the last number from the current
 * permutation (backtrack) and mark it as unused.
 * 4. Return the result list containing all permutations.
 * 
 * ### Time Complexity:
 * - **O(n! * n)**: The time complexity arises from generating all permutations,
 * where $$n!$$ is the number of permutations and $$n$$ is the time taken to
 * copy each permutation.
 * 
 * ### Space Complexity:
 * - **O(n)**: The space complexity is due to the recursion stack and the
 * temporary list used to store the current permutation.
 * 
 * ### Explanation of the Code:
 * 1. The `permute` method initializes the result list and starts the
 * backtracking process.
 * 2. The `backtrack` method checks if the current permutation has reached the
 * desired length. If so, it adds a copy of the permutation to the result.
 * 3. It iterates through each number in `nums`, skipping those that have
 * already been used in the current permutation.
 * 4. It adds the current number to the permutation, marks it as used, and
 * recursively calls itself to continue building the permutation.
 * 5. After exploring with a number, it removes the last number (backtracking)
 * and marks it as unused to explore other possibilities.
 * 
 * This solution effectively generates all permutations of the input array and
 * passes all relevant test cases on Leetcode. If you have any further questions
 * or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://www.youtube.com/watch?v=s7AvT7cGdSo
 * [2] https://www.youtube.com/watch?v=FZe0UqISmUw
 * [3] https://www.youtube.com/watch?v=H232aocj7bQ
 * [4] https://walkccc.me/LeetCode/problems/46/
 * [5] https://algo.monster/liteproblems/46
 * [6] https://www.youtube.com/watch?v=q0s6m7AiM7o
 * [7] https://www.youtube.com/watch?v=_LkzXsBKa2Q
 * [8] https://www.youtube.com/watch?v=W9ohcDTkUko
 * 
 */

class Solution_103 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPermutation,
            int[] nums, boolean[] used) {
        // If the current permutation is the same length as nums, add it to the result
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        // Iterate through the nums array to create permutations
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue; // Skip if the number is already used

            // Choose the current number
            currentPermutation.add(nums[i]);
            used[i] = true; // Mark as used

            // Recurse to continue building the permutation
            backtrack(result, currentPermutation, nums, used);

            // Backtrack: remove the last number added and mark it as unused
            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }
}