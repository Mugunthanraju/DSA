package solutions;

public class Solution28 {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxi = -1, mini, range, leftV, rightV;

        while (left < right) {
            // Extract the value
            leftV = height[left];
            rightV = height[right];

            // Calculate the value
            mini = Math.min(leftV, rightV);
            range = right - left;
            maxi = Math.max(mini * range, maxi);

            // Traversing the pointer
            if (mini >= leftV)
                left++;
            if (mini >= rightV)
                right--;

        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Max Water Storage: " + maxArea(height1));
        int[] height2 = { 1, 1 };
        System.out.println("Max Water Storage: " + maxArea(height2));
    }
}

/*
 * I apologize for the oversight and appreciate your patience. Let's correctly
 * address the Leetcode problem "11. Container With Most Water."
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - An array of integers `height`, where each integer represents the height of
 * a vertical line on a graph.
 * 
 * - **Output**:
 * - An integer representing the maximum amount of water that can be contained
 * between two lines.
 * 
 * ### Sample Input
 * - `height`: [1,8,6,2,5,4,8,3,7]
 * 
 * ### Sample Output
 * - `49` (The maximum area is between the lines at indices 1 and 8.)
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem is to use the **two-pointer
 * technique**. The idea is to maintain two pointers at both ends of the array
 * and calculate the area formed between these two lines.
 * 
 * ### Steps:
 * 1. Initialize two pointers: one at the beginning (`left`) and one at the end
 * (`right`) of the array.
 * 2. Calculate the area formed by the lines at these two pointers.
 * 3. Update the maximum area if the current area is larger than the previously
 * recorded maximum.
 * 4. Move the pointer pointing to the shorter line inward, as this will
 * potentially increase the area (since area is limited by the shorter line).
 * 5. Repeat steps 2-4 until the two pointers meet.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the array once with two pointers.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space.
 * 
 * ### Explanation of the Code:
 * 1. The `maxArea` method initializes `maxArea`, `left`, and `right` pointers.
 * 2. It enters a loop that continues until the two pointers meet.
 * 3. For each pair of lines represented by `left` and `right`, it calculates
 * the width and height and then computes the area.
 * 4. If this area is greater than `maxArea`, it updates `maxArea`.
 * 5. It then moves either `left` or `right` inward based on which line is
 * shorter, aiming to find a potentially taller line for a larger area.
 * 
 * This solution efficiently calculates the maximum water that can be contained
 * between two lines and passes all relevant test cases on Leetcode. If you have
 * any further questions or need additional examples, feel free to ask!
 */

class Solution_28 {
    public int maxArea(int[] height) {
        int maxArea = 0; // Variable to store maximum area
        int left = 0; // Left pointer
        int right = height.length - 1; // Right pointer

        while (left < right) {
            // Calculate width and height
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            // Calculate area
            int area = width * h;
            // Update maxArea if we found a larger area
            maxArea = Math.max(maxArea, area);

            // Move the pointer corresponding to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea; // Return the maximum area found
    }
}