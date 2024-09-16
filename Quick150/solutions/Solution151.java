package solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution151 {
    private static void backtrack(int[] n, List<List<Integer>> ans, List<Integer> temp, int index) {

        // Whenever it enters into method then add the temp (it may contain anything)
        // into ans.
        ans.add(new ArrayList<>(temp));

        for (int i = index; i < n.length; i++) {
            temp.add(n[i]);
            backtrack(n, ans, temp, i + 1);
            temp.remove(temp.size() - 1);
        }

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3 };
        System.out.println("Subsets: " + subsets(nums1));
        int[] nums2 = { 0 };
        System.out.println("Subsets: " + subsets(nums2));

    }
}

/*
 * To solve the Leetcode problem "78. Subsets," we need to generate all possible
 * subsets (the power set) of a given array of unique integers. Each subset can
 * include any combination of elements from the original array, including the
 * empty set.
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
 * - A list of all possible subsets of the input array.
 * 
 * - **Sample Output**:
 * - `[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]`
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use **backtracking**. The
 * idea is to explore all possible combinations of the elements by deciding
 * whether to include each element in the current subset.
 * 
 * ### Steps:
 * 1. Create a helper function that takes the current subset and the starting
 * index for the next elements.
 * 2. Add the current subset to the result list.
 * 3. Iterate through the elements starting from the current index:
 * - Include the current element in the subset and recursively call the helper
 * function to explore further.
 * - After exploring, remove the last element from the subset (backtrack) and
 * continue to the next element.
 * 
 * ### Time Complexity:
 * - **O(2^n)**: The time complexity arises because there are $$2^n$$ possible
 * subsets for an array of size $$n$$.
 * 
 * ### Space Complexity:
 * - **O(n)**: The space complexity is due to the recursion stack and the
 * temporary list used to store the current subset.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `subsets` method initializes the result list and starts the
 * backtracking process.
 * 2. The `backtrack` method adds the current subset to the result.
 * 3. It iterates through each element in `nums`, adding the current element to
 * the subset and recursively calling itself to explore further subsets.
 * 4. After exploring with a number, it removes the last number (backtracking)
 * to explore other possibilities.
 * 
 * This solution effectively generates all subsets of the input array and passes
 * all relevant test cases on Leetcode. If you have any further questions or
 * need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://www.youtube.com/watch?v=3tpjp5h3M6Y
 * [2] https://walkccc.me/LeetCode/problems/78/
 * [3] https://www.youtube.com/watch?v=REOH22Xwdkk
 * [4] https://leetcode.com/problems/subsets/
 * [5]
 * https://leetcode-in-java.github.io/src/main/java/g0001_0100/s0078_subsets/
 * [6] https://leetcode.ca/all/39.html
 * [7] https://www.youtube.com/watch?v=_LkzXsBKa2Q
 * [8] https://www.youtube.com/watch?v=W9ohcDTkUko
 */

class Solution_151 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset,
            int[] nums, int start) {
        // Add the current subset to the result
        result.add(new ArrayList<>(currentSubset));

        // Iterate through the nums array to create subsets
        for (int i = start; i < nums.length; i++) {
            // Include the current element in the subset
            currentSubset.add(nums[i]);
            // Recur with the next index
            backtrack(result, currentSubset, nums, i + 1);
            // Backtrack: remove the last element added
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}