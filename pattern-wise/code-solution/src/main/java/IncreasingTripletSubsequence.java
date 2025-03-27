import java.util.Arrays;

public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE, two = Integer.MAX_VALUE;

        for (int num : nums) {
            if (one >= num)
                one = num;
            else if (two >= num)
                two = num;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 1, 5, 0, 4, 6};
        int[] nums2 = {5, 4, 3, 2, 1};
        int[] nums3 = {2, 1, 5, 0, 4, 6};

        System.out.println("Is does have increasing Triplet Subsequence in " + Arrays.toString(nums1) + " : " + increasingTriplet(nums1));
        System.out.println("Is does have increasing Triplet Subsequence in " + Arrays.toString(nums2) + " : " + increasingTriplet(nums2));
        System.out.println("Is does have increasing Triplet Subsequence in " + Arrays.toString(nums3) + " : " + increasingTriplet(nums3));
    }
}
