import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if (len > 1) {
            // [1,2,3,4,5,6,7]
            reverse(nums, 0, len - 1);
            // [7,6,5,4,3,2,1]
            reverse(nums, 0, k - 1);
            // [5,6,7,4,3,2,1]
            reverse(nums, k, len - 1);
            // [5,6,7,1,2,3,4]
        }
    }

    public static void reverse(int[] n, int start, int end) {
        while(start < end) {
            swappy(n, start, end);
            start++;
            end--;
        }
    }

    public static void swappy(int[] n, int l, int r) {
        int temp = n[l];
        n[l] = n[r];
        n[r] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {-1, -100, 3, 99};
        System.out.println("Before: " + Arrays.toString(nums1));
        rotate(nums1, 3);
        System.out.println("After : " + Arrays.toString(nums1));
        System.out.println("Before: " + Arrays.toString(nums2));
        rotate(nums2, 2);
        System.out.println("After : " + Arrays.toString(nums2));
    }
}
