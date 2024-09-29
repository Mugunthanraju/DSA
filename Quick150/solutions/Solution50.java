package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution50 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        // Add intervals into result intervals[i][start] < newInterval[start]
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge the overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // Add the new Interval
        result.add(newInterval);

        // Add the rest other intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert ArrayList to Array and return it.
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = { { 1, 3 }, { 6, 9 } };
        int[] newInterval1 = { 2, 5 };
        // [[1, 5], [6, 9]]
        System.out.println(Arrays.deepToString(insert(intervals1, newInterval1)));
        int[][] intervals2 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval2 = { 4, 8 };
        // [[1, 2], [3, 10], [12, 16]]
        System.out.println(Arrays.deepToString(insert(intervals2, newInterval2)));
    }
}

/*
 * To solve the Leetcode problem "57. Insert Interval," we need to insert a new
 * interval into a list of existing non-overlapping intervals while ensuring
 * that the resulting list remains sorted and free of overlaps.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - A list of non-overlapping intervals `intervals`, where each interval is
 * represented as an array `[start, end]`.
 * - A new interval `newInterval` that needs to be inserted.
 * 
 * - **Sample Input**:
 * - `intervals`: `[[1,3],[6,9]]`
 * - `newInterval`: `[2,5]`
 * 
 * - **Output**:
 * - A list of intervals after inserting `newInterval`.
 * 
 * - **Sample Output**:
 * - `[[1,5],[6,9]]`
 * - Explanation: The new interval `[2,5]` overlaps with `[1,3]`, so they are
 * merged.
 * 
 * ## Approach
 * 
 * The approach involves the following steps:
 * 
 * 1. **Initialize a Result List**: Create a list to hold the merged intervals.
 * 2. **Add Intervals Before the New Interval**: Iterate through the existing
 * intervals and add any intervals that end before the new interval starts.
 * 3. **Merge Overlapping Intervals**: For intervals that overlap with the new
 * interval, update the start and end of the new interval to encompass all
 * overlapping intervals.
 * 4. **Add the Merged Interval**: After processing overlaps, add the merged new
 * interval to the result.
 * 5. **Add Remaining Intervals**: Finally, add any remaining intervals that
 * start after the new interval ends.
 * 
 * ### Time Complexity:
 * - **O(n)**: We traverse the list of intervals once.
 * 
 * ### Space Complexity:
 * - **O(n)**: For storing the result list in the worst case.
 * 
 * 
 * ### Explanation of the Code:
 * 1. The `insert` method initializes a list to hold the merged intervals.
 * 2. It iterates through each existing interval:
 * - If an interval ends before the new interval starts, it is added directly to
 * the result.
 * - If there is an overlap (i.e., if it starts before or when the new interval
 * ends), it merges by updating the start and end of `newInterval`.
 * - If there is no overlap and `newInterval` has been processed, it adds it to
 * the result and moves on to add the current interval.
 * 3. Finally, it adds any remaining merged `newInterval` to the result and
 * converts it back from a list to an array format before returning.
 * 
 * This solution efficiently inserts a new interval into a sorted list of
 * non-overlapping intervals and passes all relevant test cases on Leetcode. If
 * you have any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://blog.seancoughlin.me/mastering-leetcodes-insert-interval-a-
 * comprehensive-guide
 * [2]
 * https://github.com/doocs/leetcode/blob/main/solution/0000-0099/0057.Insert%
 * 20Interval/README_EN.md
 * [3] https://walkccc.me/LeetCode/problems/57/
 * [4] https://algo.monster/liteproblems/56
 * [5] https://www.geeksforgeeks.org/merging-intervals/
 * [6] https://www.youtube.com/watch?v=g-x-mlnJxhE
 * [7] https://walkccc.me/LeetCode/problems/56/
 * [8] https://www.youtube.com/watch?v=A8NUOmlwOlM
 */

class Solution_50 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        // Add all intervals ending before newInterval starts
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            }
            // Add and merge all overlapping intervals
            else if (interval[0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], interval[0]); // Update start
                newInterval[1] = Math.max(newInterval[1], interval[1]); // Update end
            }
            // No overlap, we can add the current interval
            else {
                result.add(newInterval);
                newInterval = interval; // Move to next interval
            }
        }

        // Add the last processed interval
        result.add(newInterval);

        // Convert List<int[]> back to int[][]
        return result.toArray(new int[result.size()][]);
    }
}