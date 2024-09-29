package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution44 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            } else {
                map.put(num, i);
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(nums1, target1))); // {0, 1}
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2))); // {1, 2}
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        System.out.println(Arrays.toString(twoSum(nums3, target3))); // {0, 1}
    }
}

/*
 * To solve the Leetcode problem "1. Two Sum," we need to find two numbers in an
 * array that add up to a specific target number. The solution should return the
 * indices of these two numbers.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - An array of integers `nums`.
 * - An integer `target` representing the target sum.
 * 
 * - **Sample Input**:
 * - `nums`: [2, 7, 11, 15]
 * - `target`: 9
 * 
 * - **Output**:
 * - An array of two integers representing the indices of the two numbers that
 * add up to the target.
 * 
 * - **Sample Output**:
 * - `[0, 1]` (because `nums + nums[1] = 2 + 7 = 9`)
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use a hash map (or
 * dictionary) to store the numbers and their corresponding indices as we
 * iterate through the array. This allows us to check if the complement (the
 * number needed to reach the target) exists in constant time.
 * 
 * ### Steps:
 * 1. Initialize an empty hash map to store numbers and their indices.
 * 2. Iterate through each number in the array:
 * - Calculate the complement by subtracting the current number from the target.
 * - Check if this complement exists in the hash map.
 * - If it exists, return the indices of the current number and its complement.
 * - If it does not exist, add the current number and its index to the hash map.
 * 3. If no such pair is found by the end of the iteration, return an empty
 * array or indicate that no solution exists.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the list once.
 * 
 * ### Space Complexity:
 * - **O(n)**: In the worst case, we store all elements in the hash map.
 * 
 * ### Explanation of the Code:
 * 1. The `twoSum` method initializes a hash map to keep track of numbers and
 * their indices.
 * 2. It iterates through each element in `nums`, calculating its complement
 * with respect to `target`.
 * 3. If the complement exists in the hash map, it retrieves its index and
 * returns both indices as an array.
 * 4. If not found, it adds the current number and its index to the hash map for
 * future reference.
 * 5. If no pairs are found by the end of the loop, an exception is thrown
 * indicating no solution.
 * 
 * This solution efficiently finds two numbers that sum up to a specified target
 * and passes all relevant test cases on Leetcode. If you have any further
 * questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1]
 * https://www.geeksforgeeks.org/check-if-pair-with-given-sum-exists-in-array/
 * [2]
 * https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-
 * sum-exists-in-array/
 * [3] https://www.youtube.com/watch?v=9UOmXgG4h2U
 * [4] https://interviewing.io/questions/two-sum
 * [5] https://www.youtube.com/watch?v=cRBSOz49fQk
 * [6] https://www.youtube.com/watch?v=GBKI9VSKdGg
 * [7] https://www.youtube.com/watch?v=aYqYMIqZx5s
 * [8] https://www.youtube.com/watch?v=N0MgLvceX7M
 */

class Solution_44 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>(); // To store number and its index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate complement

            // Check if complement exists in map
            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i }; // Return indices
            }

            // Add current number and its index to map
            numToIndex.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution"); // If no solution is found
    }
}