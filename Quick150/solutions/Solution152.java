package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution152 {
    private static void backtrack(int[] n, List<List<Integer>> ans, List<Integer> temp, int index) {

        // Whenever it enters into method then add the temp (it may contain anything)
        // into ans.
        ans.add(new ArrayList<>(temp));

        for (int i = index; i < n.length; i++) {

            // To skip the duplicates
            if (i > index && n[i] == n[i - 1])
                continue;

            temp.add(n[i]);
            backtrack(n, ans, temp, i + 1);
            temp.remove(temp.size() - 1);
        }

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // To handle the duplicates
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2 };
        System.out.println("Subsets: " + subsetsWithDup(nums1));
        int[] nums2 = { 0 };
        System.out.println("Subsets: " + subsetsWithDup(nums2));
    }
}

/*
 * To solve the Leetcode problem "90. Subsets II," we need to generate all
 * possible subsets (the power set) of a given array of integers that may
 * contain duplicates. The key requirement is to ensure that the solution set
 * does not include duplicate subsets.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `nums`: An array of integers that may contain duplicates.
 * 
 * - **Sample Input**:
 * - `nums`: [1, 2, 2]
 * 
 * - **Output**:
 * - A list of all possible unique subsets.
 * 
 * - **Sample Output**:
 * - `[[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]`
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
 * subsets.
 * 3. **Track Current Subset**: Maintain a list for the current subset and an
 * index to control the elements being considered.
 * 4. **Skip Duplicates**: When iterating through the array, if the current
 * element is the same as the previous one and the previous element was not
 * included in the current subset, skip it to avoid duplicates.
 * 5. **Add Current Subset to Result**: Whenever a subset is formed, add it to
 * the result list.
 * 
 * ### Time Complexity:
 * - **O(n * 2^n)**: The time complexity arises because there are $$2^n$$
 * possible subsets, and constructing each subset takes O(n) time.
 * 
 * ### Space Complexity:
 * - **O(n * 2^n)**: The space complexity is due to storing the subsets in the
 * result list and the recursion stack.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `subsetsWithDup` method initializes the result list and sorts the
 * input array.
 * 2. The `backtrack` method adds the current subset to the result.
 * 3. It iterates through each element in `nums`, skipping duplicates to avoid
 * generating the same subset.
 * 4. If an element is included in the current subset, the method recursively
 * calls itself to continue building the subset.
 * 5. After exploring with a number, it removes the last number (backtracking)
 * to explore other possibilities.
 * 
 * This solution effectively generates all unique subsets of the input array and
 * passes all relevant test cases on Leetcode. If you have any further questions
 * or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://walkccc.me/LeetCode/problems/90/
 * [2] https://www.youtube.com/watch?v=Vn2v6ajA7U0
 * [3] https://www.youtube.com/watch?v=3tpjp5h3M6Y
 * [4] https://www.youtube.com/watch?v=REOH22Xwdkk
 * [5] https://www.youtube.com/watch?v=qGyyzpNlMDU
 * [6] https://algo.monster/liteproblems/90
 * [7] https://www.youtube.com/watch?v=NS01_5oZn7c
 * [8]
 * https://github.com/azl397985856/leetcode/blob/master/problems/90.subsets-ii-
 * en.md
 */

class Solution_152 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset,
            int[] nums, int start) {
        // Add the current subset to the result
        result.add(new ArrayList<>(currentSubset));

        // Iterate through the nums array to create subsets
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the current element in the subset
            currentSubset.add(nums[i]);
            // Recur with the next index
            backtrack(result, currentSubset, nums, i + 1);
            // Backtrack: remove the last element added
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}