package solutions;

public class Solution155 {
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;

        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int n : nums) {
            if (first >= n) {
                first = n;
            } else if (second >= n) {
                second = n;
            } else {
                // (i < j < k) && (nums[i] < nums[j] < nums[k])
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        System.out.println(increasingTriplet(nums1)); // true
        int[] nums2 = { 5, 4, 3, 2, 1 };
        System.out.println(increasingTriplet(nums2)); // false
        int[] nums3 = { 2, 1, 5, 0, 4, 6 };
        System.out.println(increasingTriplet(nums3)); // true
    }
}

/*
 * To solve the Leetcode problem "334. Increasing Triplet Subsequence," we need
 * to determine whether there exists a triplet of indices $$i, j, k$$ such that
 * $$i < j < k$$ and $$nums[i] < nums[j] < nums[k]$$. This means we are looking
 * for three numbers in the array that form an increasing sequence.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `nums`: An array of integers.
 * 
 * - **Sample Input**:
 * - `nums`: [1, 2, 3, 4, 5]
 * 
 * - **Output**:
 * - A boolean value indicating whether there exists an increasing triplet
 * subsequence.
 * 
 * - **Sample Output**:
 * - `true` (because the triplet [1, 2, 3] is an increasing subsequence).
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use a greedy method with two
 * variables to track the smallest two numbers seen so far. This allows us to
 * efficiently check for the existence of an increasing triplet in a single pass
 * through the array.
 * 
 * ### Steps:
 * 1. **Initialize Two Variables**: Use two variables (`smallest` and `middle`)
 * initialized to infinity to keep track of the smallest and second smallest
 * numbers found so far.
 * 2. **Iterate Through the Array**: For each number in the array:
 * - If the current number is less than or equal to `smallest`, update
 * `smallest`.
 * - If it is greater than `smallest` but less than or equal to `middle`, update
 * `middle`.
 * - If it is greater than `middle`, we have found our triplet and can return
 * true.
 * 3. **Return False**: If the loop completes without finding a triplet, return
 * false.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space for the two variables.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The method initializes two variables to track the smallest and second
 * smallest values.
 * 2. It iterates through each number in `nums`:
 * - If a number is smaller than or equal to `smallest`, it updates `smallest`.
 * - If it’s greater than `smallest` but less than or equal to `middle`, it
 * updates `middle`.
 * - If it finds a number greater than both, it returns true immediately.
 * 3. If no such triplet is found by the end of the loop, it returns false.
 * 
 * This solution efficiently checks for an increasing triplet subsequence and
 * passes all relevant test cases on Leetcode. If you have any further questions
 * or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://prepfortech.io/leetcode-solutions/increasing-triplet-subsequence
 * [2] https://algo.monster/liteproblems/334
 * [3]
 * https://www.linkedin.com/pulse/understanding-threesum-problem-solution-steps-
 * jean-claude-adjanohoun-gqhmc
 * [4] https://www.baeldung.com/cs/3sum-problem
 * [5] https://algo.monster/liteproblems/209
 * [6] https://en.wikipedia.org/wiki/3sum
 * [7] https://walkccc.me/LeetCode/problems/334/
 * [8]
 * https://stackoverflow.com/questions/78354673/increasing-tripplet-subsequence
 */

class Solution_155 {
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE; // Initialize smallest to maximum value
        int middle = Integer.MAX_VALUE; // Initialize middle to maximum value

        for (int num : nums) {
            if (num <= smallest) {
                smallest = num; // Update smallest
            } else if (num <= middle) {
                middle = num; // Update middle
            } else {
                // Found a number greater than both smallest and middle
                return true;
            }
        }

        return false; // No increasing triplet found
    }
}
