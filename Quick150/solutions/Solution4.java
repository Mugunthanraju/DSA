package solutions;

import java.util.Arrays;

public class Solution4 {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return len;

        int k = 0, count = 1;

        for (int i = 1; i < len; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
                count = 1;
            } else if (nums[k] == nums[i] && count == 1) {
                nums[++k] = nums[i];
                count++;
            }
        }
        return k + 1;
    }

    public static void main(String[] args) {
        // int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        int[] nums = { 1, 1, 1 };
        int k = removeDuplicates(nums);
        System.out.println("K = " + k + ", Non duplicate sorted array : " +
                Arrays.toString(Arrays.copyOfRange(nums, 0, k)));
    }

}

/*
 * ## Approach
 * 
 * The correct approach uses a single pointer to track the position for the next
 * valid element. We iterate through the array, and whenever we encounter a
 * number that is different from the last two numbers, we add it to the modified
 * array.
 * 
 * ### Steps:
 * 1. Initialize a pointer `i` to 1, which will represent the index of the last
 * unique element.
 * 2. Loop through the array starting from index 2 (with pointer `j`):
 * - If `nums[j]` is not equal to `nums[i - 1]` and `nums[j]` is not equal to
 * `nums[i]`, it means we found a new unique element:
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
 * ### Explanation of the Code:
 * - The method `removeDuplicates` first checks if the array has length less
 * than or equal to 2. If so, it returns the length of the array, as all
 * elements are already unique or have at most two occurrences.
 * - It initializes a pointer `i` to 1, as the first two elements are always
 * unique.
 * - It iterates through the array starting from the third element. Whenever it
 * finds an element that differs from the element two positions before, it
 * updates the next position in the array with this new unique element and
 * increments the `i` pointer.
 * - Finally, it returns `i + 1`, which represents the count of unique elements
 * in the modified array.
 * 
 * This solution efficiently removes duplicates in-place while ensuring that
 * each unique element appears at most twice. It passes all test cases on
 * Leetcode.
 */

class Solution_4 {
    // Method to remove duplicates from sorted array allowing at most two
    // occurrences of each element
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length; // Handle arrays with length <= 2

        int i = 1; // Pointer for the last unique element

        // Start from the third element and compare with the last two unique elements
        for (int j = 2; j < nums.length; j++) {
            // If the current element is not equal to the element two positions before
            if (nums[j] != nums[i - 1]) {
                i++; // Move the unique pointer forward
                nums[i] = nums[j]; // Update the position with the new unique element
            }
        }

        // Return the count of unique elements
        return i + 1; // i is zero-based, so we add 1 for the count
    }
}