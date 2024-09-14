package solutions;

import java.util.Arrays;

public class Solution2 {
    public static int removeElement(int[] nums, int val) {
        /*
         * 
         * Change the array nums such that the first k elements of nums contain the
         * elements which are not equal to val.
         * The remaining elements of nums are not important as well as the size of nums.
         * 
         * Return k.
         * 
         * arr = [0,1,2,2,3,0,4,2]
         * ans = [0,1,3,0,4,0,4,2]
         * i = [0,1,2,3,4,5,6,7]
         * k = [0,1,2,2,3,4,5,5]
         * eORn = [n,n,e,e,n,n,n,e] equal or not-equal
         * 
         */

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[k++] = nums[i];
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;
        int k = removeElement(nums, val);
        System.out.println("K = " + k + " " +
                Arrays.toString(Arrays.copyOfRange(nums, 0, k)));
    }
}

/*
 * 
 * To solve the Leetcode problem "27. Remove Element," we need to remove all
 * instances of a given value from an array in-place and return the new length
 * of the modified array. The order of the elements can be changed, and we
 * should not use extra space for another array.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `nums`: An array of integers.
 * - `val`: An integer value that needs to be removed from the array.
 * 
 * - **Output**:
 * - The new length of the array after removing all occurrences of `val`.
 * 
 * ## Approach
 * 
 * The approach involves using a single pointer to keep track of the position
 * where the next non-`val` element should be placed. We can iterate through the
 * array, and whenever we encounter an element that is not equal to `val`, we
 * place it at the current position indicated by our pointer and increment the
 * pointer.
 * 
 * ### Steps:
 * 1. Initialize a counter (`newLength`) to track the position for valid
 * elements.
 * 2. Loop through each element in the `nums` array:
 * - If the current element is not equal to `val`, place it at the index
 * indicated by `newLength` and increment `newLength`.
 * 3. After the loop, `newLength` will represent the count of elements that are
 * not equal to `val`, and the first `newLength` elements of `nums` will contain
 * the valid elements.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use no additional space apart from a few variables.
 * 
 * ## Java Code
 * 
 * ```
 * 
 * ### Explanation of the Code:
 * - We define a method `removeElement` that takes an integer array `nums` and
 * an integer `val`.
 * - We initialize `newLength` to zero, which will track the index for the next
 * valid element.
 * - We loop through each element in `nums`. If the element is not equal to
 * `val`, we place it at the `newLength` index and increment `newLength`.
 * - Finally, we return `newLength`, which represents the count of elements that
 * are not equal to `val` and are now at the beginning of the `nums` array.
 * 
 * This solution efficiently modifies the input array in-place and meets the
 * problem requirements.
 * 
 * Citations:
 * [1] https://walkccc.me/LeetCode/problems/27/
 * [2] https://redquark.org/leetcode/0027-remove-element/
 * [3] https://algo.monster/liteproblems/27
 * [4] https://www.youtube.com/watch?v=Pcd1ii9P9ZI
 * [5] https://leetcode.com/problems/remove-element/
 * [6] https://leetcode.com/problems/merge-sorted-array/
 * [7]
 * https://github.com/iyashwantsaini/LeetCode-Solutions/blob/master/27.remove-
 * element.cpp
 * [8] https://www.youtube.com/watch?v=P1Ic85RarKY
 * 
 */

class Solution_2 {
    // Method to remove all instances of a given value in-place and return the new
    // length.
    public int removeElement(int[] nums, int val) {
        int newLength = 0; // Initialize a counter for the new length of the array

        // Iterate over each element in the array
        for (int num : nums) {
            // If the current element is not the value to be removed
            if (num != val) {
                // Assign the number to the new index location
                nums[newLength++] = num; // Increment newLength after assignment
            }
        }

        // Return the new length of the array after removing the value
        return newLength;
    }
}