package solutions;

import java.util.Arrays;

public class Solution37 {

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length, r, c;
        boolean isRow0 = false, isCol0 = false;

        // To find first column has Zero (0)
        for (r = 0; r < rows; r++) {
            if (matrix[r][0] == 0) {
                isCol0 = true;
                break;
            }
        }

        // To find first row has Zero (0)
        for (c = 0; c < cols; c++) {
            if (matrix[0][c] == 0) {
                isRow0 = true;
                break;
            }
        }

        // Use first row and first column as markers for zero
        for (r = 1; r < rows; r++) {
            for (c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // Zero out cells based on markers
        for (r = 1; r < rows; r++) {
            for (c = 1; c < cols; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // Zero out the first row if needed
        if (isRow0) {
            for (c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }

        // Zero out the first column if needed
        if (isCol0) {
            for (r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        setZeroes(matrix1);
        /*
         * [
         * [1,0,1],
         * [0,0,0],
         * [1,0,1]
         * ]
         */
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
        };
        setZeroes(matrix2);
        /*
         * [
         * [0,0,0,0],
         * [0,4,5,0],
         * [0,3,1,0]
         * ]
         */
        System.out.println(Arrays.deepToString(matrix2));
    }
}

/*
 * To solve the Leetcode problem "73. Set Matrix Zeroes," we need to modify a
 * given 2D matrix such that if any cell contains the value `0`, then all cells
 * in the same row and column as that `0` are set to `0`. The challenge is to
 * perform this operation in place, using constant space.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - A 2D matrix of integers.
 * 
 * - **Sample Input**:
 * - `matrix`:
 * ```
 * [
 * [1, 1, 1],
 * [1, 0, 1],
 * [1, 1, 1]
 * ]
 * ```
 * 
 * - **Output**:
 * - The modified matrix after setting the appropriate rows and columns to zero.
 * 
 * - **Sample Output**:
 * ```
 * [
 * [1, 0, 1],
 * [0, 0, 0],
 * [1, 0, 1]
 * ]
 * ```
 * 
 * ## Approach
 * 
 * The optimal approach to solve this problem involves using the first row and
 * first column of the matrix as markers to indicate which rows and columns
 * should be set to zero. Here’s how it works:
 * 
 * ### Steps:
 * 1. **Initialize Flags**: Use two boolean variables to determine if the first
 * row and first column need to be zeroed.
 * 2. **Mark Rows and Columns**: Traverse the matrix (excluding the first row
 * and column) and mark the first cell of each row and column if a `0` is found.
 * 3. **Zero Out Rows and Columns**: Using the markers in the first row and
 * column, set the corresponding rows and columns to zero.
 * 4. **Handle First Row and Column**: Finally, check if the first row or first
 * column should be zeroed based on the flags.
 * 
 * ### Time Complexity:
 * - **O(m * n)**: We traverse the matrix a few times.
 * 
 * ### Space Complexity:
 * - **O(1)**: We use constant space for variables.
 * 
 * ### Explanation of the Code:
 * 1. The `setZeroes` method initializes flags for checking whether the first
 * row and column should be zeroed.
 * 2. It checks each element in the first row and column to set these flags.
 * 3. It then iterates through the rest of the matrix, marking rows and columns
 * in the first cell when a `0` is found.
 * 4. After marking, it sets elements to `0` based on these markers.
 * 5. Finally, it checks whether to zero out the entire first row or column
 * based on the initial flags.
 * 
 * This solution efficiently modifies the matrix in place according to the
 * specified requirements and passes all relevant test cases on Leetcode. If you
 * have any further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1] https://www.geeksforgeeks.org/set-entire-matrix-row-and-column-as-zeroes/
 * [2] https://takeuforward.org/data-structure/set-matrix-zero/
 * [3] https://algo.monster/liteproblems/73
 * [4] https://www.youtube.com/watch?v=N0MgLvceX7M
 * [5] https://www.youtube.com/watch?v=cRBSOz49fQk
 * [6] https://fizzbuzzed.com/top-interview-questions-1/
 * [7] https://www.geeksforgeeks.org/combinational-sum/
 * [8] https://www.youtube.com/watch?v=9UOmXgG4h2U
 */

class Solution_37 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false; // Flag for first row
        boolean firstColZero = false; // Flag for first column

        // Determine if the first row needs to be zeroed
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Determine if the first column needs to be zeroed
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row and column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark corresponding row
                    matrix[0][j] = 0; // Mark corresponding column
                }
            }
        }

        // Zero out cells based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out the first row if needed
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Zero out the first column if needed
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
