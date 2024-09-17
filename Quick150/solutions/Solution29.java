package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution29 {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length, j, k, total;
        if (n < 3)
            return Collections.emptyList();

        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            // To skip duplicates - which will significantly improve Time taken to run
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            j = i + 1;
            k = n - 1;

            while (j < k) {
                total = nums[i] + nums[j] + nums[k];
                if (total == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (total < 0)
                    j++;
                else
                    k--;
            }
        }

        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        System.out.println("Triplets: " + threeSum(nums1));
        int[] nums2 = { 0, 1, 1 };
        System.out.println("Triplets: " + threeSum(nums2));
        int[] nums3 = { 0, 0, 0 };
        System.out.println("Triplets: " + threeSum(nums3));
    }
}

/*
 * To solve the Leetcode problem "15. 3Sum," we need to find all unique triplets
 * in an array that sum up to zero. The challenge is to ensure that the solution
 * set does not contain duplicate triplets.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `nums`: An array of integers that may contain duplicates.
 * 
 * - **Sample Input**:
 * - `nums`: [-1, 0, 1, 2, -1, -4]
 * 
 * - **Output**:
 * - A list of all unique triplets `[a, b, c]` such that `a + b + c = 0`.
 * 
 * - **Sample Output**:
 * - `[[-1, -1, 2], [-1, 0, 1]]`
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use the **two-pointer
 * technique** after sorting the array. This allows us to efficiently find pairs
 * that sum up to a specific value while avoiding duplicates.
 * 
 * ### Steps:
 * 1. **Sort the Array**: Start by sorting the input array. This helps in easily
 * skipping duplicates and using the two-pointer technique.
 * 2. **Iterate through the Array**: Use a loop to fix one element of the
 * triplet.
 * 3. **Use Two Pointers**: For each fixed element, use two pointers (one
 * starting just after the fixed element and one at the end of the array) to
 * find pairs that sum up to the negative of the fixed element.
 * 4. **Skip Duplicates**: Ensure that we skip over duplicate values for both
 * the fixed element and the pairs found by the two pointers.
 * 5. **Add Unique Triplets**: When a valid triplet is found, add it to the
 * result list.
 * 
 * ### Time Complexity:
 * - **O(n^2)**: The time complexity arises from sorting the array (O(n log n))
 * and then using a nested loop with two pointers (O(n)).
 * 
 * ### Space Complexity:
 * - **O(1)**: The space complexity is constant if we ignore the space used for
 * storing results.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `threeSum` method initializes an empty list for results and sorts the
 * input array.
 * 2. It iterates through each element in `nums` as a potential first element of
 * a triplet.
 * 3. For each fixed element, it uses two pointers (`left` and `right`) to find
 * pairs that sum to zero when combined with the fixed element.
 * 4. If a valid triplet is found, it adds it to the result list and skips any
 * duplicate values.
 * 5. Finally, it returns all unique triplets that sum to zero.
 * 
 * This solution efficiently finds all unique triplets in the input array that
 * sum up to zero and passes all relevant test cases on Leetcode. If you have
 * any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://www.baeldung.com/cs/3sum-problem
 * [2] https://fizzbuzzed.com/top-interview-questions-1/
 * [3] https://en.wikipedia.org/wiki/3SUM
 * [4] https://logicmojo.com/3sum
 * [5]
 * https://www.linkedin.com/pulse/understanding-threesum-problem-solution-steps-
 * jean-claude-adjanohoun-gqhmc
 * [6] https://www.youtube.com/watch?v=cRBSOz49fQk
 * [7] https://www.youtube.com/watch?v=utBw5FbYswk
 * [8] https://www.youtube.com/watch?v=Vn2v6ajA7U0
 */

class Solution_29 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1; // Left pointer
            int right = nums.length - 1; // Right pointer

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicate values for the second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate values for the third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Move left pointer to increase sum
                } else {
                    right--; // Move right pointer to decrease sum
                }
            }
        }

        return result; // Return all unique triplets
    }
}