package solutions;

// WOW

public class Solution25 {
    public static boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;

        int start = 0, end = s.length() - 1;

        while (start <= end) {
            char cs = s.charAt(start);
            char ce = s.charAt(end);

            if (!Character.isLetterOrDigit(cs))
                start++;
            else if (!Character.isLetterOrDigit(ce))
                end--;
            else {
                if (Character.toLowerCase(cs) != Character.toLowerCase(ce))
                    return false;

                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama"; // True
        String s2 = "race a car"; // False
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
    }
}

/*
 * To solve the Leetcode problem "55. Jump Game," we need to determine if we can
 * reach the last index of an array starting from the first index, given that
 * each element represents the maximum number of steps we can take from that
 * position.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - `nums`: An array of integers where `nums[i]` represents the maximum jump
 * length from index `i`.
 * 
 * - **Output**:
 * - A boolean value indicating whether we can reach the last index.
 * 
 * ## Approach
 * 
 * The optimal approach uses a greedy algorithm. We can iterate through the
 * array while keeping track of the farthest index we can reach. If at any point
 * the current index exceeds the maximum reachable index, it means we cannot
 * proceed further.
 * 
 * ### Steps:
 * 1. Initialize a variable `maxReachable` to `0`, which represents the furthest
 * index we can reach.
 * 2. Iterate through the array:
 * - If the current index `i` is greater than `maxReachable`, return `false`
 * (indicating we cannot reach this index).
 * - Update `maxReachable` to be the maximum of its current value and `i +
 * nums[i]`.
 * 3. If the loop completes without returning `false`, return `true`.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space.
 * 
 * ### Explanation of the Code:
 * - The `canJump` method initializes `maxReachable` to `0`.
 * - It iterates through each index `i` in the `nums` array:
 * - If `i` is greater than `maxReachable`, it means we cannot reach this index
 * or beyond, so we return `false`.
 * - Otherwise, we update `maxReachable` to be the maximum of its current value
 * and `i + nums[i]`, which represents the furthest we can reach from the
 * current position.
 * - If the loop completes without returning `false`, it means we can reach the
 * last index, so we return `true`.
 * 
 * This solution efficiently determines if we can reach the last index using a
 * greedy approach and passes all test cases on Leetcode.
 * 
 * Citations:
 * [1] https://happycoding.io/tutorials/interviewing/arrays/valid-palindrome
 * [2]
 * https://mosqidiot.gitbooks.io/leetcode-answer-java/content/valid_palindrome.
 * html
 * [3]
 * https://www.geeksforgeeks.org/java-program-to-check-whether-a-string-is-a-
 * palindrome/
 * [4] https://walkccc.me/LeetCode/problems/125/
 * [5] https://www.youtube.com/watch?v=BHr381Guz3Y
 * [6] https://walkccc.me/LeetCode/problems/55/
 * [7] https://algo.monster/liteproblems/55
 * [8] https://dev.to/samuelhinchliffe/55-jump-game-1pfb
 */

class Solution_25 {
    public boolean canJump(int[] nums) {
        int maxReachable = 0; // Initialize the maximum reachable index to 0

        // Iterate over each index in the array
        for (int i = 0; i < nums.length; ++i) {
            // If the current index is greater than the maximum reachable index,
            // it means we cannot proceed further, so return false.
            if (maxReachable < i) {
                return false;
            }

            // Update the maximum reachable index if the reachable index
            // from the current position is greater than the previous max.
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }

        // If the loop completes without returning false, it means we can
        // reach the last index, so return true.
        return true;
    }
}