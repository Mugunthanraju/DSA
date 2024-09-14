package solutions;

public class Solution9 {
    public static boolean canJump(int[] nums) {
        // Find whether I can reach last index.

        // At first I can reach 0
        int reach = 0;

        for (int idx = 0; idx < nums.length; idx++) {

            // To check, atleast I can able to reach the current index.
            if (reach < idx)
                return false; // else return false

            // Update the reach, for each index, you're getting new jump length.
            reach = Math.max(reach, idx + nums[idx]);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 1, 1, 4 };
        int[] nums2 = { 3, 2, 1, 0, 4 };
        System.out.println("Able to reach last? " + canJump(nums1));
        System.out.println("Able to reach last? " + canJump(nums2));
    }
}

/*
 * To solve the Leetcode problem "55. Jump Game," we need to determine if we can
 * reach the last index of an array starting from the first index, given that
 * each element represents the maximum number of steps we can take from that
 * position.
 * 
 * ## Approach
 * 
 * The optimal approach uses a greedy algorithm. We keep track of the maximum
 * index we can reach so far (`maxReachable`) as we iterate through the array.
 * 
 * ### Steps:
 * 1. Initialize `maxReachable` to `0`.
 * 2. Iterate through each index `i` in the array:
 * - If `i` is greater than `maxReachable`, it means we cannot proceed further,
 * so return `false`.
 * - Update `maxReachable` to be the maximum of its current value and `i +
 * nums[i]`.
 * 3. If the loop completes without returning `false`, it means we can reach the
 * last index, so return `true`.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space.
 * 
 * 
 * ### Explanation of the Code:
 * - The `canJump` method initializes `maxReachable` to `0`.
 * - It iterates through each index `i` in the `nums` array:
 * - If `i` is greater than `maxReachable`, it means we cannot reach this index
 * or beyond, so we return `false`.
 * - Otherwise, we update `maxReachable` to be the maximum of its current value
 * and `i + nums[i]`, which represents the furthest we can reach from the
 * current position.
 * - If the loop completes without returning `false`, it means we can reach the
 * last index, so we return `true`.
 * 
 * This solution efficiently determines if we can reach the last index using a
 * greedy approach and passes all test cases on Leetcode.
 * 
 * Citations:
 * [1] https://algo.monster/liteproblems/55
 * [2] https://walkccc.me/LeetCode/problems/55/
 * [3] https://www.youtube.com/watch?v=Gtugy3mRV-A
 * [4] https://dev.to/samuelhinchliffe/55-jump-game-1pfb
 * [5]
 * https://leetcode.com/problems/jump-game/solutions/3441118/55-jump-game-java/
 * [6] https://leetcode.com/problems/rotate-array/
 * [7] https://leetcode.com/problems/remove-element/
 * [8] https://www.youtube.com/watch?v=BHr381Guz3Y
 */

class Solution_9 {
    public boolean canJump(int[] nums) {
        int maxReachable = 0; // Initialize the maximum reachable index to 0

        // Iterate over each index in the array
        for (int i = 0; i < nums.length; ++i) {
            // If the current index is greater than the maximum reachable index,
            // it means we cannot proceed further, so return false.
            if (maxReachable < i) {
                return false;
            }

            // Update the maximum reachable index if the reachable index
            // from the current position is greater than the previous max.
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }

        // If the loop completes without returning false, it means we can
        // reach the last index, so return true.
        return true;
    }
}
