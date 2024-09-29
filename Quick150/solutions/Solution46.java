package solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution46 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            // checks : nums[i] == nums[j]
            if (map.containsKey(num)) {
                // checks : abs(i - j) <= k
                if (Math.abs(i - map.get(num)) <= k)
                    return true;
            }
            // We store the max index for that number
            map.put(num, i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 1 };
        int k1 = 3;
        System.out.println(containsNearbyDuplicate(nums1, k1)); // true
        int[] nums2 = { 1, 0, 1, 1 };
        int k2 = 1;
        System.out.println(containsNearbyDuplicate(nums2, k2)); // true
        int[] nums3 = { 1, 2, 3, 1, 2, 3 };
        int k3 = 2;
        System.out.println(containsNearbyDuplicate(nums3, k3)); // false
    }
}

/*
 * To solve the Leetcode problem "219. Contains Duplicate II," we need to
 * determine if there are two distinct indices $$i$$ and $$j$$ in an array such
 * that the values at those indices are equal and the absolute difference
 * between the indices is at most $$k$$.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - An integer array `nums`.
 * - An integer `k`.
 * 
 * - **Sample Input**:
 * - `nums`: [1, 2, 3, 1]
 * - `k`: 3
 * 
 * - **Output**:
 * - A boolean value indicating whether there are two indices $$i$$ and $$j$$
 * such that `nums[i] == nums[j]` and $$|i - j| \leq k$$.
 * 
 * - **Sample Output**:
 * - `true` (The number `1` appears at indices `0` and `3`, which differ by
 * `3`.)
 * 
 * ## Approach
 * 
 * A more efficient approach than using nested loops is to use a hash map (or
 * dictionary) to store the last seen index of each number as we iterate through
 * the array. This allows us to check for duplicates within the specified range
 * in constant time.
 * 
 * ### Steps:
 * 1. Initialize a hash map to keep track of the last seen index of each number.
 * 2. Iterate through the array:
 * - For each number, check if it has been seen before.
 * - If it has been seen, check if the difference between the current index and
 * the last seen index is less than or equal to $$k$$.
 * - If both conditions are met, return true.
 * - Update the last seen index for the current number.
 * 3. If no such pair is found by the end of the iteration, return false.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the list once.
 * 
 * ### Space Complexity:
 * - **O(min(n, k))**: We store at most $$k$$ elements in the hash map.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `containsNearbyDuplicate` method initializes a hash map to store
 * numbers and their latest indices.
 * 2. It iterates through each element in `nums`, checking if it has been seen
 * before.
 * 3. If it has been seen, it checks if the difference between the current index
 * and the last seen index is within $$k$$.
 * 4. If both conditions are satisfied, it returns true.
 * 5. Finally, it updates the last seen index for each number and returns false
 * if no valid pairs are found.
 * 
 * This solution efficiently checks for nearby duplicates in an array and passes
 * all relevant test cases on Leetcode. If you have any further questions or
 * need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://prepfortech.io/leetcode-solutions/contains-duplicate
 * [2] https://walkccc.me/LeetCode/problems/217/
 * [3]
 * https://takeuforward.org/data-structure/contains-duplicate-check-if-a-value-
 * appears-atleast-twice/
 * [4]
 * https://www.geeksforgeeks.org/check-if-the-given-input-contains-duplicates/
 * [5]
 * https://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-
 * within-k-distance/
 * [6] https://www.youtube.com/watch?v=3OamzN90kPg
 * [7] https://www.youtube.com/watch?v=GBKI9VSKdGg
 * [8] https://www.youtube.com/watch?v=cRBSOz49fQk
 */

class Solution_46 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>(); // To store number and its latest index

        for (int i = 0; i < nums.length; i++) {
            // Check if we have seen this number before
            if (numToIndex.containsKey(nums[i])) {
                // Check if the indices are within k distance
                if (i - numToIndex.get(nums[i]) <= k) {
                    return true; // Found a valid pair
                }
            }
            // Update the latest index of the current number
            numToIndex.put(nums[i], i);
        }

        return false; // No valid pair found
    }
}