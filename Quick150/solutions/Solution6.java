package solutions;

import java.util.Arrays;

public class Solution6 {
    private static void reverseIt(int[] nums, int from, int to) {
        int start = from, end = to - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;

        // Normalize if the k is greater than n.
        k %= n;

        // Reverse entire array
        reverseIt(nums, 0, n);
        // Reverse array upto k index
        reverseIt(nums, 0, k);
        // Reverse array from k to last
        reverseIt(nums, k, n);

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 }; // [5, 6, 7, 1, 2, 3, 4]
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}

/*
 * To solve the Leetcode problem "189. Rotate Array," we need to rotate an array
 * of integers to the right by `k` steps. The rotation should be done in-place,
 * meaning we cannot use extra space for another array.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `nums`: An array of integers.
 * - `k`: A non-negative integer representing the number of steps to rotate the
 * array.
 * 
 * - **Output**:
 * - The modified array after rotation.
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use the **three-step
 * reversal** method. This method allows us to rotate the array in-place without
 * using extra space.
 * 
 * ### Steps:
 * 1. **Normalize `k`**: Since rotating the array by its length has no effect,
 * we first take `k` modulo the length of the array.
 * 2. **Reverse the entire array**: This puts the last `k` elements in the front
 * but in reverse order.
 * 3. **Reverse the first `k` elements**: This puts them in the correct order.
 * 4. **Reverse the remaining elements**: This fixes the order of the rest of
 * the array.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array a constant number of times.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use no additional space apart from a few variables.
 * 
 * 
 * ### Explanation of the Code:
 * - The method `rotate` first normalizes `k` to ensure it is within the bounds
 * of the array length.
 * - It then calls the `reverse` method three times:
 * - First, to reverse the entire array.
 * - Second, to reverse the first `k` elements.
 * - Third, to reverse the remaining `n - k` elements.
 * - The `reverse` method uses a two-pointer technique to swap elements until
 * the pointers meet, effectively reversing the specified portion of the array.
 * 
 * This solution efficiently rotates the array in-place, meeting the problem's
 * requirements and passing all test cases.
 * 
 * Citations:
 * [1]
 * https://github.com/dongyeseu/LeetCode/blob/master/189.%20Rotate%20Array.md
 * [2] https://algo.monster/liteproblems/189
 * [3] https://walkccc.me/LeetCode/problems/189/
 * [4] https://www.youtube.com/watch?v=BHr381Guz3Y
 * [5] https://redquark.org/leetcode/0027-remove-element/
 * [6] https://leetcode.com/problems/rotate-array/
 * [7] https://leetcode.com/problems/remove-element/
 * [8]
 * https://prepfortech.io/leetcode-solutions/remove-duplicates-from-sorted-array
 * -ii
 */

class Solution_6 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // Normalize k to avoid unnecessary rotations
        k %= n;

        // Reverse the entire array
        reverse(nums, 0, n - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining n - k elements
        reverse(nums, k, n - 1);
    }

    // Helper method to reverse a portion of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap elements at start and end
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}