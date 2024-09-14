package solutions;

public class Solution5 {
    public static int majorityElement(int[] nums) {
        int candidate = 0, count = 0;

        for (int n : nums) {
            if (count == 0) {
                candidate = n;
                count++;
            } else if (candidate == n) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 }; // 2
        System.out.println(majorityElement(nums));
    }
}

/*
 * To solve the Leetcode problem "169. Majority Element," we need to find the
 * element that appears more than `n/2` times in an array of size `n`.
 * 
 * ## Approach 1: Boyer-Moore Voting Algorithm
 * 
 * The Boyer-Moore Voting Algorithm is an efficient way to find the majority
 * element in an array.
 * 
 * ### Steps:
 * 1. Initialize two variables: `candidate` and `count`. Set `candidate` to the
 * first element of the array and `count` to 1.
 * 2. Iterate through the array starting from the second element:
 * - If the current element is the same as `candidate`, increment `count`.
 * - If the current element is different from `candidate`, decrement `count`.
 * - If `count` becomes 0, update `candidate` to the current element and set
 * `count` to 1.
 * 3. After the loop, `candidate` will hold the potential majority element.
 * 4. Verify if `candidate` is indeed the majority element by counting its
 * occurrences in the array. If the count is greater than `n/2`, return
 * `candidate`.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use only a constant amount of extra space.
 * 
 * ## Approach 2: Sorting
 * 
 * Another approach is to sort the array and return the middle element, as it
 * will be the majority element if it exists.
 * 
 * ### Steps:
 * 1. Sort the input array.
 * 2. Return the middle element of the sorted array.
 * 
 * ### Time Complexity:
 * - **O(n log n)**: The time complexity depends on the sorting algorithm used.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use only a constant amount of extra space.
 * 
 * 
 * The Boyer-Moore Voting Algorithm efficiently finds the majority element in
 * linear time and constant space. If the majority element exists, it will be
 * returned. Otherwise, -1 is returned.
 * 
 * Citations:
 * [1]
 * https://www.enjoyalgorithms.com/blog/find-the-majority-element-in-an-array/
 * [2] https://www.geeksforgeeks.org/majority-element/
 * [3]
 * https://takeuforward.org/data-structure/find-the-majority-element-that-occurs
 * -more-than-n-2-times/
 * [4] https://www.javatpoint.com/majority-element-in-an-array-in-java
 * [5] https://algo.monster/liteproblems/80
 * [6] https://www.youtube.com/watch?v=P1Ic85RarKY
 * [7] https://redquark.org/leetcode/0027-remove-element/
 * [8] https://walkccc.me/LeetCode/problems/27/
 */

class Solution_5 {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        // Find the potential majority element
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Verify if the candidate is indeed the majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return (count > nums.length / 2) ? candidate : -1;
    }
}