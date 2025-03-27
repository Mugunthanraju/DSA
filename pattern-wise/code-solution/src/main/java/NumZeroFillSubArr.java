import java.sql.SQLOutput;
import java.util.Arrays;

public class NumZeroFillSubArr {
    public static  long zeroFilledSubarray(int[] nums) {
        long subArr = 0, curCount = 0;

        // Way : 1

        /*
            for (int num : nums) {
                if (num == 0)
                    curCount++;
                else {
                    // Gauss formula
                    subArr += (curCount * (curCount + 1) / 2);
                    curCount = 0;
                }
            }
            if (curCount > 0)
                subArr += (curCount * (curCount + 1) / 2); // Gauss formula
        */

        // -----------------------------------------------

        // Way : 2

        for (int num : nums) {
            if (num != 0)
                curCount = 0;
            else {
                curCount++;
                subArr += curCount;
            }
        }

        return subArr;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 0, 0, 2, 0, 0, 4};
        int[] nums2 = {0, 0, 0, 2, 0, 0};
        int[] nums3 = {2, 10, 2019};

        System.out.println("Num of Zero filled sub-array from " + Arrays.toString(nums1) + " is " + zeroFilledSubarray(nums1));
        System.out.println("Num of Zero filled sub-array from " + Arrays.toString(nums2) + " is " + zeroFilledSubarray(nums2));
        System.out.println("Num of Zero filled sub-array from " + Arrays.toString(nums3) + " is " + zeroFilledSubarray(nums3));
    }
}
