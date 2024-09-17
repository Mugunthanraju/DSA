package solutions;

public class Solution30 {
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null)
            return 0;

        int ans = Integer.MAX_VALUE, sum = 0, slow = 0, fast = 0;

        while (fast < nums.length) {
            sum += nums[fast];
            fast++;
            System.out.println(
                    "Sum: " + sum + " Element: " + nums[fast - 1] + " PrevFast: " + (fast - 1) + " CurrFast: " + fast);
            while (sum >= target) {
                ans = Math.min(fast - slow, ans);
                sum -= nums[slow];
                slow++;
                System.out.println("Sum: " + sum + " Ans: " + ans + " PrevSlow: " + (slow - 1) + " CurrSlow: " + slow);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 1, 2, 4, 3 };
        int target1 = 7;
        System.out.println(minSubArrayLen(target1, nums1));
    }
}

/*
 * To solve the Leetcode problem "209. Minimum Size Subarray Sum," we need to
 * find the minimal length of a contiguous subarray of which the sum is greater
 * than or equal to a given target value. If no such subarray exists, we should
 * return zero.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `s`: A positive integer representing the target sum.
 * - `nums`: An array of positive integers.
 * 
 * - **Sample Input**:
 * - `s`: 7
 * - `nums`: [2, 3, 1, 2, 4, 3]
 * 
 * - **Output**:
 * - An integer representing the minimal length of a contiguous subarray whose
 * sum is at least `s`.
 * 
 * - **Sample Output**:
 * - `2` (The subarray [4, 3] has the minimal length that sums to at least 7.)
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use the **sliding window
 * technique**. This allows us to efficiently find the smallest subarray that
 * meets the target sum by dynamically adjusting the window size.
 * 
 * ### Steps:
 * 1. Initialize two pointers (`left` and `right`) to represent the current
 * window's boundaries.
 * 2. Use a variable to keep track of the current sum of elements within the
 * window.
 * 3. Expand the window by moving the right pointer and adding elements to the
 * current sum until it meets or exceeds `s`.
 * 4. Once the current sum is greater than or equal to `s`, attempt to shrink
 * the window from the left side by moving the left pointer right and updating
 * the minimum length.
 * 5. Repeat until you have traversed all elements in `nums`.
 * 
 * ### Time Complexity:
 * - **O(n)**: Each element is processed at most twice (once by each pointer).
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space for variables.
 * 
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `minSubArrayLen` method initializes variables for tracking the minimum
 * length and current sum.
 * 2. It iterates through each element in `nums` using a right pointer.
 * 3. The current sum is updated by adding each element as the right pointer
 * moves.
 * 4. When the current sum meets or exceeds `s`, it updates the minimum length
 * and attempts to shrink the window from the left.
 * 5. Finally, it returns either the minimum length found or zero if no valid
 * subarray exists.
 * 
 * This solution efficiently finds the minimal size subarray that meets or
 * exceeds the target sum and passes all relevant test cases on Leetcode. If you
 * have any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://walkccc.me/LeetCode/problems/209/
 * [2] https://algo.monster/liteproblems/209
 * [3] https://www.youtube.com/watch?v=aYqYMIqZx5s
 * [4] https://prepfortech.io/leetcode-solutions/minimum-size-subarray-sum
 * [5] https://leetcode.ca/all/209.html
 * [6] https://www.youtube.com/watch?v=9UOmXgG4h2U
 * [7] https://www.geeksforgeeks.org/combinational-sum/
 * [8] https://www.youtube.com/watch?v=GBKI9VSKdGg
 */

class Solution_30 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length; // Size of input array
        int minLength = n + 1; // Initialize minLength to a value larger than any possible subarray
        int currentSum = 0; // To keep track of the current sum
        int left = 0; // Left pointer

        for (int right = 0; right < n; right++) {
            currentSum += nums[right]; // Add current number to sum

            // While current sum is greater than or equal to target
            while (currentSum >= s) {
                minLength = Math.min(minLength, right - left + 1); // Update minimum length
                currentSum -= nums[left]; // Subtract element at left pointer from sum
                left++; // Move left pointer to shrink window
            }
        }

        // If minLength was updated, return it; otherwise return 0
        return minLength == n + 1 ? 0 : minLength;
    }
}