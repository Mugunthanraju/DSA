import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int current = 1, len = nums.length, i;
        int[] ans = new int[len];

        // Prefix
        for (i = 0; i < len; i++) {
            ans[i] = current;
            current *= nums[i];
        }

        // Suffix
        current = 1;
        for (i = len - 1; i > -1; i--) {
            ans[i] *= current;
            current *= nums[i];
        }

        /*
            [1,2,3,4]
            [1,1,2,6]
            [24,12,8,6]
        */
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Before Product: " + Arrays.toString(nums1));
        System.out.println("After Product : " + Arrays.toString(productExceptSelf(nums1)));
        System.out.println("Before Product: " + Arrays.toString(nums2));
        System.out.println("After Product : " + Arrays.toString(productExceptSelf(nums2)));
    }
}
