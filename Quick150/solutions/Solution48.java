package solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution48 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        int i = 0, temp, len = nums.length; // len = size of nums array.

        while (i < len) {

            temp = nums[i]; // store the inital value as temp

            // we move index pointer until last before item
            // and difference between two consecutive numbers
            while ((i < len - 1) && (nums[i + 1] - nums[i] == 1)) {
                i++;
            }

            // Check : intial number is not equal current number
            if (temp != nums[i])
                list.add(temp + "->" + nums[i]);
            else
                list.add(temp + "");

            ++i; // increment index pointer
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = { 0, 1, 2, 4, 5, 7 };
        // [0->2, 4->5, 7]
        System.out.println(summaryRanges(nums1));
        int[] nums2 = { 0, 2, 3, 4, 6, 8, 9 };
        // [0, 2->4, 6, 8->9]
        System.out.println(summaryRanges(nums2));
    }
}

/*
 * To solve the Leetcode problem "228. Summary Ranges," we need to return the
 * smallest sorted list of ranges that cover all the numbers in a given sorted
 * unique integer array. Each range should be represented in a specific format.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - A sorted unique integer array `nums`.
 * 
 * - **Output**:
 * - A list of strings representing the ranges.
 * 
 * ### Example:
 * - **Input**: `nums = [0, 1, 2, 4, 5, 7]`
 * - **Output**: `["0->2", "4->5", "7"]`
 * - Explanation: The ranges are `[0, 2]`, `[4, 5]`, and `[7, 7]`.
 * 
 * ## Approach
 * 
 * We can solve this problem using a simple iteration through the array with two
 * pointers or indices to track the start and end of each range.
 * 
 * ### Steps:
 * 1. Initialize an empty list to store the ranges.
 * 2. Use a loop to iterate through the array.
 * 3. For each number, check if it is part of a consecutive sequence:
 * - If it is consecutive to the previous number, continue.
 * - If not, finalize the current range and start a new one.
 * 4. After exiting the loop, ensure to add the last range to the result.
 * 5. Format each range appropriately based on whether it consists of one number
 * or multiple numbers.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the list once.
 * 
 * ### Space Complexity:
 * - **O(n)**: The space used for storing the output ranges.
 * 
 * ### Explanation of the Code:
 * 1. The `summaryRanges` method initializes an empty list to hold the ranges.
 * 2. It checks if the input array is empty and returns an empty list if so.
 * 3. It starts iterating from the second element of `nums`, checking for
 * consecutive numbers.
 * 4. When a break in sequence is found, it adds either a single number or a
 * range to the result list.
 * 5. After looping through all elements, it handles any remaining range or
 * single number.
 * 6. Finally, it returns the complete list of ranges.
 * 
 * This solution efficiently computes and formats all ranges from the given
 * sorted unique integer array and passes all relevant test cases on Leetcode.
 * If you have any further questions or need additional examples, feel free to
 * ask!
 * 
 * Citations:
 * [1] https://www.youtube.com/watch?v=ZHJDwbfqoa8
 * [2] https://leetcode.ca/all/228.html
 * [3] https://www.youtube.com/watch?v=9UOmXgG4h2U
 * [4]
 * https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-
 * sum-exists-in-array/
 * [5]
 * https://github.com/doocs/leetcode/blob/main/solution/0200-0299/0228.Summary%
 * 20Ranges/README_EN.md
 * [6] https://walkccc.me/LeetCode/problems/228/
 * [7] https://www.youtube.com/watch?v=P0BT1xA2tIg
 * [8]
 * https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-
 * array/
 */

class Solution_48 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) {
            return ranges; // Return empty list if input is empty
        }

        int start = nums[0]; // Start of the current range

        for (int i = 1; i < nums.length; i++) {
            // Check if current number is not consecutive
            if (nums[i] != nums[i - 1] + 1) {
                // If it's a single number
                if (start == nums[i - 1]) {
                    ranges.add(String.valueOf(start));
                } else {
                    // If it's a range
                    ranges.add(start + "->" + nums[i - 1]);
                }
                start = nums[i]; // Update start for new range
            }
        }

        // Handle the last range or single number
        if (start == nums[nums.length - 1]) {
            ranges.add(String.valueOf(start));
        } else {
            ranges.add(start + "->" + nums[nums.length - 1]);
        }

        return ranges; // Return all ranges
    }
}