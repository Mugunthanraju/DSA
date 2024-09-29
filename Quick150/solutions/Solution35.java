package solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution35 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        /*
         * rn = Row Min
         * rx = Row Max
         * cn = Col Min
         * cx = Col Max
         */

        int rows = matrix.length, cols = matrix[0].length;

        int rn = 0, cn = 0, rx = rows - 1, cx = cols - 1, i;

        List<Integer> answer = new ArrayList<>();

        while (rn <= rx && cn <= cx) {

            // Right
            for (i = cn; i <= cx; i++)
                answer.add(matrix[rn][i]);
            rn++;

            // Down
            for (i = rn; i <= rx; i++)
                answer.add(matrix[i][cx]);
            cx--;

            // Condition : If we have all the elements then break from loop
            if (answer.size() == rows * cols)
                break;

            // Left
            for (i = cx; i >= cn; i--)
                answer.add(matrix[rx][i]);
            rx--;

            // Up
            for (i = rx; i >= rn; i--)
                answer.add(matrix[i][cn]);
            cn++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(spiralOrder(matrix1));

        int[][] matrix2 = {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 }
        };
        // [5, 1, 9, 11, 10, 7, 16, 12, 14, 15, 13, 2, 4, 8, 6, 3]
        System.out.println(spiralOrder(matrix2));
    }
}

/*
 * To solve the Leetcode problem "54. Spiral Matrix," we need to traverse a
 * given `m x n` matrix in a spiral order and return the elements in the order
 * they were visited.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - A 2D array (matrix) of integers.
 * 
 * - **Sample Input**:
 * - `matrix`:
 * ```
 * [
 * [1, 2, 3],
 * [4, 5, 6],
 * [7, 8, 9]
 * ]
 * ```
 * 
 * - **Output**:
 * - A list of integers representing the elements of the matrix in spiral order.
 * 
 * - **Sample Output**:
 * - `[1, 2, 3, 6, 9, 8, 7, 4, 5]`
 * 
 * ## Approach
 * 
 * The approach to solve this problem involves simulating the process of
 * traversing the matrix in a spiral pattern. We can achieve this by maintaining
 * four boundaries: top, bottom, left, and right. We will iterate over the
 * matrix in the following order:
 * 
 * 1. Traverse from left to right along the top boundary.
 * 2. Traverse from top to bottom along the right boundary.
 * 3. Traverse from right to left along the bottom boundary (if applicable).
 * 4. Traverse from bottom to top along the left boundary (if applicable).
 * 5. Adjust the boundaries after each traversal and repeat until all elements
 * are processed.
 * 
 * ### Steps:
 * 1. Initialize four boundaries: `top`, `bottom`, `left`, and `right`.
 * 2. Use a loop to traverse the matrix while updating these boundaries.
 * 3. Append elements to a result list during each traversal.
 * 4. Return the result list once all elements have been added.
 * 
 * ### Time Complexity:
 * - **O(m * n)**: We traverse each element of the matrix exactly once.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use a constant amount of extra space for variables (not
 * counting the output list).
 * 
 * ### Explanation of the Code:
 * 1. The method initializes boundaries and checks for an empty matrix.
 * 2. It enters a loop that continues until all boundaries overlap.
 * 3. Inside the loop, it performs four traversals: left-to-right,
 * top-to-bottom, right-to-left, and bottom-to-top while adjusting the
 * corresponding boundary after each traversal.
 * 4. Finally, it returns the list containing elements in spiral order.
 * 
 * This solution efficiently traverses the matrix in spiral order and passes all
 * relevant test cases on Leetcode. If you have any further questions or need
 * additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://algo.monster/liteproblems/54
 * [2] https://www.youtube.com/watch?v=aqVW8IuXUF0
 * [3] https://sewb.dev/posts/leetcode-54:-spiral-matrix-solution-
 * cl2bqnl6s0009kgru1xt6ev3e
 * [4] https://takeuforward.org/data-structure/spiral-traversal-of-matrix/
 * [5] https://algo.monster/liteproblems/48
 * [6] https://www.youtube.com/watch?v=BJnMZNwUk1M
 * [7] https://www.youtube.com/watch?v=Ux058jpRB9Y
 * [8] https://walkccc.me/LeetCode/problems/54/
 */

class Solution_35 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0)
            return result; // Handle empty matrix

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move down to next row

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move left to next column

            if (top <= bottom) { // Check if there are rows remaining
                // Traverse from right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move up to previous row
            }

            if (left <= right) { // Check if there are columns remaining
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move right to next column
            }
        }

        return result; // Return the collected elements in spiral order
    }
}