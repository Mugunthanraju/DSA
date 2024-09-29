package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution47 {

    public static int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int longest = 0, next;
        for (int x : nums)
            set.add(x);
        for (int num : nums) {
            // Checks whether it doesn't have previous number.
            if (!set.contains(num - 1)) {
                next = num + 1;
                while (set.contains(next))
                    next++;
                longest = Math.max(next - num, longest);
            }
        }
        return longest;

        /*************************************************************/

        /* Another Approach */

        // int res = 0;
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for (int n : nums) {
        // if (!map.containsKey(n)) {
        // int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
        // int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
        // // sum: length of the sequence n is in
        // int sum = left + right + 1;
        // map.put(n, sum);

        // // keep track of the max length
        // res = Math.max(res, sum);

        // // extend the length to the boundary(s)
        // // of the sequence
        // // will do nothing if n has no neighbors
        // map.put(n - left, sum);
        // map.put(n + right, sum);
        // }
        // else {
        // // duplicates
        // continue;
        // }
        // }
        // return res;
    }

    public static void main(String[] args) {
        int[] nums1 = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums1)); // 4
        int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive(nums2)); // 9
    }
}

/*
 * To solve the Leetcode problem "128. Longest Consecutive Sequence," we need to
 * find the length of the longest consecutive elements sequence in an unsorted
 * array of integers.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - An integer array `nums`.
 * 
 * - **Sample Input**:
 * - `nums`: [100, 4, 200, 1, 3, 2]
 * 
 * - **Output**:
 * - An integer representing the length of the longest consecutive elements
 * sequence.
 * 
 * - **Sample Output**:
 * - `4` (The longest consecutive sequence is `[1, 2, 3, 4]`.)
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use a hash set to store the
 * elements of the array. This allows us to check for the existence of
 * consecutive numbers in constant time.
 * 
 * ### Steps:
 * 1. **Store Elements in a Set**: Insert all elements of the array into a hash
 * set for O(1) look-up times.
 * 2. **Iterate Through the Array**: For each number, check if it is the start
 * of a sequence (i.e., if `num - 1` is not in the set).
 * 3. **Count Consecutive Numbers**: If it is the start of a sequence, count how
 * many consecutive numbers exist starting from that number.
 * 4. **Update Maximum Length**: Keep track of the maximum length found during
 * the iteration.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array and perform constant time operations for
 * each element.
 * 
 * ### Space Complexity:
 * - **O(n)**: We use a hash set to store all unique elements.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `longestConsecutive` method initializes a hash set to store unique
 * numbers from `nums`.
 * 2. It iterates through each number in `numSet` and checks if it is the
 * beginning of a sequence.
 * 3. If it is, it counts how many consecutive numbers follow and updates the
 * maximum streak length.
 * 4. Finally, it returns the length of the longest consecutive sequence found.
 * 
 * This solution efficiently finds the longest consecutive sequence in an
 * unsorted array and passes all relevant test cases on Leetcode. If you have
 * any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://www.geeksforgeeks.org/longest-consecutive-subsequence/
 * [2]
 * https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-
 * array/
 * [3] https://www.enjoyalgorithms.com/blog/longest-consecutive-sequence/
 * [4] https://www.youtube.com/watch?v=9UOmXgG4h2U
 * [5]
 * https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-
 * sum-exists-in-array/
 * [6] https://www.youtube.com/watch?v=aYqYMIqZx5s
 * [7] https://www.youtube.com/watch?v=3OamzN90kPg
 * [8]
 * https://takeuforward.org/data-structure/contains-duplicate-check-if-a-value-
 * appears-atleast-twice/
 */

class Solution_47 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num); // Add all numbers to the set
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak); // Update max streak
            }
        }

        return longestStreak; // Return the longest streak found
    }
}