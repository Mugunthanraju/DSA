import java.util.Arrays;

// LC : 26. Remove Duplicates from Sorted Array
public class RemoveDuplicatesSort {
    public static int removeDuplicates(int[] nums){
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] == nums[right])
                right++;
            else {
                nums[++left] = nums[right++];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        System.out.println("Before removing duplicates: " + Arrays.toString(nums1));
        int[] ans1 = Arrays.copyOf(nums1, removeDuplicates(nums1));
        System.out.println("After removing duplicates : " + Arrays.toString(ans1));
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Before removing duplicates: " + Arrays.toString(nums2));
        int[] ans2 = Arrays.copyOf(nums2, removeDuplicates(nums2));
        System.out.println("After removing duplicates : " + Arrays.toString(ans2));
    }
}
