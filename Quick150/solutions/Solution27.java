package solutions;

import java.util.Arrays;

public class Solution27 {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] ans = { 0, 0 };

        while (left < right) {
            int value = numbers[left] + numbers[right];
            if (value == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            } else if (value < target)
                left++;
            else
                right--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = { 2, 7, 11, 15 };
        int target1 = 9;
        System.out.println("Index pairs : " + Arrays.toString(twoSum(num1, target1)));
        int[] num2 = { 2, 3, 4 };
        int target2 = 6;
        System.out.println("Index pairs : " + Arrays.toString(twoSum(num2, target2)));
    }
}

/*
 * To solve the Leetcode problem "167. Two Sum II - Input Array Is Sorted," we
 * need to find two numbers in a sorted array that add up to a specific target
 * value. The solution must return the indices of these two numbers in a
 * 1-indexed format.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `numbers`: An array of integers sorted in non-decreasing order.
 * - `target`: An integer representing the target sum.
 * 
 * - **Output**:
 * - An array containing the 1-indexed positions of the two numbers that add up
 * to the target.
 * 
 * ## Approach
 * 
 * The optimal solution uses the **two-pointer technique**. Since the array is
 * sorted, we can efficiently find the two numbers by starting with one pointer
 * at the beginning of the array and the other at the end.
 * 
 * ### Steps:
 * 1. Initialize two pointers:
 * - `left` at the start of the array (index `0`).
 * - `right` at the end of the array (index `numbers.length - 1`).
 * 
 * 2. Use a loop to iterate while `left` is less than `right`:
 * - Calculate the sum of the elements at the two pointers.
 * - If the sum equals the target, return the indices (incremented by one for
 * 1-indexing).
 * - If the sum is less than the target, increment the `left` pointer to
 * increase the sum.
 * - If the sum is greater than the target, decrement the `right` pointer to
 * decrease the sum.
 * 
 * 3. Since the problem guarantees that there is exactly one solution, we do not
 * need to handle cases where no solution exists.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array at most once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space.
 * 
 * ### Explanation of the Code:
 * - The `twoSum` method initializes two pointers, `left` and `right`, to the
 * start and end of the `numbers` array, respectively.
 * - It enters a loop that continues until the two pointers meet. Inside the
 * loop, it calculates the sum of the values at the two pointers.
 * - If the sum matches the target, it returns the indices of the two numbers,
 * adjusted for 1-based indexing.
 * - Depending on whether the sum is less than or greater than the target, it
 * adjusts the pointers accordingly.
 * - The solution efficiently finds the required indices and passes all test
 * cases on Leetcode.
 * 
 * Citations:
 * [1] https://walkccc.me/LeetCode/problems/167/
 * [2] https://algo.monster/liteproblems/167
 * [3]
 * https://www.geeksforgeeks.org/pair-with-given-sum-in-sorted-array-two-sum-ii/
 * [4]
 * https://github.com/Seanforfun/Algorithm-and-Leetcode/blob/master/leetcode/167
 * .%20Two%20Sum%20II%20-%20Input%20array%20is%20sorted.md
 * [5]
 * https://www.interviewkickstart.com/blogs/problems/two-sum-ii-input-array-is-
 * sorted
 * [6]
 * https://stackoverflow.com/questions/55508252/two-sum-ii-input-array-is-sorted
 * [7] https://www.youtube.com/watch?v=BHr381Guz3Y
 * [8] https://algo.monster/liteproblems/55
 */

class Solution_27 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; // Pointer for the start of the array
        int right = numbers.length - 1; // Pointer for the end of the array

        // Loop until the two pointers meet
        while (left < right) {
            int sum = numbers[left] + numbers[right]; // Calculate the sum of the two pointers

            // Check if the sum equals the target
            if (sum == target) {
                // Return the indices (1-indexed)
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                // If the sum is less than the target, move the left pointer to the right
                left++;
            } else {
                // If the sum is greater than the target, move the right pointer to the left
                right--;
            }
        }

        // The problem guarantees that exactly one solution exists, so we should never
        // reach here
        return new int[] { -1, -1 }; // Placeholder return, not expected to be executed
    }
}