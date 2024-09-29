package solutions;

import java.util.Arrays;

public class Solution36 {

    private static void reverseMatrix(int[][] matrix) {
        int top = 0, down = matrix.length - 1;

        while (top < down) {
            int[] tempo = matrix[top];
            matrix[top++] = matrix[down];
            matrix[down--] = tempo;
        }
    }

    private static void swapMatrix(int[][] matrix) {
        int i, j, temp;

        for (i = 0; i < matrix.length; i++) {
            for (j = i + 1; j < matrix[i].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void rotate(int[][] matrix) {
        /*
         * Rotate 90 : reverse -> swap
         * Anti-Rotate 90 : swap -> reverse
         */

        // Rotate 90
        reverseMatrix(matrix);
        swapMatrix(matrix);

        // Anti-Rotate 90
        // swapMatrix(matrix);
        // reverseMatrix(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        rotate(matrix1);
        // [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 }
        };

        rotate(matrix2);
        // [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]
        System.out.println(Arrays.deepToString(matrix2));
    }
}

/*
 * To solve the Leetcode problem "48. Rotate Image," we need to rotate a given
 * `n x n` 2D matrix (representing an image) by 90 degrees clockwise in-place.
 * This means we should modify the input matrix directly without using any
 * additional space for another matrix.
 * 
 * ## Problem Breakdown
 * 
 * - **Input**:
 * - A 2D array `matrix` of size `n x n`.
 * 
 * - **Sample Input**:
 * - `matrix`: `[[1,2,3],[4,5,6],[7,8,9]]`
 * 
 * - **Output**:
 * - The rotated matrix.
 * 
 * - **Sample Output**:
 * - `[[7,4,1],[8,5,2],[9,6,3]]`
 * 
 * ## Approach
 * 
 * The optimal approach to rotate the matrix involves two main steps:
 * 
 * 1. **Transpose the Matrix**: Swap elements across the diagonal. This step
 * transforms the rows into columns.
 * 2. **Reverse Each Row**: After transposing, reverse each row to achieve the
 * final rotated state.
 * 
 * ### Steps:
 * 1. **Transpose**: For each element at position `(i, j)`, swap it with the
 * element at `(j, i)`.
 * 2. **Reverse Rows**: For each row in the matrix, reverse the elements.
 * 
 * ### Time Complexity:
 * - **O(n^2)**: We traverse each element of the matrix twice (once for
 * transposing and once for reversing).
 * 
 * ### Space Complexity:
 * - **O(1)**: We are modifying the matrix in place without using additional
 * data structures.
 * 
 * ### Explanation of the Code:
 * 1. The `rotate` method first calculates the size of the matrix (`n`).
 * 2. It then performs a nested loop to transpose the matrix by swapping
 * elements across the diagonal.
 * 3. After transposing, it reverses each row by swapping elements from both
 * ends towards the center.
 * 
 * This solution efficiently rotates the image represented by the input matrix
 * by 90 degrees clockwise and meets all problem constraints. If you have any
 * further questions or need additional examples, feel free to ask!
 * 
 * Citations:
 * [1]
 * https://github.com/doocs/leetcode/blob/main/solution/0000-0099/0048.Rotate%
 * 20Image/README_EN.md
 * [2] https://www.youtube.com/watch?v=Ux058jpRB9Y
 * [3] https://algo.monster/liteproblems/48
 * [4] https://walkccc.me/LeetCode/problems/48/
 * [5] https://dev.to/rohithv07/leetcode-48-rotate-image-4kmo
 * [6] https://algo.monster/liteproblems/567
 * [7] https://www.youtube.com/watch?v=jSto0O4AJbM
 * [8] https://www.geeksforgeeks.org/length-of-the-longest-substring-without-
 * repeating-characters/
 */

class Solution_36 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap elements at (i,j) and (j,i)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                // Swap elements at (i,j) and (i,n-j-1)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}