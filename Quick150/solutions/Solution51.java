package solutions;

import java.util.Arrays;

public class Solution51 {

    public static int findMinArrowShots(int[][] points) {

        int n = points.length, arrow, end, i;

        if (n < 2)
            return n;

        // Sort the points by the end value.
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        // Put an arrow at the end of 1st point.
        arrow = 1;
        end = points[0][1];

        // from the 2-nd point,
        // we check whether the current arrow pass through the current point,
        // if not add an arrow, put it at the end of the current point
        for (i = 1; i < n; i++) {
            if (end < points[i][0]) {
                arrow++;
                end = points[i][1];
            }
        }
        return arrow;
    }

    public static void main(String[] args) {
        int[][] points1 = {
                { 3, 9 },
                { 7, 12 },
                { 3, 8 },
                { 6, 8 },
                { 9, 10 },
                { 2, 9 },
                { 0, 9 },
                { 3, 9 },
                { 0, 6 },
                { 2, 8 }
        };
        System.out.println(findMinArrowShots(points1)); // 2
        int[][] points2 = {
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 4, 5 }
        };
        System.out.println(findMinArrowShots(points2)); // 2
        int[][] points3 = {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 },
                { 7, 8 }
        };
        System.out.println(findMinArrowShots(points3)); // 4
        int[][] points4 = {
                { 10, 16 },
                { 2, 8 },
                { 1, 6 },
                { 7, 12 }
        };
        System.out.println(findMinArrowShots(points4)); // 2
    }
}

/*
 * To solve the Leetcode problem
 * "452. Minimum Number of Arrows to Burst Balloons," we need to determine the
 * minimum number of arrows required to burst all balloons represented by their
 * start and end coordinates on a horizontal line.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - An array of intervals `points`, where each interval is represented as
 * `[xstart, xend]`.
 * 
 * - **Output**:
 * - An integer representing the minimum number of arrows needed to burst all
 * balloons.
 * 
 * ### Example:
 * - **Input**: `points = [[10,16],[2,8],[1,6],[7,12]]`
 * - **Output**: `2`
 * - Explanation: One arrow can burst balloons in the interval `[1,6]` and
 * another can burst those in `[7,12]`.
 * 
 * ## Approach
 * 
 * The optimal approach involves using a greedy algorithm:
 * 
 * 1. **Sort the Intervals**: First, sort the intervals based on their end
 * coordinates. This allows us to efficiently determine overlaps.
 * 
 * 2. **Iterate Through the Intervals**: Initialize a variable to keep track of
 * the end of the last arrow shot. For each balloon:
 * - If the start of the current balloon is greater than the end of the last
 * arrow shot, it means we need to shoot a new arrow.
 * - Update the position of the last arrow shot to be at the end of the current
 * balloon if they overlap.
 * 
 * 3. **Count Arrows**: Maintain a count of arrows shot and return this count at
 * the end.
 * 
 * ### Time Complexity:
 * - **O(n log n)**: Due to sorting the intervals.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space (excluding input and
 * output).
 * 
 * ### Explanation of the Code:
 * 1. The `findMinArrowShots` method initializes an arrow count and sorts the
 * input intervals based on their end coordinates.
 * 2. It iterates through each balloon:
 * - If there is an overlap with the last arrow's position, it continues without
 * incrementing the arrow count.
 * - If there is no overlap, it increments the arrow count and updates the
 * position of the last arrow.
 * 3. Finally, it returns the total number of arrows needed.
 * 
 * This solution efficiently calculates the minimum number of arrows required to
 * burst all balloons and passes all relevant test cases on Leetcode. If you
 * have any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1]
 * https://prepfortech.io/leetcode-solutions/minimum-number-of-arrows-to-burst-
 * balloons
 * [2]
 * https://dev.to/rohithv07/452-minimum-number-of-arrows-to-burst-balloons-2ac5
 * [3] https://www.youtube.com/watch?v=9UOmXgG4h2U
 * [4] https://www.youtube.com/watch?v=g-x-mlnJxhE
 * [5] https://www.youtube.com/watch?v=P0BT1xA2tIg
 * [6] https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
 * [7]
 * https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-
 * sum-exists-in-array/
 * [8] https://www.youtube.com/watch?v=ZHJDwbfqoa8
 */

class Solution_51 {
    public int findMinArrowShots(int[][] points) {
        // Edge case: if there are no points
        if (points.length == 0) {
            return 0;
        }

        // Sort intervals based on their end coordinates
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // Start with one arrow
        int currentEnd = points[0][1]; // End of the first balloon

        for (int i = 1; i < points.length; i++) {
            // If there is an overlap
            if (points[i][0] <= currentEnd) {
                continue; // No new arrow needed
            } else {
                arrows++; // Need a new arrow
                currentEnd = points[i][1]; // Update current end
            }
        }

        return arrows; // Return total arrows used
    }
}