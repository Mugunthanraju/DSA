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
