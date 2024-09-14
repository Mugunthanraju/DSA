package solutions;

import java.util.Arrays;

public class Solution3 {

    public static int removeDuplicates(int[] nums) {

        if (nums.length < 2)
            return nums.length;

        int k = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[k] != nums[i]) // check values at k and i
                nums[++k] = nums[i]; // copy the value at i to k + 1 if it's not equal
        }
        return k + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }; // [0, 1, 2, 3, 4]
        int k = removeDuplicates(nums);
        System.out.println("K = " + k + ", Non duplicate sorted array : " +
                Arrays.toString(Arrays.copyOfRange(nums, 0, k)));
    }
}

/*
 * To solve the Leetcode problem "26. Remove Duplicates from Sorted Array," we
 * need to remove duplicate elements from a sorted array in-place and return the
 * count of unique elements. The key point is that since the array is sorted,
 * all duplicates will be adjacent to each other.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `nums`: An array of integers sorted in non-decreasing order.
 * 
 * - **Output**:
 * - The number of unique elements in the modified array.
 * 
 * ## Approach
 * 
 * The optimal approach uses a two-pointer technique:
 * 1. Use one pointer (`i`) to track the position of the last unique element
 * found.
 * 2. Use another pointer (`j`) to iterate through the array.
 * 
 * ### Steps:
 * 1. Initialize `i` to 0, which will represent the index of the last unique
 * element.
 * 2. Loop through the array starting from index 1 (with pointer `j`):
 * - If `nums[j]` is not equal to `nums[i]`, it means we found a new unique
 * element:
 * - Increment `i` and assign `nums[i] = nums[j]`.
 * 3. After the loop, `i + 1` will be the count of unique elements, as `i` is
 * zero-based.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use no additional space apart from a few variables.
 * 
 * 
 * ### Explanation of the Code:
 * - The method `removeDuplicates` checks if the array is empty and returns 0 if
 * it is.
 * - It initializes a pointer `i` to track the last unique element's index.
 * - It iterates through the array starting from the second element. Whenever it
 * finds an element that differs from the last unique element, it updates the
 * next position in the array with this new unique element and increments the
 * `i` pointer.
 * - Finally, it returns `i + 1`, which represents the count of unique elements
 * in the modified array.
 * 
 * This solution efficiently removes duplicates in-place while maintaining the
 * order of unique elements.
 * 
 * Citations:
 * [1] https://www.geeksforgeeks.org/remove-duplicates-sorted-array/
 * [2]
 * https://www.prepbytes.com/blog/arrays/remove-duplicates-from-sorted-array/
 * [3] https://takeuforward.org/data-structure/remove-duplicates-in-place-from-
 * sorted-array/
 * [4] https://walkccc.me/LeetCode/problems/88/
 * [5] https://redquark.org/leetcode/0027-remove-element/
 * [6] https://algo.monster/liteproblems/88
 * [7] https://algo.monster/liteproblems/27
 * [8] https://www.youtube.com/watch?v=Pcd1ii9P9ZI
 */

class Solution_3 {
    // Method to remove duplicates from a sorted array and return the new length.
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0; // Handle empty array case

        int i = 0; // Pointer for the last unique element

        // Start from the second element and compare with the last unique element
        for (int j = 1; j < nums.length; j++) {
            // If the current element is not equal to the last unique element
            if (nums[j] != nums[i]) {
                i++; // Move the unique pointer forward
                nums[i] = nums[j]; // Update the position with the new unique element
            }
        }

        // Return the count of unique elements
        return i + 1; // i is zero-based, so we add 1 for the count
    }
}