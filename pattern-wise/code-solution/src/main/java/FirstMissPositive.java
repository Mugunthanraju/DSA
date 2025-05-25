import java.util.Arrays;

public class FirstMissPositive {

    public static int firstMissingPositive(int[] nums) {
        int result = 1, n = nums.length, temp;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] < n + 1 && nums[nums[i] - 1] != nums[i]) {
                temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i + 1 != nums[i])
                return i + 1;
        }

        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0};
        int[] nums2 = {3, 4, -1, 1};
        int[] nums3 = {7, 8, 9, 11, 12};

        System.out.println("First Missing Positive in " + Arrays.toString(nums1) + " is " + firstMissingPositive(nums1));
        System.out.println("First Missing Positive in " + Arrays.toString(nums2) + " is " + firstMissingPositive(nums2));
        System.out.println("First Missing Positive in " + Arrays.toString(nums3) + " is " + firstMissingPositive(nums3));
    }
}
