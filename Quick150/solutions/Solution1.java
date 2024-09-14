package solutions;

import java.util.Arrays;

public class Solution1 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
         * nums1 has capacity to hold elements in nums2.
         * All we wanted to do is add elements in nums1 from nums2 in sorted manner.
         * So, we going to sort from lastIndex to firstIndex in ascending order.
         * Since, both arrays are sorted. We pick last elements of both arrays and store
         * it with a condition check.
         * Atlast, we get to know that it a Merge Sort's merger function used here.
         */

        int i = m + n - 1;
        m--;
        n--;

        while (i > -1 && m > -1 && n > -1) {
            if (nums1[m] <= nums2[n]) {
                nums1[i--] = nums2[n--];
            } else {
                nums1[i--] = nums1[m--];
            }
        }
        // If we left anything in nums2 array
        while (i > -1 && n > -1)
            nums1[i--] = nums2[n--];
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1)); // {1,2,2,3,5,6}
    }

}

/*
 * 
 * To solve the Leetcode problem "88. Merge Sorted Array," we need to merge two
 * sorted arrays, `nums1` and `nums2`, into a single sorted array stored in
 * `nums1`. The `nums1` array has enough space to accommodate all elements from
 * both arrays.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `nums1`: An array of length `m + n`, where the first `m` elements are
 * valid, and the last `n` elements are zeros (placeholders).
 * - `nums2`: An array of length `n` containing valid elements.
 * - `m`: The number of valid elements in `nums1`.
 * - `n`: The number of valid elements in `nums2`.
 * 
 * - **Output**:
 * - The merged array should be stored in `nums1` in non-decreasing order.
 * 
 * ## Approach
 * 
 * The optimal approach involves merging the arrays from the end to the
 * beginning. This avoids the need for additional space and ensures that we can
 * place elements directly into `nums1` without overwriting any of the valid
 * elements.
 * 
 * ### Steps:
 * 1. Initialize three pointers:
 * - `indexNums1` at the last valid element of `nums1` (i.e., `m - 1`).
 * - `indexNums2` at the last element of `nums2` (i.e., `n - 1`).
 * - `mergedIndex` at the last position of `nums1` (i.e., `m + n - 1`).
 * 
 * 2. Compare elements from the end of both arrays:
 * - If the current element in `nums1` is greater than or equal to the current
 * element in `nums2`, place the element from `nums1` at `mergedIndex` and move
 * the pointer in `nums1` back.
 * - Otherwise, place the element from `nums2` at `mergedIndex` and move the
 * pointer in `nums2` back.
 * 
 * 3. Continue this process until all elements from `nums2` are merged into
 * `nums1`.
 * 
 * 4. If there are any remaining elements in `nums2`, copy them over to `nums1`
 * (this step is necessary because if `nums1` has remaining elements, they are
 * already in the correct position).
 * 
 * ### Time Complexity:
 * - **O(m + n)**: We traverse both arrays once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use no additional space apart from a few pointers.
 * 
 * 
 * This code efficiently merges the two sorted arrays in-place, ensuring that
 * the final result is stored in `nums1` as required.
 * 
 * Citations:
 * [1] https://walkccc.me/LeetCode/problems/88/
 * [2] https://algo.monster/liteproblems/88
 * [3] https://dev.to/rohithv07/leetcode-88-merge-sorted-array-58kf
 * [4] https://www.youtube.com/watch?v=P1Ic85RarKY
 * [5] https://leetcode.com/problems/merge-sorted-array/
 * 
 */

class Solution_1 {
    // Merges two sorted arrays, nums1 and nums2, into a single sorted array.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Initialize pointers for nums1, nums2, and the merged array.
        int indexNums1 = m - 1; // Pointer for the last element in the nums1's original part
        int indexNums2 = n - 1; // Pointer for the last element in nums2
        int mergedIndex = m + n - 1; // Pointer for the last element of merged array (end of nums1)

        // Iterate over nums2 and nums1 from the end of both arrays
        while (indexNums2 >= 0) {
            // If nums1 is exhausted, or the current element in nums2 is larger
            if (indexNums1 < 0 || nums1[indexNums1] <= nums2[indexNums2]) {
                nums1[mergedIndex] = nums2[indexNums2]; // Place nums2's element in the merged array
                indexNums2--; // Move to the next element in nums2
            } else {
                // The current element in nums1 is larger; place it in the merged array
                nums1[mergedIndex] = nums1[indexNums1];
                indexNums1--; // Move to the next element in nums1
            }
            mergedIndex--; // Move to the next position in the merged array
        }
        // No need to check the remaining elements of nums1,
        // if any left, since they are already in their sorted position.
    }
}