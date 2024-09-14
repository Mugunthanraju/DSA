package solutions;

public class Solution10 {

    public static int jump(int[] nums) {
        int jumps = 0;
        int lastJumpedPos = 0;
        int maxReachable = 0;
        int lastIndex = nums.length - 1;
        int index = 0;

        while (lastJumpedPos < lastIndex) {
            maxReachable = Math.max(nums[index] + index, maxReachable);

            if (index == lastJumpedPos) {
                jumps++;
                lastJumpedPos = maxReachable;
            }
            index++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 1, 1, 4 };
        int[] nums2 = { 2, 3, 0, 1, 4 };
        System.out.println("Min steps to jump : " + jump(nums1));
        System.out.println("Min steps to jump : " + jump(nums2));
    }
}

/*
 * To solve the Leetcode problem "45. Jump Game II," we need to determine the
 * minimum number of jumps required to reach the last index of an array, where
 * each element represents the maximum jump length from that position.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `nums`: An array of non-negative integers where `nums[i]` represents the
 * maximum jump length from index `i`.
 * 
 * - **Output**:
 * - The minimum number of jumps required to reach the last index.
 * 
 * ## Approach
 * 
 * The optimal approach uses a greedy algorithm. The idea is to keep track of
 * the farthest index we can reach with the current number of jumps and when we
 * need to make a new jump.
 * 
 * ### Steps:
 * 1. Initialize three variables:
 * - `steps` to count the number of jumps made.
 * - `maxReach` to track the maximum index reachable from the current jump.
 * - `lastJumpMaxReach` to track the maximum index reachable from the last jump.
 * 
 * 2. Iterate through the array (up to the second-to-last index):
 * - Update `maxReach` to be the maximum of its current value and the index plus
 * the jump length from that index (`i + nums[i]`).
 * - If the current index `i` reaches `lastJumpMaxReach`, it means we need to
 * make another jump:
 * - Increment `steps`.
 * - Update `lastJumpMaxReach` to `maxReach`.
 * - If at any point `maxReach` reaches or exceeds the last index, we can break
 * early.
 * 
 * 3. Return `steps` as the result.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space.
 * 
 * ### Explanation of the Code:
 * - The `jump` method initializes `steps`, `maxReach`, and `lastJumpMaxReach`.
 * - It iterates through the `nums` array, updating `maxReach` based on the
 * current index and the jump length.
 * - When the current index reaches `lastJumpMaxReach`, it increments the
 * `steps` counter and updates `lastJumpMaxReach`.
 * - If `maxReach` reaches or exceeds the last index, the loop can terminate
 * early.
 * - Finally, it returns the total number of jumps taken to reach the last
 * index.
 * 
 * This solution efficiently calculates the minimum number of jumps required to
 * reach the end of the array and passes all test cases on Leetcode.
 * 
 * Citations:
 * [1] https://dev.to/seanpgallivan/solution-jump-game-ii-cn3
 * [2] https://walkccc.me/LeetCode/problems/45/
 * [3] https://www.youtube.com/watch?v=dJ7sWiOoK7g
 * [4] https://www.youtube.com/watch?v=9kyHYVxL4fw
 * [5] https://www.youtube.com/watch?v=Gtugy3mRV-A
 * [6] https://algo.monster/liteproblems/45
 * [7] https://walkccc.me/LeetCode/problems/55/
 * [8] https://algo.monster/liteproblems/55
 */

class Solution_10 {
    public int jump(int[] nums) {
        int steps = 0; // Initialize a step counter to keep track of the number of jumps made
        int maxReach = 0; // Initialize the maximum reach from the current position
        int lastJumpMaxReach = 0; // Initialize the maximum reach of the last jump

        // Iterate through the array except for the last element,
        // because we want to reach the last index, not jump beyond it
        for (int i = 0; i < nums.length - 1; ++i) {
            // Update the maximum reach by taking the maximum between the current maxReach
            // and the position we could reach from the current index (i + nums[i])
            maxReach = Math.max(maxReach, i + nums[i]);

            // If the current index reaches the last jump's maximum reach,
            // it means we have to make another jump to proceed further
            if (lastJumpMaxReach == i) {
                steps++; // Increment the step counter because we're making another jump
                lastJumpMaxReach = maxReach; // Update the last jump's max reach to the current maxReach
            }

            // There's no need to continue if the maximum reach is already beyond the last
            // index,
            // as we are guaranteed to end the loop
            if (maxReach >= nums.length - 1) {
                break;
            }
        }

        // Return the minimum number of jumps needed to reach the last index
        return steps;
    }
}