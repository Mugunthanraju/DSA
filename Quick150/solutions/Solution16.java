package solutions;

public class Solution16 {

    public static int trap(int[] height) {

        int n = height.length;
        if (n < 1)
            return 0;

        // two pointers
        int head = 0, tail = n - 1;
        // To check which is max value
        int maxLeft = height[head], maxRight = height[tail];
        // Total unit of water
        int units = 0;

        while (head < tail) {
            maxLeft = Math.max(maxLeft, height[head]);
            maxRight = Math.max(maxRight, height[tail]);

            if (maxLeft < maxRight) {
                units += (maxLeft - height[head]);
                ++head;
            } else {
                units += (maxRight - height[tail]);
                --tail;
            }
        }
        return units;
    }

    public static void main(String[] args) {
        int[] heights1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(heights1)); // 6
        int[] heights2 = { 4, 2, 0, 3, 2, 5 };
        System.out.println(trap(heights2)); // 9
    }
}

/*
 * To solve the Leetcode problem "42. Trapping Rain Water," we need to calculate
 * how much water can be trapped after raining, given an elevation map
 * represented by an array of non-negative integers.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - An array of non-negative integers representing the elevation map where the
 * width of each bar is 1.
 * 
 * - **Sample Input**:
 * - `height = [0,1,0,2,1,0,1,3,2,1,2,1]`
 * 
 * - **Output**:
 * - An integer representing the total units of water that can be trapped.
 * 
 * - **Sample Output**:
 * - `6`
 * - Explanation: The water trapped is represented by the blue sections in the
 * diagram.
 * 
 * ## Approach
 * 
 * The most efficient way to solve this problem is to use a two-pointer
 * technique. This method allows us to calculate the trapped water in linear
 * time while using constant space.
 * 
 * ### Steps:
 * 1. **Initialize Pointers and Variables**:
 * - Use two pointers (`left` and `right`) at the beginning and end of the
 * array.
 * - Maintain two variables to track the maximum heights on both sides
 * (`leftMax` and `rightMax`).
 * - Initialize a variable to accumulate the total trapped water.
 * 
 * 2. **Iterate Until Pointers Meet**:
 * - Compare `height[left]` and `height[right]`:
 * - If `height[left]` is less than or equal to `height[right]`, check if it can
 * trap water:
 * - If `height[left] >= leftMax`, update `leftMax`.
 * - Otherwise, calculate the trapped water as `leftMax - height[left]` and add
 * it to the total.
 * - Move the left pointer right.
 * - If `height[right]` is less than `height[left]`, do similar checks for the
 * right side:
 * - If `height[right] >= rightMax`, update `rightMax`.
 * - Otherwise, calculate the trapped water as `rightMax - height[right]` and
 * add it to the total.
 * - Move the right pointer left.
 * 
 * 3. **Return Total Water**: After processing all elements, return the total
 * accumulated water.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse each element once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space for pointers and max
 * height variables.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `trap` method initializes pointers and max height variables.
 * 2. It iterates through the elevation map using a while loop until both
 * pointers meet.
 * 3. Depending on which side has a smaller height, it updates either the left
 * or right max height and calculates any trapped water accordingly.
 * 4. Finally, it returns the total amount of trapped water.
 * 
 * This solution efficiently computes how much rainwater can be trapped based on
 * the elevation map and passes all relevant test cases on Leetcode. If you have
 * any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://www.youtube.com/watch?v=4Y7irecfvLM
 * [2]
 * https://github.com/azl397985856/leetcode/blob/master/problems/42.trapping-
 * rain-water.en.md
 * [3] https://www.youtube.com/watch?v=ZI2z5pq0TqA
 * [4] https://takeuforward.org/data-structure/trapping-rainwater/
 * [5] https://walkccc.me/LeetCode/problems/42/
 * [6] https://www.youtube.com/watch?v=g-x-mlnJxhE
 * [7] https://algo.monster/liteproblems/56
 * [8] https://www.youtube.com/watch?v=A8NUOmlwOlM
 */

class Solution_16 {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater; // Return total trapped water
    }
}