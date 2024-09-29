package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution49 {

    public static int[][] merge(int[][] intervals) {

        int i, n = intervals.length;

        if (n < 2)
            return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];

        for (i = 1; i < n; i++) {

            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        list.add(new int[] { start, end });

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        // [[1,6],[8,10],[15,18]]
        System.out.println(Arrays.deepToString(merge(intervals1)));
        int[][] intervals2 = { { 1, 4 }, { 4, 5 } };
        // [[1,5]]
        System.out.println(Arrays.deepToString(merge(intervals2)));
        int[][] intervals3 = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        // [[1,5]]
        System.out.println(Arrays.deepToString(merge(intervals3)));
    }
}

/*
 * To solve the Leetcode problem "56. Merge Intervals," we need to merge
 * overlapping intervals from a given list of intervals and return a new list of
 * non-overlapping intervals.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - An array of intervals, where each interval is represented as an array of
 * two integers `[start, end]`.
 * 
 * - **Sample Input**:
 * - `intervals`: `[[1,3],[2,6],[8,10],[15,18]]`
 * 
 * - **Output**:
 * - A list of merged intervals.
 * 
 * - **Sample Output**:
 * - `[[1,6],[8,10],[15,18]]`
 * - Explanation: The intervals `[1,3]` and `[2,6]` overlap and are merged into
 * `[1,6]`.
 * 
 * ## Approach
 * 
 * The optimal approach involves the following steps:
 * 
 * 1. **Sort the Intervals**: First, sort the list of intervals based on their
 * start times. This allows us to easily identify overlaps.
 * 
 * 2. **Merge Intervals**: Initialize a new list to hold the merged intervals.
 * Iterate through the sorted intervals and compare each interval with the last
 * added interval in the merged list:
 * - If there is an overlap (i.e., the start of the current interval is less
 * than or equal to the end of the last merged interval), merge them by updating
 * the end of the last merged interval to be the maximum of both ends.
 * - If there is no overlap, simply add the current interval to the merged list.
 * 
 * 3. **Return Result**: After processing all intervals, return the merged list.
 * 
 * ### Time Complexity:
 * - **O(n log n)**: Due to sorting the intervals.
 * 
 * ### Space Complexity:
 * - **O(n)**: For storing the merged intervals.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `merge` method first checks for edge cases where there are no
 * intervals.
 * 2. It sorts the input array based on start times using a custom comparator.
 * 3. It initializes a list to hold merged intervals and starts with the first
 * interval.
 * 4. It iterates through each subsequent interval and checks for overlaps:
 * - If overlapping, it merges by updating the end time.
 * - If not overlapping, it adds the current interval to the merged list and
 * moves on.
 * 5. Finally, it adds any remaining interval and converts the result from a
 * list back to an array format before returning.
 * 
 * This solution efficiently merges overlapping intervals and passes all
 * relevant test cases on Leetcode. If you have any further questions or need
 * additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://algo.monster/liteproblems/56
 * [2] https://www.geeksforgeeks.org/merging-intervals/
 * [3] https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
 * [4] https://walkccc.me/LeetCode/problems/56/
 * [5] https://www.youtube.com/watch?v=44H3cEC2fFM
 * [6] https://www.youtube.com/watch?v=HCbKvBOlMVI
 * [7] https://www.youtube.com/watch?v=dzNIPX7HY6A
 * [8] https://www.youtube.com/watch?v=ZHJDwbfqoa8
 */

class Solution_49 {
    public int[][] merge(int[][] intervals) {
        // Edge case: if there are no intervals
        if (intervals.length == 0) {
            return new int[0][0];
        }

        // Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0]; // Start with the first interval

        for (int i = 1; i < intervals.length; i++) {
            // If there is an overlap
            if (intervals[i][0] <= currentInterval[1]) {
                // Merge by updating the end time
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // No overlap, add the current interval to merged list
                merged.add(currentInterval);
                currentInterval = intervals[i]; // Move to next interval
            }
        }

        // Add the last processed interval
        merged.add(currentInterval);

        // Convert List<int[]> back to int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}