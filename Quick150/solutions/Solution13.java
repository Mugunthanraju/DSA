package solutions;

import java.util.Arrays;

class Solution13 {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = n - 1; i > -1; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(productExceptSelf(numbers))); // {24,12,8,6}
    }
}
